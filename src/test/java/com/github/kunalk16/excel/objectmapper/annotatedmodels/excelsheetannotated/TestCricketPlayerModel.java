package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelColumn;

public class TestCricketPlayerModel extends TestPlayerModel {
    @ExcelColumn(name = "Runs")
    private String runs;

    public String getRuns() {
        return runs;
    }
}
