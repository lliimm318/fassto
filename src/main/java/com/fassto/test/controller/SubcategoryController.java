package com.fassto.test.controller;

import com.fassto.test.payload.request.SubcategoryRequest;
import com.fassto.test.payload.response.CategoryResponse;
import com.fassto.test.payload.response.SubcategoryResponse;
import com.fassto.test.service.SubcategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("subcategory")
@RequiredArgsConstructor
public class SubcategoryController {

    private final SubcategoryService subcategoryService;

    @GetMapping("/{code}")
    public List<SubcategoryResponse> getCategories(@PathVariable String code) {
        return subcategoryService.getSubcategories(code);
    }

    @GetMapping("/{code}/desc")
    public List<SubcategoryResponse> getCategoriesDesc(@PathVariable String code) {
        return subcategoryService.getSubcategoriesDesc(code);
    }

    @PostMapping("/{code}")
    public void createSubcategory(@PathVariable String code,
                            @RequestBody SubcategoryRequest subcategoryRequest) {
        subcategoryService.createSubcategory(code, subcategoryRequest);
    }

    @DeleteMapping("/{category}/{subcategory}")
    public void deleteSubcategory(@PathVariable String categoryCode,
                           @PathVariable String subcategoryCode) {
        subcategoryService.deleteSubcategory(categoryCode, subcategoryCode);
    }

    @PutMapping()
    public void updateCategory(@PathVariable String categoryCode,
                               @PathVariable String subcategoryCode,
                               @RequestBody SubcategoryRequest subcategoryRequest) {
        subcategoryService.updateCategory(categoryCode, subcategoryCode, subcategoryRequest);
    }

}
