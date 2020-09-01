package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.builder.ExcelArchiveFilesDataBuilder;
import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;

import java.io.File;

class ArchiveFilesFactory {
    static ExcelArchiveFiles create(File excelFile) {
        return new ExcelArchiveFilesDataBuilder()
                .withExcelFile(excelFile)
                .build();
    }
}
