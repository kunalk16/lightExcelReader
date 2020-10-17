package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;

import java.util.*;

public class ExcelWorkBook implements WorkBook {
    private final Map<String, Sheet> sheetByName;
    private final List<Sheet> sheetList;
    private final Map<String, ExcelNamedCellLocation> cellLocationByName;

    public ExcelWorkBook(Map<String, Sheet> sheetByName, Map<String, ExcelNamedCellLocation> cellLocationByName) {
        this.sheetByName = sheetByName;
        this.sheetList = Collections.unmodifiableList(new ArrayList<>(this.sheetByName.values()));
        this.cellLocationByName = cellLocationByName;
    }

    @Override
    public Sheet getSheet(int index) {
        return this.sheetList.get(index);
    }

    @Override
    public Sheet getSheet(String sheetName) {
        return this.sheetByName.get(sheetName);
    }

    @Override
    public Collection<Sheet> getSheets() {
        return this.sheetByName.values();
    }

    @Override
    public Cell getCellByDefinedName(String definedName) {
        if (!this.cellLocationByName.containsKey(definedName)) {
            return null;
        }

        return Optional.of(this.cellLocationByName.get(definedName))
                .filter(cellLocation -> Objects.nonNull(this.getSheet(cellLocation.getSheetName())))
                .map(cellLocation -> this.getSheet(cellLocation.getSheetName())
                        .getCell(cellLocation.getRow(), cellLocation.getColumn()))
                .orElse(null);
    }
}
