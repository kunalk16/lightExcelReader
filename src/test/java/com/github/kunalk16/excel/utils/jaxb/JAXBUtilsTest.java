package com.github.kunalk16.excel.utils.jaxb;

import com.github.kunalk16.excel.model.jaxb.workbook.DefinedNameType;
import com.github.kunalk16.excel.model.jaxb.workbook.DefinedNamesType;
import com.github.kunalk16.excel.model.jaxb.workbook.WorkBookType;
import org.junit.jupiter.api.Test;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JAXBUtilsTest {
    @Test
    public void testUnMarshallWorkBookWithDefinedNames() throws IOException, JAXBException {
        try(InputStream inputStream = getClass().getResourceAsStream("workbook.xml")) {
            WorkBookType workBookType = JAXBUtils.unMarshall(inputStream, WorkBookType.class);

            assertNotNull(workBookType);

            DefinedNamesType definedNames = workBookType.getDefinedNames();
            assertNotNull(definedNames);

            List<DefinedNameType> definedNamesList = definedNames.getDefinedNames();
            assertEquals(3, definedNamesList.size());

            assertEquals("Kunal1", definedNamesList.get(0).getName());
            assertEquals("Kunal2", definedNamesList.get(1).getName());
            assertEquals("Kunal3", definedNamesList.get(2).getName());

            assertEquals("'pplay 23'!$B$7", definedNamesList.get(0).getValue());
            assertEquals("ref!$C$17", definedNamesList.get(1).getValue());
            assertEquals("ref!$D$5", definedNamesList.get(2).getValue());
        }
    }
}
