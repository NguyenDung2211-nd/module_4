package com.example.book.service;

import com.example.book.entity.Book;
import com.example.book.entity.CodeBook;

public interface ICodeBookService {
    public int saveCodeBook(Book book);
    void delete(Long codeBook);
    CodeBook findByCodeBook(Long codeBook);
}
