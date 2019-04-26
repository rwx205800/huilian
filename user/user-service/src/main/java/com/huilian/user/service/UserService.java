package com.huilian.user.service;

import com.alibaba.fastjson.JSONObject;
import com.huilian.user.dto.UserInfo;
import com.huilian.user.rabbit.TopicRabbitConfig;
import com.huilian.user.rabbit.fanout.FanoutSender;
import com.huilian.user.rabbit.hello.HelloSender;
import com.huilian.user.rabbit.topic.TopicSender;
import com.huilian.user.rocketMQ.DemoProducer;
import com.maihaoche.starter.mq.base.MessageBuilder;
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
    private HelloSender helloSender;
    @Autowired
    private FanoutSender fanoutSender;
    @Autowired
    private TopicSender topicSender;
    @Autowired
    private DemoProducer producer;

    public UserInfo getUserInfo(long userId) {

        String ss = redisService.getValue("hello");
        logger.info("redis value :" + ss );

        System.out.println("************rabbitMQ start**************");
        helloSender.send();
        fanoutSender.send();
        logger.info("获取用户：{}",userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setName("姓名");
        topicSender.send(TopicRabbitConfig.message,userInfo);
        System.out.println("************rabbitMQ end**************");

        System.out.println("************rocketMQ start**************");
        producer.syncSend(MessageBuilder.of(userInfo).topic("TopicTest").build());
        System.out.println("************rocketMQ end**************");
        return userInfo;
    }

    public String save(UserInfo userInfo) {
        logger.info("保存用户：{}", JSONObject.toJSONString(userInfo));
        return "ok";
    }
}
