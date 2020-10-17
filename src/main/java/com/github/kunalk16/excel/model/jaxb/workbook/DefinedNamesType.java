package com.github.kunalk16.excel.model.jaxb.workbook;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("unused")
@XmlRootElement(name = "definedNames")
public class DefinedNamesType {
    private List<DefinedNameType> definedNames;

    @XmlElement(name = "definedName")
    public List<DefinedNameType> getDefinedNames() {
        return this.definedNames;
    }

    public void setDefinedNames(List<DefinedNameType> definedNames) {
        this.definedNames = definedNames;
    }
}
