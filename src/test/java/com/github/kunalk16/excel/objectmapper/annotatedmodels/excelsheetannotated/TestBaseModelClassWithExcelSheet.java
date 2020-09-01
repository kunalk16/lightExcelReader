package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelSheet;

public class TestBaseModelClassWithExcelSheet {
    @ExcelSheet(name = "C")
    private int c;

    @ExcelSheet(name = "Python")
    private double python;
}
