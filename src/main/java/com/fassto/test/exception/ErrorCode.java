package com.fassto.test.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ErrorCode {

    CATEGORY_NOT_FOUND(404, "category not found"),
    SUBCATEGORY_NOT_FOUND(404, "subcategory not found");

    private final int status;

    private final String message;

}
