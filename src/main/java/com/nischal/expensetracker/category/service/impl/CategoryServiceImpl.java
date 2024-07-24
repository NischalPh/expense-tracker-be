package com.nischal.expensetracker.category.service.impl;

import com.nischal.expensetracker.category.entity.Category;
import com.nischal.expensetracker.category.repository.CategoryRepository;
import com.nischal.expensetracker.category.service.CategoryService;
import com.nischal.expensetracker.common.builder.ResponseBuilder;
import com.nischal.expensetracker.common.dto.Response;
import com.nischal.expensetracker.common.exception.ResourceNotFoundException;
import com.nischal.expensetracker.common.mapper.CategoryMapper;
import com.nischal.expensetracker.common.request.CategoryDetailRequest;
import com.nischal.expensetracker.common.response.CategoryResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author : Nischal on 7/23/2024
 */

@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Response addCategory(CategoryDetailRequest categoryDetailRequest) {
        Category category = CategoryMapper.toEntity(categoryDetailRequest);
        categoryRepository.save(category);
        return ResponseBuilder.success("Category added successfully.");
    }

    @Override
    public Response updateCategory(Long categoryId, CategoryDetailRequest categoryDetailRequest) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found."));

        CategoryMapper.convertForUpdate(category, categoryDetailRequest);

        categoryRepository.save(category);

        return ResponseBuilder.success("Category updated successfully.");
    }

    @Override
    public Response deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found."));

        category.setStatus(false);
        categoryRepository.save(category);
        return ResponseBuilder.success("Category deleted successfully.");
    }

    @Override
    public Response getAllCategory() {
        List<Category> categoryList = categoryRepository.findAll();

        List<CategoryResponse> categoryResponseList = categoryList
                .stream().map(category -> CategoryMapper.convertToResponse(category))
                .collect(Collectors.toList());

        return ResponseBuilder.success("Successfully fetch category list.", categoryResponseList);
    }

}
