package com.ccruce.ecom.project.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ccruce.ecom.project.model.Category;
import com.ccruce.ecom.project.repositories.CategoryRepository;

@Service
public class CategoryServiceImplementation implements CategoryService{

    //private List<Category> categories = new ArrayList<>();
    //private Long categoryId = 1L;

    @Autowired
    private CategoryRepository categoryRepository;
    
    @Override
    public List<Category> getAllCategories() {
        
        return categoryRepository.findAll();
    }

    @Override
    public void createCategory(Category category) {
        //category.setCategoryId(categoryId++);
        categoryRepository.save(category);
    }

    @Override
    public String deleteCategory(Long categoryId) {
        List<Category> categories = categoryRepository.findAll();
        Category category = categories.stream()
            .filter(c -> c.getCategoryId().equals(categoryId))
            .findFirst()
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found"));
        
        categoryRepository.delete(category);
        
        return "Category with category ID: " + categoryId + " deleted successfully";
    
    }

    @Override
    public Category updateCategory(Category category, Long categoryId) {
        List<Category> categories = categoryRepository.findById(categoryId);
        Optional<Category> optionalCategory = categories.stream()
            .filter(c -> c.getCategoryId().equals(categoryId))
            .findFirst();
        
            if (optionalCategory.isPresent()) {
                Category existingCategory = optionalCategory.get();
                existingCategory.setCategoryName(category.getCategoryName());
                Category savedCategory = categoryRepository.save(existingCategory);
                return savedCategory;
            } else {
                throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Resource not found");
            }
    }
    
}
