package com.kk.utils.excel.factory.filter;

import com.kk.utils.excel.model.user.Cell;
import com.kk.utils.excel.model.user.Row;
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
public class NonEmptyRowFilterTest {
    @Mock
    private Row row;

    @Mock
    private Cell cell;

    private static Predicate<Row> predicate;

    @BeforeAll
    public static void setUp() {
        predicate = new NonEmptyRowFilter();
    }

    @Test
    public void testNonEmptyRow() {
        when(row.getCells()).thenReturn(Collections.singletonList(cell));

        assertTrue(predicate.test(row));
    }

    @Test
    public void testEmptyRow() {
        when(row.getCells()).thenReturn(Collections.emptyList());

        assertFalse(predicate.test(row));
    }
}
