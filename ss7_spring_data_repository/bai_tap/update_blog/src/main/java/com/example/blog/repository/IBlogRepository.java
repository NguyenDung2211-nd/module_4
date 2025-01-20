package com.example.blog.repository;

import com.example.blog.entity.Blog;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "select * from blogs as b where b.name_blog like concat('%', :name, '%')")
    List<Blog> findAllByNameContaining(@Param("name") String name);

    Page<Blog> findByNameContaining(String name, Pageable pageable);
    Page<Blog> findBlogByCategoryId(Integer categoryId, Pageable pageable);
    Page<Blog> findByNameContainingAndCategoryId(String name, Integer category_id, Pageable pageable);
}
