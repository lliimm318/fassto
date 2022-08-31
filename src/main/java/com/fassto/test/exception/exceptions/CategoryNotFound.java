package com.fassto.test.exception.exceptions;

import com.fassto.test.exception.BaseException;
import com.fassto.test.exception.ErrorCode;

public class CategoryNotFound extends BaseException {

    public CategoryNotFound() {
        super(ErrorCode.CATEGORY_NOT_FOUND);
    }

}
