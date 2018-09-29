package com.tnt.rabbitmq.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.tnt.rabbitmq.common.Person;

public class LambdaDemo {
	public static void main(String[] args) {
		List<Person> persons = new ArrayList<Person>();
		for(int i=0;i<10;i++){
			Person p = new Person();
			p.setAge(20+i);
			p.setName("a"+i);
			persons.add(p);
		}
		Map<String,Person> result = persons.stream().collect(Collectors.toMap(Person::getName, obj -> obj));
		System.out.println(result);
	}
}
