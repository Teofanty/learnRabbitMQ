package com.tnt.rabbitmq.handler;

import org.springframework.stereotype.Component;

@Component("syncResponseHandler")
public class SyncResponseHandler {

	public String sync(String message){
		System.out.println("sync==========="+message);
		return "{\"status\":\"success\"}";
	}
}
