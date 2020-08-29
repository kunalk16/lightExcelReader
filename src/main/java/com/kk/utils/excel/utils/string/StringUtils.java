package com.kk.utils.excel.utils.string;

import java.util.Optional;

public class StringUtils {
    public static final String EMPTY = "";

    public static final int INDEX_NOT_FOUND = -1;

    public static String replace(String string, String toReplace, String replaceWith) {
        return getOptionalString(string)
                .map(s -> s.replace(toReplace, replaceWith))
                .orElse(null);
    }

    public static boolean startsWith(String string, String prefix) {
        return getOptionalString(string)
                .map(s -> s.startsWith(prefix))
                .orElse(false);
    }

    public static boolean endsWith(String string, String suffix) {
        return getOptionalString(string)
                .map(s -> s.endsWith(suffix))
                .orElse(false);
    }

    public static boolean equals(String string1, String string2) {
        return getOptionalString(string1)
                .map(s -> s.equals(string2))
                .orElse(false);
    }

    public static boolean equalsIgnoreCase(String string1, String string2) {
        return getOptionalString(string1)
                .map(s -> s.equalsIgnoreCase(string2))
                .orElse(false);
    }

    public static String substring(String string, int index) {
        return getOptionalString(string)
                .map(s -> s.substring(index))
                .orElse(null);
    }

    public static String substring(String string, int beginIndex, int endIndex) {
        return getOptionalString(string)
                .map(s -> s.substring(beginIndex, endIndex))
                .orElse(null);
    }

    public static boolean isNotEmpty(String string) {
        return !isEmpty(string);
    }

    public static boolean isEmpty(String string) {
        return getOptionalString(string)
                .map(String::isEmpty)
                .orElse(true);
    }

    public static int lastIndexOf(String string, String word) {
        return getOptionalString(string)
                .map(s -> s.lastIndexOf(word))
                .orElse(INDEX_NOT_FOUND);
    }

    private static Optional<String> getOptionalString(String string) {
        return Optional.ofNullable(string);
    }
}
