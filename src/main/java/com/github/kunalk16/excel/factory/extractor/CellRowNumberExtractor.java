package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.model.jaxb.worksheet.RowType;
import com.github.kunalk16.excel.model.user.Cell;

import java.util.List;
import java.util.function.Function;

public class CellRowNumberExtractor implements Function<List<Cell>, Integer> {
    private final RowType row;

    public CellRowNumberExtractor(RowType row) {
        this.row = row;
    }

    @Override
    public Integer apply(List<Cell> cells) {
        return cells.stream().findFirst()
                .map(Cell::getRow)
                .orElse(Integer.parseInt(this.row.getRowNumber()));
    }
}
