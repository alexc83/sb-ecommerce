package com.ccruce.ecom.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ccruce.ecom.project.model.Category;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    private Long categoryId = (long) 1;
    
    @Override
    public List<Category> getAllCategories() {
        
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        category.setCategoryId(categoryId++);
        categories.add(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        Category category = categories.stream()
            .filter(c -> c.getCategoryId().equals(categoryId))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        
        categories.remove(category);
        
        return "Category with category ID: " + categoryId + " deleted successfully";
    
    }
    
}
