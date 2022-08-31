package com.fassto.test.payload.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CategoryRequest {

    private final String code;

    private final String name;

    private final Boolean isUsed;

}
