package com.github.kunalk16.excel.objectmapper.extractor;

import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Row;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ColumnByHeaderRowValueExtractorTest {
    private static Function<Row, Map<String, String>> columnByHeaderRowValueExtractor;

    @Mock
    private Row row;

    @Mock
    private Cell cell1, cell2, cell3;

    @BeforeAll
    public static void setUp() {
        columnByHeaderRowValueExtractor = new ColumnByHeaderRowValueExtractor();
    }

    @BeforeEach
    public void setUpMocks() {
        when(row.getCells()).thenReturn(Arrays.asList(cell1, cell2, cell3));
        when(cell1.getColumn()).thenReturn("A");
        when(cell1.getValue()).thenReturn("Name");
        when(cell2.getColumn()).thenReturn("B");
        when(cell2.getValue()).thenReturn("City");
        when(cell3.getColumn()).thenReturn("D");
        when(cell3.getValue()).thenReturn("Country");
    }

    @Test
    public void testColumnByHeaderRowValueExtraction() {
        Map<String, String> columnByHeaderRowValue = columnByHeaderRowValueExtractor.apply(row);

        assertEquals(3, columnByHeaderRowValue.size());
        assertEquals("A", columnByHeaderRowValue.get("Name"));
        assertEquals("B", columnByHeaderRowValue.get("City"));
        assertEquals("D", columnByHeaderRowValue.get("Country"));
    }
}
