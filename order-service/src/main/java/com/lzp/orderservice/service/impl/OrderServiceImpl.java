package com.lzp.orderservice.service.impl;

import com.alibaba.fastjson.JSON;
import com.lzp.orderservice.dao.OrderDao;
import com.lzp.orderservice.dao.TransactionLogDao;
import com.lzp.orderservice.model.Order;
import com.lzp.orderservice.model.TransactionLog;
import com.lzp.orderservice.rocketmq.TransactionProducer;
import com.lzp.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private TransactionLogDao transactionLogDao;

    @Autowired
    private TransactionProducer producer;

    //=============前端调用,只用于向RocketMQ发送事务消息
    @Override
    public void makeOrder(Order order) throws MQClientException {
        producer.send(JSON.toJSONString(order), "order");
    }

    //=============执行本地事务时调用,将订单数据和事务日志写入本地数据库
    @Transactional
    @Override
    public void createOrder(Order orderDTO, String transactionId) {
        //创建订单
        Order order = new Order();
        BeanUtils.copyProperties(orderDTO, order);
        orderDao.makeOrder(order);

        //写入事务日志
        TransactionLog transactionLog = TransactionLog.builder()
                .id(transactionId)
                .business("order")
                .orderId(order.getId())
                .build();
        transactionLogDao.insert(transactionLog);
        log.info("订单创建完成:{}", orderDTO);
    }
}
