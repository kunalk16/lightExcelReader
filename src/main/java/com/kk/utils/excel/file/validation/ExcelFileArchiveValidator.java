package com.kk.utils.excel.file.validation;

import com.kk.utils.excel.utils.logger.ExcelReaderLogger;

import java.io.*;

public class ExcelFileArchiveValidator extends AbstractExcelFileValidator {
    private static final int ZIP_FILE_VALID_BYTES = 0x504b0304;

    ExcelFileArchiveValidator(ExcelFileValidator nextExcelFileValidator) {
        super(nextExcelFileValidator);
    }

    @Override
    protected boolean validateFile(String filePath) {
        try (InputStream fileInputStream = new FileInputStream(new File(filePath));
             InputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
             DataInputStream dataInputStream = new DataInputStream(bufferedInputStream)) {
            int test = dataInputStream.readInt();

            if (test != ZIP_FILE_VALID_BYTES) {
                ExcelReaderLogger.getInstance().severe("Not a valid archive file");

                return false;
            }

            return true;
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe(filePath);
            return false;
        }
    }
}
