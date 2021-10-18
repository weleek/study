package com.study.algorithm.sortingsearching;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

class LargestNumberTest {

    private LargestNumber largestNumber;

    @BeforeEach
    void setUp() {
        largestNumber = new LargestNumber();
    }

    @ParameterizedTest
    @CsvSource(value = {"6,10,2:'6210'", "3,30,34,5,9:'9534330'"}, delimiter = ':')
    void solution(String input, String expected) {
        int[] ints = Arrays.stream(input.split(","))
                .mapToInt(Integer::parseInt)
                .toArray();

        String result = largestNumber.solution(ints);
        if (!result.equals(expected)) {
            throw new RuntimeException(String.format("결과값[%s]이 기대값[%s]과 다릅니다.", result, expected));
        }
    }
}