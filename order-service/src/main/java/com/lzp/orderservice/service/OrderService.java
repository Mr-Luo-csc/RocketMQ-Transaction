package com.lzp.orderservice.service;

import com.lzp.orderservice.model.Order;
import org.apache.rocketmq.client.exception.MQClientException;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
public interface OrderService {

    void makeOrder(Order order) throws MQClientException;

    void createOrder(Order orderString, String transactionId);
}
