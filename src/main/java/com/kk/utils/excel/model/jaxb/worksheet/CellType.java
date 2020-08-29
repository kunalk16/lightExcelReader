package com.kk.utils.excel.model.jaxb.worksheet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "c")
public class CellType {
    private String position;

    private String type;

    private String value;

    @XmlAttribute(name = "r")
    public String getPosition() {
        return position;
    }

    @XmlAttribute(name = "t")
    public String getType() {
        return type;
    }

    @XmlElement(name = "v")
    public String getValue() {
        return value;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setType(String type) {
        this.type = type;
    }
}
