package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.exception.BlogNotFoundException;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return (List<Blog>) blogRepository.findAll();
    }

    @Override
    public void save(Blog b) {
        blogRepository.save(b);
    }

    @Override
    public void delete(Integer id) {
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isPresent()) {
            blogRepository.deleteById(id);
        } else {
            throw new BlogNotFoundException("Blog with ID " + id + " not found");
        }
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void update(Integer id, Blog blog) {
        Optional<Blog> existingBlog = blogRepository.findById(id);
        if (existingBlog.isPresent()) {
            Blog updatedBlog = existingBlog.get();
            updatedBlog.setName(blog.getName());
            updatedBlog.setBlogger(blog.getBlogger());
            updatedBlog.setUrl(blog.getUrl());
            updatedBlog.setCreatedAt(blog.getCreatedAt());
            updatedBlog.setCategory(blog.getCategory());
            blogRepository.save(updatedBlog);
        }else {
            throw new BlogNotFoundException("Blog with ID " + id + " not found");
        }
    }

    @Override
    public List<Blog> findByName(String name) {
        return List.of();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findByNameContaining(String name, Pageable pageable) {
        return blogRepository.findByNameContaining(name, pageable);
    }

}
