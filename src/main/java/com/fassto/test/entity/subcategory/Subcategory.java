package com.fassto.test.entity.subcategory;

import com.fassto.test.entity.category.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity(name = "subcategory")
@NoArgsConstructor
@AllArgsConstructor
public class Subcategory {

    @Id
    @Column(name = "code")
    private String code;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "is_used")
    private Boolean isUsed;

    @Column(name = "category_code")
    private String categoryCode;

}
