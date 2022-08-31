package com.fassto.test.controller;

import com.fassto.test.payload.response.CategoryResponse;
import com.fassto.test.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping("/list")
    private List<CategoryResponse> categoryList() {
        return categoryService.getCategories();
    }

    

}
