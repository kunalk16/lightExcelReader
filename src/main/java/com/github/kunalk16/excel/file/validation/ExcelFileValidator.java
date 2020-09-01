package com.github.kunalk16.excel.file.validation;

@FunctionalInterface
public interface ExcelFileValidator {
    boolean validate(String filePath);
}
