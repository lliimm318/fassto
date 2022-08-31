package com.fassto.test.service;

import com.fassto.test.entity.category.Category;
import com.fassto.test.entity.category.CategoryRepository;
import com.fassto.test.entity.subcategory.Subcategory;
import com.fassto.test.entity.subcategory.SubcategoryRepository;
import com.fassto.test.exception.exceptions.CategoryNotFound;
import com.fassto.test.exception.exceptions.SubcategoryNotFound;
import com.fassto.test.payload.request.SubcategoryRequest;
import com.fassto.test.payload.response.SubcategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SubCategoryServiceImpl implements SubcategoryService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public List<SubcategoryResponse> getSubcategories(String code) {

        Category category = categoryRepository.findByCode(code)
                .orElseThrow(CategoryNotFound::new);

        List<Subcategory> subcategories = subcategoryRepository.findByCategoryOrderBySort(category);
        List<SubcategoryResponse> subcategoryResponses = new ArrayList<>();

        Integer count = 1;
        for (Subcategory s : subcategories) {
            SubcategoryResponse subcategoryResponse = SubcategoryResponse.builder()
                            .number(count)
                            .code(s.getCode())
                            .name(s.getName())
                            .sort(s.getSort())
                            .isUsed(s.getIsUsed())
                    .build();
            count++;

            subcategoryResponses.add(subcategoryResponse);
        }

        return subcategoryResponses;
    }

    @Override
    public List<SubcategoryResponse> getSubcategoriesDesc(String code) {

        Category category = categoryRepository.findByCode(code)
                .orElseThrow(CategoryNotFound::new);

        List<Subcategory> subcategories = subcategoryRepository.findByCategoryOrderBySortDesc(category);
        List<SubcategoryResponse> subcategoryResponses = new ArrayList<>();

        Integer count = 1;
        for (Subcategory s : subcategories) {
            SubcategoryResponse subcategoryResponse = SubcategoryResponse.builder()
                    .number(count)
                    .code(s.getCode())
                    .name(s.getName())
                    .sort(s.getSort())
                    .isUsed(s.getIsUsed())
                    .build();
            count++;

            subcategoryResponses.add(subcategoryResponse);
        }

        return subcategoryResponses;
    }

    @Override
    public void createSubcategory(String code, SubcategoryRequest subcategoryRequest) {

        Category category = categoryRepository.findByCode(code)
                .orElseThrow(CategoryNotFound::new);

        Subcategory subcategory = Subcategory.builder()
                        .fullCode(code+subcategoryRequest.getCode())
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

        Category category = categoryRepository.findByCode(categoryCode)
                .orElseThrow(CategoryNotFound::new);

        Subcategory subcategory = subcategoryRepository.findByFullCode(categoryCode+subcategoryCode)
                .orElseThrow(SubcategoryNotFound::new);

        subcategoryRepository.delete(subcategory);

    }

    @Override
    public void updateCategory(String categoryCode, String subcategoryCode, SubcategoryRequest subcategoryRequest) {

        Category category = categoryRepository.findByCode(categoryCode)
                .orElseThrow(CategoryNotFound::new);

        Subcategory subcategory = subcategoryRepository.findByFullCode(categoryCode+subcategoryCode)
                .orElseThrow(SubcategoryNotFound::new);

        subcategory.updateSubcategory(categoryCode, subcategoryRequest.getCode(), subcategoryRequest.getName(), subcategoryRequest.getSort(), subcategoryRequest.getIsUsed());

        subcategoryRepository.save(subcategory);

    }

}
