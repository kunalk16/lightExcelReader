package com.kk.utils.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("unused")
@XmlRootElement(name = "sheets")
public class SheetsType {
    private List<SheetType> sheets;

    @XmlElement(name = "sheet")
    public List<SheetType> getSheets() {
        return sheets;
    }

    public void setSheets(List<SheetType> sheets) {
        this.sheets = sheets;
    }
}
