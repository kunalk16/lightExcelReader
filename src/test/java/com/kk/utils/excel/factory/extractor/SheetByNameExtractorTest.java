package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.model.user.Sheet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SheetByNameExtractorTest {
    @Mock
    private Sheet sheet1, sheet2, sheet3;

    @BeforeEach
    public void setUp() {
        when(sheet1.getSheetName()).thenReturn("SHEET-1");
        when(sheet2.getSheetName()).thenReturn("SHEET-2");
        when(sheet3.getSheetName()).thenReturn("SHEET-3");
    }

    @Test
    public void testSheetByNameExtraction() {
        List<Sheet> sheets = Arrays.asList(sheet1, sheet2, sheet3);

        Map<String, Sheet> sheetByName = new SheetByNameExtractor().apply(sheets);

        int count = 0;
        for (String name : sheetByName.keySet()) {
            assertEquals("SHEET-" + (count + 1), name);
            assertEquals(sheets.get(count), sheetByName.get(name));
            count++;
        }
    }
}
