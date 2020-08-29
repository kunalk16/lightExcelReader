package com.kk.utils.excel.model.factory;

import com.kk.utils.excel.factory.extractor.ColumnNumberByNameExtractor;
import com.kk.utils.excel.model.user.Cell;

public class ExcelCell implements Cell {
    private final int row;

    private final String column;

    private final String value;

    public ExcelCell(int row, String column, String value) {
        this.row = row;
        this.column = column;
        this.value = value;
    }

    @Override
    public int getRow() {
        return this.row;
    }

    @Override
    public String getColumn() {
        return this.column;
    }

    @Override
    public int getColumnIndex() {
        return ColumnNumberByNameExtractor.getInstance().apply(this.getColumn());
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
