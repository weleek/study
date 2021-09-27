package com.study.algorithm.integer;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PlusOneTest {

    private PlusOne plusOne;

    @BeforeEach
    void setUp() {
        plusOne = new PlusOne();
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2,3:1,2,4", "9,9,9:1,0,0,0"}, delimiter = ':')
    void solution(String input, String expected) {
        int[] digits = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        assertThat(Arrays.toString(plusOne.solution(digits))
                .replaceAll("\\[", "")
                .replaceAll("\\]", "")
                .replaceAll("\\s", "")
                .trim())
                .isEqualTo(expected);
    }
}