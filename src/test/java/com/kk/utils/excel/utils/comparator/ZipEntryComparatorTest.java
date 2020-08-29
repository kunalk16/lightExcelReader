package com.kk.utils.excel.utils.comparator;

import com.kk.utils.excel.model.factory.ExcelDataFiles;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.zip.ZipEntry;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ZipEntryComparatorTest {
    private static Comparator<ZipEntry> zipEntryComparator;

    @BeforeAll
    public static void initiate() {
        zipEntryComparator = new ZipEntryComparator();
    }

    @Test
    public void testSort1() {
        ZipEntry entry1 = createZipEntry(2);
        ZipEntry entry2 = createZipEntry(4);
        ZipEntry entry3 = createZipEntry(1);
        ZipEntry entry4 = createZipEntry(5);
        ZipEntry entry5 = createZipEntry(3);

        List<ZipEntry> zipEntries = Arrays.asList(entry1, entry2, entry3, entry4, entry5);
        zipEntries.sort(zipEntryComparator);

        assertEquals(Arrays.asList(entry3, entry1, entry5, entry2, entry4), zipEntries);
    }

    @Test
    public void testSort2() {
        ZipEntry entry1 = createZipEntry(1);
        ZipEntry entry2 = createZipEntry(0);
        ZipEntry entry3 = createZipEntry(10);
        ZipEntry entry4 = createZipEntry(111);
        ZipEntry entry5 = createZipEntry(110);

        List<ZipEntry> zipEntries = Arrays.asList(entry1, entry2, entry3, entry4, entry5);
        zipEntries.sort(zipEntryComparator);

        assertEquals(Arrays.asList(entry2, entry1, entry3, entry5, entry4), zipEntries);
    }

    private ZipEntry createZipEntry(int name) {
        ZipEntry zipEntry = mock(ZipEntry.class);
        when(zipEntry.getName()).thenReturn(ExcelDataFiles.SHEET_FILE.getFileName() + name + ".xml");

        return zipEntry;
    }
}
