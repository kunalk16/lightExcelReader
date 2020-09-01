package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.model.jaxb.sharedstrings.SharedStringType;
import com.github.kunalk16.excel.model.jaxb.workbook.WorkBookType;
import com.github.kunalk16.excel.model.jaxb.worksheet.WorkSheetType;

import java.util.List;

public class ExcelXMLData {
    private final WorkBookType workBook;

    private final SharedStringType sharedString;

    private final List<WorkSheetType> sheets;

    public ExcelXMLData(WorkBookType workBook, SharedStringType sharedString, List<WorkSheetType> sheets) {
        this.workBook = workBook;
        this.sharedString = sharedString;
        this.sheets = sheets;
    }

    public WorkBookType getWorkBook() {
        return workBook;
    }

    public SharedStringType getSharedString() {
        return sharedString;
    }

    public List<WorkSheetType> getSheets() {
        return sheets;
    }
}
