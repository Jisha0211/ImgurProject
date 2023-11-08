package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.UserInfo;
import com.example.demo.repository.DemoUserRepository;

@Service
public class DemoService {

	@Autowired
	DemoUserRepository repo;
	
	public void save(UserInfo user)   
	{  
	repo.save(user);  
	}  
	public UserInfo getUserDetails(String userName)   
	{  
	UserInfo user =repo.findByUserName(userName); 
    return user;	
	
	}  
	public UserInfo getByEmail(String email)  {
		UserInfo user =repo.findByEmail(email); 
		return user;
	}
}
