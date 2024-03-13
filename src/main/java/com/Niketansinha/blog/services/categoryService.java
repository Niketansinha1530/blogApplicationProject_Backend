package com.Niketansinha.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Niketansinha.blog.payloads.categoryDto;
@Service
public interface categoryService {

	// create

	categoryDto createCategory(categoryDto CategoryDto);

	// update
	categoryDto updateCategory(categoryDto CategoryDto, Integer categoryId);

	// delete
	void deleteCategory(Integer categoryId);

	// get

	categoryDto getCategoryById(Integer categoryId);

	// getAll
	List<categoryDto> getAllCategory();

}
