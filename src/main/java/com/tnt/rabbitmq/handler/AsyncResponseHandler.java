package com.tnt.rabbitmq.handler;

import org.springframework.stereotype.Component;

@Component("asyncResponseHandler")
public class AsyncResponseHandler {

	public void async(String message){
		System.out.println("async==========="+message);
		throw new RuntimeException("a");
	}
}
