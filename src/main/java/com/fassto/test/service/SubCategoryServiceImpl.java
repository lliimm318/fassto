package com.fassto.test.service;

import com.fassto.test.entity.category.Category;
import com.fassto.test.entity.category.CategoryRepository;
import com.fassto.test.entity.subcategory.Subcategory;
import com.fassto.test.entity.subcategory.SubcategoryRepository;
import com.fassto.test.exception.exceptions.CategoryNotFound;
import com.fassto.test.payload.request.SubcategoryRequest;
import com.fassto.test.payload.response.SubcategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubcategoryService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public List<SubcategoryResponse> getSubcategories(String code) {

        Category category = findCategory(code);

        return subcategoryRepository.findByCategoryOrderBySort(category).stream()
                .map(subcategory -> SubcategoryResponse.builder()
                        .id(subcategory.getId())
                        .code(subcategory.getCode())
                        .name(subcategory.getName())
                        .sort(subcategory.getSort())
                        .isUsed(subcategory.getIsUsed())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public List<SubcategoryResponse> getSubcategoriesDesc(String code) {

        Category category = findCategory(code);

        return subcategoryRepository.findByCategoryOrderBySortDesc(category).stream()
                .map(subcategory -> SubcategoryResponse.builder()
                        .id(subcategory.getId())
                        .code(subcategory.getCode())
                        .name(subcategory.getName())
                        .sort(subcategory.getSort())
                        .isUsed(subcategory.getIsUsed())
                        .build())
                .collect(Collectors.toList());

    }

    @Override
    public void createSubcategory(String code, SubcategoryRequest subcategoryRequest) {

        Category category = findCategory(code);

        Subcategory subcategory = Subcategory.builder()
                        .code(subcategoryRequest.getCode())
                        .name(subcategoryRequest.getName())
                        .sort(subcategoryRequest.getSort())
                        .isUsed(subcategoryRequest.getIsUsed())
                        .category(category)
                .build();

        subcategoryRepository.save(subcategory);

    }

    @Override
    public void deleteSubcategory(String categoryCode, String subcategoryCode) {

        Category category = findCategory(categoryCode);
        Subcategory subcategory = findSubcategory(category, subcategoryCode);

        subcategoryRepository.delete(subcategory);

    }

    @Override
    public void updateCategory(String categoryCode, String subcategoryCode, SubcategoryRequest subcategoryRequest) {

        Category category = findCategory(categoryCode);
        Subcategory subcategory = findSubcategory(category, subcategoryCode);

        subcategory.updateSubcategory(subcategoryRequest.getCode(), subcategoryRequest.getName(), subcategoryRequest.getSort(), subcategoryRequest.getIsUsed());

        subcategoryRepository.save(subcategory);

    }

    private Category findCategory(String categoryCode) {

        return categoryRepository.findByCode(categoryCode)
                .orElseThrow(CategoryNotFound::new);

    }

    private Subcategory findSubcategory(Category category, String subcategoryCode) {

        return subcategoryRepository.findByCategoryAndCode(category, subcategoryCode)
                .orElseThrow(CategoryNotFound::new);

    }

}
