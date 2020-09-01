package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelSheet;

import java.util.List;

public class TestSportsModel extends TestBaseSportsModel {
    @ExcelSheet(name = "Football")
    private List<TestFootballPlayerModel> footballPlayerModels;

    public List<TestFootballPlayerModel> getFootballPlayerModels() {
        return this.footballPlayerModels;
    }
}
