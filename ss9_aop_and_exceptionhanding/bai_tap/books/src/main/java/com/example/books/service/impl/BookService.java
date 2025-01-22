package com.example.books.service.impl;

import com.example.books.entity.Book;
import com.example.books.repository.BookRepository;
import com.example.books.service.IBookService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class BookService implements IBookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void addBook(Book book) {
//        if (book.getId() != null && bookRepository.existsById(book.getId())) {
//            throw new DuplicateKeyException("Sách đã tồn tại");
//        }
        bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return bookRepository.findAll();
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public int borrowBook(int id) {
        Book book = findById(id);
        if (book == null || book.getQuantity() <= 0) {
            throw new IllegalArgumentException("Sách không có sẵn hoặc hết hàng.");
        }
        book.setQuantity(book.getQuantity() - 1);
        int borrowCode = generateBorrowCode();
        book.setCode(borrowCode);
        bookRepository.save(book);
        return borrowCode;
    }

    @Override
    @Transactional
    public boolean returnBook(int id, int code) {
        Book book = findById(id);
        if (book == null) {
            throw new IllegalArgumentException("Không tìm thấy sách cho ID: " + id);
        }
        if (book.getCode() != code) {
            throw new IllegalArgumentException("Mã mượn không hợp lệ.");
        }
        book.setQuantity(book.getQuantity() + 1);
        book.setCode(0);
        bookRepository.save(book);

        System.out.println("Sách được trả lại: " + book.getName() + ", Số lượng mới: " + book.getQuantity());

        return true;
    }

    private int generateBorrowCode() {
        Random random = new Random();
        return random.nextInt(99999) + 10000;
    }
}
