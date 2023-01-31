package com.example.demo.object;

import java.util.List;

import com.example.demo.user.UserDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ObjectDto {

	private Long id;

	private Integer objectNumber;

	private String address;

	private List<UserDto> users;

	private Long planId;

}
