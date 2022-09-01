package com.fassto.test.service;

import com.fassto.test.payload.request.CategoryRequest;
import com.fassto.test.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getCategories(String parentCode);

    void createCategory(String parentCode, CategoryRequest categoryRequest);

    void deleteCategory(Integer categoryId);

    void updateCategory(Integer categoryId, CategoryRequest categoryRequest);

    List<CategoryResponse> searchResponse(String word);

}
