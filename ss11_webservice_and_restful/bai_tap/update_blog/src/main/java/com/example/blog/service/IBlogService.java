package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public interface IBlogService extends IService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findByNameContaining(String name, Pageable pageable);
}
