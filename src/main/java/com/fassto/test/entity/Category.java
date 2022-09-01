package com.fassto.test.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Builder
@Entity(name = "category")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", nullable = false, length = 6)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "is_used", nullable = false)
    private Boolean isUsed;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "parents_code")
    private String parentsCode;

    public Category update(String code, String name, Integer sort, Boolean isUsed) {
        this.code = code;
        this.name = name;
        this.sort = sort;
        this.isUsed = isUsed;

        return this;
    }

}
