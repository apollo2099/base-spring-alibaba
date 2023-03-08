package com.ibase.alibaba.provider.controller;

import com.ibase.alibaba.provider.service.OrderService;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ProduceController {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/send/{msg}")
    public void send(@PathVariable String msg){
        rocketMQTemplate.convertAndSend("test-topic",msg);
    }

    @GetMapping(value = "/sendTransaction/{msg}")
    public void sendTransaction(@PathVariable String msg){
        orderService.saveOrder();
    }


}
