package com.fassto.test.payload.request;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SearchRequest {

    private final String word;

}
