package com.Niketansinha.blog.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.Niketansinha.blog.payloads.userDto;

@Service
public interface userService {

	userDto createUser(userDto user);
	
	userDto updateUser(userDto user,Integer userId);
	
	userDto getUserById(Integer userId);
	
	List<userDto> getAllUsers();
	
	void deleteUser(Integer userId);
}
