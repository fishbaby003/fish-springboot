package com.fish.sse.task;

import com.fish.sse.entity.Message;
import com.fish.sse.service.SseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Configuration
public class SendMessageTask {
    @Autowired
    private SseService sseService;

    /**
     * 定时执行 秒 分 时 日 月 周 间隔5秒
     */
    @Scheduled(cron = "*/5 * * * * *")
    public void sendMessageTask() {
        Message message = new Message();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        message.setData(LocalDateTime.now().format(format));
        sseService.sendMessage(message);
    }
}
