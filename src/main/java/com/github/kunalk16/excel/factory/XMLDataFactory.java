package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.builder.ExcelXMLDataBuilder;
import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;
import com.github.kunalk16.excel.model.factory.ExcelXMLData;

class XMLDataFactory {
    static ExcelXMLData create(ExcelArchiveFiles excelArchiveFiles) {
        return new ExcelXMLDataBuilder()
                .withExcelZipFile(excelArchiveFiles.getExcelZipFile())
                .withSharedStringsEntry(excelArchiveFiles.getSharedStringsFile())
                .withWorkBookEntry(excelArchiveFiles.getWorkBookFile())
                .withSheetsEntry(excelArchiveFiles.getSheetFiles())
                .build();
    }
}
