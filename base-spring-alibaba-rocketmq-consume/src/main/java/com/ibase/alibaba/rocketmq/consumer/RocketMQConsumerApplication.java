package com.ibase.alibaba.rocketmq.consumer;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({ MySink.class })
public class RocketMQConsumerApplication {
    public static void main(String args[]){
        SpringApplication.run(RocketMQConsumerApplication.class,args);
    }
}
