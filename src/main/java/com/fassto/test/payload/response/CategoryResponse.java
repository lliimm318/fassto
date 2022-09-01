package com.fassto.test.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class CategoryResponse {

    private final Integer id;

    private final String code;

    private final String name;

    private final Integer sort;

    private final Boolean isUsed;

}
