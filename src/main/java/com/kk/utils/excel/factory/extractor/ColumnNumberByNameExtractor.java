package com.kk.utils.excel.factory.extractor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ColumnNumberByNameExtractor implements Function<String, Integer> {
    private final Map<String, Integer> columnNumberCache;

    private ColumnNumberByNameExtractor() {
        this.columnNumberCache = new HashMap<>();
    }

    public static ColumnNumberByNameExtractor getInstance() {
        return ColumnNumberByNameExtractorInstanceHolder.INSTANCE;
    }

    @Override
    public Integer apply(String columnName) {
        return this.columnNumberCache.computeIfAbsent(columnName, this::getColumnNumber);
    }

    private int getColumnNumber(String columnName) {
        int columnNumber = 0;
        int power = 1;

        for (int i = columnName.length() - 1; i >= 0; i--) {
            char ch = Character.toUpperCase(columnName.charAt(i));
            columnNumber += power * (ch - 'A' + 1);
            power *= 26;
        }

        return columnNumber;
    }

    private static class ColumnNumberByNameExtractorInstanceHolder {
        private static final ColumnNumberByNameExtractor INSTANCE = new ColumnNumberByNameExtractor();
    }
}
