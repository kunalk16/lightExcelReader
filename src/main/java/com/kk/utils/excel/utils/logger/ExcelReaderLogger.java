package com.kk.utils.excel.utils.logger;

public class ExcelReaderLogger {
    private final ExcelLogger excelLogger;

    private ExcelReaderLogger() {
        this.excelLogger = new ExcelLogger();
    }

    public static ExcelLogger getInstance() {
        return ExcelReaderLoggerInstanceHolder.INSTANCE.excelLogger;
    }

    public static void enableLogging(boolean loggingEnabled) {
        ExcelReaderLoggerInstanceHolder.INSTANCE.excelLogger.enableLogging(loggingEnabled);
    }

    private static class ExcelReaderLoggerInstanceHolder {
        private static final ExcelReaderLogger INSTANCE = new ExcelReaderLogger();
    }
}
