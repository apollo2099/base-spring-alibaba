package com.ibase.alibaba.provider.service;

import com.alibaba.nacos.common.util.UuidUtils;
import com.ibase.alibaba.provider.dao.OrderDao;
import com.ibase.alibaba.provider.entity.Order;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
public class OrderService {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    @Resource
    private OrderDao orderDao;

    @Transactional(rollbackFor = Exception.class)
    public Boolean saveOrder(){
        Order order = new Order();
        order.setTradeId(1);
        order.setItemId(1);
        order.setItemName("item1");
        order.setItemPrice(new BigDecimal("0.3"));
        order.setNum(4);
        order.setAccountId(1);
        orderDao.insert(order);


        // 事务id
        String transactionId = UuidUtils.generateUuid();
        rocketMQTemplate.sendMessageInTransaction("erp",
                "update-account-score",
                MessageBuilder.withPayload(order)
                        .setHeader(RocketMQHeaders.TRANSACTION_ID, transactionId)
                        .setHeader("share_id", 3).build(),
                4L
        );
        System.out.println(" prepare 消息发送成功");

        // 这里消息发送只是prepare发送，
        // 后面消息队列中prepare成功后，在TestTransactionListener中的executeLocalTransaction的方法中决定是否要提交本地事务
        return true;
    }
}
