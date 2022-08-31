package com.fassto.test.service;

import com.fassto.test.entity.category.Category;
import com.fassto.test.entity.category.CategoryRepository;
import com.fassto.test.exception.exceptions.CategoryNotFound;
import com.fassto.test.payload.request.CategoryRequest;
import com.fassto.test.payload.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryResponse> getCategories() {

        return categoryRepository.findAllByOrderByCode().stream()
                .map(category -> CategoryResponse.builder()
                        .name(category.getName())
                        .code(category.getCode())
                        .isUsed(category.getIsUsed())
                        .build())
                .collect(Collectors.toList());

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

        return categoryRepository.findByCodeOrName(word).stream()
                .map(category -> CategoryResponse.builder()
                        .name(category.getName())
                        .code(category.getCode())
                        .isUsed(category.getIsUsed())
                        .build())
                .collect(Collectors.toList());

    }

}
