package com.fassto.test.entity.subcategory;

import com.fassto.test.entity.category.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory, String> {

    List<Subcategory> findByCategoryOrderBySort(Category category);

    List<Subcategory> findByCategoryOrderBySortDesc(Category category);

    Optional<Subcategory> findByCategoryAndCode(Category category, String code);

}
