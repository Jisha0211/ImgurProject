package com.example.demo.contoller;

import java.io.File;
import java.io.IOException;
import java.net.http.HttpHeaders;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.entity.ImageData;
import com.example.demo.entity.ResponseData;
import com.example.demo.entity.UserInfo;
import com.example.demo.service.DemoService;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;





@RestController
public class DemoController {

	@Autowired
	DemoService demoservice;
	@Autowired
	ResourceLoader resourceLoader;
	
	
	@GetMapping("/hello")
	public String hello()
	{
		return "Hello world";
	}
	
	
	@PostMapping("/user/registration")
	public ResponseEntity<?> saveDetails(@RequestBody UserInfo user) {
		
		UserInfo existingUser =demoservice.getUserDetails(user.getUserName());
		if(null!=existingUser && null!= existingUser.getUserName()){
			return ResponseEntity.badRequest().body("Username is already taken");
		}
		if(null!=existingUser && null!= existingUser.getEmail()){
			return ResponseEntity.badRequest().body("Email is already in use");
		}
		demoservice.save(user);
		return ResponseEntity.ok("Registration Completed ");
		
	}
	@GetMapping("/user/authenicate/{username}/{password}")
	public String authenticate(@PathVariable("username") String userName, 
			@PathVariable("password") String passWord) {
		UserInfo user = demoservice.getUserDetails(userName);
		if(null!=user && user.getPassword().equals(passWord)) {
			return "logged in successfully";
		}
		
		else
			return "Incorrect UserId or Password";
	}
	
	@GetMapping("/user/view/images")
	public ResponseEntity<String> viewImage(@RequestHeader("Authorization") String accessToken){
		
		RestTemplate rest = new RestTemplate();
		org.springframework.http.HttpHeaders header =new org.springframework.http.HttpHeaders();
		header.set("Authorization", accessToken);
		HttpEntity<Void> requestEntity = new HttpEntity<>(header);
		ResponseEntity<String> response = rest.exchange("https://api.imgur.com/3/account/me/images", HttpMethod.GET, requestEntity , String.class);
		return response;

		
	}
	@DeleteMapping("/user/delete/images/{imageid}")
	public String deleteImage(@RequestHeader("Authorization") String accessToken,@PathVariable("imageid") String id){
		
		
		RestTemplate rest = new RestTemplate();
		org.springframework.http.HttpHeaders header =new org.springframework.http.HttpHeaders();
		
		header.set("Authorization", accessToken);
			
		HttpEntity<Void> requestEntity = new HttpEntity<>(header);
		
		
		ResponseEntity<String> response = rest.exchange("https://api.imgur.com/3/image/{imageHash}", HttpMethod.DELETE, requestEntity , String.class,id);
        
		
		return response.getBody();

		
	}
		
	
	@PostMapping(value="/user/upload/images", consumes = "multipart/form-data")
	public ResponseEntity<byte[]> uploadImage(@RequestHeader("Authorization") String accessToken, @RequestParam("image")  MultipartFile[] requestBody) throws IOException{
		
		
		RestTemplate rest = new RestTemplate();
		org.springframework.http.HttpHeaders header =new org.springframework.http.HttpHeaders();
		
		header.set("Authorization", accessToken);
			
		
		
		MultiValueMap<String, Object> multipartMap = new LinkedMultiValueMap<> ();
		
		multipartMap.add ("file", new ClassPathResource("7097997285_d8c7b1f3ee.jpg"));
		header.set("Content-Type", "multipart/form-data");
		header.set("Accept", "text/plain");
		HttpEntity<MultiValueMap<String, Object>> request = new HttpEntity<MultiValueMap<String, Object>> (multipartMap, header);
		System.out.println ("Request for File Upload : " + request);
		
		ResponseEntity<byte[]> result = rest.exchange ("https://api.imgur.com/3/image", HttpMethod.POST, request, byte[].class);
		
		
		
		return result;

		
	}
	
}
