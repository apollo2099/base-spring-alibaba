package com.ibase.alibaba.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.ibase.alibaba.provider.dao")
public class ProviderApplication {
    public static void main(String args[]){
        SpringApplication.run(ProviderApplication.class,args);
    }
}