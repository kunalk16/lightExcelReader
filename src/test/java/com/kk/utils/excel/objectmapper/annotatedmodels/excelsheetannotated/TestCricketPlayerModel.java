package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;

public class TestCricketPlayerModel extends TestPlayerModel {
    @ExcelColumn(name = "Runs")
    private String runs;

    public String getRuns() {
        return runs;
    }
}
