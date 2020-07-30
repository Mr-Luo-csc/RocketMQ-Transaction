package com.lzp.shoppingcarservice.rocketmq;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Discription: 处理消费异常
 * @Author: luozhipeng
 * @Date: 2020/7/30
 **/
//@Component
@Slf4j
public class OrderListenerDeal implements MessageListenerConcurrently {

    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        log.info("消费者线程监听到消息...");
        for (MessageExt messageExt : list) {
            if (!(process(messageExt))) {
                return ConsumeConcurrentlyStatus.RECONSUME_LATER;
            }
        }
        return ConsumeConcurrentlyStatus.RECONSUME_LATER;
    }

    //===========处理消费消息
    private boolean process(MessageExt messageExt) {
        String body = new String(messageExt.getBody());
        try {
            log.info("消息处理....{}", body);
            int k = 1 / 0;
            return true;
        } catch (Exception e) {
            if (messageExt.getReconsumeTimes() >= 3) {
                log.error("消息重试已达最大次数，将通知业务人员排查问题。{}", messageExt.getMsgId());
                sendMail(messageExt);
                return true;
            }
        }
        return false;
    }

    //===========发送邮件人工处理咯
    public void sendMail(MessageExt messageExt) {
        log.info("messageExt,{}", messageExt);
    }

}
