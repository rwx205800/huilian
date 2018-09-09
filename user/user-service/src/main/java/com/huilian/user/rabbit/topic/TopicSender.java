package com.huilian.user.rabbit.topic;

import com.huilian.user.dto.UserInfo;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;

@Component
public class TopicSender {

	@Autowired
	private AmqpTemplate rabbitTemplate;

	public void send(String topic, UserInfo userInfo) {
		System.out.println("Sender : " + userInfo);
		this.rabbitTemplate.convertAndSend("topicExchange", topic, userInfo);
	}

	public void send(String topic, Map map) {
		System.out.println("Sender : " + map.toString());
		this.rabbitTemplate.convertAndSend("topicExchange", topic, map);
	}

	public void send1() {
		String context = "hi, i am message 1";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.message", context);
	}

	public void send2() {
		String context = "hi, i am messages 2";
		System.out.println("Sender : " + context);
		this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context);
	}

}