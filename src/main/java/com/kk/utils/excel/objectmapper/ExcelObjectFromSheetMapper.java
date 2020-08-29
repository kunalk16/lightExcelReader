package com.kk.utils.excel.objectmapper;

import com.kk.utils.excel.model.user.Row;
import com.kk.utils.excel.objectmapper.annotations.ExcelColumn;
import com.kk.utils.excel.objectmapper.extractor.ColumnByHeaderRowValueExtractor;
import com.kk.utils.excel.objectmapper.extractor.FieldsFromClassExtractor;
import com.kk.utils.excel.objectmapper.extractor.ObjectFromRowExtractor;

import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

public class ExcelObjectFromSheetMapper {
    static <T> List<T> createObjectFromSheet(Class<T> modelClass, Iterator<Row> rowIterator) {
        if (rowIterator.hasNext()) {
            Map<String, Field> fieldsFromClass = new FieldsFromClassExtractor<>(ExcelColumn.class).apply(modelClass);
            if (fieldsFromClass.isEmpty()) {
                return Collections.emptyList();
            }

            Map<String, String> columnByHeaderRowValue = new ColumnByHeaderRowValueExtractor().apply(rowIterator.next());

            if (columnByHeaderRowValue.isEmpty()) {
                return Collections.emptyList();
            }

            if (!rowIterator.hasNext()) {
                return Collections.emptyList();
            }

            List<T> modelRows = new ArrayList<>();

            Function<Row, T> objectFromRowExtractor = new ObjectFromRowExtractor<>(modelClass,
                    fieldsFromClass, columnByHeaderRowValue);

            while (rowIterator.hasNext()) {
                Optional.ofNullable(rowIterator.next())
                        .map(objectFromRowExtractor)
                        .ifPresent(modelRows::add);
            }

            return Collections.unmodifiableList(modelRows);
        }

        return Collections.emptyList();
    }
}
