package com.ibase.alibaba.consumer.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibase.alibaba.consumer.entity.Account;

public interface AccountDao extends BaseMapper<Account> {

    Boolean updateScore(Account account);
}
