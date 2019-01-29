package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.entity.User;
import com.example.service.UserService;
import com.example.test01.UserMapperTest01;
import com.example.test02.UserMapperTest02;

@Controller
public class UserController {
	@Autowired
	public UserService service;
	@Autowired
	public UserMapperTest01 userMapperTest01;
	@Autowired
	public UserMapperTest02 userMapperTest02;

	@RequestMapping("/selectUser")
	@ResponseBody
	public List<User> selectUser(String name) {
		List<User> users = service.findUser(name);
		return users;
	}
	//springboot+mybatis 实现crud  以及多数据源的使用
	@RequestMapping("/insertUser")
	public String insertUser(String name, Integer age) {
		userMapperTest01.insert(name, age);
		return "success";
	}
	@RequestMapping("/insertUserTest2")
	public String insertUserTest2(String name, Integer age) {
		userMapperTest02.insert(name, age);
		return "success";
	}
	@RequestMapping("/deletUser")
	@ResponseBody
	public String deletUser(int age) {
		service.delet(age);
		return "success";
	}

	@RequestMapping("/updateUser")
	@ResponseBody
	public String updateUser(String name, int age) {
		service.update(name, age);
		return "success";
	}
}
