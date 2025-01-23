package com.example.productss10.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name="products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên sản phẩm không được để trống.")
    private String name;

    @NotNull(message = "Giá sản phẩm không được để trống.")
    @Positive(message = "Giá sản phẩm phải là số dương.")
    private Double price;
    private Double discountedPrice;
    @NotNull(message = "Mô tả sản phẩm không được để trống.")
    private String description;
    private String image;
}
