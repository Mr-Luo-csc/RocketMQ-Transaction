package com.lzp.orderservice.dao;

import com.lzp.orderservice.model.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Repository
public interface OrderDao {

    @Insert(value = "insert into t_rocket_order value(#{order.id},#{order.goodsId},#{order.userName},#{order.price})")
    int makeOrder(@Param(value = "order") Order order);

}
