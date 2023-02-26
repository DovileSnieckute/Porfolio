package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class MathService {
	
	public void testService() {
		
		System.out.println("I WAS CALLED");
	}
	
public Integer testService2(Integer num1, Integer num2) {
		
		return num1 + num2;
	}
	
	

}
