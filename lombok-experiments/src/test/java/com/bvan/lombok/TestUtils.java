package com.bvan.lombok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

public class TestUtils {

    private TestUtils() {}

    public static String resource(String resourceName) {
        try {
            try (InputStream stream = TestUtils.class.getResourceAsStream(resourceName)) {
                if (stream == null) {
                    throw new RuntimeException("Incorrect resource path: " + resourceName);
                }
                System.out.println(resourceName);
                return new BufferedReader(new InputStreamReader(stream))
                        .lines().collect(Collectors.joining("\n"));
            }
        } catch (IOException | RuntimeException e) {
            throw new RuntimeException(e);
        }
    }
}
