package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelSheet;

import java.util.List;

public class TestBaseSportsModel {
    @ExcelSheet(name = "Cricket")
    private List<TestCricketPlayerModel> cricketPlayerModels;

    public List<TestCricketPlayerModel> getCricketPlayerModels() {
        return this.cricketPlayerModels;
    }
}
