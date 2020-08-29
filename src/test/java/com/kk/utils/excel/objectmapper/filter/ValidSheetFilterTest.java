package com.kk.utils.excel.objectmapper.filter;

import com.kk.utils.excel.model.user.Row;
import com.kk.utils.excel.model.user.Sheet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidSheetFilterTest {
    private static Predicate<Sheet> validSheetFilter;

    @Mock
    private Sheet sheet;

    @Mock
    private Row row;

    @BeforeAll
    public static void setUp() {
        validSheetFilter = new ValidSheetFilter();
    }

    @Test
    public void testNullSheet() {
        assertFalse(validSheetFilter.test(null));
    }

    @Test
    public void testSheetWithNoRows() {
        when(sheet.getRows()).thenReturn(Collections.emptyList());
        assertFalse(validSheetFilter.test(sheet));
    }

    @Test
    public void testSheetWithSingleRow() {
        when(sheet.getRows()).thenReturn(Collections.singletonList(row));
        assertFalse(validSheetFilter.test(sheet));
    }

    @Test
    public void testSheetWithMultipleRows() {
        when(sheet.getRows()).thenReturn(Arrays.asList(row, row));
        assertTrue(validSheetFilter.test(sheet));
    }
}
