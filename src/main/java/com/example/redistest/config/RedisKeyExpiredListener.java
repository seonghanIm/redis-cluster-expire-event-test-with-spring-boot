package com.example.redistest.config;


import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.connection.MessageListener;

import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.stereotype.Component;

@Component
public class RedisKeyExpiredListener extends KeyExpirationEventMessageListener {
    /**
     * Creates new {@link MessageListener} for {@code __keyevent@*__:expired} messages.
     *
     * @param listenerContainer must not be {@literal null}.
     */
    public RedisKeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    /**
     *
     * @param message   redis key
     * @param pattern   __keyevent@*__:expired
     */
    @Override
    public void onMessage(Message message, byte[] pattern) {

        System.out.println("########## onMessage pattern " + new String(pattern) + " | " + message.toString());
    }
}