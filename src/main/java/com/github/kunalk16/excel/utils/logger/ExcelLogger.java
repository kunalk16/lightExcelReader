package com.github.kunalk16.excel.utils.logger;

import java.util.function.Consumer;
import java.util.logging.Logger;

public class ExcelLogger {
    private final Logger logger;
    private boolean logMessages;

    ExcelLogger() {
        this.logger = Logger.getLogger("ExcelReaderLogger");
        this.logMessages = false;
    }

    public void enableLogging(boolean logMessages) {
        this.logMessages = logMessages;
    }

    public void info(String message) {
        this.log(this.logger::info, message);
    }

    public void warning(String message) {
        this.log(this.logger::warning, message);
    }

    public void severe(String message) {
        this.log(this.logger::severe, message);
    }

    private void log(Consumer<String> logConsumer, String message) {
        if (this.logMessages) {
            logConsumer.accept(message);
        }
    }
}
