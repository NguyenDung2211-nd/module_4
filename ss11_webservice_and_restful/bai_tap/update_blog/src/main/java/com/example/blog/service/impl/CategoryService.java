package com.example.blog.service.impl;

import com.example.blog.entity.Category;
import com.example.blog.exception.CategoryNotFoundException;
import com.example.blog.repository.ICategoryRepository;
import com.example.blog.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public void save(Category b) {
        categoryRepository.save(b);
    }

    @Override
    public void delete(Integer id) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            categoryRepository.deleteById(id);
        } else {
            throw new CategoryNotFoundException("Blog with ID " + id + " not found");
        }
    }

    @Override
    public Optional<Category> findById(Integer id) {
        return categoryRepository.findById(id);
    }

    @Override
    public void update(Integer id, Category b) {
        Optional<Category> existingCategory = categoryRepository.findById(id);
        if (existingCategory.isPresent()) {
            Category categoryToUpdate = existingCategory.get();
            categoryToUpdate.setName(b.getName());
            categoryRepository.save(categoryToUpdate);
        } else {
            throw new CategoryNotFoundException("Category with id " + id + " not found.");
        }
    }

    @Override
    public List<Category> findByName(String name) {
        return List.of();
    }
}
