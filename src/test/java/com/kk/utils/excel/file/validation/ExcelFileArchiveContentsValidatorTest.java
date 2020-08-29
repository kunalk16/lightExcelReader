package com.kk.utils.excel.file.validation;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelFileArchiveContentsValidatorTest {
    private static ExcelFileArchiveContentsValidator excelFileArchiveContentsValidator;

    @BeforeEach
    public void setUp() {
        excelFileArchiveContentsValidator = new ExcelFileArchiveContentsValidator(null);
    }

    @Test
    public void testExcelFileInvalidContents() {
        assertFalse(excelFileArchiveContentsValidator.validateFile(getClass().getResource("invalid_contents.xlsx").getFile()));
    }

    @Test
    public void testExcelFileNumericContents() {
        assertTrue(excelFileArchiveContentsValidator.validateFile(getClass().getResource("numbers_only.xlsx").getFile()));
    }

    @Test
    public void testExcelFileAlphanumericContents() {
        assertTrue(excelFileArchiveContentsValidator.validateFile(getClass().getResource("alphanumeric.xlsx").getFile()));
    }
}
