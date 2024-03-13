package com.Niketansinha.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Niketansinha.blog.entities.Category;

import com.Niketansinha.blog.exceptions.ResourceNotFoundException;
import com.Niketansinha.blog.payloads.categoryDto;

import com.Niketansinha.blog.repositories.categoryRepo;
import com.Niketansinha.blog.services.categoryService;

@Service
public class categoryServiceImpl implements categoryService {

	@Autowired
	private categoryRepo CategoryRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public categoryDto createCategory(categoryDto CategoryDto) {

		Category cat = this.modelMapper.map(CategoryDto, Category.class);
		Category addedCat = this.CategoryRepo.save(cat);
		return this.modelMapper.map(addedCat, categoryDto.class);
	}

	@Override
	public categoryDto updateCategory(categoryDto CategoryDto, Integer categoryId) {

		Category cat = this.CategoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

		cat.setCategoryDescription(CategoryDto.getCategoryDescription());
		cat.setCategoryTitle(CategoryDto.getCategoryTitle());

		Category updatedCat = this.CategoryRepo.save(cat);

		return this.modelMapper.map(updatedCat, categoryDto.class);

	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category cat = this.CategoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		this.CategoryRepo.delete(cat);

	}

	@Override
	public categoryDto getCategoryById(Integer categoryId) {
		Category cat = this.CategoryRepo.findById(categoryId)
				.orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));

		return this.modelMapper.map(cat, categoryDto.class);
	}

	@Override
	public List<categoryDto> getAllCategory() {

		List<Category> categories = this.CategoryRepo.findAll();

		List<categoryDto> catDtos = categories.stream().map((cat) -> this.modelMapper.map(cat, categoryDto.class))
				.collect(Collectors.toList());

		return catDtos;
	}

}
