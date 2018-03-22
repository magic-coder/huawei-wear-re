package org.apache.log4j.lf5;

import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import java.awt.Toolkit;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

public class LF5Appender extends AppenderSkeleton {
    protected static LogBrokerMonitor _defaultLogMonitor;
    protected static AppenderFinalizer _finalizer;
    protected LogBrokerMonitor _logMonitor;

    public LF5Appender() {
        this(getDefaultInstance());
    }

    public LF5Appender(LogBrokerMonitor logBrokerMonitor) {
        if (logBrokerMonitor != null) {
            this._logMonitor = logBrokerMonitor;
        }
    }

    public void append(LoggingEvent loggingEvent) {
        String loggerName = loggingEvent.getLoggerName();
        String renderedMessage = loggingEvent.getRenderedMessage();
        String ndc = loggingEvent.getNDC();
        String threadName = loggingEvent.getThreadName();
        String level = loggingEvent.getLevel().toString();
        long j = loggingEvent.timeStamp;
        LocationInfo locationInformation = loggingEvent.getLocationInformation();
        LogRecord log4JLogRecord = new Log4JLogRecord();
        log4JLogRecord.setCategory(loggerName);
        log4JLogRecord.setMessage(renderedMessage);
        log4JLogRecord.setLocation(locationInformation.fullInfo);
        log4JLogRecord.setMillis(j);
        log4JLogRecord.setThreadDescription(threadName);
        if (ndc != null) {
            log4JLogRecord.setNDC(ndc);
        } else {
            log4JLogRecord.setNDC("");
        }
        if (loggingEvent.getThrowableInformation() != null) {
            log4JLogRecord.setThrownStackTrace(loggingEvent.getThrowableInformation());
        }
        try {
            log4JLogRecord.setLevel(LogLevel.valueOf(level));
        } catch (LogLevelFormatException e) {
            log4JLogRecord.setLevel(LogLevel.WARN);
        }
        if (this._logMonitor != null) {
            this._logMonitor.addMessage(log4JLogRecord);
        }
    }

    public void close() {
    }

    public boolean requiresLayout() {
        return false;
    }

    public void setCallSystemExitOnClose(boolean z) {
        this._logMonitor.setCallSystemExitOnClose(z);
    }

    public boolean equals(LF5Appender lF5Appender) {
        return this._logMonitor == lF5Appender.getLogBrokerMonitor();
    }

    public LogBrokerMonitor getLogBrokerMonitor() {
        return this._logMonitor;
    }

    public static void main(String[] strArr) {
        LF5Appender lF5Appender = new LF5Appender();
    }

    public void setMaxNumberOfRecords(int i) {
        _defaultLogMonitor.setMaxNumberOfLogRecords(i);
    }

    protected static synchronized LogBrokerMonitor getDefaultInstance() {
        LogBrokerMonitor logBrokerMonitor;
        synchronized (LF5Appender.class) {
            if (_defaultLogMonitor == null) {
                try {
                    _defaultLogMonitor = new LogBrokerMonitor(LogLevel.getLog4JLevels());
                    _finalizer = new AppenderFinalizer(_defaultLogMonitor);
                    _defaultLogMonitor.setFrameSize(getDefaultMonitorWidth(), getDefaultMonitorHeight());
                    _defaultLogMonitor.setFontSize(12);
                    _defaultLogMonitor.show();
                } catch (SecurityException e) {
                    _defaultLogMonitor = null;
                }
            }
            logBrokerMonitor = _defaultLogMonitor;
        }
        return logBrokerMonitor;
    }

    protected static int getScreenWidth() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().width;
        } catch (Throwable th) {
            return 800;
        }
    }

    protected static int getScreenHeight() {
        try {
            return Toolkit.getDefaultToolkit().getScreenSize().height;
        } catch (Throwable th) {
            return HeartRateDetail.HEART_RATE_TYPE_SPORT;
        }
    }

    protected static int getDefaultMonitorWidth() {
        return (getScreenWidth() * 3) / 4;
    }

    protected static int getDefaultMonitorHeight() {
        return (getScreenHeight() * 3) / 4;
    }
}
