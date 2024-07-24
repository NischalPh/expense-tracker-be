package com.nischal.expensetracker.expense.service;

import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.request.ExpenseDetailRequest;

/**
 * @Author : Nischal on 7/20/2024
 */
public interface ExpenseService {

    Response addExpense(ExpenseDetailRequest expenseDetailRequest);

    Response updateExpense(Long expenseId, ExpenseDetailRequest expenseDetailRequest);

    Response deleteExpense(Long id);

    Response getAllExpense();
}
