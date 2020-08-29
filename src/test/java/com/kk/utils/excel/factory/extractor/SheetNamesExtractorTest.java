package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.model.jaxb.workbook.SheetType;
import com.kk.utils.excel.model.jaxb.workbook.SheetsType;
import com.kk.utils.excel.model.jaxb.workbook.WorkBookType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SheetNamesExtractorTest {
    @Mock
    private WorkBookType workBook;

    @Mock
    private SheetsType sheets;

    @Mock
    private SheetType sheet1, sheet2, sheet3;

    @BeforeEach
    public void setUp() {
        when(workBook.getSheets()).thenReturn(sheets);
        when(sheets.getSheets()).thenReturn(Arrays.asList(sheet1, sheet2, sheet3));
        when(sheet1.getName()).thenReturn("Sheet1");
        when(sheet2.getName()).thenReturn("Sheet2");
        when(sheet3.getName()).thenReturn("Sheet3");
    }

    @Test
    public void testSheetNamesExtraction() {
        List<String> extractedNames = new SheetNamesExtractor().apply(workBook);

        assertEquals(Arrays.asList("Sheet1", "Sheet2", "Sheet3"), extractedNames);
    }
}
