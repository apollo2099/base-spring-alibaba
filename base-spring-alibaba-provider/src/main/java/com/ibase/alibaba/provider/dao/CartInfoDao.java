package com.ibase.alibaba.provider.dao;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ibase.alibaba.provider.entity.CartInfoEntity;

import java.util.Map;

/**
 * Created by huixiong on 2018/1/4.
 */
public interface CartInfoDao extends BaseMapper<CartInfoEntity> {

    CartInfoEntity getCartInfoByUserId(Map param);
}