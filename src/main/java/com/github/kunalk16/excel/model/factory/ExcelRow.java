package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.factory.extractor.ColumnNameByNumberExtractor;
import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Row;

import java.util.Collection;
import java.util.Map;

public class ExcelRow implements Row {
    private final int rowNumber;

    private final Map<String, Cell> cellByColumn;

    public ExcelRow(Map<String, Cell> cellByColumn, int rowNumber) {
        this.cellByColumn = cellByColumn;
        this.rowNumber = rowNumber;
    }

    @Override
    public int getRow() {
        return this.rowNumber;
    }

    @Override
    public Collection<Cell> getCells() {
        return this.cellByColumn.values();
    }

    @Override
    public Cell getCellByColumn(String column) {
        return this.cellByColumn.get(column);
    }

    @Override
    public Cell getCellByIndex(int index) {
        return this.getCellByColumn(ColumnNameByNumberExtractor.getInstance().apply(index));
    }
}
