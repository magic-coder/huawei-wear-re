package org.apache.log4j.lf5.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apache.log4j.lf5.LogLevel;
import org.apache.log4j.lf5.LogRecord;

public class AdapterLogRecord extends LogRecord {
    private static PrintWriter pw = new PrintWriter(sw);
    private static LogLevel severeLevel = null;
    private static StringWriter sw = new StringWriter();

    public void setCategory(String str) {
        super.setCategory(str);
        super.setLocation(getLocationInfo(str));
    }

    public boolean isSevereLevel() {
        if (severeLevel == null) {
            return false;
        }
        return severeLevel.equals(getLevel());
    }

    public static void setSevereLevel(LogLevel logLevel) {
        severeLevel = logLevel;
    }

    public static LogLevel getSevereLevel() {
        return severeLevel;
    }

    protected String getLocationInfo(String str) {
        return parseLine(stackTraceToString(new Throwable()), str);
    }

    protected String stackTraceToString(Throwable th) {
        String stringWriter;
        synchronized (sw) {
            th.printStackTrace(pw);
            stringWriter = sw.toString();
            sw.getBuffer().setLength(0);
        }
        return stringWriter;
    }

    protected String parseLine(String str, String str2) {
        int indexOf = str.indexOf(str2);
        if (indexOf == -1) {
            return null;
        }
        String substring = str.substring(indexOf);
        return substring.substring(0, substring.indexOf(")") + 1);
    }
}
