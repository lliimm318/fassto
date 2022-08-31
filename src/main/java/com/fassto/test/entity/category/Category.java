package com.fassto.test.entity.category;

import com.fassto.test.entity.subcategory.Subcategory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Getter
@Builder
@Entity(name = "master")
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @Column(name = "code", nullable = false, unique = true, length = 6)
    private String code;

    @Column(name = "number")
    private Integer number;

    @Column(name = "name")
    private String name;

    @Column(name = "sort")
    private Integer sort;

    @Column(name = "is_used")
    private Boolean isUsed;

    @OneToMany(mappedBy = "code")
    private List<Subcategory> subcategories;

}
