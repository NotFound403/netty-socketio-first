package com.sinovoice.hcicloud.nettysocketiofirst.config;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by littlersmall on 16/5/16.
 */
@Configuration
public class RabbitMQConf {

    @Value("${rabbitmq_ip}")
    private String ip;

    @Value("${rabbitmq_port}")
    private int port;

    @Value("${rabbitmq_user_name}")
    private String userName;

    @Value("${rabbitmq_password}")
    private String password;

    @Bean
    ConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory(ip, port);
        connectionFactory.setUsername(userName);
        connectionFactory.setPassword(password);
        connectionFactory.setPublisherConfirms(true); // enable confirm mode
        //connectionFactory.getRabbitConnectionFactory().setAutomaticRecoveryEnabled(true);
        return connectionFactory;
    }
}
