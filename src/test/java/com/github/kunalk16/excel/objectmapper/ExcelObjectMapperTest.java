package com.github.kunalk16.excel.objectmapper;

import com.github.kunalk16.excel.factory.WorkBookFactory;
import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import com.github.kunalk16.excel.objectmapper.annotatedmodels.excelcolumnannotated.TestModelClassWithExcelColumn;
import com.github.kunalk16.excel.objectmapper.annotatedmodels.excelsheetannotated.TestSportsModel;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ExcelObjectMapperTest {
    @Test
    public void testObjectFromExcelColumn() {
        Sheet sheet = getFirstSheet("excel_column.xlsx");

        List<TestModelClassWithExcelColumn> modelObjects = ExcelObjectMapper.createObjectFromSheet(sheet, TestModelClassWithExcelColumn.class);

        assertEquals(3, modelObjects.size());

        assertEquals("Kunal Karmakar Kurseong India", modelObjects.get(0).toString());
        assertEquals("James Bond London England", modelObjects.get(1).toString());
        assertEquals("John Wick null null", modelObjects.get(2).toString());
    }

    @Test
    public void testObjectFromExcelColumnIncomplete() {
        Sheet sheet = getFirstSheet("excel_column_incomplete.xlsx");

        List<TestModelClassWithExcelColumn> modelObjects = ExcelObjectMapper.createObjectFromSheet(sheet, TestModelClassWithExcelColumn.class);

        assertEquals(3, modelObjects.size());

        assertEquals("Kunal null Kurseong India", modelObjects.get(0).toString());
        assertEquals("James null London England", modelObjects.get(1).toString());
        assertEquals("John null null null", modelObjects.get(2).toString());
    }

    @Test
    public void testObjectFromExcelWorkBook() {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource("sports.xlsx").getFile());

        TestSportsModel testSportsModel = ExcelObjectMapper.createObjectFromWorkBook(workBook, TestSportsModel.class);

        assertEquals(2, testSportsModel.getFootballPlayerModels().size());
        assertEquals(2, testSportsModel.getCricketPlayerModels().size());

        assertEquals("Ganguly", testSportsModel.getCricketPlayerModels().get(0).getName());
        assertEquals("183*", testSportsModel.getCricketPlayerModels().get(0).getRuns());
        assertEquals("Dhoni", testSportsModel.getCricketPlayerModels().get(1).getName());
        assertEquals("150", testSportsModel.getCricketPlayerModels().get(1).getRuns());

        assertEquals("Ronaldo", testSportsModel.getFootballPlayerModels().get(0).getName());
        assertEquals("200", testSportsModel.getFootballPlayerModels().get(0).getGoals());
        assertEquals("Messi", testSportsModel.getFootballPlayerModels().get(1).getName());
        assertEquals("190", testSportsModel.getFootballPlayerModels().get(1).getGoals());
    }

    private Sheet getFirstSheet(String resourceName) {
        WorkBook workBook = WorkBookFactory.create(getClass().getResource(resourceName).getFile());

        assertNotNull(workBook);

        Sheet sheet = workBook.getSheet(0);

        assertNotNull(sheet);

        return sheet;
    }
}
