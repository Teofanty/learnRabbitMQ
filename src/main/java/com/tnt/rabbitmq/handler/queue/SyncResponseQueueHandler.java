package com.tnt.rabbitmq.handler.queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.tnt.rabbitmq.gateway.response.SyncResponseGateway;

@Component("syncResponseQueueHandler")
public class SyncResponseQueueHandler {
	@Autowired
	private SyncResponseGateway gateway;

	public Message<?> sync(Message<?> message){
		return MessageBuilder.withPayload(gateway.sync((String)message.getPayload())).copyHeadersIfAbsent(message.getHeaders()).build();
	}
}
