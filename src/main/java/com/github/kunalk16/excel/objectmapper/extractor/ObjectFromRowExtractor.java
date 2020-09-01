package com.github.kunalk16.excel.objectmapper.extractor;

import com.github.kunalk16.excel.model.user.Row;
import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;

import java.lang.reflect.Field;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;

public class ObjectFromRowExtractor<T> implements Function<Row, T> {
    private final Class<T> modelClass;

    private final Map<String, Field> fieldByName;

    private final Map<String, String> columnByHeaderName;

    public ObjectFromRowExtractor(Class<T> modelClass, Map<String, Field> fieldByName, Map<String, String> columnByHeaderName) {
        this.modelClass = modelClass;
        this.fieldByName = fieldByName;
        this.columnByHeaderName = columnByHeaderName;
    }

    @Override
    public T apply(Row row) {
        try {
            T instance = modelClass.newInstance();

            for (String fieldName : fieldByName.keySet()) {
                if (fieldByName.containsKey(fieldName) && columnByHeaderName.containsKey(fieldName) &&
                        Objects.nonNull(row.getCellByColumn(columnByHeaderName.get(fieldName)))) {
                    Field field = getField(modelClass, fieldByName.get(fieldName).getName());

                    field.setAccessible(true);
                    field.set(instance, row.getCellByColumn(columnByHeaderName.get(fieldName)).getValue());
                }
            }

            return instance;
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe("Could not create instance of row object " + e.getLocalizedMessage());
            return null;
        }
    }

    private Field getField(Class<?> modelClass, String fieldName) throws Exception {
        try {
            return modelClass.getDeclaredField(fieldName);
        } catch (Exception e) {
            if (modelClass.getSuperclass() != Object.class) {
                return getField(modelClass.getSuperclass(), fieldName);
            }
            throw e;
        }
    }
}
