package com.kk.utils.excel.factory.filter;

import com.kk.utils.excel.model.user.Row;

import java.util.function.Predicate;

public class NonEmptyRowFilter implements Predicate<Row> {
    @Override
    public boolean test(Row row) {
        return !row.getCells().isEmpty();
    }
}
