package com.ccruce.ecom.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ccruce.ecom.project.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {


    
}
