package com.github.kunalk16.excel.objectmapper.annotatedmodels.excelcolumnannotated;

import com.github.kunalk16.excel.objectmapper.annotations.ExcelColumn;

public class TestModelClassWithExcelColumn extends TestBaseModelClassWithExcelColumn {
    @ExcelColumn(name = "City")
    private String city;

    @ExcelColumn(name = "Country")
    private String country;

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return getFirstName() + " " + getLastName() + " " + getCity() + " " + getCountry();
    }
}
