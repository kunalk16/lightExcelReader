package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;

public class TestFootballPlayerModel extends TestPlayerModel {
    @ExcelColumn(name = "Goals")
    private String goals;

    public String getGoals() {
        return this.goals;
    }
}
