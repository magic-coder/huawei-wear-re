package org.apache.log4j.varia;

import java.io.InterruptedIOException;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.LoggingEvent;

public class FallbackErrorHandler implements ErrorHandler {
    Appender backup;
    Vector loggers;
    Appender primary;

    public void setLogger(Logger logger) {
        LogLog.debug(new StringBuffer().append("FB: Adding logger [").append(logger.getName()).append("].").toString());
        if (this.loggers == null) {
            this.loggers = new Vector();
        }
        this.loggers.addElement(logger);
    }

    public void activateOptions() {
    }

    public void error(String str, Exception exception, int i) {
        error(str, exception, i, null);
    }

    public void error(String str, Exception exception, int i, LoggingEvent loggingEvent) {
        if (exception instanceof InterruptedIOException) {
            Thread.currentThread().interrupt();
        }
        LogLog.debug(new StringBuffer().append("FB: The following error reported: ").append(str).toString(), exception);
        LogLog.debug("FB: INITIATING FALLBACK PROCEDURE.");
        if (this.loggers != null) {
            for (int i2 = 0; i2 < this.loggers.size(); i2++) {
                Logger logger = (Logger) this.loggers.elementAt(i2);
                LogLog.debug(new StringBuffer().append("FB: Searching for [").append(this.primary.getName()).append("] in logger [").append(logger.getName()).append("].").toString());
                LogLog.debug(new StringBuffer().append("FB: Replacing [").append(this.primary.getName()).append("] by [").append(this.backup.getName()).append("] in logger [").append(logger.getName()).append("].").toString());
                logger.removeAppender(this.primary);
                LogLog.debug(new StringBuffer().append("FB: Adding appender [").append(this.backup.getName()).append("] to logger ").append(logger.getName()).toString());
                logger.addAppender(this.backup);
            }
        }
    }

    public void error(String str) {
    }

    public void setAppender(Appender appender) {
        LogLog.debug(new StringBuffer().append("FB: Setting primary appender to [").append(appender.getName()).append("].").toString());
        this.primary = appender;
    }

    public void setBackupAppender(Appender appender) {
        LogLog.debug(new StringBuffer().append("FB: Setting backup appender to [").append(appender.getName()).append("].").toString());
        this.backup = appender;
    }
}
