package com.kk.utils.excel.model.jaxb.worksheet;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("unused")
@XmlRootElement(name = "row")
public class RowType {
    private List<CellType> cells;
    private String rowNumber;

    @XmlAttribute(name = "r")
    public String getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(String rowNumber) {
        this.rowNumber = rowNumber;
    }

    @XmlElement(name = "c")
    public List<CellType> getCells() {
        return cells;
    }

    public void setCells(List<CellType> cells) {
        this.cells = cells;
    }
}
