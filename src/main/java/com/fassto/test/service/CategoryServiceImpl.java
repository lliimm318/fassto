package com.fassto.test.service;

import com.fassto.test.entity.category.Category;
import com.fassto.test.entity.category.CategoryRepository;
import com.fassto.test.entity.subcategory.SubcategoryRepository;
import com.fassto.test.payload.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final SubcategoryRepository subcategoryRepository;

    @Override
    public List<CategoryResponse> getCategories() {

        List<Category> categories = categoryRepository.findAllOrderByCode();
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

}
