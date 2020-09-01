package com.github.kunalk16.excel.objectmapper.filter;

import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ValidWorkBookFilterTest {
    private static Predicate<WorkBook> validWorkBookFilter;

    @Mock
    private WorkBook workBook;

    @Mock
    private Sheet sheet;

    @BeforeAll
    public static void setUp() {
        validWorkBookFilter = new ValidWorkBookFilter();
    }

    @Test
    public void testNullWorkBook() {
        assertFalse(validWorkBookFilter.test(null));
    }

    @Test
    public void testWorkBookWithNoSheets() {
        when(workBook.getSheets()).thenReturn(Collections.emptyList());
        assertFalse(validWorkBookFilter.test(workBook));
    }

    @Test
    public void testWorkBookWithSheet() {
        when(workBook.getSheets()).thenReturn(Collections.singletonList(sheet));
        assertTrue(validWorkBookFilter.test(workBook));
    }
}
