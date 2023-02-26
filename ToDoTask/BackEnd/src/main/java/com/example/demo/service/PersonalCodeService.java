package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class PersonalCodeService {
	
	public boolean personalCode(String code) {
		
		ArrayList<String> strList = new ArrayList<String>(
	            Arrays.asList(code));
		
//		char [] convertedCode = code.toCharArray();
		for (String s : strList)
            System.out.println(s.length());
		
		
//		int sum = 0;
//		
//		for(int i = 0; i < convertedCode.length; i++) {
//			
//			int number = Integer.parseInt(String.valueOf(convertedCode[i]));
//			
//			sum += number;
//		}
//		
//		System.out.println(sum);
//
//		int ilgis = convertedCode.length;
//		
//		int k = sum%11;
//		
//		if(k != 10) {
//			if(k == convertedCode[10] && ilgis == 11) {
//				System.out.println("true");
//				return true;
//			}
//			else {
//				System.out.println("false");
//				return false;
//			}
//
//		}
		return true;

	}
}
