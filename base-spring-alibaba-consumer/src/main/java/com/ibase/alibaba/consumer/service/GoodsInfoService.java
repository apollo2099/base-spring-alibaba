package com.ibase.alibaba.consumer.service;

import com.ibase.alibaba.consumer.dao.GoodsInfoDao;
import com.ibase.alibaba.consumer.entity.GoodsInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class GoodsInfoService {

    @Resource
    private GoodsInfoDao goodsInfoDao;

    public GoodsInfo getById(Integer id){
        return goodsInfoDao.selectById(id);
    }
}
