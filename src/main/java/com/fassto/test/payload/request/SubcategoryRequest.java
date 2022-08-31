package com.fassto.test.payload.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SubcategoryRequest {

    private final String code;

    private final String name;

    private final Integer sort;

    private final Boolean isUsed;

}
