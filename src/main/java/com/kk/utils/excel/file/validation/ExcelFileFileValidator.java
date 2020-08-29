package com.kk.utils.excel.file.validation;

import com.kk.utils.excel.utils.logger.ExcelReaderLogger;

import java.io.File;

public class ExcelFileFileValidator extends AbstractExcelFileValidator {
    ExcelFileFileValidator(ExcelFileValidator nextExcelFileValidator) {
        super(nextExcelFileValidator);
    }

    @Override
    protected boolean validateFile(String filePath) {
        File file = new File(filePath);

        if (!file.exists()) {
            ExcelReaderLogger.getInstance().severe("File does not exist!");
            return false;
        }

        if (!file.isFile()) {
            ExcelReaderLogger.getInstance().severe("Not a file!");
            return false;
        }

        if (!file.canRead()) {
            ExcelReaderLogger.getInstance().severe("Cannot read file!");
            return false;
        }

        return true;
    }
}
