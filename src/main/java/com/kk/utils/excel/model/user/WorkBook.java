package com.kk.utils.excel.model.user;

import java.util.Collection;

public interface WorkBook {
    Sheet getSheet(int index);

    Sheet getSheet(String sheetName);

    Collection<Sheet> getSheets();
}
