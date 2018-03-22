package org.apache.log4j;

import org.apache.http.client.methods.HttpTrace;
import org.apache.log4j.spi.LocationInfo;
import org.apache.log4j.spi.LoggingEvent;

public abstract class LogXF {
    private static final String FQCN;
    protected static final Level TRACE = new Level(5000, HttpTrace.METHOD_NAME, 7);
    static Class class$org$apache$log4j$LogXF;

    static {
        Class class$;
        if (class$org$apache$log4j$LogXF == null) {
            class$ = class$("org.apache.log4j.LogXF");
            class$org$apache$log4j$LogXF = class$;
        } else {
            class$ = class$org$apache$log4j$LogXF;
        }
        FQCN = class$.getName();
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    protected LogXF() {
    }

    protected static Boolean valueOf(boolean z) {
        if (z) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    protected static Character valueOf(char c) {
        return new Character(c);
    }

    protected static Byte valueOf(byte b) {
        return new Byte(b);
    }

    protected static Short valueOf(short s) {
        return new Short(s);
    }

    protected static Integer valueOf(int i) {
        return new Integer(i);
    }

    protected static Long valueOf(long j) {
        return new Long(j);
    }

    protected static Float valueOf(float f) {
        return new Float(f);
    }

    protected static Double valueOf(double d) {
        return new Double(d);
    }

    protected static Object[] toArray(Object obj) {
        return new Object[]{obj};
    }

    protected static Object[] toArray(Object obj, Object obj2) {
        return new Object[]{obj, obj2};
    }

    protected static Object[] toArray(Object obj, Object obj2, Object obj3) {
        return new Object[]{obj, obj2, obj3};
    }

    protected static Object[] toArray(Object obj, Object obj2, Object obj3, Object obj4) {
        return new Object[]{obj, obj2, obj3, obj4};
    }

    public static void entering(Logger logger, String str, String str2) {
        if (logger.isDebugEnabled()) {
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, new StringBuffer().append(str).append(".").append(str2).append(" ENTRY").toString(), null));
        }
    }

    public static void entering(Logger logger, String str, String str2, String str3) {
        if (logger.isDebugEnabled()) {
            Category category = logger;
            logger.callAppenders(new LoggingEvent(FQCN, category, Level.DEBUG, new StringBuffer().append(str).append(".").append(str2).append(" ENTRY ").append(str3).toString(), null));
        }
    }

    public static void entering(Logger logger, String str, String str2, Object obj) {
        if (logger.isDebugEnabled()) {
            Object stringBuffer;
            String stringBuffer2 = new StringBuffer().append(str).append(".").append(str2).append(" ENTRY ").toString();
            if (obj == null) {
                stringBuffer = new StringBuffer().append(stringBuffer2).append("null").toString();
            } else {
                try {
                    stringBuffer = new StringBuffer().append(stringBuffer2).append(obj).toString();
                } catch (Throwable th) {
                    stringBuffer = new StringBuffer().append(stringBuffer2).append(LocationInfo.NA).toString();
                }
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, stringBuffer, null));
        }
    }

    public static void entering(Logger logger, String str, String str2, Object[] objArr) {
        if (logger.isDebugEnabled()) {
            Object stringBuffer;
            String stringBuffer2 = new StringBuffer().append(str).append(".").append(str2).append(" ENTRY ").toString();
            if (objArr == null || objArr.length <= 0) {
                stringBuffer = new StringBuffer().append(stringBuffer2).append("{}").toString();
            } else {
                String str3 = "{";
                for (Object stringBuffer3 : objArr) {
                    try {
                        stringBuffer2 = new StringBuffer().append(stringBuffer2).append(str3).append(stringBuffer3).toString();
                    } catch (Throwable th) {
                        stringBuffer2 = new StringBuffer().append(stringBuffer2).append(str3).append(LocationInfo.NA).toString();
                    }
                    str3 = ",";
                }
                stringBuffer3 = new StringBuffer().append(stringBuffer2).append("}").toString();
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, stringBuffer3, null));
        }
    }

    public static void exiting(Logger logger, String str, String str2) {
        if (logger.isDebugEnabled()) {
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, new StringBuffer().append(str).append(".").append(str2).append(" RETURN").toString(), null));
        }
    }

    public static void exiting(Logger logger, String str, String str2, String str3) {
        if (logger.isDebugEnabled()) {
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, new StringBuffer().append(str).append(".").append(str2).append(" RETURN ").append(str3).toString(), null));
        }
    }

    public static void exiting(Logger logger, String str, String str2, Object obj) {
        if (logger.isDebugEnabled()) {
            Object stringBuffer;
            String stringBuffer2 = new StringBuffer().append(str).append(".").append(str2).append(" RETURN ").toString();
            if (obj == null) {
                stringBuffer = new StringBuffer().append(stringBuffer2).append("null").toString();
            } else {
                try {
                    stringBuffer = new StringBuffer().append(stringBuffer2).append(obj).toString();
                } catch (Throwable th) {
                    stringBuffer = new StringBuffer().append(stringBuffer2).append(LocationInfo.NA).toString();
                }
            }
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, stringBuffer, null));
        }
    }

    public static void throwing(Logger logger, String str, String str2, Throwable th) {
        if (logger.isDebugEnabled()) {
            logger.callAppenders(new LoggingEvent(FQCN, logger, Level.DEBUG, new StringBuffer().append(str).append(".").append(str2).append(" THROW").toString(), th));
        }
    }
}
