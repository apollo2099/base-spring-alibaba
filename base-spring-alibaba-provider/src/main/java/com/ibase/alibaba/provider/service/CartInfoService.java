package com.ibase.alibaba.provider.service;
import com.ibase.alibaba.provider.dao.CartInfoDao;
import com.ibase.alibaba.provider.entity.CartInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huixiong on 2018/1/4.
 */
@Component
public class CartInfoService {
    @Resource
    private CartInfoDao cartInfoDao;

    public CartInfoEntity getCartInfoByUserId(Long userId){
        // 获取分表名称
        String tableName ="js_cart_info";
        // 暂时先屏蔽分表功能
        // tableName = TableModelHelper.getCartInfoTableName(String.valueOf(userId), tableName);
        // 组装参数
        Map<String,Object> param = new HashMap(2);
        param.put("userId",userId);
        param.put("tableName",tableName);
        return cartInfoDao.getCartInfoByUserId(param);
    }
}
