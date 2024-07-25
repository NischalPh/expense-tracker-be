package com.nischal.expensetracker.expense.repository;

import com.nischal.expensetracker.category.entity.Category;
import com.nischal.expensetracker.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @Author : Nischal on 7/20/2024
 */

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    @Query("select e from Expense  e where  e.id = :id and e.status = true")
    Optional<Expense> findById(@Param("id") Long id);

    @Query("select e from Expense  e where e.status = true")
    List<Expense> findAll();
}
