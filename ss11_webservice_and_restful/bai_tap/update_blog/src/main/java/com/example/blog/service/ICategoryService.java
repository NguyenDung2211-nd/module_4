package com.example.blog.service;

import com.example.blog.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICategoryService extends IService<Category> {
    List<Category> findAll();
}
