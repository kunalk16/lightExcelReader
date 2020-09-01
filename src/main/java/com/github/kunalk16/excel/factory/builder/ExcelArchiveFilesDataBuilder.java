package com.github.kunalk16.excel.factory.builder;

import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;
import com.github.kunalk16.excel.model.factory.ExcelDataFiles;
import com.github.kunalk16.excel.utils.comparator.ZipEntryComparator;
import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;

import java.io.File;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Optional;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExcelArchiveFilesDataBuilder {
    private File excelFile;

    private List<ZipEntry> sheetZipEntries;

    private ZipEntry workBookZipEntry;

    private ZipEntry sharedStringsZipEntry;

    public ExcelArchiveFilesDataBuilder withExcelFile(File excelFile) {
        this.excelFile = excelFile;
        return this;
    }

    public ExcelArchiveFiles build() {
        try {
            ZipFile zipFile = new ZipFile(excelFile);
            this.sheetZipEntries = new ArrayList<>();

            Enumeration<? extends ZipEntry> entries = zipFile.entries();

            while (entries.hasMoreElements()) {
                ZipEntry zipEntry = entries.nextElement();

                Optional.of(zipEntry)
                        .map(ZipEntry::getName)
                        .map(ExcelDataFiles::matchByName)
                        .ifPresent(xlsxDataFileType -> add(xlsxDataFileType, zipEntry));
            }

            this.sheetZipEntries.sort(new ZipEntryComparator());

            return new ExcelArchiveFiles(zipFile, this.workBookZipEntry, this.sharedStringsZipEntry, this.sheetZipEntries);
        } catch (Exception exception) {
            ExcelReaderLogger.getInstance().severe("Could not read zip file contents!" + exception.getLocalizedMessage());
            return null;
        }
    }

    private void add(ExcelDataFiles excelDataFile, ZipEntry zipEntry) {
        switch (excelDataFile) {
            case WORKBOOK_FILE:
                workBookZipEntry = zipEntry;
                break;
            case SHARED_STRINGS_FILE:
                sharedStringsZipEntry = zipEntry;
                break;
            case SHEET_FILE:
                this.sheetZipEntries.add(zipEntry);
        }
    }
}
