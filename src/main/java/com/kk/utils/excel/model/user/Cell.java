package com.kk.utils.excel.model.user;

public interface Cell {
    int getRow();

    String getColumn();

    int getColumnIndex();

    String getValue();
}
