package com.github.kunalk16.excel.factory.builder;

import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;
import com.github.kunalk16.excel.model.factory.ExcelXMLData;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class ExcelXMLDataBuilderTest {
    private ExcelArchiveFiles excelArchiveFiles;

    @Test
    public void testNumericExcelXMLDataBuilder() {
        excelArchiveFiles = new ExcelArchiveFilesDataBuilder()
                .withExcelFile(new File(getClass().getResource("numbers_only.xlsx").getFile()))
                .build();

        ExcelXMLData excelXMLData = new ExcelXMLDataBuilder()
                .withExcelZipFile(excelArchiveFiles.getExcelZipFile())
                .withWorkBookEntry(excelArchiveFiles.getWorkBookFile())
                .withSharedStringsEntry(excelArchiveFiles.getSharedStringsFile())
                .withSheetsEntry(excelArchiveFiles.getSheetFiles())
                .build();

        assertNotNull(excelXMLData.getWorkBook());
        assertNotNull(excelXMLData.getSheets());
        assertEquals(1, excelXMLData.getSheets().size());
        assertNull(excelXMLData.getSharedString());
    }

    @Test
    public void testAlphaNumericExcelXMLDataBuilder() {
        excelArchiveFiles = new ExcelArchiveFilesDataBuilder()
                .withExcelFile(new File(getClass().getResource("alphanumeric.xlsx").getFile()))
                .build();

        ExcelXMLData excelXMLData = new ExcelXMLDataBuilder()
                .withExcelZipFile(excelArchiveFiles.getExcelZipFile())
                .withWorkBookEntry(excelArchiveFiles.getWorkBookFile())
                .withSharedStringsEntry(excelArchiveFiles.getSharedStringsFile())
                .withSheetsEntry(excelArchiveFiles.getSheetFiles())
                .build();

        assertNotNull(excelXMLData.getWorkBook());
        assertNotNull(excelXMLData.getSheets());
        assertEquals(2, excelXMLData.getSheets().size());
        assertNotNull(excelXMLData.getSharedString());
    }
}
