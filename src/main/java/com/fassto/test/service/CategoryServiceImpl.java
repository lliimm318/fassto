package com.fassto.test.service;

import com.fassto.test.entity.category.Category;
import com.fassto.test.entity.category.CategoryRepository;
import com.fassto.test.exception.exceptions.CategoryNotFound;
import com.fassto.test.payload.request.CategoryRequest;
import com.fassto.test.payload.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getCategories() {

        List<Category> categories = categoryRepository.findAllByOrderByCode();
        List<CategoryResponse> responses = new ArrayList<>();

        Integer count = 1;

        for(Category c : categories) {
            CategoryResponse categoryResponse = CategoryResponse.builder()
                    .code(c.getCode())
                    .name(c.getName())
                    .isUsed(c.getIsUsed())
                    .number(count)
                    .build();
            count++;

            responses.add(categoryResponse);
        }
        return responses;

    }

    @Override
    public void createCategory(CategoryRequest categoryRequest) {

        Category category = Category.builder()
                        .code(categoryRequest.getCode())
                        .name(categoryRequest.getName())
                        .isUsed(categoryRequest.getIsUsed())
                .build();

        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(String code) {

        Category category = categoryRepository.findByCode(code)
                .orElseThrow(CategoryNotFound::new);

        categoryRepository.delete(category);

    }

    @Override
    public List<CategoryResponse> searchResponse(String word) {

        return null;

    }

}
