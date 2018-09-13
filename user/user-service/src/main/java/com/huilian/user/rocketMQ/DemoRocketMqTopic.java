package com.huilian.user.rocketMQ;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqTopic;

/**
 * @author rhwayfun
 * @since 0.0.1
 */
public class DemoRocketMqTopic implements RocketMqTopic {
    @Override
    public String getTopic() {
        return "TopicTest";
    }
}
