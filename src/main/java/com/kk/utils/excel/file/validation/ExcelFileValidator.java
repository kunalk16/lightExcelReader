package com.kk.utils.excel.file.validation;

@FunctionalInterface
public interface ExcelFileValidator {
    boolean validate(String filePath);
}
