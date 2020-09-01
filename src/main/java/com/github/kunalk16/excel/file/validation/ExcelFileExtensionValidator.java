package com.github.kunalk16.excel.file.validation;

import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;
import com.github.kunalk16.excel.utils.string.StringUtils;

public class ExcelFileExtensionValidator extends AbstractExcelFileValidator {
    private static final String XLSX_EXTENSION = "XLSX";

    ExcelFileExtensionValidator(ExcelFileValidator nextExcelFileValidator) {
        super(nextExcelFileValidator);
    }

    @Override
    protected boolean validateFile(String filePath) {
        int lastFullStopIndex = StringUtils.lastIndexOf(filePath, ".");

        if (lastFullStopIndex == -1) {
            ExcelReaderLogger.getInstance().severe("Could not find full stop in file path!");
            return false;
        }

        String extension = StringUtils.substring(filePath, lastFullStopIndex + 1);

        if (!StringUtils.equalsIgnoreCase(extension, XLSX_EXTENSION)) {
            ExcelReaderLogger.getInstance().severe("File is not a .xlsx file!");
            return false;
        }

        return true;
    }
}
