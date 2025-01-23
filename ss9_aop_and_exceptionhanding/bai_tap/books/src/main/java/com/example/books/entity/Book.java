package com.example.books.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

@Entity(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

//    @NotBlank(message = "Tên sách không được bỏ trống")
//    @Size(min = 1, max = 200, message = "Tên sách phải có độ dài từ 1 đến 200 ký tự.")
//    @Column(name = "name_book",columnDefinition = "VARCHAR(200)", nullable = false)
//    private String name;
//
//    @NotBlank(message = "Tên tác giả không được bỏ trống")
//    @Size(min = 1, max = 200, message = "Tên Tác giả phải có độ dài từ 1 đến 200 ký tự.")
//    @Column(name = "author",columnDefinition = "VARCHAR(200)", nullable = false)
//    private String author;
//
//    @NotBlank(message = "Mô tả không được để trống")
//    @Column(name = "description",columnDefinition = "TEXT", nullable = false)
//    @Size(min = 2, max = 300, message = "Mô tả phải có độ dài từ 2 đến 300 ký tự.")
//    private String description;
//
//    @NotNull (message = "Số lượng không được để trống")
//    @Column(name = "quantity",columnDefinition = "INTEGER", nullable = false)
//    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1.")
//    private Integer quantity;
//
//    @Range(min = 10000, max = 99999, message = "Mã sách phải trong khoảng từ 10000 đến 99999.")
//    @Column(name = "code_book", unique = true)
//    private Integer code;

    @Column(name = "name_book", nullable = false, length = 100)
    @NotBlank(message = "Tên sách không được để trống")
    private String name;

    @Column(name = "author", nullable = false, length = 100)
    @NotEmpty(message = "Tên tác giả không được để trống")
    private String author;

    @Column(name = "description", nullable = false, length = 500)
    @NotNull(message = "Mô tả không được để rỗng")
    @Size(min = 1, max = 500, message = "Mô tả phải có độ dài từ 1 đến 500 ký tự.")
    private String description;

    @Column(name = "quantity", nullable = false)
    @NotNull (message = "Số lượng không được rỗng")
    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1.")
    private Integer quantity;

    @Min(10000)
    @Max(99999)
    @Column(name = "code_book")
    private Integer code;


//    @Column(name = "name", nullable = false, length = 100)
//    @NotBlank(message = "Vui lòng nhập tên sách.")
//    private String name;
//
//    @Column(name = "author", nullable = false, length = 100)
//    @NotEmpty(message = "Vui lòng nhập tên tác giả.")
//    private String author;
//
//    @Column(name = "description", nullable = false, length = 500)
//    @NotNull(message = "Vui lòng nhập mô tả cho sách.")
//    @Size(min = 10, max = 500, message = "Mô tả phải có độ dài từ 10 đến 500 ký tự.")
//    private String description;
//
//    @Column(name = "quantity", nullable = false)
//    @NotNull(message = "Vui lòng nhập số lượng sách.")
//    @Min(value = 1, message = "Số lượng phải lớn hơn hoặc bằng 1.")
//    private Integer quantity;
//
//    @Column(name = "code", nullable = false, unique = true)
//    @NotNull(message = "Vui lòng nhập mã sách.")
//    @Min(value = 10000, message = "Mã sách phải lớn hơn hoặc bằng 10000.")
//    @Max(value = 99999, message = "Mã sách phải nhỏ hơn hoặc bằng 99999.")
//    private Integer code;
}
