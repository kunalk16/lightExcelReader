package com.kk.utils.excel.file.validation;

import com.kk.utils.excel.utils.logger.ExcelReaderLogger;
import com.kk.utils.excel.utils.string.StringUtils;

public class ExcelFilePathValidator extends AbstractExcelFileValidator {
    ExcelFilePathValidator(ExcelFileValidator nextExcelFileValidator) {
        super(nextExcelFileValidator);
    }

    @Override
    protected boolean validateFile(String filePath) {
        if (StringUtils.isEmpty(filePath)) {
            ExcelReaderLogger.getInstance().severe("File path invalid!");

            return false;
        }

        return true;
    }
}
