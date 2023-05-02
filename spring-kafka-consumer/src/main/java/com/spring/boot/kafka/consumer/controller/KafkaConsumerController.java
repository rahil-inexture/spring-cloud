package com.spring.boot.kafka.consumer.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.spring.boot.kafka.consumer.entity.Employee;

@RestController
public class KafkaConsumerController {
	private static Logger logger = LoggerFactory.getLogger(KafkaConsumerController.class);
	
	@Autowired
	private Gson gson;
	
	@KafkaListener(topics = { "test" })
	public void getTopics(@RequestBody String emp) {
		logger.info("kafka event consumed is: " + emp);
		Employee model = gson.fromJson(emp, Employee.class);
		
		logger.info("Model converted value:  " + model.toString());
		System.out.println("Model converted value: " + model.toString());
	}
		
}
