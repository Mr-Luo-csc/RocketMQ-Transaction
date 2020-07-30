package com.lzp.orderservice.controller;

import com.lzp.orderservice.model.Order;
import com.lzp.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@RestController
@Slf4j
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value = "/order/makeOrder")
    public String makeOrder(@RequestBody Order order) {
        log.info("接收到订单数据:{}", order);
        try {
            orderService.makeOrder(order);
        } catch (MQClientException e) {
            log.error("操作失败,{}", e);
            return "操作失败";
        }
        return "下单成功";
    }

}
