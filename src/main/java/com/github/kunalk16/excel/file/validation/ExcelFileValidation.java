package com.github.kunalk16.excel.file.validation;

public class ExcelFileValidation {
    public static boolean validate(String filePath) {
        return getValidatorChain().validate(filePath);
    }

    private static ExcelFileValidator getValidatorChain() {
        ExcelFileValidator excelFileArchiveContentsValidator = new ExcelFileArchiveContentsValidator(null);
        ExcelFileValidator excelFileArchiveValidator = new ExcelFileFileValidator(excelFileArchiveContentsValidator);
        ExcelFileValidator excelFileValidator = new ExcelFileFileValidator(excelFileArchiveValidator);
        ExcelFileValidator excelFileExtensionValidator = new ExcelFileFileValidator(excelFileValidator);
        return new ExcelFilePathValidator(excelFileExtensionValidator);
    }
}
