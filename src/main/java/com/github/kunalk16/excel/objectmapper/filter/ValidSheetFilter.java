package com.github.kunalk16.excel.objectmapper.filter;

import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.model.user.Sheet;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Predicate;

public class ValidSheetFilter implements Predicate<Sheet> {
    @Override
    public boolean test(Sheet sheet) {
        return Optional.ofNullable(sheet)
                .map(Sheet::getRows)
                .map(this::isValidCollection)
                .orElse(false);
    }

    private boolean isValidCollection(Collection<Row> rows) {
        return rows.size() > 1;
    }
}
