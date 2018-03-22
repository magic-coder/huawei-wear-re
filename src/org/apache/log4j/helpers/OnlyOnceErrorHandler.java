package org.apache.log4j.helpers;

import java.io.InterruptedIOException;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

public class OnlyOnceErrorHandler implements ErrorHandler {
    final String ERROR_PREFIX = "log4j error: ";
    final String WARN_PREFIX = "log4j warning: ";
    boolean firstTime = true;

    public void setLogger(Logger logger) {
    }

    public void activateOptions() {
    }

    public void error(String str, Exception exception, int i) {
        error(str, exception, i, null);
    }

    public void error(String str, Exception exception, int i, LoggingEvent loggingEvent) {
        if ((exception instanceof InterruptedIOException) || (exception instanceof InterruptedException)) {
            Thread.currentThread().interrupt();
        }
        if (this.firstTime) {
            LogLog.error(str, exception);
            this.firstTime = false;
        }
    }

    public void error(String str) {
        if (this.firstTime) {
            LogLog.error(str);
            this.firstTime = false;
        }
    }

    public void setAppender(Appender appender) {
    }

    public void setBackupAppender(Appender appender) {
    }
}
