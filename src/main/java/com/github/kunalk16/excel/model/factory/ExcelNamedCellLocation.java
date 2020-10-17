package com.github.kunalk16.excel.model.factory;

public class ExcelNamedCellLocation {
    private final String sheetName;

    private final String column;

    private final int row;

    public ExcelNamedCellLocation(String sheetName, String column, int row) {
        this.sheetName = sheetName;
        this.column = column;
        this.row = row;
    }

    public String getSheetName() {
        return sheetName;
    }

    public String getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }
}
