package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.example.entity.User;
import com.example.mpper.UserMapper;

@Controller
public class UserService {
	@Autowired
	public UserMapper mapper;

	public List<User> findUser(String name) {
		return mapper.findByName(name);
	}

	public void insertUser(String name, int age) {
		mapper.insert(name, age);
	}

	public void delet(int age) {
		mapper.delete(age);
	}

	public void update(String name, int age) {
		mapper.update(name, age);
	}
}
