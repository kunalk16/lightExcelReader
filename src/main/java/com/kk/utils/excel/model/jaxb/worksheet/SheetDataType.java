package com.kk.utils.excel.model.jaxb.worksheet;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("unused")
@XmlRootElement(name = "sheetData")
public class SheetDataType {
    private List<RowType> rows;

    @XmlElement(name = "row")
    public List<RowType> getRows() {
        return rows;
    }

    public void setRows(List<RowType> rows) {
        this.rows = rows;
    }
}
