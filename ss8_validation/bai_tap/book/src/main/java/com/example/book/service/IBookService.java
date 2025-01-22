package com.example.book.service;

import com.example.book.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IBookService {
    Page<Book> findAll(Pageable pageable);
    Book findById(Long id);
    Book save(Book book);
    void giveBack(Long id);
}
