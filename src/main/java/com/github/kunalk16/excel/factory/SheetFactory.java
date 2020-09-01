package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.extractor.RowByNumberExtractor;
import com.github.kunalk16.excel.factory.filter.NonEmptyRowFilter;
import com.github.kunalk16.excel.model.factory.ExcelSheet;
import com.github.kunalk16.excel.model.jaxb.sharedstrings.SharedStringType;
import com.github.kunalk16.excel.model.jaxb.worksheet.SheetDataType;
import com.github.kunalk16.excel.model.jaxb.worksheet.WorkSheetType;
import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.model.user.Sheet;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class SheetFactory {
    static Sheet create(SharedStringType sharedStrings, WorkSheetType workSheet, String sheetName) {
        return Optional.ofNullable(getRows(sharedStrings, workSheet))
                .map(new RowByNumberExtractor())
                .map(rowByNumber -> new ExcelSheet(rowByNumber, sheetName))
                .orElse(null);
    }

    private static List<Row> getRows(SharedStringType sharedStrings, WorkSheetType workSheet) {
        return Optional.ofNullable(workSheet)
                .map(WorkSheetType::getSheetData)
                .map(SheetDataType::getRows)
                .orElse(Collections.emptyList())
                .stream()
                .map(row -> RowFactory.create(sharedStrings, row))
                .filter(new NonEmptyRowFilter())
                .collect(Collectors.toList());
    }
}
