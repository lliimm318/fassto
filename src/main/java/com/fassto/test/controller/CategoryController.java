package com.fassto.test.controller;

import com.fassto.test.payload.request.CategoryRequest;
import com.fassto.test.payload.request.CodeRequest;
import com.fassto.test.payload.response.CategoryResponse;
import com.fassto.test.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    public List<CategoryResponse> categoryList() {
        return categoryService.getCategories();
    }

    @PostMapping
    public void createCategory(@RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(categoryRequest);
    }

    @DeleteMapping("/{categoryCode}")
    public void deleteCategory(@PathVariable String code) {
        categoryService.deleteCategory(code);
    }


}
