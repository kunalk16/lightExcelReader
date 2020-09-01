package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelSheet;

public class TestModelClassWithExcelSheet extends TestBaseModelClassWithExcelSheet {
    @ExcelSheet(name = "Java")
    private int java;

    @ExcelSheet(name = "C++")
    private String cPlusPlus;
}
