package com.kk.utils.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "sheet")
public class SheetType {
    private String name;

    private String sheetId;

    private String rId;

    @XmlAttribute(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "sheetId")
    public String getSheetId() {
        return sheetId;
    }

    public void setSheetId(String sheetId) {
        this.sheetId = sheetId;
    }

    @XmlAttribute(name = "r:Id")
    public String getRId() {
        return rId;
    }

    public void setRId(String rId) {
        this.rId = rId;
    }
}
