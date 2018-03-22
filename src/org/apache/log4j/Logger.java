package org.apache.log4j;

import org.apache.log4j.spi.LoggerFactory;

public class Logger extends Category {
    private static final String FQCN;
    static Class class$org$apache$log4j$Logger;

    static {
        Class class$;
        if (class$org$apache$log4j$Logger == null) {
            class$ = class$("org.apache.log4j.Logger");
            class$org$apache$log4j$Logger = class$;
        } else {
            class$ = class$org$apache$log4j$Logger;
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

    protected Logger(String str) {
        super(str);
    }

    public static Logger getLogger(String str) {
        return LogManager.getLogger(str);
    }

    public static Logger getLogger(Class cls) {
        return LogManager.getLogger(cls.getName());
    }

    public static Logger getRootLogger() {
        return LogManager.getRootLogger();
    }

    public static Logger getLogger(String str, LoggerFactory loggerFactory) {
        return LogManager.getLogger(str, loggerFactory);
    }

    public void trace(Object obj) {
        if (!this.repository.isDisabled(5000) && Level.TRACE.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.TRACE, obj, null);
        }
    }

    public void trace(Object obj, Throwable th) {
        if (!this.repository.isDisabled(5000) && Level.TRACE.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.TRACE, obj, th);
        }
    }

    public boolean isTraceEnabled() {
        if (this.repository.isDisabled(5000)) {
            return false;
        }
        return Level.TRACE.isGreaterOrEqual(getEffectiveLevel());
    }
}
