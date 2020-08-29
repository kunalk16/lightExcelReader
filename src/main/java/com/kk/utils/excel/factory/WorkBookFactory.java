package com.kk.utils.excel.factory;

import com.kk.utils.excel.factory.extractor.SheetByNameExtractor;
import com.kk.utils.excel.factory.extractor.SheetNamesExtractor;
import com.kk.utils.excel.file.validation.ExcelFileValidation;
import com.kk.utils.excel.model.factory.ExcelArchiveFiles;
import com.kk.utils.excel.model.factory.ExcelWorkBook;
import com.kk.utils.excel.model.factory.ExcelXMLData;
import com.kk.utils.excel.model.user.Sheet;
import com.kk.utils.excel.model.user.WorkBook;
import com.kk.utils.excel.utils.logger.ExcelReaderLogger;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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
        return Optional.ofNullable(excelXMLData)
                .map(WorkBookFactory::getSheets)
                .map(new SheetByNameExtractor())
                .map(ExcelWorkBook::new)
                .orElse(null);
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
