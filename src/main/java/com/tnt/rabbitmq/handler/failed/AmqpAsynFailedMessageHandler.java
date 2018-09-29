package com.tnt.rabbitmq.handler.failed;

import java.io.PrintWriter;
import java.io.StringWriter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component("amqpAsynFailedMessageHandler")
public class AmqpAsynFailedMessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(AmqpAsynFailedMessageHandler.class);

	@ServiceActivator
	public Message<?> handleFailedMessage(Exception e) {
		logger.error("Profile 项目抛出非预期异常信息：{}", printStacktrace(e));

		throw new AmqpRejectAndDontRequeueException(e.getMessage(),e.getCause());
	}
	
	private String printStacktrace(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
}
