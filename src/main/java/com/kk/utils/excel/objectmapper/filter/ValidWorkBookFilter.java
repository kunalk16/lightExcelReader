package com.kk.utils.excel.objectmapper.filter;

import com.kk.utils.excel.model.user.WorkBook;

import java.util.Optional;
import java.util.function.Predicate;

public class ValidWorkBookFilter implements Predicate<WorkBook> {
    @Override
    public boolean test(WorkBook workBook) {
        return Optional.ofNullable(workBook)
                .map(WorkBook::getSheets)
                .map(sheets -> !sheets.isEmpty())
                .orElse(false);
    }
}
