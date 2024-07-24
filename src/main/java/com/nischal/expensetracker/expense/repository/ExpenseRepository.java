package com.nischal.expensetracker.expense.repository;

import com.nischal.expensetracker.expense.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author : Nischal on 7/20/2024
 */

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

}
