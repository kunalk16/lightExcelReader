package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.model.user.Cell;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class CellByColumnExtractor implements Function<List<Cell>, Map<String, Cell>> {
    @Override
    public Map<String, Cell> apply(List<Cell> cells) {
        return cells.stream()
                .collect(LinkedHashMap::new, (map, cell) -> map.put(cell.getColumn(), cell), Map::putAll);
    }
}
