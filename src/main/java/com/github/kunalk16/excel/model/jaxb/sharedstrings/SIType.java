package com.github.kunalk16.excel.model.jaxb.sharedstrings;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "si")
public class SIType {
    private String value;

    @XmlElement(name = "t")
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
