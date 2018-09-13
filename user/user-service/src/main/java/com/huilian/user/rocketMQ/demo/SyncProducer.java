package com.huilian.user.rocketMQ.demo;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Created by renfei on 2018/9/10.
 *
 */
//      sh bin/mqshutdown broker
//      sh bin/mqshutdown namesrv
//   nohup sh bin/mqnamesrv &
//    nohup sh bin/mqbroker -n localhost:9876  autoCreateTopicEnable=true &
//    tail -f ~/logs/rocketmqlogs/broker.log

/**
 * 停止服务
 /etc/init.d/docker stop
 关掉docker0
 ifconfig docker0 down
 删除docker
 brctl  delbr  docker0
 增加网桥br0
 yum install bridge-utils
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //Instantiate with a producer group name.
        DefaultMQProducer producer = new DefaultMQProducer("producer");
        // Specify name server addresses.
        producer.setNamesrvAddr("47.98.134.140:9876");
        producer.setVipChannelEnabled(false);
        //Launch the instance.
        producer.start();
        for (int i = 0; i < 10; i++) {
            //Create a message instance, specifying topic, tag and message body.
            Message msg = new Message("TopicTest" /* Topic */,
                    "TagA" /* Tag */,
                    ("Hello RocketMQ " +
                            i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg);
            System.out.printf("%s%n", sendResult);
        }
        //Shut down once the producer instance is not longer in use.
        producer.shutdown();
    }
}