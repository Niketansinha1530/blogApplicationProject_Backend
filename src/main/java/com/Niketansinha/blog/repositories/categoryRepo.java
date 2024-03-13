package com.Niketansinha.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Niketansinha.blog.entities.Category;

@Repository
public interface categoryRepo extends JpaRepository<Category, Integer>{

}
