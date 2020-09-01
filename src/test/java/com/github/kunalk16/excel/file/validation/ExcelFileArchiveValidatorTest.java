package com.github.kunalk16.excel.file.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelFileArchiveValidatorTest {
    private static ExcelFileArchiveValidator excelFileArchiveValidator;

    @BeforeAll
    public static void setUp() {
        excelFileArchiveValidator = new ExcelFileArchiveValidator(null);
    }

    @Test
    public void testInvalidArchiveFile() {
        assertFalse(excelFileArchiveValidator.validateFile(getClass().getResource("invalid_archive.xlsx").getFile()));
    }

    @Test
    public void testValidArchiveFile() {
        assertTrue(excelFileArchiveValidator.validateFile(getClass().getResource("alphanumeric.xlsx").getFile()));
    }
}
