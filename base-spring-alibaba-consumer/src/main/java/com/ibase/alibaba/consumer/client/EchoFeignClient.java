package com.ibase.alibaba.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "base-spring-alibaba-provider")
public interface EchoFeignClient {

    @GetMapping("/echo/{str}")
    String echo(@PathVariable("str") String str);
}
