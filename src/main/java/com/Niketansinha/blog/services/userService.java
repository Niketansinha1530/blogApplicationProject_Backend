package com.Niketansinha.blog.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Niketansinha.blog.payloads.userDto;

@Service
public interface userService {

	//create
	userDto createUser(userDto user);
	
	//update
	userDto updateUser(userDto user,Integer userId);
	
	//get by id
	userDto getUserById(Integer userId);
	
	//get all 
	List<userDto> getAllUsers();
	
	//delete by id
	void deleteUser(Integer userId);
}
