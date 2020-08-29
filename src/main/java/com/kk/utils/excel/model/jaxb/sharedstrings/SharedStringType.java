package com.kk.utils.excel.model.jaxb.sharedstrings;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@SuppressWarnings("unused")
@XmlRootElement(name = "sst")
public class SharedStringType {
    private String count;

    private String uniqueCount;

    private List<SIType> siTypeList;

    @XmlAttribute(name = "count")
    public String getCount() {
        return count;
    }

    @XmlAttribute(name = "uniqueCount")
    public String getUniqueCount() {
        return uniqueCount;
    }

    @XmlElement(name = "si")
    public List<SIType> getSiTypeList() {
        return siTypeList;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public void setUniqueCount(String uniqueCount) {
        this.uniqueCount = uniqueCount;
    }

    public void setSiTypeList(List<SIType> siTypeList) {
        this.siTypeList = siTypeList;
    }
}
