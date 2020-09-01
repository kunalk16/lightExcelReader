package com.github.kunalk16.excel.utils.comparator;

import com.github.kunalk16.excel.model.factory.ExcelDataFiles;
import com.github.kunalk16.excel.utils.string.StringUtils;

import java.util.Comparator;
import java.util.zip.ZipEntry;

public class ZipEntryComparator implements Comparator<ZipEntry> {
    @Override
    public int compare(ZipEntry o1, ZipEntry o2) {
        String name1 = o1.getName();
        String name2 = o2.getName();

        name1 = StringUtils.replace(name1, ExcelDataFiles.SHEET_FILE.getFileName(), StringUtils.EMPTY);
        name2 = StringUtils.replace(name2, ExcelDataFiles.SHEET_FILE.getFileName(), StringUtils.EMPTY);

        name1 = StringUtils.substring(name1, 0, StringUtils.lastIndexOf(name1, "."));
        name2 = StringUtils.substring(name2, 0, StringUtils.lastIndexOf(name2, "."));

        return Integer.parseInt(name1) - Integer.parseInt(name2);
    }
}
