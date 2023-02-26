package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Temperature;
import com.example.demo.service.TemperatureService;


@RestController
@RequestMapping("/temperature")
public class TemperatureController {
	
	@Autowired
	TemperatureService temperatureService;
	
	@GetMapping("/tempcelsius")
	public Double tempService1(@RequestParam Double celsius) {
		
		return temperatureService.convertCelsiusToFarenheit(celsius);
		
		
	}
	@GetMapping("/tempfahrenheit")
public Double tempService2(@RequestParam Double fahrenheit) {
		
		return temperatureService.convertFarenheittoCelsius(fahrenheit);
		

}
	
	@PostMapping("/temp1")
	public Temperature tempConvert(@RequestBody Temperature temp) {
		
		if(temp.getFahrenheit() == null){

			temp.setFahrenheit((temp.getCelsius()*1.8)+32);
			return temp;
		}
		else if(temp.getCelsius() == null){
			
			temp.setCelsius((temp.getFahrenheit()- 32)*0.5556);
			return temp;
		}
		
		return temp;
	}
}
