package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SheetFactoryTest {
    private static Sheet sheet;

    @BeforeAll
    public static void setUp() {
        WorkBook workBook = WorkBookFactory.create(SheetFactoryTest.class.getResource("scattered.xlsx").getFile());
        sheet = Optional.ofNullable(workBook)
                .map(book -> book.getSheet(0))
                .orElse(null);
    }

    @Test
    public void testCellFromRowAndColumnName() {
        checkCellFromRowAndColumnName(1, "A", "A1");
        checkCellFromRowAndColumnName(33, "AQ", "AQ33");
        checkCellFromRowAndColumnName(3, "C", "C3");
        checkCellFromRowAndColumnName(20, "P", "P20");
    }

    @Test
    public void testCellFromRowAndColumnIndex() {
        checkCellFromRowAndColumnIndex(1, 1, "A1");
        checkCellFromRowAndColumnIndex(33, 43, "AQ33");
        checkCellFromRowAndColumnIndex(3, 3, "C3");
        checkCellFromRowAndColumnIndex(20, 16, "P20");
    }

    private void checkCellFromRowAndColumnName(int rowIndex, String columnName, String expected) {
        assertNotNull(sheet.getCell(rowIndex, columnName));
        assertEquals(expected, sheet.getCell(rowIndex, columnName).getValue());
    }

    private void checkCellFromRowAndColumnIndex(int rowIndex, int columnIndex, String expected) {
        assertNotNull(sheet.getCell(rowIndex, columnIndex));
        assertEquals(expected, sheet.getCell(rowIndex, columnIndex).getValue());
    }
}
