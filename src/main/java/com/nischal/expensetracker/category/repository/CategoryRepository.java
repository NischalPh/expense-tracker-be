package com.nischal.expensetracker.category.repository;

import com.nischal.expensetracker.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author : Nischal on 7/23/2024
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select c from Category  c where  c.id = :id and c.status = true")
    Optional<Category> findById(@Param("id") Long id);

    @Query("select c from Category  c where c.status = true")
    List<Category> findAll();
}
