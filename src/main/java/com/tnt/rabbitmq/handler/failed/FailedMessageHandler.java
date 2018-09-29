package com.tnt.rabbitmq.handler.failed;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;

@Component("failedMessageHandler")
public class FailedMessageHandler {

	private static final Logger logger = LoggerFactory.getLogger(FailedMessageHandler.class);

	@ServiceActivator
	public Message<?> handleFailedMessage(Exception e) {

		logger.error("Profile 项目抛出非预期异常信息：{}", printStacktrace(e));


		return MessageBuilder.withPayload(buildRespMap(e)).build();
	}

	private String buildRespMap(Exception e) {
		Map<String, String> respMap = new HashMap<String, String>();
		respMap.put("code", "500");
		respMap.put("message", e.getLocalizedMessage());
		respMap.put("detail_info",e.getMessage());
		respMap.put("request_id", "");
		return JSON.toJSONString(respMap);
	}

	private String printStacktrace(Exception ex) {
		StringWriter errors = new StringWriter();
		ex.printStackTrace(new PrintWriter(errors));
		return errors.toString();
	}
}
