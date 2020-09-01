package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelColumn;

public class TestPlayerModel {
    @ExcelColumn(name = "Name")
    private String name;

    public String getName() {
        return this.name;
    }
}
