package com.study.algorithm.sort;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class KthNumberTest {

    private KthNumber kthNumber;

    @BeforeEach
    void setUp() {
        kthNumber = new KthNumber();
    }

    @Test
    void solution() {
        // given
        int[] array = new int[]{1, 5, 2, 6, 3, 7, 4};
        int[][] commands = new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

        // when
        int[] result = kthNumber.solution(array, commands);

        // then
        Arrays.stream(result)
                .forEach(System.out::println);
    }
}