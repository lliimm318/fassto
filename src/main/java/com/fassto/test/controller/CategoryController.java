package com.fassto.test.controller;

import com.fassto.test.payload.request.CategoryRequest;
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

    @GetMapping
    public List<CategoryResponse> categoryList(@RequestParam(value = "parentsCode", required=false) String parentsCode) {
        return categoryService.getCategories(parentsCode);
    }

    @PostMapping
    public void createCategory(@RequestParam(value = "parentsCode", required=false) String parentsCode,
                                @RequestBody CategoryRequest categoryRequest) {
        categoryService.createCategory(parentsCode, categoryRequest);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable Integer categoryId) {
        categoryService.deleteCategory(categoryId);
    }

    @PutMapping("/{categoryId}")
    public void updateCategory(@PathVariable Integer categoryId,
                               @RequestBody CategoryRequest categoryRequest) {
        categoryService.updateCategory(categoryId, categoryRequest);
    }

    @GetMapping("/search")
    public List<CategoryResponse> getSearchList(@RequestParam(value = "search") String word) {
        return categoryService.searchResponse(word);
    }

}
