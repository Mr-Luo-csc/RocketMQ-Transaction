package com.lzp.shoppingcarservice.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


/**
 * @Discription:
 * @Author: luozhipeng
 * @Date: 2020/7/28
 **/
@Component
@Slf4j
public class Consumer {

    //消费者实体对象
    private DefaultMQPushConsumer consumer;

    //消费者组
    private static final String CONSUMER_GROUP = "consumer_group";

    private static final String NAME_SERVER = "192.168.165.100:9876";

    //主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（如果没有创建好,生产者往该主题发送消息 会报找不到topic错误）

    @Autowired
    private OrderListener orderListener;

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(NAME_SERVER);
        consumer.subscribe("order", "*");
        consumer.registerMessageListener(orderListener);
        consumer.start();
    }

}
