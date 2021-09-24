package com.study.algorithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class HIndexTest {

    private HIndex hIndex;

    @BeforeEach
    void setUp() {
        hIndex = new HIndex();
    }

    @ParameterizedTest
    @CsvSource(value = {"3, 0, 6, 1, 5:3"}, delimiter = ':')
    void solution(String input, int expected) {
        int[] citations = Arrays.stream(input.split(","))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();

        assertThat(hIndex.solution(citations))
                .isEqualTo(expected);
    }
}