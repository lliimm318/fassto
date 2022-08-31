package com.fassto.test.entity.category;

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
    @Column(name = "code", nullable = false, unique = true, length = 6)
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "is_used")
    private Boolean isUsed;

}
