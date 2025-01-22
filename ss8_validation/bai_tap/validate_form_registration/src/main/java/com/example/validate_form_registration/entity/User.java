package com.example.validate_form_registration.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id" , columnDefinition = "INT" )
    private Integer id;

    @Size(min = 1, max = 50, message = "first name phải có kí tự trong khoảng từ 1 đến 50. Bạn hãy lưu ý!")
    @NotBlank(message = "Không được để trống." )
    @Column(name = "first_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String firstName;

    @Size(min = 1, max = 50, message = "first name phải có kí tự trong khoảng từ 1 đến 50. Bạn hãy lưu ý!")
    @NotBlank(message = "Không được để trống.")
    @Column(name = "last_name", columnDefinition = "VARCHAR(50)", nullable = false)
    private String lastName;

    @Pattern(regexp = "^(\\+84|0)\\d{9,10}$", message = "Số điện thoại không đúng định dạng.")
    @NotBlank(message = "Không được để trống.")
    @Column(name = "phone_number", columnDefinition = "VARCHAR(16)", nullable = false, unique = true)
    private String phoneNumber;

    @Range(min = 18, max = 120, message = "Tuổi phải trong khoảng từ 18 đến 120. Bạn lưu ý nhé.")
    @NotNull (message = "Không được để trống.")
    @Column(name = "age_user", columnDefinition = "INTEGER", nullable = false)
    private Integer age;

    @Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$", message = "Email không đúng định dạng.")
    @NotBlank(message = "Không được để trống.")
    @Column(name = "email", columnDefinition = "VARCHAR(50)", nullable = false, unique = true)
    private String email;
}
