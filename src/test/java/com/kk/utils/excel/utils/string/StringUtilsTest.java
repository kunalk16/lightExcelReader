package com.kk.utils.excel.utils.string;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {
    @Test
    public void testReplace() {
        String test = "A B C D E F";
        assertEquals("A D E D E F", StringUtils.replace(test, "B C", "D E"));
    }

    @Test
    public void testStartsWith() {
        String test = "A quick brown fox";
        assertTrue(StringUtils.startsWith(test, "A quick"));
    }

    @Test
    public void testEndsWith() {
        String test = "A quick brown fox";
        assertTrue(StringUtils.endsWith(test, "fox"));
    }
}
