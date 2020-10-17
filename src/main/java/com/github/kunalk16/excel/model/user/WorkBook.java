package com.github.kunalk16.excel.model.user;

import java.util.Collection;

public interface WorkBook {
    Sheet getSheet(int index);

    Sheet getSheet(String sheetName);

    Collection<Sheet> getSheets();

    Cell getCellByDefinedName(String definedName);
}
