package com.github.kunalk16.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("unused")
@XmlRootElement(name = "workbook")
public class WorkBookType {
    private SheetsType sheets;

    private DefinedNamesType definedNames;

    @XmlElement(name = "sheets")
    public SheetsType getSheets() {
        return sheets;
    }

    public void setSheets(SheetsType sheets) {
        this.sheets = sheets;
    }

    @XmlElement(name = "definedNames")
    public DefinedNamesType getDefinedNames() {
        return this.definedNames;
    }

    public void setDefinedNames(DefinedNamesType definedNames) {
        this.definedNames = definedNames;
    }
}
