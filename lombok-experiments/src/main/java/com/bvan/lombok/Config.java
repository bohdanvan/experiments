package com.bvan.lombok;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Config {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static ObjectMapper objectMapper() {
        return OBJECT_MAPPER;
    }
}
