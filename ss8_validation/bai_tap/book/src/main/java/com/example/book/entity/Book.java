package com.example.book.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Size(max = 200, message = "Tên sách không vượt quá 200 kí tự.")
    @NotBlank(message = "Tên sách không được để trống.")
    @Column(name = "name_book", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @Range(max = 100, message = "Số lượng sách không vượt quá 100 .")
    @NotBlank(message = "Số lượng sách không được để trống.")
    @Column(name = "quantity", columnDefinition = "INTEGER", nullable = false)
    private Integer quantity;
}

