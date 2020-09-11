package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.model.user.Sheet;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

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

    @Override
    public Cell getCell(int rowIndex, String columnName) {
        return Optional.ofNullable(this.getRowByIndex(rowIndex))
                .map(row -> row.getCellByColumn(columnName))
                .orElse(null);
    }

    @Override
    public Cell getCell(int rowIndex, int columnIndex) {
        return Optional.ofNullable(this.getRowByIndex(rowIndex))
                .map(row -> row.getCellByIndex(columnIndex))
                .orElse(null);
    }
}
