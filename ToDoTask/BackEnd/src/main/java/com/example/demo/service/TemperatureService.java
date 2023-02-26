package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class TemperatureService {
	
	public Double convertCelsiusToFarenheit(Double fahrenheit) {
		
		return (fahrenheit- 32)*0.5556;
		
	}
	
	public Double convertFarenheittoCelsius(Double celsius) {
		
		 
		return ((celsius*1.8)+32);
	}

}
