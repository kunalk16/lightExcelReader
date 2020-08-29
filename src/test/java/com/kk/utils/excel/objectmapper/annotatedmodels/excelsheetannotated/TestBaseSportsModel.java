package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;

import java.util.List;

public class TestBaseSportsModel {
    @ExcelSheet(name = "Cricket")
    private List<TestCricketPlayerModel> cricketPlayerModels;

    public List<TestCricketPlayerModel> getCricketPlayerModels() {
        return this.cricketPlayerModels;
    }
}
