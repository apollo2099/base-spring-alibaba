package com.ibase.alibaba.consumer.service;

import com.alibaba.fastjson.JSON;
import com.ibase.alibaba.consumer.dao.AccountDao;
import com.ibase.alibaba.consumer.entity.Account;
import com.ibase.alibaba.consumer.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.transaction.annotation.Transactional;

@EnableBinding(TestInput.class)
public class AccountService {
    @Autowired
    AccountDao accountDao;


    @StreamListener(TestInput.TEST_INPUT)
    @Transactional(rollbackFor = Exception.class)
    public void input(Order order) {
//        throw new IllegalArgumentException("测试失败");

        Account account = accountDao.selectById(order.getAccountId());
        if(account == null){
            throw new IllegalArgumentException("该用户不存在: " + order.getAccountId());
        }
        account.setScore(account.getScore() + 1);
        accountDao.updateScore(account);
    }

    @StreamListener(TestInput.TEST_DLQ_INPUT)
    @Transactional(rollbackFor = Exception.class)
    public void dlqInput(Order order) {
//        throw new IllegalArgumentException("dlq测试失败");
       // log.error("update-account-score失败:{}", order);
        System.out.println("update-account-score失败:"+ JSON.toJSONString(order));
    }
}
