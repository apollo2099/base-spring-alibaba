package com.ibase.alibaba.provider.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibase.alibaba.provider.entity.Order;

import java.util.List;

public interface OrderDao extends BaseMapper<Order> {

    List<Order> queryByTradeAndItem(Integer tradeId, Integer itemId);
}
