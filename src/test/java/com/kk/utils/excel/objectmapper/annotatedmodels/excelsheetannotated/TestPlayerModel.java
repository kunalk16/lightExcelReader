package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;

public class TestPlayerModel {
    @ExcelColumn(name = "Name")
    private String name;

    public String getName() {
        return this.name;
    }
}
