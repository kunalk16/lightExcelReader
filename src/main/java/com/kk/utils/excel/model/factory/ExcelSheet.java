package com.kk.utils.excel.model.factory;

import com.kk.utils.excel.model.user.Row;
import com.kk.utils.excel.model.user.Sheet;

import java.util.Collection;
import java.util.Map;

public class ExcelSheet implements Sheet {
    private final Map<Integer, Row> rowByNumber;
    private final String sheetName;

    public ExcelSheet(Map<Integer, Row> rowByNumber, String sheetName) {
        this.rowByNumber = rowByNumber;
        this.sheetName = sheetName;
    }

    @Override
    public String getSheetName() {
        return this.sheetName;
    }

    @Override
    public Collection<Row> getRows() {
        return this.rowByNumber.values();
    }

    @Override
    public Row getRowByIndex(int index) {
        return this.rowByNumber.get(index);
    }
}
