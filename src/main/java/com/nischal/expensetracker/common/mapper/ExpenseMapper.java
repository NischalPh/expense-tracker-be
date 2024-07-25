package com.nischal.expensetracker.common.mapper;

import com.nischal.expensetracker.common.request.ExpenseDetailRequest;
import com.nischal.expensetracker.common.response.ExpenseResponse;
import com.nischal.expensetracker.expense.entity.Expense;

import java.util.Date;

/**
 * @Author : Nischal on 7/20/2024
 */
public class ExpenseMapper {

    public static Expense toEntity(ExpenseDetailRequest expenseDetailRequest) {
        Expense expense = new Expense();
        expense.setAmount(expenseDetailRequest.getAmount());
        expense.setDescription(expenseDetailRequest.getDescription());
        expense.setCurrency(expenseDetailRequest.getCurrency());
        expense.setRecurring(expenseDetailRequest.getRecurring());
        expense.setRecordedDate(new Date());
        return expense;
    }

    public static void convertForUpdate(Expense expense, ExpenseDetailRequest expenseDetailRequest) {
        expense.setAmount(expenseDetailRequest.getAmount());
        expense.setDescription(expenseDetailRequest.getDescription());
        expense.setCurrency(expenseDetailRequest.getCurrency());
        expense.setRecurring(expenseDetailRequest.getRecurring());
        expense.setUpdateDate(new Date());
    }

    public static ExpenseResponse toResponse(Expense expense) {
        return ExpenseResponse
                .builder()
                .id(expense.getId())
                .description(expense.getDescription())
                .amount(expense.getAmount())
                .recordedDate(expense.getRecordedDate())
                .currency(expense.getCurrency())
                .recurring(expense.getRecurring())
                .updateDate(expense.getUpdateDate())
                .categoryResponse(CategoryMapper.convertToResponse(expense.getCategory()))
                .build();
    }
}
