package com.kk.utils.excel.factory.extractor;

import com.kk.utils.excel.model.jaxb.worksheet.CellType;

import java.util.function.BiFunction;
import java.util.function.IntPredicate;

public class CellPositionDataExtractor implements BiFunction<IntPredicate, CellType, String> {
    @Override
    public String apply(IntPredicate predicate, CellType cell) {
        StringBuilder position = new StringBuilder();

        cell.getPosition().chars()
                .filter(predicate)
                .mapToObj(index -> (char) index)
                .forEach(position::append);

        return position.toString();
    }
}
