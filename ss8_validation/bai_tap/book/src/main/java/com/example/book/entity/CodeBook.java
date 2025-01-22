package com.example.book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "borrow_records")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CodeBook {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Mã mượn sách không được để trống.")
    @Column(name = "borrow_code", columnDefinition = "Integer", nullable = false, unique = true)
    private Long codeBook;

    @ManyToOne
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public CodeBook(Long codeBook, Book book) {
        this.codeBook = codeBook;
        this.book = book;
    }
}
