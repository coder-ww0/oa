package com.wei.emos.wx.config;

import com.rabbitmq.client.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author www
 * @date 2021/11/30 14:59
 * @description: TODO
 */

@Configuration
public class RabbitMQConfig {
    @Bean
    public ConnectionFactory getFactory() {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("192.168.0.7");
        factory.setPort(5672);
        return factory;
    }
}
