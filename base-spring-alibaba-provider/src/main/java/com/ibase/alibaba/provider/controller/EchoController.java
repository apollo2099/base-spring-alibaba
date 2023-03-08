package com.ibase.alibaba.provider.controller;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.ibase.alibaba.provider.entity.CartInfoEntity;
import com.ibase.alibaba.provider.service.CartInfoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope//支持Nacos的动态刷新功能。
public class EchoController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private CartInfoService cartInfoService;

//    @Resource
//    private EchoService echoService;

    @Value("${base.spring.alibaba.provider:123}")
    private String testProperties;


    @GetMapping(value = "/echo/{string}")
    public String echo(@PathVariable String string) {
        // redis
        redisTemplate.opsForValue().set(1,string);


        Object resutl = redisTemplate.opsForValue().get(1);
        System.out.println(resutl);

        // db
        CartInfoEntity cartInfoEntity = cartInfoService.getCartInfoByUserId(16130151L);
        System.out.println(JSON.toJSONString(cartInfoEntity));

        //feign
//        String feignResult = echoService.echo(string);
//        System.out.println(feignResult);

        System.out.println("配置项："+testProperties);
        return "Hello Nacos Discovery 服务端 " + string;
    }
}