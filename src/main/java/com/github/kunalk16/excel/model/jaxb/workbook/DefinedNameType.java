package com.github.kunalk16.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlValue;

@SuppressWarnings("unused")
@XmlRootElement(name = "definedName")
public class DefinedNameType {
    private String name;

    private String value;

    @XmlAttribute(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlValue
    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
