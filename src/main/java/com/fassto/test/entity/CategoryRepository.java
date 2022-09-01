package com.fassto.test.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    List<Category> findByParentsCodeOrderBySort(String parentCode);

    Optional<Category> findById(Integer id);

    @Query(value = "select c from category c where (c.code like %:word%) or (c.name like %:word%)")
    List<Category> findByCodeOrName(@Param("word") String word);

}
