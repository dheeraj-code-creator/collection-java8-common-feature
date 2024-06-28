package com.example.restspringbootarrayexample.controller;

import com.example.restspringbootarrayexample.dto.UserDto;
import com.example.restspringbootarrayexample.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/restspringbootarrayexample")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/alluser", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<UserDto> getUserinfo() {
        return userService.getAllUserInfo();
	}

}
