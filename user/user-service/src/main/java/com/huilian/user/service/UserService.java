package com.huilian.user.service;

import com.alibaba.fastjson.JSONObject;
import com.huilian.user.dto.UserInfo;
import com.huilian.user.rocketMQ.DemoProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by renfei on 2018/8/6.
 */
@Service
public class UserService {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private RedisService redisService;
    @Autowired
    private DemoProducer producer;

    public UserInfo getUserInfo(long userId) {

        String ss = redisService.getValue("hello");
        logger.info("redis value is " + ss );

        if (StringUtils.isEmpty(ss)){
            redisService.setKey("hello","你好");
        }

        logger.info("获取用户：{}",userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setName("姓名");
        logger.info("获取用户：{}",userInfo.toString());

        producer.syncSend(MessageBuilder.of(userInfo).topic("TopicTest").build());

        return userInfo;
    }

    public String save(UserInfo userInfo) {
        logger.info("保存用户：{}", JSONObject.toJSONString(userInfo));
        return "ok";
    }
}
