package com.kk.utils.excel.objectmapper.extractor;

import com.kk.utils.excel.objectmapper.annotatedmodels.excelcolumnannotated.TestModelClassWithExcelColumn;
import com.kk.utils.excel.objectmapper.annotatedmodels.excelsheetannotated.TestModelClassWithExcelSheet;
import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;
import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FieldsFromClassExtractorTest {
    @Test
    public void testExcelColumnFields() {
        Function<Class<?>, Map<String, Field>> fieldsByNameExtractor = new FieldsFromClassExtractor<>(ExcelColumn.class);

        Map<String, Field> fieldsByName = fieldsByNameExtractor.apply(TestModelClassWithExcelColumn.class);

        assertEquals(4, fieldsByName.size());
        assertEquals("firstName", fieldsByName.get("First Name").getName());
        assertEquals("lastName", fieldsByName.get("Last Name").getName());
        assertEquals("city", fieldsByName.get("City").getName());
        assertEquals("country", fieldsByName.get("Country").getName());
    }

    @Test
    public void testExcelSheetFields() {
        Function<Class<?>, Map<String, Field>> fieldsByNameExtractor = new FieldsFromClassExtractor<>(ExcelSheet.class);

        Map<String, Field> fieldsByName = fieldsByNameExtractor.apply(TestModelClassWithExcelSheet.class);

        assertEquals(4, fieldsByName.size());
        assertEquals("c", fieldsByName.get("C").getName());
        assertEquals("cPlusPlus", fieldsByName.get("C++").getName());
        assertEquals("java", fieldsByName.get("Java").getName());
        assertEquals("python", fieldsByName.get("Python").getName());
    }
}
