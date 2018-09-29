package com.tnt.rabbitmq.handler;

import org.springframework.stereotype.Component;

@Component("fanoutResponseHandler")
public class FanoutResponseHandler {

	public void fanoutTwo(String message){
		System.out.println("fanoutTwo==========="+message);
	}
	
	public void fanoutOne(String message){
		System.out.println("fanoutOne==========="+message);
	}
}
