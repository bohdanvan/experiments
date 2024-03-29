package com.bvan.lombok;

import static net.javacrumbs.jsonunit.assertj.JsonAssertions.assertThatJson;
import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;
import java.io.IOException;
import org.junit.jupiter.api.Test;

class ImmutableClassAndJacksonTest {

    private static final ObjectMapper objectMapper = Config.objectMapper();

    @Test
    void deserialization() throws IOException {
        assertThat(objectMapper.readValue(json(), Movie.class))
                .isEqualTo(movie());
    }

    @Test
    void serialization() throws JsonProcessingException {
        assertThatJson(objectMapper.writeValueAsString(movie()))
                .isEqualTo(json());
    }

    private String json() {
        return TestUtils.resource("/movie.json");
    }

    private Movie movie() {
        return Movie.builder()
                .title("Once Upon a Time... in Hollywood")
                .releaseYear(2019)
                .actors(ImmutableList.of(
                        new Actor("Leonardo", "DiCaprio"),
                        new Actor("Brad", "Pitt"),
                        new Actor("Margot", "Robbie")
                ))
                .genres(ImmutableSet.of(Genre.COMEDY, Genre.DRAMA))
                .build();
    }
}
