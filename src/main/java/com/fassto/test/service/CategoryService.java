package com.fassto.test.service;

import com.fassto.test.payload.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> getCategories();

}
