package com.kk.utils.excel.factory;

import com.kk.utils.excel.factory.builder.ExcelXMLDataBuilder;
import com.kk.utils.excel.model.factory.ExcelArchiveFiles;
import com.kk.utils.excel.model.factory.ExcelXMLData;

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
