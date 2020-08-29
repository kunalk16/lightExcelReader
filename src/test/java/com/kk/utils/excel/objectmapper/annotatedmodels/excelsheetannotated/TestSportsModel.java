package com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;

import java.util.List;

public class TestSportsModel extends TestBaseSportsModel {
    @ExcelSheet(name = "Football")
    private List<TestFootballPlayerModel> footballPlayerModels;

    public List<TestFootballPlayerModel> getFootballPlayerModels() {
        return this.footballPlayerModels;
    }
}
