package com.github.kunalk16.excel.factory.filter;

import com.github.kunalk16.excel.model.user.Row;

import java.util.function.Predicate;

public class NonEmptyRowFilter implements Predicate<Row> {
    @Override
    public boolean test(Row row) {
        return !row.getCells().isEmpty();
    }
}
