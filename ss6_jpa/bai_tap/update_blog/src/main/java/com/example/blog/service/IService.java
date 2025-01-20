package com.example.blog.service;

import com.example.blog.entity.Blog;

import java.util.List;
import java.util.Optional;

public interface IService {
    List<Blog> findAll();
    void save(Blog blog);
    void delete(Integer id);
    Optional<Blog> findById(Integer id);
    void updateBlog(Integer id,Blog blog);
}
