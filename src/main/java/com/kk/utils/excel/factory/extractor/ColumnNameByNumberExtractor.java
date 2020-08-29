package com.kk.utils.excel.factory.extractor;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ColumnNameByNumberExtractor implements Function<Integer, String> {
    private final Map<Integer, String> columnNameCache;

    private ColumnNameByNumberExtractor() {
        this.columnNameCache = new HashMap<>();
    }

    public static ColumnNameByNumberExtractor getInstance() {
        return ColumnNameByNumberExtractorInstanceHolder.INSTANCE;
    }

    @Override
    public String apply(Integer columnNumber) {
        return this.columnNameCache.computeIfAbsent(columnNumber, this::getColumnName);
    }

    private String getColumnName(int columnNumber) {
        StringBuilder columnName = new StringBuilder();

        while (columnNumber > 0) {
            int rem = columnNumber % 26;

            if (rem == 0) {
                columnName.append('Z');
                columnNumber = (columnNumber / 26) - 1;
            } else {
                columnName.append((char) ((rem - 1) + 'A'));
                columnNumber = columnNumber / 26;
            }
        }

        return columnName.reverse().toString();
    }

    private static class ColumnNameByNumberExtractorInstanceHolder {
        private static final ColumnNameByNumberExtractor INSTANCE = new ColumnNameByNumberExtractor();
    }
}
