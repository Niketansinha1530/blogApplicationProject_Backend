package com.Niketansinha.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Niketansinha.blog.entities.user;
@Repository
public interface userRepo extends JpaRepository<user , Integer> {

}