package com.kk.utils.excel.objectmapper.annotatedmodels.excelcolumnannotated;

import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;

public class TestBaseModelClassWithExcelColumn {
    @ExcelColumn(name = "First Name")
    private String firstName;

    @ExcelColumn(name = "Last Name")
    private String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
