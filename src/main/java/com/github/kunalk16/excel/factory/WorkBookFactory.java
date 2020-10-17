package com.github.kunalk16.excel.factory;

import com.github.kunalk16.excel.factory.extractor.CellLocationByDefinedNameExtractor;
import com.github.kunalk16.excel.factory.extractor.SheetByNameExtractor;
import com.github.kunalk16.excel.factory.extractor.SheetNamesExtractor;
import com.github.kunalk16.excel.file.validation.ExcelFileValidation;
import com.github.kunalk16.excel.model.factory.ExcelArchiveFiles;
import com.github.kunalk16.excel.model.factory.ExcelNamedCellLocation;
import com.github.kunalk16.excel.model.factory.ExcelWorkBook;
import com.github.kunalk16.excel.model.factory.ExcelXMLData;
import com.github.kunalk16.excel.model.jaxb.workbook.WorkBookType;
import com.github.kunalk16.excel.model.user.Sheet;
import com.github.kunalk16.excel.model.user.WorkBook;
import com.github.kunalk16.excel.utils.logger.ExcelReaderLogger;

import java.io.File;
import java.util.*;
import java.util.stream.IntStream;

public class WorkBookFactory {
    public static WorkBook create(String filePath) {
        if (ExcelFileValidation.validate(filePath)) {
            return getWorkBookData(new File(filePath));
        }
        return null;
    }

    private static WorkBook getWorkBookData(File excelFile) {
        try (ExcelArchiveFiles excelArchiveFiles = ArchiveFilesFactory.create(excelFile)) {
            ExcelXMLData excelXMLData = XMLDataFactory.create(excelArchiveFiles);

            return getWorkBookData(excelXMLData);
        } catch (Exception exception) {
            ExcelReaderLogger.getInstance().severe("Excel Resources not handles properly!" + exception.getLocalizedMessage());
            return null;
        }
    }

    private static WorkBook getWorkBookData(ExcelXMLData excelXMLData) {
        final Map<String, Sheet> sheetByName = Optional.ofNullable(excelXMLData)
                .map(WorkBookFactory::getSheets)
                .map(new SheetByNameExtractor())
                .orElse(Collections.emptyMap());

        final Map<String, ExcelNamedCellLocation> cellByDefinedName = Optional.ofNullable(excelXMLData)
                .map(ExcelXMLData::getWorkBook)
                .map(WorkBookType::getDefinedNames)
                .map(new CellLocationByDefinedNameExtractor())
                .orElse(Collections.emptyMap());

        return new ExcelWorkBook(sheetByName, cellByDefinedName);
    }

    private static List<Sheet> getSheets(ExcelXMLData excelXMLData) {
        List<String> sheetNames = new SheetNamesExtractor().apply(excelXMLData.getWorkBook());
        List<Sheet> sheets = new ArrayList<>();

        IntStream.range(0, sheetNames.size())
                .mapToObj(index -> SheetFactory.create(excelXMLData.getSharedString(),
                        excelXMLData.getSheets().get(index), sheetNames.get(index)))
                .forEach(sheets::add);

        return sheets;
    }
}
