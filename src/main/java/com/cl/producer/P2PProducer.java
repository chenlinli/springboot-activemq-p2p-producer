package com.cl.producer;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class P2PProducer {
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    //每隔5s向队列中发送msg
    @Scheduled(fixedDelay = 5000)
    public void send(){
        String userName ="cl";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userName",userName);
        jsonObject.put("email","lingchen_cl@sina.com");
        String msg = jsonObject.toJSONString();
        jmsMessagingTemplate.convertAndSend(queue,msg);
        System.out.println("采用点对点通讯模式:"+msg);
    }
}
