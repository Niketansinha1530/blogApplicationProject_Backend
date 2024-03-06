package com.Niketansinha.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class userDto {

	private int id;
	
	@NotEmpty
	@Size(min=3,message="username must have more then 3 character")
	private String name;
	
	@NotEmpty
	@Size(min =3,max=15,message="Password size must be in range of 3 to 14")
	private String password;
	
	@NotEmpty
	private String about;
	
	@Email(message="Email addres in not Valid")
	private String email;
	
	//DTO stands for data transfer object
}
