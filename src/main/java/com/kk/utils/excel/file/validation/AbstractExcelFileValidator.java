package com.kk.utils.excel.file.validation;

abstract class AbstractExcelFileValidator implements ExcelFileValidator {
    private final ExcelFileValidator nextExcelFileValidator;

    AbstractExcelFileValidator(ExcelFileValidator nextExcelFileValidator) {
        this.nextExcelFileValidator = nextExcelFileValidator;
    }

    public boolean validate(String filePath) {
        if (this.validateFile(filePath)) {
            if (this.nextExcelFileValidator != null) {
                return this.nextExcelFileValidator.validate(filePath);
            }
            return true;
        }

        return false;
    }

    protected abstract boolean validateFile(String filePath);
}
