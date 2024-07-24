package com.nischal.expensetracker.category.controller;

import com.nischal.expensetracker.category.service.CategoryService;
import com.nischal.expensetracker.common.constant.ApiConstant;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.request.CategoryDetailRequest;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * @Author : Nischal on 7/23/2024
 */

@RestController
@RequestMapping(ApiConstant.CATEGORY)
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public Response addCategory(@RequestBody @Valid CategoryDetailRequest categoryDetailRequest) {
        Response response = categoryService.addCategory(categoryDetailRequest);
        return response;
    }

    @GetMapping
    public Response getAllCategory() {
        return categoryService.getAllCategory();
    }

    @DeleteMapping(ApiConstant.ID)
    public Response deleteCategory(@PathVariable(ApiConstant.ID) Long expenseId) {
        return categoryService.deleteCategory(expenseId);
    }

    @PutMapping(ApiConstant.ID)
    public Response updateCategory(@PathVariable(ApiConstant.ID) Long expenseId, @RequestBody CategoryDetailRequest categoryDetailRequest) {
        return categoryService.updateCategory(expenseId, categoryDetailRequest);
    }
}
