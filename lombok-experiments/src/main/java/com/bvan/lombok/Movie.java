package com.bvan.lombok;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.util.Set;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Movie {

    private final String title;
    @JsonProperty("year")
    private final int releaseYear;
    private final List<Actor> actors;
    private final Set<Genre> genres;
}
