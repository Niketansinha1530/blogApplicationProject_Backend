package com.Niketansinha.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Niketansinha.blog.payloads.userDto;
import com.Niketansinha.blog.services.userService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class userController {

	@Autowired
	private userService UserService;
	//POST - create user
	
//	http://localhost:8080/api/users/
	@PostMapping("/")
	public ResponseEntity<userDto> createUser(@Valid @RequestBody userDto UserDto){
		userDto createUserDto =this.UserService.createUser(UserDto);
		
		return new ResponseEntity<>(createUserDto,HttpStatus.CREATED);
	}
	
	//PUT - update user
//	http://localhost:8080/api/users/?id=6
	@PutMapping("/")
	public ResponseEntity<userDto> updateUserById(@RequestParam(name = "id") int userId, @RequestBody userDto updatedUserDto) {
	    userDto updatedDto = UserService.updateUser(updatedUserDto, userId);
	    if (updatedDto != null) {
	        return new ResponseEntity<>(updatedDto, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}

	//DELTE -delete user
//	http://localhost:8080/api/users/?id=4
	@DeleteMapping("/")
	public void deleteUser(@RequestParam(name = "id") int userId) {
	     this.UserService.deleteUser(userId);
	    
	}
	
	//GET -get user
	
//	http://localhost:8080/api/users/
	@GetMapping("/")
	public ResponseEntity<List<userDto>> getAllUsers(){
		return ResponseEntity.ok(this.UserService.getAllUsers());
	}
     //	http://localhost:8080/api/users/get?id=4
	 @GetMapping("/get")
	    public ResponseEntity<userDto> getUser(@RequestParam(name = "id")int userId) {
	    	userDto getUser = UserService.getUserById(userId);
	        if (getUser != null) {
	            return new ResponseEntity<>(getUser, HttpStatus.OK);
	        } else {
	            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	        }
	    
}
}
