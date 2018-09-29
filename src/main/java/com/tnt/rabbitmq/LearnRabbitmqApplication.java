package com.tnt.rabbitmq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ComponentScan(basePackages = "com.tnt.rabbitmq")
@ImportResource({ "classpath:META-INF/integration/*.xml",
	"classpath:META-INF/integration/gateway/*.xml"})
public class LearnRabbitmqApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnRabbitmqApplication.class, args);
	}
}
