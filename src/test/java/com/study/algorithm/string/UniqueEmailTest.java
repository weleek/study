package com.study.algorithm.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueEmailTest {

    private UniqueEmail uniqueEmail;

    @BeforeEach
    void setUp() {
        uniqueEmail = new UniqueEmail();
    }

    @ParameterizedTest
    @CsvSource(value = {"test.email+james@coding.com,test.e.mail+toto.jane@coding.com,testemail+tom@cod.ing.com:2"}, delimiter = ':')
    void solution(String input, int expected) {
        String[] emails = input.split(",");

        assertThat(uniqueEmail.solution(emails))
                .isEqualTo(expected);
    }
}