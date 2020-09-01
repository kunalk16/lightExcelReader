package com.github.kunalk16.excel.file.validation;

import com.github.kunalk16.excel.model.factory.ExcelDataFiles;
import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;

import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExcelFileArchiveContentsValidator extends AbstractExcelFileValidator {
    private int workBookFileCount, sheetFileCount, sharedStringsFileCount;

    ExcelFileArchiveContentsValidator(ExcelFileValidator nextExcelFileValidator) {
        super(nextExcelFileValidator);
        this.workBookFileCount = 0;
        this.sheetFileCount = 0;
        this.sharedStringsFileCount = 0;
    }

    @Override
    protected boolean validateFile(String filePath) {
        try (ZipFile zipFile = new ZipFile(new File(filePath))) {
            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();

                Optional.of(zipEntry)
                        .map(ZipEntry::getName)
                        .map(ExcelDataFiles::matchByName)
                        .ifPresent(this::add);
            }
        } catch (IOException exception) {
            ExcelReaderLogger.getInstance().severe(exception.getLocalizedMessage());
            return false;
        }

        if (workBookFileCount == 0) {
            ExcelReaderLogger.getInstance().severe(ExcelDataFiles.WORKBOOK_FILE.getFileName() + " is missing!");
            return false;
        }

        if (sheetFileCount == 0) {
            ExcelReaderLogger.getInstance().severe(ExcelDataFiles.SHEET_FILE.getFileName() + "*.xml files are missing!");
            return false;
        }

        if (sharedStringsFileCount == 0) {
            ExcelReaderLogger.getInstance().info(ExcelDataFiles.SHARED_STRINGS_FILE.getFileName() + " not present!");
        }

        return true;
    }

    private void add(ExcelDataFiles excelDataFile) {
        switch (excelDataFile) {
            case WORKBOOK_FILE:
                workBookFileCount++;
                break;
            case SHARED_STRINGS_FILE:
                sharedStringsFileCount++;
                break;
            case SHEET_FILE:
                sheetFileCount++;
                break;
        }
    }
}
