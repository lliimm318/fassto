package com.fassto.test.exception.exceptions;

import com.fassto.test.exception.BaseException;
import com.fassto.test.exception.ErrorCode;

public class SubcategoryNotFound extends BaseException {
    public SubcategoryNotFound() {
        super(ErrorCode.SUBCATEGORY_NOT_FOUND);
    }
}
