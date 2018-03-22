package org.apache.log4j;

import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.apache.log4j.spi.LoggingEvent;

public final class LogMF extends LogXF {
    private static final String FQCN;
    static Class class$org$apache$log4j$LogMF;
    private static DateFormat dateFormat = null;
    private static Locale dateLocale = null;
    private static NumberFormat numberFormat = null;
    private static Locale numberLocale = null;

    private LogMF() {
    }

    static {
        Class class$;
        if (class$org$apache$log4j$LogMF == null) {
            class$ = class$("org.apache.log4j.LogMF");
            class$org$apache$log4j$LogMF = class$;
        } else {
            class$ = class$org$apache$log4j$LogMF;
        }
        FQCN = class$.getName();
    }

    private static synchronized String formatNumber(Object obj) {
        String format;
        synchronized (LogMF.class) {
            Locale locale = Locale.getDefault();
            if (locale != numberLocale || numberFormat == null) {
                numberLocale = locale;
                numberFormat = NumberFormat.getInstance(locale);
            }
            format = numberFormat.format(obj);
        }
        return format;
    }

    private static synchronized String formatDate(Object obj) {
        String format;
        synchronized (LogMF.class) {
            Locale locale = Locale.getDefault();
            if (locale != dateLocale || dateFormat == null) {
                dateLocale = locale;
                dateFormat = DateFormat.getDateTimeInstance(3, 3, locale);
            }
            format = dateFormat.format(obj);
        }
        return format;
    }

    private static String formatObject(Object obj) {
        if (obj instanceof String) {
            return obj.toString();
        }
        if ((obj instanceof Double) || (obj instanceof Float)) {
            return formatNumber(obj);
        }
        if (obj instanceof Date) {
            return formatDate(obj);
        }
        return String.valueOf(obj);
    }

    private static boolean isSimple(String str) {
        if (str.indexOf(39) != -1) {
            return false;
        }
        int indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS);
        while (indexOf != -1) {
            if (indexOf + 2 >= str.length() || str.charAt(indexOf + 2) != '}' || str.charAt(indexOf + 1) < '0' || str.charAt(indexOf + 1) > '9') {
                return false;
            }
            indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS, indexOf + 1);
        }
        return true;
    }

    private static String format(String str, Object[] objArr) {
        if (str == null) {
            return null;
        }
        if (isSimple(str)) {
            String[] strArr = new String[10];
            int i = 0;
            String str2 = "";
            int indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS);
            while (indexOf >= 0) {
                if (indexOf + 2 >= str.length() || str.charAt(indexOf + 2) != '}' || str.charAt(indexOf + 1) < '0' || str.charAt(indexOf + 1) > '9') {
                    indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS, indexOf + 1);
                } else {
                    int charAt = str.charAt(indexOf + 1) - 48;
                    str2 = new StringBuffer().append(str2).append(str.substring(i, indexOf)).toString();
                    if (strArr[charAt] == null) {
                        if (objArr == null || charAt >= objArr.length) {
                            strArr[charAt] = str.substring(indexOf, indexOf + 3);
                        } else {
                            strArr[charAt] = formatObject(objArr[charAt]);
                        }
                    }
                    str2 = new StringBuffer().append(str2).append(strArr[charAt]).toString();
                    i = indexOf + 3;
                    indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS, i);
                }
            }
            return new StringBuffer().append(str2).append(str.substring(i)).toString();
        }
        try {
            return MessageFormat.format(str, objArr);
        } catch (IllegalArgumentException e) {
            return str;
        }
    }

    private static String format(String str, Object obj) {
        String str2 = null;
        if (str == null) {
            return null;
        }
        if (isSimple(str)) {
            int i = 0;
            String str3 = "";
            int indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS);
            while (indexOf >= 0) {
                if (indexOf + 2 >= str.length() || str.charAt(indexOf + 2) != '}' || str.charAt(indexOf + 1) < '0' || str.charAt(indexOf + 1) > '9') {
                    indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS, indexOf + 1);
                } else {
                    String str4;
                    int charAt = str.charAt(indexOf + 1) - 48;
                    str3 = new StringBuffer().append(str3).append(str.substring(i, indexOf)).toString();
                    String stringBuffer;
                    if (charAt != 0) {
                        stringBuffer = new StringBuffer().append(str3).append(str.substring(indexOf, indexOf + 3)).toString();
                        str4 = str2;
                        str2 = stringBuffer;
                    } else {
                        if (str2 == null) {
                            str2 = formatObject(obj);
                        }
                        stringBuffer = new StringBuffer().append(str3).append(str2).toString();
                        str4 = str2;
                        str2 = stringBuffer;
                    }
                    int i2 = indexOf + 3;
                    indexOf = str.indexOf(ReportInfoUtils.FEEDBACK_SUCCESS, i2);
                    i = i2;
                    str3 = str2;
                    str2 = str4;
                }
            }
            return new StringBuffer().append(str3).append(str.substring(i)).toString();
        }
        try {
            return MessageFormat.format(str, new Object[]{obj});
        } catch (IllegalArgumentException e) {
            return str;
        }
    }

    private static String format(String str, String str2, Object[] objArr) {
        if (str != null) {
            try {
                str2 = ResourceBundle.getBundle(str).getString(str2);
            } catch (Exception e) {
            }
        }
        return format(str2, objArr);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    private static void forcedLog(Logger logger, Level level, String str) {
        logger.callAppenders(new LoggingEvent(FQCN, logger, level, str, null));
    }

    private static void forcedLog(Logger logger, Level level, String str, Throwable th) {
        logger.callAppenders(new LoggingEvent(FQCN, logger, level, str, th));
    }

    public static void trace(Logger logger, String str, Object[] objArr) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, objArr));
        }
    }

    public static void debug(Logger logger, String str, Object[] objArr) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, objArr));
        }
    }

    public static void info(Logger logger, String str, Object[] objArr) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, objArr));
        }
    }

    public static void warn(Logger logger, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, objArr));
        }
    }

    public static void error(Logger logger, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.ERROR)) {
            forcedLog(logger, Level.ERROR, format(str, objArr));
        }
    }

    public static void fatal(Logger logger, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.FATAL)) {
            forcedLog(logger, Level.FATAL, format(str, objArr));
        }
    }

    public static void trace(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, objArr), th);
        }
    }

    public static void debug(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, objArr), th);
        }
    }

    public static void info(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, objArr), th);
        }
    }

    public static void warn(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, objArr), th);
        }
    }

    public static void error(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.ERROR)) {
            forcedLog(logger, Level.ERROR, format(str, objArr), th);
        }
    }

    public static void fatal(Logger logger, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(Level.FATAL)) {
            forcedLog(logger, Level.FATAL, format(str, objArr), th);
        }
    }

    public static void trace(Logger logger, String str, boolean z) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(z)));
        }
    }

    public static void trace(Logger logger, String str, char c) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(c)));
        }
    }

    public static void trace(Logger logger, String str, byte b) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(b)));
        }
    }

    public static void trace(Logger logger, String str, short s) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(s)));
        }
    }

    public static void trace(Logger logger, String str, int i) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(i)));
        }
    }

    public static void trace(Logger logger, String str, long j) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(j)));
        }
    }

    public static void trace(Logger logger, String str, float f) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(f)));
        }
    }

    public static void trace(Logger logger, String str, double d) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.valueOf(d)));
        }
    }

    public static void trace(Logger logger, String str, Object obj) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, obj));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void trace(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(TRACE)) {
            forcedLog(logger, TRACE, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void debug(Logger logger, String str, boolean z) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(z)));
        }
    }

    public static void debug(Logger logger, String str, char c) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(c)));
        }
    }

    public static void debug(Logger logger, String str, byte b) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(b)));
        }
    }

    public static void debug(Logger logger, String str, short s) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(s)));
        }
    }

    public static void debug(Logger logger, String str, int i) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(i)));
        }
    }

    public static void debug(Logger logger, String str, long j) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(j)));
        }
    }

    public static void debug(Logger logger, String str, float f) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(f)));
        }
    }

    public static void debug(Logger logger, String str, double d) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.valueOf(d)));
        }
    }

    public static void debug(Logger logger, String str, Object obj) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, obj));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void debug(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isDebugEnabled()) {
            forcedLog(logger, Level.DEBUG, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void info(Logger logger, String str, boolean z) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(z)));
        }
    }

    public static void info(Logger logger, String str, char c) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(c)));
        }
    }

    public static void info(Logger logger, String str, byte b) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(b)));
        }
    }

    public static void info(Logger logger, String str, short s) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(s)));
        }
    }

    public static void info(Logger logger, String str, int i) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(i)));
        }
    }

    public static void info(Logger logger, String str, long j) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(j)));
        }
    }

    public static void info(Logger logger, String str, float f) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(f)));
        }
    }

    public static void info(Logger logger, String str, double d) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.valueOf(d)));
        }
    }

    public static void info(Logger logger, String str, Object obj) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, obj));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void info(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isInfoEnabled()) {
            forcedLog(logger, Level.INFO, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void warn(Logger logger, String str, boolean z) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(z)));
        }
    }

    public static void warn(Logger logger, String str, char c) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(c)));
        }
    }

    public static void warn(Logger logger, String str, byte b) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(b)));
        }
    }

    public static void warn(Logger logger, String str, short s) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(s)));
        }
    }

    public static void warn(Logger logger, String str, int i) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(i)));
        }
    }

    public static void warn(Logger logger, String str, long j) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(j)));
        }
    }

    public static void warn(Logger logger, String str, float f) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(f)));
        }
    }

    public static void warn(Logger logger, String str, double d) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.valueOf(d)));
        }
    }

    public static void warn(Logger logger, String str, Object obj) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, obj));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void warn(Logger logger, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(Level.WARN)) {
            forcedLog(logger, Level.WARN, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr));
        }
    }

    public static void log(Logger logger, Level level, Throwable th, String str, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, objArr), th);
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj)));
        }
    }

    public static void log(Logger logger, Level level, String str, boolean z) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(z))));
        }
    }

    public static void log(Logger logger, Level level, String str, byte b) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(b))));
        }
    }

    public static void log(Logger logger, Level level, String str, char c) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(c))));
        }
    }

    public static void log(Logger logger, Level level, String str, short s) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(s))));
        }
    }

    public static void log(Logger logger, Level level, String str, int i) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(i))));
        }
    }

    public static void log(Logger logger, Level level, String str, long j) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(j))));
        }
    }

    public static void log(Logger logger, Level level, String str, float f) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(f))));
        }
    }

    public static void log(Logger logger, Level level, String str, double d) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(LogXF.valueOf(d))));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void log(Logger logger, Level level, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, objArr));
        }
    }

    public static void logrb(Logger logger, Level level, Throwable th, String str, String str2, Object[] objArr) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, objArr), th);
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, boolean z) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(z))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, char c) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(c))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, byte b) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(b))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, short s) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(s))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, int i) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(i))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, long j) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(j))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, float f) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(f))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, double d) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(LogXF.valueOf(d))));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2, Object obj3) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2, obj3)));
        }
    }

    public static void logrb(Logger logger, Level level, String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (logger.isEnabledFor(level)) {
            forcedLog(logger, level, format(str, str2, LogXF.toArray(obj, obj2, obj3, obj4)));
        }
    }
}
