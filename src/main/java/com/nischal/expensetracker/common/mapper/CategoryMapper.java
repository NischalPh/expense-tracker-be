package com.nischal.expensetracker.common.mapper;

import com.nischal.expensetracker.category.entity.Category;
import com.nischal.expensetracker.common.request.CategoryDetailRequest;
import com.nischal.expensetracker.common.response.CategoryResponse;

/**
 * @Author : Nischal on 7/23/2024
 */
public class CategoryMapper {

    public static Category toEntity(CategoryDetailRequest categoryDetailRequest) {
        Category category = new Category();
        category.setName(categoryDetailRequest.getName());
        category.setDescription(categoryDetailRequest.getDescription());
        return category;
    }

    public static void convertForUpdate(Category category, CategoryDetailRequest categoryDetailRequest) {
        category.setName(categoryDetailRequest.getName());
        category.setDescription(categoryDetailRequest.getDescription());
    }

    public static CategoryResponse convertToResponse(Category category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(category.getId());
        categoryResponse.setName(category.getName());
        categoryResponse.setDescription(category.getDescription());
        return categoryResponse;
    }
}
