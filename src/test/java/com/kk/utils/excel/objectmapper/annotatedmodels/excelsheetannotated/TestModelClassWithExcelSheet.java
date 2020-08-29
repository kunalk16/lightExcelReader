package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;

public class TestModelClassWithExcelSheet extends TestBaseModelClassWithExcelSheet {
    @ExcelSheet(name = "Java")
    private int java;

    @ExcelSheet(name = "C++")
    private String cPlusPlus;
}
