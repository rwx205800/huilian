package com.huilian.user.rocketMQ;

import io.github.rhwayfun.springboot.rocketmq.starter.constants.RocketMqTag;

/**
 * @author rhwayfun
 * @since 0.0.1
 */
public class DemoRocketMqTag implements RocketMqTag {
    @Override
    public String getTag() {
        return "TagA";
    }
}
