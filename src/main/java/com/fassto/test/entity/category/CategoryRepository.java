package com.fassto.test.entity.category;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

    List<Category> findAllByOrderByCode();

    Optional<Category> findByCode(String code);

    /*
    @Query(value = "select c from category c where (c.code like %a%) or (c.name like %a%)")
    List<Category> findByCodeOrName(String word);
     */

}
