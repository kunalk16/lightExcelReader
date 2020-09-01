package com.github.kunalk16.excel.factory.builder;

import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelArchiveFilesDataBuilderTest {
    private ExcelArchiveFiles excelArchiveFiles;

    @Test
    public void testNumericExcelArchiveFileData() {
        excelArchiveFiles = new ExcelArchiveFilesDataBuilder()
                .withExcelFile(new File(getClass().getResource("numbers_only.xlsx").getFile()))
                .build();

        assertNotNull(excelArchiveFiles.getExcelZipFile());
        assertNotNull(excelArchiveFiles.getWorkBookFile());
        assertNotNull(excelArchiveFiles.getSheetFiles());
        assertEquals(1, excelArchiveFiles.getSheetFiles().size());
        assertNull(excelArchiveFiles.getSharedStringsFile());
    }

    @Test
    public void testAlphaNumericExcelArchiveFileData() {
        excelArchiveFiles = new ExcelArchiveFilesDataBuilder()
                .withExcelFile(new File(getClass().getResource("alphanumeric.xlsx").getFile()))
                .build();

        assertNotNull(excelArchiveFiles.getExcelZipFile());
        assertNotNull(excelArchiveFiles.getWorkBookFile());
        assertNotNull(excelArchiveFiles.getSheetFiles());
        assertEquals(2, excelArchiveFiles.getSheetFiles().size());
        assertNotNull(excelArchiveFiles.getSharedStringsFile());
    }

    @AfterEach
    public void releaseResource() throws IOException {
        excelArchiveFiles.close();
    }
}
