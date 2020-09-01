package com.github.kunalk16.excel.model.user;

public interface Cell {
    int getRow();

    String getColumn();

    int getColumnIndex();

    String getValue();
}
