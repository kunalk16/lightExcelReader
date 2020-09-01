package com.github.kunalk16.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "workbook")
public class WorkBookType {
    private SheetsType sheets;

    @XmlElement(name = "sheets")
    public SheetsType getSheets() {
        return sheets;
    }

    public void setSheets(SheetsType sheets) {
        this.sheets = sheets;
    }
}
