package com.github.kunalk16.excel.objectmapper.extractor;

import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.*;
import java.util.function.Function;

public class FieldsFromClassExtractor<T extends Annotation> implements Function<Class<?>, Map<String, Field>> {
    private final Class<T> annotationClass;

    public FieldsFromClassExtractor(Class<T> annotationClass) {
        this.annotationClass = annotationClass;
    }

    @Override
    public Map<String, Field> apply(Class<?> modelClass) {
        List<Class<?>> allClasses = getAllClasses(modelClass);

        Map<String, Field> fieldsByName = new HashMap<>();

        allClasses.stream()
                .map(Class::getDeclaredFields)
                .map(Arrays::asList)
                .flatMap(Collection::stream)
                .filter(this::isFieldAnnotated)
                .forEach(field -> storeFieldByName(field, fieldsByName));

        return fieldsByName;
    }

    private List<Class<?>> getAllClasses(Class<?> clazz) {
        List<Class<?>> allClasses = new LinkedList<>();

        Class<?> currentClass = clazz;

        while (currentClass != Object.class) {
            allClasses.add(currentClass);
            currentClass = currentClass.getSuperclass();
        }

        return allClasses;
    }

    private boolean isFieldAnnotated(Field field) {
        return Objects.nonNull(field.getAnnotation(annotationClass));
    }

    private void storeFieldByName(Field field, Map<String, Field> fieldsByName) {
        T annotation = field.getAnnotation(annotationClass);
        try {
            fieldsByName.put(annotation.getClass().getMethod("name").invoke(annotation).toString(), field);
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe("Could not generate fields by name " + e.getLocalizedMessage());
        }
    }
}
