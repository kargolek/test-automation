package com.jsystem.qajunit.junittest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("Junit tests")
public class JunitTest {

    private static final String TESTOWY = "test";

    @DisplayName("First junit test")
    @RepeatedTest(5)
    @Test
    public void firstJunitTest() {
        assertTrue(5 == 2 + 3);
        assertTrue(TESTOWY.contains("est"));
    }


    @DisplayName("First junit test")
    @Test
    public void secondJunitTest() {
        double result = new BigDecimal("0.2").multiply(new BigDecimal("0.2")).doubleValue();
        assertEquals(0.04, result);
    }

    @DisplayName("String test")
    @Test
    public void stringTest() {
        String simpleString = "simpleString";
        String simple = "simpleString";
        String simpleStringObj = new String("simpleString");
        String simpleStringObj2 = new String("simpleString");

        assertTrue(simpleString == "simpleString");
        assertTrue(simpleString == simple);
        assertTrue(simpleString.equals(simpleStringObj));
        assertTrue(simpleStringObj2.equals(simpleStringObj));

    }

    @DisplayName("Google truth assertion test")
    @Test
    public void googleTruthTest() {
        assertThat(TESTOWY).contains("test");
    }

    @Test
    public void zad1() {
        String result = "Wordpress powers 100% of the internet";
        String expectedString = "Wordpress powers [number]% of the internet";
        result = result.replaceAll("[*a-zA-Z]", "").replace("%","");
        assertThat(result).containsMatch("[0-9]");
    }

    @DisplayName("Nested suite")
    @Nested
    public class NestedTest{

        @DisplayName("Example list tests")
        @Test
        public void zad2() {
            //comment
            List<Integer> result = Arrays.asList(1,2,3,4,5);
            List<Integer> expected = Arrays.asList(3,4,5);
            assertThat(result).containsAnyIn(expected);
            assertTrue(result.containsAll(expected));
            assertThat(result).hasSize(5);
        }

    }



}
