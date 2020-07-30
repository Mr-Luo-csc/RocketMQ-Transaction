package com.lzp.shoppingcarservice.rocketmq;

import com.alibaba.fastjson.JSONObject;
import com.lzp.shoppingcarservice.model.Order;
import com.lzp.shoppingcarservice.service.GoodService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Discription: 消费者监听器
 * @Author: luozhipeng
 * @Date: 2020/7/29
 **/
@Component
@Slf4j
public class OrderListener implements MessageListenerConcurrently {

    @Autowired
    private GoodService goodService;

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        log.info("消费者线程监听到消息...");
        try {
            for (MessageExt messageExt : list) {
                log.info("开始处理订单数据,准备移除购物车的商品....");
                Order order = JSONObject.parseObject(messageExt.getBody(), Order.class);
                goodService.removeShopCar(order);
            }
            return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
        } catch (Exception e) {
            log.error("处理消费者数据发生异常,{}", e);
            return ConsumeConcurrentlyStatus.RECONSUME_LATER;
        }
    }

}
