package com.kk.utils.excel.model.factory;

import java.io.Closeable;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExcelArchiveFiles implements Closeable {
    private final ZipFile excelZipFile;

    private final ZipEntry workBookFile;

    private final ZipEntry sharedStringsFile;

    private final List<ZipEntry> sheetFiles;

    public ExcelArchiveFiles(ZipFile excelZipFile, ZipEntry workBookFile, ZipEntry sharedStringsFile, List<ZipEntry> sheetFiles) {
        this.excelZipFile = excelZipFile;
        this.workBookFile = workBookFile;
        this.sharedStringsFile = sharedStringsFile;
        this.sheetFiles = sheetFiles;
    }

    public ZipEntry getWorkBookFile() {
        return this.workBookFile;
    }

    public ZipEntry getSharedStringsFile() {
        return this.sharedStringsFile;
    }

    public List<ZipEntry> getSheetFiles() {
        return Collections.unmodifiableList(this.sheetFiles);
    }

    public ZipFile getExcelZipFile() {
        return this.excelZipFile;
    }

    @Override
    public void close() throws IOException {
        this.excelZipFile.close();
    }
}
