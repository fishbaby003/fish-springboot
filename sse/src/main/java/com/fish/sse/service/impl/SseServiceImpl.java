package com.fish.sse.service.impl;

import com.fish.sse.entity.Message;
import com.fish.sse.service.SseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author fish
 */
@Slf4j
@Service
public class SseServiceImpl implements SseService {
    /**
     * messageId的 SseEmitter对象映射集
     */
    private static Map<String, SseEmitter> sseEmitterMap = new ConcurrentHashMap<>();

    /**
     * 连接sse
     * @param uuid
     * @return
     */
    @Override
    public SseEmitter connect(String uuid) {
//        SseEmitter sseEmitter = new SseEmitter(300*1000L);
        SseEmitter sseEmitter = new SseEmitter();

        // 连接成功需要返回数据，否则会出现待处理状态
        try {
            sseEmitter.send(SseEmitter.event().comment("welcome"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 连接断开
        sseEmitter.onCompletion(() -> {
            sseEmitterMap.remove(uuid);
        });

        // 连接超时
        sseEmitter.onTimeout(() -> {
            sseEmitterMap.remove(uuid);
        });

        // 连接报错
        sseEmitter.onError((throwable) -> {
            sseEmitterMap.remove(uuid);
        });

        sseEmitterMap.put(uuid, sseEmitter);

        return sseEmitter;
    }

    /**
     * 发送消息
     * @param message
     */
    @Override
    public void sendMessage(Message message) {
        message.setTotal(sseEmitterMap.size());

        sseEmitterMap.forEach((uuid, sseEmitter) -> {
            try {
                sseEmitter.send(message, MediaType.APPLICATION_JSON);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
