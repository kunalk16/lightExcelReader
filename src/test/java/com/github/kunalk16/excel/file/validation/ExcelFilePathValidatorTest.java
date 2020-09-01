package com.github.kunalk16.excel.file.validation;

import com.github.kunalk16.excel.utils.string.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelFilePathValidatorTest {
    private static ExcelFilePathValidator excelFilePathValidator;

    @BeforeAll
    public static void setUp() {
        excelFilePathValidator = new ExcelFilePathValidator(null);
    }

    @Test
    public void testInvalidPathString() {
        assertFalse(excelFilePathValidator.validateFile(null));
        assertFalse(excelFilePathValidator.validateFile(StringUtils.EMPTY));
    }

    @Test
    public void testValidPathString() {
        assertTrue(excelFilePathValidator.validateFile("/path/to/excel/file.xlsx"));
    }
}
