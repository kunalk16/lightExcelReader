package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.factory.WorkBookFactory;
import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColumnNumberByNameExtractorTest {
    private static Function<String, Integer> columnNumberByNameExtractor;

    @BeforeAll
    public static void setUp() {
        columnNumberByNameExtractor = ColumnNumberByNameExtractor.getInstance();
    }

    @Test
    public void testColumnNumberByName() {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource("column_number.xlsx").getFile());

        assertNotNull(workBook);

        Sheet sheet = workBook.getSheet(0);

        assertNotNull(sheet);

        Row row = sheet.getRowByIndex(1);

        assertNotNull(row);

        for (Cell cell : row.getCells()) {
            int columnNumber = columnNumberByNameExtractor.apply(cell.getColumn());

            assertEquals(cell.getValue(), String.valueOf(columnNumber));
        }
    }
}
