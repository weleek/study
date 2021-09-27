package com.study.algorithm.string;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class LicenseKeyFormatTest {

    private LicenseKeyFormat licenseKeyFormat;

    @BeforeEach
    void setUp() {
        licenseKeyFormat = new LicenseKeyFormat();
    }

    @ParameterizedTest
    @CsvSource(value = {"8F3Z-2e-9-w,4:8F3Z-2E9W", "8-5g-3-J,2:8-5G-3J"}, delimiter = ':')
    void solution(String input, String expected) {
        String[] inputs = input.split(",");
        String licenseKey = inputs[0];
        int formatLength = Integer.parseInt(inputs[1]);

        assertThat(licenseKeyFormat.solution(licenseKey, formatLength))
                .isEqualTo(expected);
    }
}