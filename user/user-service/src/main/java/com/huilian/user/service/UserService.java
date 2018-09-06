package com.huilian.user.service;

import com.alibaba.druid.support.json.JSONUtils;
import com.alibaba.fastjson.JSONObject;
import com.huilian.user.dto.UserInfo;
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

    public UserInfo getUserInfo(long userId) {

        String ss = redisService.getValue("foo");
        logger.info("redis value :" + ss );

        logger.info("获取用户：{}",userId);
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userId);
        userInfo.setName("姓名");
        return userInfo;
    }

    public String save(UserInfo userInfo) {
        logger.info("保存用户：{}", JSONObject.toJSONString(userInfo));
        return "ok";
    }
}
