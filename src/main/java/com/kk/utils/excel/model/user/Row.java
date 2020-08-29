package com.kk.utils.excel.model.user;

import java.util.Collection;

public interface Row {
    int getRow();

    Collection<Cell> getCells();

    Cell getCellByColumn(String cellName);

    Cell getCellByIndex(int index);
}
