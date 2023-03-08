package com.ibase.alibaba.rocketmq.produce;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding({ MySource.class })
public class RocketMQProduceApplication {
    public static void main(String args[]){
        SpringApplication.run(RocketMQProduceApplication.class,args);
    }
}
