package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.model.jaxb.sharedstrings.SIType;
import com.github.kunalk16.excel.model.jaxb.sharedstrings.SharedStringType;
import com.github.kunalk16.excel.model.jaxb.worksheet.CellType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class CellValueFactory {
    private static final String STRING_MARKER = "s";

    static String create(SharedStringType sharedStrings, CellType cell) {
        List<SIType> listOfSharedStrings = getListOfSharedStrings(sharedStrings);

        return Optional.of(cell)
                .filter(CellValueFactory::checkCellOfTypeString)
                .map(CellType::getValue)
                .map(Integer::parseInt)
                .map(listOfSharedStrings::get)
                .map(SIType::getValue)
                .orElse(cell.getValue());
    }

    private static List<SIType> getListOfSharedStrings(SharedStringType sharedStrings) {
        return Optional.ofNullable(sharedStrings)
                .map(SharedStringType::getSiTypeList)
                .orElse(Collections.emptyList());
    }

    private static boolean checkCellOfTypeString(CellType cell) {
        return Optional.of(cell)
                .map(CellType::getType)
                .map(STRING_MARKER::equals)
                .orElse(false);
    }
}
