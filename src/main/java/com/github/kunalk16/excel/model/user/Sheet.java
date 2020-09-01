package com.github.kunalk16.excel.model.user;

import java.util.Collection;

public interface Sheet {
    String getSheetName();

    Collection<Row> getRows();

    Row getRowByIndex(int index);
}
