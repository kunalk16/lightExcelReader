package com.github.kunalk16.excel.factory.extractor;

import com.github.kunalk16.excel.model.factory.ExcelNamedCellLocation;
import com.github.kunalk16.excel.model.jaxb.workbook.DefinedNamesType;
import com.github.kunalk16.excel.model.jaxb.workbook.WorkBookType;
import com.github.kunalk16.excel.utils.jaxb.JAXBUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.function.Function;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CellLocationByDefinedNameExtractorTest {
    private static Function<DefinedNamesType, Map<String, ExcelNamedCellLocation>> cellLocationByDefinedNameExtractor;

    @BeforeAll
    public static void setUpExtractor() {
        cellLocationByDefinedNameExtractor = new CellLocationByDefinedNameExtractor();
    }

    @Test
    public void testCellLocationExtraction() throws IOException, JAXBException {
        try (InputStream inputStream = getClass().getResourceAsStream("workbook.xml")) {
            WorkBookType workBook = JAXBUtils.unMarshall(inputStream, WorkBookType.class);

            Map<String, ExcelNamedCellLocation> cellLocationByName = cellLocationByDefinedNameExtractor.apply(workBook.getDefinedNames());
            ExcelNamedCellLocation location1 = cellLocationByName.get("Kunal1");
            assertNotNull(location1);

            ExcelNamedCellLocation location2 = cellLocationByName.get("Kunal2");
            assertNotNull(location2);

            ExcelNamedCellLocation location3 = cellLocationByName.get("Kunal3");
            assertNotNull(location3);

            assertEquals("pplay 23", location1.getSheetName());
            assertEquals("B", location1.getColumn());
            assertEquals(7, location1.getRow());

            assertEquals("ref", location2.getSheetName());
            assertEquals("C", location2.getColumn());
            assertEquals(17, location2.getRow());

            assertEquals("ref", location3.getSheetName());
            assertEquals("D", location3.getColumn());
            assertEquals(5, location3.getRow());
        }
    }
}
