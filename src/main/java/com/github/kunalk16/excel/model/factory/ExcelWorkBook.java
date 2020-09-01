package com.github.kunalk16.excel.model.factory;

import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;

import java.util.*;

public class ExcelWorkBook implements WorkBook {
    private final Map<String, Sheet> sheetByName;
    private final List<Sheet> sheetList;

    public ExcelWorkBook(Map<String, Sheet> sheetByName) {
        this.sheetByName = sheetByName;
        this.sheetList = Collections.unmodifiableList(new ArrayList<>(this.sheetByName.values()));
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
}
