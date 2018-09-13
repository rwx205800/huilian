package com.huilian.user.rocketMQ;

import com.maihaoche.starter.mq.annotation.MQConsumer;
import com.maihaoche.starter.mq.base.AbstractMQPushConsumer;

import java.util.Map;

/**
 * <p>Title: huilian</p>
 * <p>Description: </p>
 *
 * @author renfei
 * @date 2018/9/13
 */
@MQConsumer(topic = "TopicTest", consumerGroup = "consumer")
public class DemoConsumer extends AbstractMQPushConsumer {

    @Override
    public boolean process(Object message, Map extMap) {
        // extMap 中包含messageExt中的属性和message.properties中的属性
        System.out.println(message);
        return true;
    }
}
