package com.fassto.test.service;

import com.fassto.test.payload.request.CategoryRequest;
import com.fassto.test.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getCategories();

    void createCategory(CategoryRequest categoryRequest);

    void deleteCategory(String code);

    List<CategoryResponse> searchResponse(String word);

}
