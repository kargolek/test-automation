package com.jsystem.qajunit.junittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.assertTrue;

@DisplayName("Param tests")
public class JunitParameterizedTest {

    @DisplayName("Parameterized test value {0}")
    @ParameterizedTest(name = "Param test divide value {0} by 5")
    @ValueSource(ints = {5, 15, 20})
    public void divideByFiveTest(int value){
        assertTrue(value % 5 == 0 );
    }

    @DisplayName("Parameterized test value {0}")
    @ParameterizedTest(name = "Param test: string {0} contains hello")
    @ValueSource(strings = {"hello", "Hello Junit", "Hello students"})
    public void shouldStringContainsHello(String value){
        assertThat(value.toLowerCase()).contains("hello");
    }

    @DisplayName("Parameterized test value {0}, {1}")
    @ParameterizedTest(name = "Param test: {0} contains hello; {1} equal to 5")
    @CsvSource(value = {"Hello, 5", "Hello junit, 5"}, delimiter = ',')
    public void shouldCscValuesContainsValue(String text, int num){
        assertThat(text.toLowerCase()).contains("hello");
        assertThat(num).isEqualTo(5);
    }

    @DisplayName("Parameterized test value {0}, {1}")
    @ParameterizedTest(name = "Param test: {0} contains hello; {1} divide by 5")
    @CsvFileSource(resources = "/file.csv", delimiter = ',')
    public void shouldCscFileContainsProperValue(String text, int num){
        assertThat(text.toLowerCase()).contains("hello");
        assertThat(num % 5).isEqualTo(0);
    }

    @DisplayName("Parameterized test value {0}, {1}")
    @ParameterizedTest(name = "Param test: {0} contains hello; {1} divide by 5")
    @CsvFileSource(resources = "/file.csv", delimiter = ',')
    public void shouldCscFileContainsProperValue2(String text, int num){
        assertThat(text.toLowerCase()).contains("hello");
        assertThat(num % 5).isEqualTo(0);
    }

}
