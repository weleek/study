package com.study.algorithm.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class JewelsAndStonesTest {

    private JewelsAndStones jewelsAndStones;

    @BeforeEach
    void setUp() {
        jewelsAndStones = new JewelsAndStones();
    }

    @ParameterizedTest
    @CsvSource(value = {"aA,aAAbbbb:3", "z,ZZ:0"}, delimiter = ':')
    void solution(String input, int expected) {
        String[] tmp = input.split(",");

        String jewels = tmp[0];
        String stones = tmp[1];

        assertThat(jewelsAndStones.solution(jewels, stones))
                .isEqualTo(expected);
    }
}