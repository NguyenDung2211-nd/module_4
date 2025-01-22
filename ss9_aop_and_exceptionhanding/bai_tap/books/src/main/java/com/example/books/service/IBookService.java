package com.example.books.service;

import com.example.books.entity.Book;

import java.util.List;

public interface IBookService {
    void addBook(Book book);
    Book findById(int id);
    int borrowBook(int id);
    boolean returnBook(int id, int code);
    List<Book> getAll();
}
