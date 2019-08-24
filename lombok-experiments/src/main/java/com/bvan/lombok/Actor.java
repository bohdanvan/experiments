package com.bvan.lombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
public class Actor {

    @JsonProperty("name")
    private final String firstName;
    @JsonProperty("surname")
    private final String lastName;
}
