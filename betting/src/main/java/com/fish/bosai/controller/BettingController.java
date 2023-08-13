package com.fish.bosai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author fish
 */
@Slf4j
@RestController
public class BettingController {

    private final Map<Integer, String> sessions = new ConcurrentHashMap<>();
    private final Map<String, Integer> customerMap = new ConcurrentHashMap<>();
    private final Map<Integer, Map<Integer, Integer>> stakes = new ConcurrentHashMap<>();

    @GetMapping("/{customerId}/session")
    public ResponseEntity<String> getSession(@PathVariable int customerId) {
        String sessionKey = sessions.get(customerId);
        if (sessionKey != null && isSessionValid(sessionKey)) {
            return ResponseEntity.ok(sessionKey);
        }

        synchronized (BettingController.class) {
            sessionKey = sessions.get(customerId);
            if (sessionKey != null && isSessionValid(sessionKey)) {
                return ResponseEntity.ok(sessionKey);
            }

            sessionKey = generateSessionKey();
            sessions.put(customerId, sessionKey);
            customerMap.put(sessionKey, customerId);
            log.info("sessionKey,{}", sessionKey);
            return ResponseEntity.ok(sessionKey);
        }

    }

    @PostMapping("/{betOfferId}/stake")
    public ResponseEntity<Void> postStake(@PathVariable int betOfferId,
                                          @RequestParam String sessionKey,
                                          @RequestBody int stake) {
        if (!isSessionValid(sessionKey)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        int customerId = customerMap.get(sessionKey);
        Map<Integer, Integer> customerStakes = stakes.computeIfAbsent(betOfferId, k -> new HashMap<>());
        customerStakes.put(customerId, stake);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{betOfferId}/highstakes")
    public ResponseEntity<String> getHighStakes(@PathVariable int betOfferId) {
        Map<Integer, Integer> customerStakes = stakes.get(betOfferId);
        if (customerStakes == null || customerStakes.isEmpty()) {
            return ResponseEntity.ok().build();
        }

        StringBuilder response = new StringBuilder();
        customerStakes.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(20)
                .forEach(entry -> response.append(entry.getKey()).append("=").append(entry.getValue()).append(","));

        return ResponseEntity.ok(response.substring(0, response.length() - 1));
    }

    private boolean isSessionValid(String sessionKey) {
        LocalDateTime sessionTime = LocalDateTime.parse(sessionKey.substring(0, 19));
        return sessionTime.isAfter(LocalDateTime.now().minusMinutes(10));
    }

    private String generateSessionKey() {
        return LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS).toString() +
                (int) (Math.random() * 10000);
    }

    /*private int getCustomerId(String sessionKey) {
        return Integer.parseInt(sessionKey.substring(19));
    }*/
}
