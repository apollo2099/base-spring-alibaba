package com.ibase.alibaba.consumer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.fastjson.JSON;
import com.ibase.alibaba.consumer.client.EchoFeignClient;
import com.ibase.alibaba.consumer.entity.GoodsInfo;
import com.ibase.alibaba.consumer.service.GoodsInfoService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ConsumerController {

    @Resource
    private EchoFeignClient echoFeignClient;

    @Resource
    private GoodsInfoService goodsInfoService;

    @Resource
    private RedisTemplate redisTemplate;

    @GetMapping("/consumer/echo/{str}")
    String echo(@PathVariable("str") String str){

        echoFeignClient.echo(str);

        return "Hello Nacos Discovery 消费端 " + str;
    }

    @GetMapping("/consumer/goods/get-by-id/{id}")
    @SentinelResource("/consumer/goods/get-by-id/{id}")
    public GoodsInfo getById(@PathVariable("id")Integer id){
        GoodsInfo goodsInfo = goodsInfoService.getById(id);

        String goodsRedisKey = "goodsInfo-"+id;
        if(redisTemplate.hasKey(goodsRedisKey)){
            String result = (String) redisTemplate.opsForValue().get(goodsRedisKey);

            GoodsInfo goods = JSON.parseObject(result,GoodsInfo.class);
            System.out.println("getById get cache goods info "+JSON.toJSONString(goods));
        }else {
            redisTemplate.opsForValue().set(goodsRedisKey, JSON.toJSONString(goodsInfo));
            System.out.println("getById cache goods info");
        }
        return goodsInfo;
    }

}
