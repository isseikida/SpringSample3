package com.example.demo.trySpring.login.repository.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.trySpring.login.repository.UserDao;



@Service
public class UserService {

	@Autowired
	UserDao dao;

}