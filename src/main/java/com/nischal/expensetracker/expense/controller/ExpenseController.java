package com.nischal.expensetracker.expense.controller;

import com.nischal.expensetracker.common.constant.ApiConstant;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.request.ExpenseDetailRequest;
import com.nischal.expensetracker.expense.service.ExpenseService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Nischal on 7/23/2024
 */

@RestController
@RequestMapping(ApiConstant.EXPENSE)
public class ExpenseController {

    private final ExpenseService expenseService;

    public ExpenseController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @PostMapping
    public Response addExpense(@RequestBody @Valid ExpenseDetailRequest expenseDetailRequest) {
        Response response = expenseService.addExpense(expenseDetailRequest);
        return response;
    }

    @GetMapping
    public Response getAllExpense() {
        return expenseService.getAllExpense();
    }

    @DeleteMapping(ApiConstant.ID)
    public Response deleteExpense(@PathVariable(ApiConstant.ID) Long expenseId) {
        return expenseService.deleteExpense(expenseId);
    }

    @PutMapping(ApiConstant.ID)
    public Response updateExpense(@PathVariable(ApiConstant.ID) Long expenseId, @RequestBody ExpenseDetailRequest expenseDetailRequest) {
        return expenseService.updateExpense(expenseId, expenseDetailRequest);
    }
}
