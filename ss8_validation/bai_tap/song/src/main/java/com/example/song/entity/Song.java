package com.example.song.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Tên bài hát không được để trống")
    @Size(max = 200, message = "Tên bài hát không được vượt quá 200 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-+]+$", message = "Tên bài hát không chứa ký tự đặc biệt")
    @Column(name = "name_song", columnDefinition = "VARCHAR(200)", nullable = false)
    private String name;

    @NotBlank(message = "Nghệ sĩ không được để trống")
    @Size(max = 200, message = "Nghệ sĩ không được vượt quá 200 ký tự")
    @Pattern(regexp = "^[^@;,.=\\-+]+$", message = "Nghệ sĩ không chứa ký tự đặc biệt")
    @Column(name = "artist", columnDefinition = "VARCHAR(200)", nullable = false)
    private String artist;

    @NotBlank(message = "Thể loại nhạc không được để trống")
    @Size(max = 200, message = "Thể loại nhạc không được vượt quá 200 ký tự")
    @Pattern(regexp = "^[^@;.=\\-+]+(,[^@;.=\\-+]+)*$", message = "Thể loại nhạc chỉ cho phép dấu phẩy và không chứa ký tự đặc biệt khác")
    @Column(name = "genre", columnDefinition = "VARCHAR(200)", nullable = false)
    private String genre;
}
