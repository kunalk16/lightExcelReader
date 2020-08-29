package com.kk.utils.excel.objectmapper;

import com.kk.utils.excel.model.user.Sheet;
import com.kk.utils.excel.model.user.WorkBook;
import com.kk.utils.excel.objectmapper.annotations.ExcelSheet;
import com.kk.utils.excel.objectmapper.extractor.FieldsFromClassExtractor;
import com.kk.utils.excel.objectmapper.filter.ValidWorkBookFilter;
import com.kk.utils.excel.utils.logger.ExcelReaderLogger;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Objects;

public class ExcelObjectFromWorkbookMapper {
    static <T> T createObjectFromWorkBook(WorkBook workBook, Class<T> modelClass) {
        if (Objects.nonNull(modelClass) && new ValidWorkBookFilter().test(workBook)) {
            Map<String, Field> fieldsFromClass = new FieldsFromClassExtractor<>(ExcelSheet.class).apply(modelClass);

            if (fieldsFromClass.isEmpty()) {
                return null;
            }

            T instance = createInstance(modelClass);

            if (Objects.isNull(instance)) {
                return null;
            }

            for (String name : fieldsFromClass.keySet()) {
                Sheet sheet = workBook.getSheet(name);
                Field field = fieldsFromClass.get(name);

                addListToField(instance, sheet, field);
            }

            return instance;
        }

        return null;
    }

    private static <T> T createInstance(Class<T> modelClass) {
        try {
            return modelClass.newInstance();
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe("Could not create model instance " + e.getLocalizedMessage());
            return null;
        }
    }

    private static <T> void addListToField(T instance, Sheet sheet, Field field) {
        try {
            if (Objects.nonNull(sheet)) {
                ParameterizedType parameterizedType = (ParameterizedType) field.getGenericType();
                Type genericParameterType = parameterizedType.getActualTypeArguments()[0];

                Class<?> classOfSheet = Class.forName(genericParameterType.getTypeName());

                field.setAccessible(true);
                field.set(instance, ExcelObjectFromSheetMapper.createObjectFromSheet(classOfSheet, sheet.getRows().iterator()));
            }
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().warning(e.getLocalizedMessage());
        }
    }
}
