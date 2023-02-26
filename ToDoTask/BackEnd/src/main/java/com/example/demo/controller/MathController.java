package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.TodoTask;
import com.example.demo.service.MathService;

@RestController
@RequestMapping("/math")
public class MathController {

	@Autowired
	MathService mathService;
	
	@GetMapping("/test")
	public String helloSpring() {
		mathService.testService();
		return "HELLO SPRING";
	}
	
	@PostMapping("/test")
	public String postSpring() {
		 return "HELLO SPRING IM POSTING";
	}
	
	@PutMapping("/test")
	public String putSpring() {
		 return "HELLO SPRING IM PUTTING";
	}
	
	@DeleteMapping("/test")
	public String deleteSpring() {
		 return "HELLO SPRING IM DELETING";
	}
	
	@GetMapping("/testqueryparam")
	public String helloSpringWithQueryParam(@RequestParam String data) {
		
		return data;
	}
	
	@GetMapping("/testqueryparam2")
	public String helloSpringWithQueryParam2(@RequestParam String data, Integer data2) {
		
		return data + " " + String.valueOf(data2);
	}
	
	@GetMapping("/testqueryparam3")
	public String helloSpringWithQueryParam3(@RequestParam Integer num1, Integer num2) {
		
		return String.valueOf(num1 + num2);
	}
	
	@GetMapping("/testqueryparam4")
	public String helloSpringWithQueryParam4(@RequestParam Integer num1, Integer num2, char sign) {
		
		switch (sign) {
	      case '+':
	        return String.valueOf(num1 + num2);

	      case '-':
	    	  return String.valueOf(num1 - num2);

	      case '*':
	    	  return String.valueOf(num1 * num2);

	      case '/':
	    	  return String.valueOf(num1 / num2);

	}
		return null;
}
	
	
	@GetMapping("/testpathvariable/{number}/{numbertwo}")
	public Integer helloSpringWithQueryParam5(@PathVariable Integer number,@PathVariable Integer numbertwo) {
		
		return number + numbertwo;
	}
	
	@GetMapping("/testpathvariable2/{num1}/{num2}/{sign}")
	public Integer calculator(@PathVariable Integer num1, @PathVariable Integer num2, @PathVariable char sign) {
		
		switch (sign) {
	      case '+':
	        return (num1 + num2);

	      case '-':
	    	  return (num1 - num2);

	      case '*':
	    	  return (num1 * num2);

	      case '/':
	    	  return (num1 / num2);

	}
		return null;
	}
	
	@GetMapping("/testservice")
	public Integer testService() {
		
		return mathService.testService2(2, 4);
	}
	
	
}
