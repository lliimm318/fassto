package com.fassto.test.service;

import com.fassto.test.payload.request.SubcategoryRequest;
import com.fassto.test.payload.response.SubcategoryResponse;

import java.util.List;

public interface SubcategoryService {

    List<SubcategoryResponse> getSubcategories(String code);

    List<SubcategoryResponse> getSubcategoriesDesc(String code);

    void createSubcategory(String code, SubcategoryRequest subcategoryRequest);

    void deleteSubcategory(String categoryCode, String subcategoryCode);

    void updateCategory(String categoryCode, String subcategoryCode, SubcategoryRequest subcategoryRequest);

}
