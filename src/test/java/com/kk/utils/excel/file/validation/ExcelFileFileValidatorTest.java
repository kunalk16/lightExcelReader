package com.kk.utils.excel.file.validation;

import com.kk.utils.excel.utils.string.StringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ExcelFileFileValidatorTest {
    private static ExcelFileFileValidator excelFileFileValidator;

    @BeforeAll
    public static void setUp() {
        excelFileFileValidator = new ExcelFileFileValidator(null);
    }

    @Test
    public void testNonExistentFile() {
        String filePath = getClass().getResource(StringUtils.EMPTY).getFile() + "invalid.xlsx";
        assertFalse(excelFileFileValidator.validateFile(filePath));
    }

    @Test
    public void testFolder() {
        String filePath = getClass().getResource(StringUtils.EMPTY).getFile();
        assertFalse(excelFileFileValidator.validateFile(filePath));
    }

    @Test
    public void testValidFile() {
        String filePath = getClass().getResource("invalid_archive.xlsx").getFile();
        assertTrue(excelFileFileValidator.validateFile(filePath));
    }
}
