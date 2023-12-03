package com.fish.sse.service;

import com.fish.sse.entity.Message;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

/**
 * @author fish
 */
public interface SseService {
    /**
     *  创建sse连接
     * @param uuid
     * @return
     */
    SseEmitter connect(String uuid);

    /**
     *  发送消息
     * @param message
     */
    void sendMessage(Message message);
}