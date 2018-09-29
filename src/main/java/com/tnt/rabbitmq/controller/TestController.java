package com.tnt.rabbitmq.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tnt.rabbitmq.gateway.request.SyncRequestGateway;

@Controller
public class TestController {

	@Autowired
	private SyncRequestGateway syncGateway;
	@Autowired
	@Qualifier("input_async_request_channel")
	private MessageChannel registeredChannel;
	@Autowired
	@Qualifier("input_fanout_request_channel")
	private MessageChannel fanoutSendChannel;

	@ResponseBody
	@RequestMapping(value = "/sync", produces = "application/json")
	public String sync(@RequestBody String payload, HttpServletRequest request) {
		return syncGateway.sync(payload);
	}

	@ResponseBody
	@RequestMapping(value = "/async", produces = "application/json")
	public String async(@RequestBody String payload, HttpServletRequest request) {
		registeredChannel.send(MessageBuilder.withPayload(payload).build());
		return "{\"status\":\"success\"}";
	}
	
	@ResponseBody
	@RequestMapping(value = "/fanout", produces = "application/json")
	public String fanout(@RequestBody String payload, HttpServletRequest request){
		fanoutSendChannel.send(MessageBuilder.withPayload(payload).build());
		return "{\"status\":\"success\"}";
	}

}
