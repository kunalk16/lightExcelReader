package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.model.user.Sheet;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class SheetByNameExtractor implements Function<List<Sheet>, Map<String, Sheet>> {
    @Override
    public Map<String, Sheet> apply(List<Sheet> sheets) {
        return sheets.stream()
                .collect(LinkedHashMap::new, (map, sheet) -> map.put(sheet.getSheetName(), sheet), Map::putAll);
    }
}
