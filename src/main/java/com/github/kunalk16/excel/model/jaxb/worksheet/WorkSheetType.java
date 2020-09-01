package com.github.kunalk16.excel.model.jaxb.worksheet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "worksheet")
public class WorkSheetType {
    private SheetDataType sheetData;

    @XmlElement(name = "sheetData")
    public SheetDataType getSheetData() {
        return sheetData;
    }

    public void setSheetData(SheetDataType sheetData) {
        this.sheetData = sheetData;
    }
}
