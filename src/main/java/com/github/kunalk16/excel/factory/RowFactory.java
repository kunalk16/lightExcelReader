package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.extractor.CellByColumnExtractor;
import com.github.kunalk16.excel.factory.extractor.CellRowNumberExtractor;
import com.github.kunalk16.excel.model.factory.ExcelRow;
import com.github.kunalk16.excel.model.jaxb.sharedstrings.SharedStringType;
import com.github.kunalk16.excel.model.jaxb.worksheet.RowType;
import com.github.kunalk16.excel.model.user.Cell;
import com.github.kunalk16.excel.model.user.Row;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class RowFactory {
    static Row create(SharedStringType sharedStrings, RowType row) {
        List<Cell> cells = Optional.ofNullable(getCells(sharedStrings, row))
                .orElse(Collections.emptyList());

        Map<String, Cell> cellByColumn = Optional.of(cells)
                .map(new CellByColumnExtractor())
                .orElse(Collections.emptyMap());

        return new ExcelRow(cellByColumn, new CellRowNumberExtractor(row).apply(cells));
    }

    private static List<Cell> getCells(SharedStringType sharedStrings, RowType row) {
        return Optional.ofNullable(row)
                .map(RowType::getCells)
                .orElse(Collections.emptyList())
                .stream()
                .map(cell -> CellFactory.create(sharedStrings, cell))
                .collect(Collectors.toList());
    }
}
