/******************************************/
/*   DatabaseName = test   */
/*   TableName = js_account   */
/******************************************/
CREATE TABLE `js_account`
(
    `id`    int NOT NULL AUTO_INCREMENT COMMENT '序号',
    `score` int DEFAULT NULL COMMENT '账户积分',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;

/******************************************/
/*   DatabaseName = test   */
/*   TableName = js_cart_info   */
/******************************************/
CREATE TABLE `js_cart_info`
(
    `id`            bigint NOT NULL AUTO_INCREMENT,
    `user_id`       bigint                                                       DEFAULT NULL COMMENT '用户ID',
    `goods_version` int                                                          DEFAULT NULL COMMENT '商品版本号',
    `goods_id`      bigint                                                       DEFAULT NULL COMMENT '商品ID',
    `goods_code`    varchar(64)                                                  DEFAULT NULL COMMENT '商品Code',
    `sku_id`        bigint                                                       DEFAULT NULL COMMENT '商品SKU ID',
    `sku_num`       int                                                          DEFAULT NULL COMMENT '商品SKU数量',
    `barcode`       varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '商品条码',
    `create_time`   datetime                                                     DEFAULT NULL COMMENT '创建时间',
    `update_time`   datetime                                                     DEFAULT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='购物车信息表'
;

/******************************************/
/*   DatabaseName = test   */
/*   TableName = js_order   */
/******************************************/
CREATE TABLE `js_order`
(
    `id`         int                                                    DEFAULT NULL COMMENT '序号',
    `trade_id`   bigint                                                 DEFAULT NULL COMMENT '链路ID',
    `item_id`    int                                                    DEFAULT NULL COMMENT '商品ID',
    `item_name`  varchar(32) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL COMMENT '商品名称',
    `Item_price` decimal(11, 2)                                         DEFAULT NULL COMMENT '商品价格',
    `num`        int                                                    DEFAULT NULL COMMENT '数量',
    `account_id` int                                                    DEFAULT NULL COMMENT '账户ID'
) ENGINE=InnoDB DEFAULT CHARSET=utf8
;


/******************************************/
/*   DatabaseName = js_goods   */
/*   TableName = js_goods_info   */
/******************************************/
CREATE TABLE `js_goods_info`
(
    `id`         int NOT NULL COMMENT '序号',
    `goods_name` varchar(64)  DEFAULT NULL COMMENT '商品名称',
    `goods_desc` varchar(256) DEFAULT NULL COMMENT '商品描述',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品详情信息'
;




