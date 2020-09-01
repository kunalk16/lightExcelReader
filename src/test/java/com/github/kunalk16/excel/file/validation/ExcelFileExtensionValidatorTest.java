package com.github.kunalk16.excel.file.validation;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelFileExtensionValidatorTest {
    private static ExcelFileExtensionValidator excelFileExtensionValidator;

    @BeforeAll
    public static void setUp() {
        excelFileExtensionValidator = new ExcelFileExtensionValidator(null);
    }

    @Test
    public void testInvalidFileExtension() {
        assertFalse(excelFileExtensionValidator.validateFile(getClass().getResource("test.txt").getFile()));
    }

    @Test
    public void testValidFileExtension() {
        assertTrue(excelFileExtensionValidator.validateFile(getClass().getResource("invalid_archive.xlsx").getFile()));
    }
}
