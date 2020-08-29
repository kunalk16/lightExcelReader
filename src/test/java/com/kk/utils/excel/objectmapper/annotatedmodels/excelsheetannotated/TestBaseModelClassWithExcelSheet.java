package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;

public class TestBaseModelClassWithExcelSheet {
    @ExcelSheet(name = "C")
    private int c;

    @ExcelSheet(name = "Python")
    private double python;
}
