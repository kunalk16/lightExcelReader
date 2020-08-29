package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.model.user.Row;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class RowByNumberExtractor implements Function<List<Row>, Map<Integer, Row>> {
    @Override
    public Map<Integer, Row> apply(List<Row> rows) {
        return rows.stream()
                .collect(LinkedHashMap::new, (map, row) -> map.put(getRowNumber(row), row), Map::putAll);
    }

    private int getRowNumber(Row row) {
        return row.getRow();
    }
}
