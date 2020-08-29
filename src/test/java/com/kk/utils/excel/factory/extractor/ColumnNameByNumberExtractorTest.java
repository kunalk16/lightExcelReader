package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.factory.WorkBookFactory;
import com.kk.utils.excel.model.user.Cell;
import com.kk.utils.excel.model.user.Row;
import com.kk.utils.excel.model.user.Sheet;
import com.kk.utils.excel.model.user.WorkBook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ColumnNameByNumberExtractorTest {
    private static Function<Integer, String> columnNameByNumberExtractor;

    @BeforeAll
    public static void setUp() {
        columnNameByNumberExtractor = ColumnNameByNumberExtractor.getInstance();
    }

    @Test
    public void testColumnNameByNumber() {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource("column_number.xlsx").getFile());

        assertNotNull(workBook);

        Sheet sheet = workBook.getSheet(0);

        assertNotNull(sheet);

        Row row = sheet.getRowByIndex(1);

        assertNotNull(row);

        for (Cell cell : row.getCells()) {
            int cellNumber = Integer.parseInt(cell.getValue());
            assertEquals(cell.getColumn(), columnNameByNumberExtractor.apply(cellNumber));
        }
    }
}