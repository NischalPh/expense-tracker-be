package com.nischal.expensetracker.category.repository;

import com.nischal.expensetracker.category.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Nischal on 7/23/2024
 */

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
