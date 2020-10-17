package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.model.factory.ExcelNamedCellLocation;
import com.github.kunalk16.excel.model.jaxb.workbook.DefinedNamesType;
import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;
import com.github.kunalk16.excel.utils.string.StringUtils;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public class CellLocationByDefinedNameExtractor implements Function<DefinedNamesType, Map<String, ExcelNamedCellLocation>> {
    @Override
    public Map<String, ExcelNamedCellLocation> apply(DefinedNamesType definedNames) {
        Map<String, ExcelNamedCellLocation> cellLocationByDefinedName = new HashMap<>();

        Optional.ofNullable(definedNames)
                .map(DefinedNamesType::getDefinedNames)
                .stream()
                .flatMap(Collection::stream)
                .filter(definedName -> StringUtils.isNotBlank(definedName.getName()) && StringUtils.isNotBlank(definedName.getValue()))
                .forEach(definedName -> {
                    String cellName = definedName.getName();
                    String[] rawData = definedName.getValue().split("\\$");

                    if (rawData.length >= 3) {
                        Optional.ofNullable(getCellLocation(rawData))
                                .ifPresent(cellLocation -> cellLocationByDefinedName.put(cellName, cellLocation));
                    }
                });

        return Collections.unmodifiableMap(cellLocationByDefinedName);
    }

    private ExcelNamedCellLocation getCellLocation(String[] rawData) {
        if (Stream.of(rawData).anyMatch(StringUtils::isBlank)) {
            return null;
        }

        String sheetName = getSheetName(rawData[0]);

        String columnName = rawData[1];
        int row;

        try {
            row = Integer.parseInt(rawData[2]);
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe(e.getLocalizedMessage());
            return null;
        }

        return new ExcelNamedCellLocation(sheetName, columnName, row);
    }

    private String getSheetName(String rawSheetName) {
        String sanitizedSheetName;
        if (StringUtils.endsWith(rawSheetName, "!")) {
            sanitizedSheetName = StringUtils.substring(rawSheetName, 0, rawSheetName.length() - 1);
        } else {
            sanitizedSheetName = rawSheetName;
        }

        if (StringUtils.startsWith(sanitizedSheetName, "'") && StringUtils.endsWith(sanitizedSheetName, "'")) {
            sanitizedSheetName = StringUtils.substring(sanitizedSheetName, 1, sanitizedSheetName.length() - 1);
        }

        return sanitizedSheetName;
    }
}
