package com.kk.utils.excel.factory.builder;

import com.kk.utils.excel.model.factory.ExcelXMLData;
import com.kk.utils.excel.model.jaxb.sharedstrings.SharedStringType;
import com.kk.utils.excel.model.jaxb.workbook.WorkBookType;
import com.kk.utils.excel.model.jaxb.worksheet.WorkSheetType;
import com.kk.utils.excel.utils.jaxb.JAXBUtils;
import com.kk.utils.excel.utils.logger.ExcelReaderLogger;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class ExcelXMLDataBuilder {
    private ZipEntry workBookZipEntry;

    private ZipEntry sharedStringsEntry;

    private List<ZipEntry> sheetEntries;

    private ZipFile excelZipFile;

    public ExcelXMLDataBuilder withExcelZipFile(ZipFile excelZipFile) {
        this.excelZipFile = excelZipFile;
        return this;
    }

    public ExcelXMLDataBuilder withWorkBookEntry(ZipEntry workBookEntry) {
        this.workBookZipEntry = workBookEntry;
        return this;
    }

    public ExcelXMLDataBuilder withSharedStringsEntry(ZipEntry sharedStringsEntry) {
        this.sharedStringsEntry = sharedStringsEntry;
        return this;
    }

    public ExcelXMLDataBuilder withSheetsEntry(List<ZipEntry> sheetEntries) {
        this.sheetEntries = sheetEntries;
        return this;
    }

    public ExcelXMLData build() {
        try {
            WorkBookType workBookType = null;
            if (Objects.nonNull(workBookZipEntry)) {
                workBookType = unMarshall(workBookZipEntry, WorkBookType.class);
            }

            SharedStringType sharedStringType = null;
            if (Objects.nonNull(sharedStringsEntry)) {
                sharedStringType = unMarshall(sharedStringsEntry, SharedStringType.class);
            }

            List<WorkSheetType> sheetsTypes = new ArrayList<>();

            if (Objects.nonNull(sheetEntries) && !sheetEntries.isEmpty()) {
                for (ZipEntry sheetEntry : sheetEntries) {
                    sheetsTypes.add(unMarshall(sheetEntry, WorkSheetType.class));
                }
            }

            return new ExcelXMLData(workBookType, sharedStringType, sheetsTypes);
        } catch (Exception e) {
            ExcelReaderLogger.getInstance().severe("Could not unmarshall XML files " + e.getLocalizedMessage());
            return null;
        }
    }

    private <T> T unMarshall(ZipEntry zipEntry, Class<T> clazz) throws IOException, JAXBException {
        try (InputStream inputStream = this.excelZipFile.getInputStream(zipEntry)) {
            return JAXBUtils.unMarshall(inputStream, clazz);
        }
    }
}
