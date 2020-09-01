package com.github.kunalk16.excel.objectmapper.extractor;

import com.github.kunalk16.excel.model.user.Row;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ColumnByHeaderRowValueExtractor implements Function<Row, Map<String, String>> {
    @Override
    public Map<String, String> apply(Row row) {
        Map<String, String> columnByHeaderRowValue = new HashMap<>();
        row.getCells().forEach(cell -> columnByHeaderRowValue.put(cell.getValue(), cell.getColumn()));

        return columnByHeaderRowValue;
    }
}
