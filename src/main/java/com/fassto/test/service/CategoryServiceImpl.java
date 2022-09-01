package com.fassto.test.service;

import com.fassto.test.entity.Category;
import com.fassto.test.entity.CategoryRepository;
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
    public List<CategoryResponse> getCategories(String parentCode) {

        return categoryRepository.findByParentsCodeOrderBySort(parentCode).stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .code(category.getCode())
                        .isUsed(category.getIsUsed())
                        .sort(category.getSort())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public void createCategory(String parentCode, CategoryRequest categoryRequest) {

        Category category = Category.builder()
                        .code(categoryRequest.getCode())
                        .name(categoryRequest.getName())
                        .isUsed(categoryRequest.getIsUsed())
                        .parentsCode(parentCode)
                .build();

        categoryRepository.save(category);

    }

    @Override
    public void deleteCategory(Integer categoryId) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFound::new);

        categoryRepository.delete(category);

    }

    @Override
    public void updateCategory(Integer categoryId, CategoryRequest categoryRequest) {

        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(CategoryNotFound::new);

        category.update(categoryRequest.getCode(), categoryRequest.getName(), categoryRequest.getSort(), categoryRequest.getIsUsed());

        System.out.println(category.getCode());
        categoryRepository.save(category);

    }

    @Override
    public List<CategoryResponse> searchResponse(String word) {

        return categoryRepository.findByCodeOrName(word).stream()
                .map(category -> CategoryResponse.builder()
                        .id(category.getId())
                        .name(category.getName())
                        .code(category.getCode())
                        .isUsed(category.getIsUsed())
                        .build())
                .collect(Collectors.toList());

    }

}
