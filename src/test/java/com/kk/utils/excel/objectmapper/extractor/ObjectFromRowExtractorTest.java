package com.kk.utils.excel.objectmapper.extractor;

import com.kk.utils.excel.model.user.Cell;
import com.kk.utils.excel.model.user.Row;
import com.kk.utils.excel.objectmapper.annotatedmodels.excelcolumnannotated.TestModelClassWithExcelColumn;
import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ObjectFromRowExtractorTest {
    @Mock
    private Row headerRow, valueRow;

    @Mock
    private Cell cell11, cell12, cell13, cell14, cell21, cell22, cell23, cell24;

    @BeforeEach
    public void setUp() {
        when(headerRow.getCells()).thenReturn(Arrays.asList(cell11, cell12, cell13, cell14));

        bindRowToColumn(valueRow, cell21, "A");
        bindRowToColumn(valueRow, cell22, "B");
        bindRowToColumn(valueRow, cell23, "C");
        bindRowToColumn(valueRow, cell24, "D");

        setValue(cell11, "A", "First Name");
        setValue(cell12, "B", "Last Name");
        setValue(cell13, "C", "City");
        setValue(cell14, "D", "Country");

        setValue(cell21, "Kunal");
        setValue(cell22, "Karmakar");
        setValue(cell23, "Kurseong");
        setValue(cell24, "India");
    }

    @Test
    public void testObjectFromRowExtraction() {
        Map<String, String> columnByHeaderRow = new ColumnByHeaderRowValueExtractor().apply(headerRow);
        Map<String, Field> fieldsFromClass = new FieldsFromClassExtractor<>(ExcelColumn.class)
                .apply(TestModelClassWithExcelColumn.class);

        ObjectFromRowExtractor<TestModelClassWithExcelColumn> objectFromRowExtractor =
                new ObjectFromRowExtractor<>(TestModelClassWithExcelColumn.class,
                        fieldsFromClass, columnByHeaderRow);

        TestModelClassWithExcelColumn instance = objectFromRowExtractor.apply(valueRow);

        assertEquals("Kunal", instance.getFirstName());
        assertEquals("Karmakar", instance.getLastName());
        assertEquals("Kurseong", instance.getCity());
        assertEquals("India", instance.getCountry());
    }

    private void bindRowToColumn(Row row, Cell cell, String column) {
        when(row.getCellByColumn(column)).thenReturn(cell);
    }

    private void setValue(Cell cell, String column, String value) {
        when(cell.getColumn()).thenReturn(column);
        setValue(cell, value);
    }

    private void setValue(Cell cell, String value) {
        when(cell.getValue()).thenReturn(value);
    }
}
