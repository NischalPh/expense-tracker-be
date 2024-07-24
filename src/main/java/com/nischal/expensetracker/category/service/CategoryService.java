package com.nischal.expensetracker.category.service;

import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.request.CategoryDetailRequest;
import com.nischal.expensetracker.common.request.ExpenseDetailRequest;

/**
 * @Author : Nischal on 7/23/2024
 */
public interface CategoryService {

    Response addCategory(CategoryDetailRequest categoryDetailRequest);

    Response updateCategory(Long categoryId, CategoryDetailRequest categoryDetailRequest);

    Response deleteCategory(Long categoryId);

    Response getAllCategory();
}
