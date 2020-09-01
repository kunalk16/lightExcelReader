package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.utils.string.StringUtils;

public enum ExcelDataFiles {
    WORKBOOK_FILE("xl/workbook.xml"),

    SHARED_STRINGS_FILE("xl/sharedStrings.xml"),

    SHEET_FILE("xl/worksheets/sheet");

    private static final String XML_EXTENSION = ".xml";

    private final String fileName;

    ExcelDataFiles(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public static ExcelDataFiles matchByName(String fileName) {
        if (StringUtils.equals(WORKBOOK_FILE.fileName, fileName)) {
            return WORKBOOK_FILE;
        } else if (StringUtils.equals(SHARED_STRINGS_FILE.fileName, fileName)) {
            return SHARED_STRINGS_FILE;
        } else if (StringUtils.isNotEmpty(fileName)) {
            if (StringUtils.startsWith(fileName, SHEET_FILE.fileName) && StringUtils.endsWith(fileName, XML_EXTENSION)) {
                return SHEET_FILE;
            }
        }
        return null;
    }
}
