package com.example.book.service.impl;

import com.example.book.entity.Book;
import com.example.book.entity.CodeBook;
import com.example.book.repository.CodeBookRepository;
import com.example.book.service.ICodeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeBookService implements ICodeBookService {

    @Autowired
    private CodeBookRepository codeBookRepository;

    @Override
    public int saveCodeBook(Book book) {
        double random = Math.random()*99999 + 10000;
        CodeBook codeBook = new CodeBook((long) random, book);
        codeBookRepository.save(codeBook);
        return (int) random ;
    }

    @Override
    public void delete(Long codeBook) {
        codeBookRepository.deleteById(codeBook);
    }

    @Override
    public CodeBook findByCodeBook(Long codeBook) {
        return codeBookRepository.findByCodeBook(codeBook);
    }
}
