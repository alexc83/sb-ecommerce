package com.ccruce.ecom.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ccruce.ecom.project.model.Category;

@Service
public class CategoryServiceImplementation implements CategoryService{

    private List<Category> categories = new ArrayList<>();
    
    @Override
    public List<Category> getAllCategories() {
        
        return categories;
    }

    @Override
    public void createCategory(Category category) {
        categories.add(category);
    }
    
}
