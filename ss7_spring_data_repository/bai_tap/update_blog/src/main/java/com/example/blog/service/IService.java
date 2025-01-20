package com.example.blog.service;

import com.example.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface IService<T> {
    List<T> findAll();
    void save(T b);
    void delete(Integer id);
    Optional<T> findById(Integer id);
    void update(Integer id,T b);
    List<T> findByName(String name);
}
