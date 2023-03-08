package com.ibase.alibaba.consumer.service;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(consumerGroup = "test-group", topic = "test-topic")
public class MQConsumerMessageListener implements RocketMQListener<String> {

    @Override
    public void onMessage(String msg) {
        System.out.println("消费端测试"+msg);
    }
}
