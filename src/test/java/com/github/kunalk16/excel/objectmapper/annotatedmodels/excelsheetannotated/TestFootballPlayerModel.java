package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelColumn;

public class TestFootballPlayerModel extends TestPlayerModel {
    @ExcelColumn(name = "Goals")
    private String goals;

    public String getGoals() {
        return this.goals;
    }
}
