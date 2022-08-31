package com.fassto.test.payload.response;

import lombok.AllArgsConstructor;
import lombok.Builder;

@Builder
@AllArgsConstructor
public class SubcategoryResponse {

    private final Integer number;

    private final String code;

    private final String name;

    private final Boolean isUsed;

}
