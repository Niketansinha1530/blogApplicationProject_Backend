package com.Niketansinha.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Niketansinha.blog.entities.user;
import com.Niketansinha.blog.payloads.userDto;
import com.Niketansinha.blog.repositories.userRepo;
import com.Niketansinha.blog.services.userService;
import com.Niketansinha.blog.exceptions.*;

@Service
public class userServiceImpl implements userService {

	@Autowired
	private userRepo userRepositories;

	@Override
	public userDto createUser(userDto UserDto) {

		user User = this.dtoToUser(UserDto);
		user savedUser = this.userRepositories.save(User);
		return this.userToDto(savedUser);
	}

	@Override
	public userDto updateUser(userDto UserDto, Integer userId) {
		user User = this.userRepositories.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));

		User.setName(UserDto.getName());
		User.setEmail(UserDto.getEmail());
		User.setPassword(UserDto.getPassword());
		User.setAbout(UserDto.getAbout());

		user updateUser = this.userRepositories.save(User);
		userDto userDto1 = this.userToDto(updateUser);

		return userDto1;

	}

	@Override
	public userDto getUserById(Integer userId) {
		user User=this.userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		
		return this.userToDto(User);
	}

	@Override
	public List<userDto> getAllUsers() {
		
		List<user> Users =this.userRepositories.findAll();
		
		List<userDto> UserDtos = Users.stream()
                .map(user -> userToDto(user))
                .collect(Collectors.toList());
		return UserDtos;
	}

	@Override
	public void deleteUser(Integer userId) {
	user User=	this.userRepositories.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "id", userId));
		
		this.userRepositories.delete(User);

	}
	
	@Autowired
	private ModelMapper modelMapper;

	public user dtoToUser(userDto UserDto) {
		user User = this.modelMapper.map(UserDto, user.class);
		
		/*
		User.setId(UserDto.getId());
		User.setName(UserDto.getName());
		User.setEmail(UserDto.getEmail());
		User.setAbout(UserDto.getAbout());
		User.setPassword(UserDto.getPassword());
		*/
		return User;
	}

	public userDto userToDto(user User) {

		userDto UserDto = this.modelMapper.map(User, userDto.class);
		
		/*
		UserDto.setId(User.getId());
		UserDto.setName(User.getName());
		UserDto.setEmail(User.getEmail());
		UserDto.setPassword(User.getPassword());
		UserDto.setAbout(User.getAbout());
		*/
		return UserDto;
	}
}
