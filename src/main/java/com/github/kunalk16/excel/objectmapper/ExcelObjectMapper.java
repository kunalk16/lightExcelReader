package com.github.kunalk16.excel.objectmapper;

import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import com.github.kunalk16.excel.objectmapper.filter.ValidSheetFilter;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ExcelObjectMapper {
    public static <T> List<T> createObjectFromSheet(Sheet sheet, Class<T> modelClass) {
        return createObjectFromSheet(sheet, modelClass, 1);
    }

    public static <T> List<T> createObjectFromSheet(Sheet sheet, Class<T> modelClass, int headerRowIndex) {
        if (Objects.nonNull(sheet) && Objects.nonNull(modelClass) && headerRowIndex > 0 && new ValidSheetFilter().test(sheet)) {
            Iterator<Row> rowIterator = sheet.getRows().iterator();

            if (headerRowIndex == 1) {
                return ExcelObjectFromSheetMapper.createObjectFromSheet(modelClass, rowIterator);
            }

            int previous = 0;
            for (int i = 1; i <= headerRowIndex; i++) {
                if (rowIterator.hasNext()) {
                    Row row = rowIterator.next();
                    if (row.getRow() == headerRowIndex - 1) {
                        return ExcelObjectFromSheetMapper.createObjectFromSheet(modelClass, rowIterator);
                    } else if (row.getRow() == headerRowIndex) {
                        break;
                    }
                }
                previous = i;
            }

            rowIterator = sheet.getRows().iterator();

            for (int i = 1; i <= previous; i++) {
                rowIterator.next();
            }

            return ExcelObjectFromSheetMapper.createObjectFromSheet(modelClass, rowIterator);
        }

        return Collections.emptyList();
    }

    public static <T> T createObjectFromWorkBook(WorkBook workBook, Class<T> modelClass) {
        return ExcelObjectFromWorkbookMapper.createObjectFromWorkBook(workBook, modelClass);
    }
}
