package com.example.book.repository;

import com.example.book.entity.CodeBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;

@Repository
public interface CodeBookRepository extends JpaRepository<CodeBook, Long> {
    @Modifying
    void deleteByCodeBook(Long codeBook);
    CodeBook findByCodeBook(Long codeBook);
}
