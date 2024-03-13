package com.Niketansinha.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Niketansinha.blog.payloads.categoryDto;
import com.Niketansinha.blog.services.categoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

	@Autowired
	private categoryService CategoryService;

	// create
	@PostMapping("/")
	public ResponseEntity<categoryDto> createCategory(@RequestBody categoryDto catDto) {
		categoryDto createCategory = this.CategoryService.createCategory(catDto);
		return new ResponseEntity<categoryDto>(createCategory, HttpStatus.CREATED);
	}

	// update

	@PutMapping("/{catId}")
	public ResponseEntity<categoryDto> updateCategory(@RequestBody categoryDto CategoryDto,
			@PathVariable Integer catId) {
		categoryDto updatedCategory = this.CategoryService.updateCategory(CategoryDto, catId);
		return new ResponseEntity<categoryDto>(updatedCategory, HttpStatus.CREATED);
	}
	// get

	@GetMapping("/get")
	public ResponseEntity<categoryDto> getCategory(@RequestParam(name = "id") int categoryId) {
		categoryDto CategoryDto = CategoryService.getCategoryById(categoryId);
		return new ResponseEntity<categoryDto>(CategoryDto, HttpStatus.OK);
	}

	// get all
	@GetMapping("/")
	public ResponseEntity<List<categoryDto>> getAllCategory() {
		return ResponseEntity.ok(this.CategoryService.getAllCategory());
	}

	// delete

	@DeleteMapping("/")
	public void deleteCategory(@RequestParam(name = "id") int categoryId) {
		this.CategoryService.deleteCategory(categoryId);

	}
}
