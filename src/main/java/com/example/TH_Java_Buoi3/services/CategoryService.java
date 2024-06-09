package com.example.TH_Java_Buoi3.services;


import com.example.TH_Java_Buoi3.entity.Category;
import com.example.TH_Java_Buoi3.repository.ICategoryRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    public Category getCategoryById(Long id){
        return categoryRepository.findById(id).orElse(null);
    }

    public void addCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public void deleteCategory(Long id){
        categoryRepository.deleteById(id);
    }

    public void updateCategory(@NotNull Category category) {
        if (category == null || category.getId() == null) {
            throw new IllegalArgumentException("Invalid book object");
        }

        Category existingCategory = getCategoryById(category.getId());

        existingCategory.setName(category.getName());

        categoryRepository.save(existingCategory);
    }

}
