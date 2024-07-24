package com.nischal.expensetracker.expense.service.impl;

import com.nischal.expensetracker.common.builder.ResponseBuilder;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.exception.ResourceNotFoundException;
import com.nischal.expensetracker.common.mapper.ExpenseMapper;
import com.nischal.expensetracker.common.request.ExpenseDetailRequest;
import com.nischal.expensetracker.common.response.ExpenseResponse;
import com.nischal.expensetracker.expense.entity.Expense;
import com.nischal.expensetracker.expense.repository.ExpenseRepository;
import com.nischal.expensetracker.expense.service.ExpenseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Nischal on 7/20/2024
 */

@Slf4j
@Service
public class ExpenseServiceImpl implements ExpenseService {

    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @Override
    public Response addExpense(ExpenseDetailRequest expenseDetailRequest) {
        Expense expense = ExpenseMapper.toEntity(expenseDetailRequest);
        expenseRepository.save(expense);
        return ResponseBuilder.success("Expense saved successfully.");
    }

    @Override
    public Response updateExpense(Long expenseId, ExpenseDetailRequest expenseDetailRequest) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(() -> new ResourceNotFoundException("Expense not found."));

        ExpenseMapper.convertForUpdate(expense, expenseDetailRequest);
        expenseRepository.save(expense);
        return ResponseBuilder.success("Expense updated successfully.");
    }

    @Override
    public Response deleteExpense(Long id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Exception not found."));

        expense.setStatus(false);
        expenseRepository.save(expense);
        return ResponseBuilder.success("Expense deleted successfully.");
    }

    @Override
    public Response getAllExpense() {
        List<Expense> expenseList = expenseRepository.findAll();
        List<ExpenseResponse> expenseResponseList = expenseList.stream()
                .map(expense -> ExpenseMapper.toResponse(expense))
                .collect(Collectors.toList());
        return ResponseBuilder.success("Expense list fetched successfully.", expenseResponseList);
    }

}
