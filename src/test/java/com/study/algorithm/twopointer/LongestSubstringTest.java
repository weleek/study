package com.study.algorithm.twopointer;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LongestSubstringTest {

    private LongestSubstring longestSubstring;

    @BeforeEach
    void setUp() {
        longestSubstring = new LongestSubstring();
    }

    @ParameterizedTest
    @DisplayName("Longest Substring Without Repeating Characters")
    @CsvSource(value = {"abcabcd:4", "pwwkea:4", "aaaaa:1", "'':0"}, delimiter = ':')
    public void solution(String input, int expected) {
        Assertions.assertThat(longestSubstring.solution(input))
                .isEqualTo(expected);
    }

}