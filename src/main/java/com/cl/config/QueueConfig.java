package com.cl.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.jms.Queue;


@Component
public class QueueConfig {
    @Value("${myQueueSB}")
    private String myQueueSB;
    //1.将队列注入springboot容器
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(myQueueSB);
    }
}
