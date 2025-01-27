package com.ccruce.ecom.project.service;

import java.util.List;

import com.ccruce.ecom.project.model.Category;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCategory(Category category);
    String deleteCategory(Long categoryId);
}
