package com.example.book.repository;

import com.example.book.entity.Book;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Page<Book> findAll(Pageable pageable);

    @Modifying
    @Transactional
    @Query(value="update book set quantity= quantity+1 where id = :id", nativeQuery=true)
    void giveBack(Long id);
}
