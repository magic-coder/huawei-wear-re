package org.apache.log4j.lf5.util;

import com.huawei.hwcommonmodel.fitnessdatatype.HeartRateDetail;
import java.awt.Toolkit;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;
import org.apache.log4j.lf5.viewer.LogBrokerMonitor;

public class LogMonitorAdapter {
    public static final int JDK14_LOG_LEVELS = 1;
    public static final int LOG4J_LOG_LEVELS = 0;
    private LogLevel _defaultLevel = null;
    private LogBrokerMonitor _logMonitor;

    private LogMonitorAdapter(List list) {
        this._defaultLevel = (LogLevel) list.get(0);
        this._logMonitor = new LogBrokerMonitor(list);
        this._logMonitor.setFrameSize(getDefaultMonitorWidth(), getDefaultMonitorHeight());
        this._logMonitor.setFontSize(12);
        this._logMonitor.show();
    }

    public static LogMonitorAdapter newInstance(int i) {
        if (i == 1) {
            LogMonitorAdapter newInstance = newInstance(LogLevel.getJdk14Levels());
            newInstance.setDefaultLevel(LogLevel.FINEST);
            newInstance.setSevereLevel(LogLevel.SEVERE);
            return newInstance;
        }
        newInstance = newInstance(LogLevel.getLog4JLevels());
        newInstance.setDefaultLevel(LogLevel.DEBUG);
        newInstance.setSevereLevel(LogLevel.FATAL);
        return newInstance;
    }

    public static LogMonitorAdapter newInstance(LogLevel[] logLevelArr) {
        if (logLevelArr == null) {
            return null;
        }
        return newInstance(Arrays.asList(logLevelArr));
    }

    public static LogMonitorAdapter newInstance(List list) {
        return new LogMonitorAdapter(list);
    }

    public void addMessage(LogRecord logRecord) {
        this._logMonitor.addMessage(logRecord);
    }

    public void setMaxNumberOfRecords(int i) {
        this._logMonitor.setMaxNumberOfLogRecords(i);
    }

    public void setDefaultLevel(LogLevel logLevel) {
        this._defaultLevel = logLevel;
    }

    public LogLevel getDefaultLevel() {
        return this._defaultLevel;
    }

    public void setSevereLevel(LogLevel logLevel) {
        AdapterLogRecord.setSevereLevel(logLevel);
    }

    public LogLevel getSevereLevel() {
        return AdapterLogRecord.getSevereLevel();
    }

    public void log(String str, LogLevel logLevel, String str2, Throwable th, String str3) {
        LogRecord adapterLogRecord = new AdapterLogRecord();
        adapterLogRecord.setCategory(str);
        adapterLogRecord.setMessage(str2);
        adapterLogRecord.setNDC(str3);
        adapterLogRecord.setThrown(th);
        if (logLevel == null) {
            adapterLogRecord.setLevel(getDefaultLevel());
        } else {
            adapterLogRecord.setLevel(logLevel);
        }
        addMessage(adapterLogRecord);
    }

    public void log(String str, String str2) {
        log(str, null, str2);
    }

    public void log(String str, LogLevel logLevel, String str2, String str3) {
        log(str, logLevel, str2, null, str3);
    }

    public void log(String str, LogLevel logLevel, String str2, Throwable th) {
        log(str, logLevel, str2, th, null);
    }

    public void log(String str, LogLevel logLevel, String str2) {
        log(str, logLevel, str2, null, null);
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
