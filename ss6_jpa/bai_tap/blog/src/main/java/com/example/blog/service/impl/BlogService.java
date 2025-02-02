package com.example.blog.service.impl;

import com.example.blog.entity.Blog;
import com.example.blog.exception.ResourceNotFoundException;
import com.example.blog.repository.IBlogRepository;
import com.example.blog.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void delete(Integer id) {
        if(!blogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Blog with ID " + id + " not found.");
        }
        blogRepository.deleteById(id);
    }

    @Override
    public Optional<Blog> findById(Integer id) {
        return blogRepository.findById(id);
    }

    @Override
    public void updateBlog(Integer id, Blog blog) {
        if (!blogRepository.existsById(id)) {
            throw new ResourceNotFoundException("Blog with ID " + id + " not found.");
        }
        Blog existingBlog = blogRepository.findById(id).get();
        existingBlog.setName(blog.getName());
        existingBlog.setBlogger(blog.getBlogger());
        existingBlog.setUrl(blog.getUrl());
        blogRepository.save(existingBlog);
    }



}
