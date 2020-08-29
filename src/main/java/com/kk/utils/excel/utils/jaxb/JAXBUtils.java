package com.kk.utils.excel.utils.jaxb;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.InputStream;

@SuppressWarnings("unchecked")
public class JAXBUtils {
    public static <T> T unMarshall(InputStream inputStream, Class<T> modelClass) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(modelClass);

        Unmarshaller jaxbUnMarshaller = jaxbContext.createUnmarshaller();

        return (T) jaxbUnMarshaller.unmarshal(inputStream);
    }
}
