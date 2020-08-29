package com.kk.utils.excel.factory;

import com.kk.utils.excel.factory.builder.ExcelArchiveFilesDataBuilder;
import com.kk.utils.excel.model.factory.ExcelArchiveFiles;

import java.io.File;

class ArchiveFilesFactory {
    static ExcelArchiveFiles create(File excelFile) {
        return new ExcelArchiveFilesDataBuilder()
                .withExcelFile(excelFile)
                .build();
    }
}
