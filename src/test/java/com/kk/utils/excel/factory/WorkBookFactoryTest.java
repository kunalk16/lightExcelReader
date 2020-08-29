package com.kk.utils.excel.factory;

import com.kk.utils.excel.model.user.Sheet;
import com.kk.utils.excel.model.user.WorkBook;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class WorkBookFactoryTest {
    @Test
    public void testWorkBookCreation() {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource("sample.xlsx").getFile());

        assertNotNull(workBook);
    }

    @Test
    public void testMultiSheetWorkBookCreation() {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource("multi-sheet.xlsx").getFile());

        assertNotNull(workBook);

        Sheet start = workBook.getSheet("Start");

        assertNotNull(start);

        assertEquals("12", start.getRowByIndex(1).getCellByColumn("A").getValue());
        assertEquals("Kun-Test", start.getRowByIndex(2).getCellByColumn("B").getValue());

        Sheet intermediate = workBook.getSheet(1);

        assertNotNull(intermediate);

        assertEquals("900", intermediate.getRowByIndex(1).getCellByColumn("B").getValue());
        assertEquals("1213", intermediate.getRowByIndex(2).getCellByColumn("A").getValue());
        assertEquals(">123<", intermediate.getRowByIndex(2).getCellByColumn("B").getValue());
        assertEquals("Test*&^@*&^", intermediate.getRowByIndex(3).getCellByColumn("B").getValue());
    }
}
