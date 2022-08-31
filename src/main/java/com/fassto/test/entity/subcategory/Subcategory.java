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
    @Column(name = "full_code")
    private String fullCode;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "is_used")
    private Boolean isUsed;

    @ManyToOne
    @JoinColumn(name = "category_code")
    private Category category;

    public Subcategory updateSubcategory(String categoryCode, String code, String name, Integer sort, Boolean isUsed) {
        fullCode = categoryCode+code;
        this.code = code;
        this.name = name;
        this.sort = sort;
        this.isUsed = isUsed;

        return this;
    }

}
