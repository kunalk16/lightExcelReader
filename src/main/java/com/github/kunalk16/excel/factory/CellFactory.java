package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.extractor.CellPositionDataExtractor;
import com.github.kunalk16.excel.model.factory.ExcelCell;
import com.github.kunalk16.excel.model.jaxb.sharedstrings.SharedStringType;
import com.github.kunalk16.excel.model.jaxb.worksheet.CellType;
import com.github.kunalk16.excel.model.user.Cell;

import java.util.function.IntPredicate;

class CellFactory {
    static Cell create(SharedStringType sharedStrings, CellType cell) {
        int row = getCellRow(cell);
        String column = getCellColumn(cell);
        String value = getValue(sharedStrings, cell);

        return new ExcelCell(row, column, value);
    }

    private static int getCellRow(CellType cell) {
        return Integer.parseInt(getCellPositionData(Character::isDigit, cell));
    }

    private static String getCellColumn(CellType cell) {
        return getCellPositionData(Character::isAlphabetic, cell);
    }

    private static String getCellPositionData(IntPredicate predicate, CellType cell) {
        return new CellPositionDataExtractor().apply(predicate, cell);
    }

    private static String getValue(SharedStringType sharedStrings, CellType cell) {
        return CellValueFactory.create(sharedStrings, cell);
    }
}
