package org.apache.log4j;

import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.NullEnumeration;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.LoggingEvent;

public class Category implements AppenderAttachable {
    private static final String FQCN;
    static Class class$org$apache$log4j$Category;
    AppenderAttachableImpl aai;
    protected boolean additive = true;
    protected volatile Level level;
    protected String name;
    protected volatile Category parent;
    protected LoggerRepository repository;
    protected ResourceBundle resourceBundle;

    static {
        Class class$;
        if (class$org$apache$log4j$Category == null) {
            class$ = class$("org.apache.log4j.Category");
            class$org$apache$log4j$Category = class$;
        } else {
            class$ = class$org$apache$log4j$Category;
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

    protected Category(String str) {
        this.name = str;
    }

    public synchronized void addAppender(Appender appender) {
        if (this.aai == null) {
            this.aai = new AppenderAttachableImpl();
        }
        this.aai.addAppender(appender);
        this.repository.fireAddAppenderEvent(this, appender);
    }

    public void assertLog(boolean z, String str) {
        if (!z) {
            error(str);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void callAppenders(org.apache.log4j.spi.LoggingEvent r4) {
        /*
        r3 = this;
        r0 = 0;
        r1 = r3;
    L_0x0002:
        if (r1 == 0) goto L_0x0015;
    L_0x0004:
        monitor-enter(r1);
        r2 = r1.aai;	 Catch:{ all -> 0x0021 }
        if (r2 == 0) goto L_0x0010;
    L_0x0009:
        r2 = r1.aai;	 Catch:{ all -> 0x0021 }
        r2 = r2.appendLoopOnAppenders(r4);	 Catch:{ all -> 0x0021 }
        r0 = r0 + r2;
    L_0x0010:
        r2 = r1.additive;	 Catch:{ all -> 0x0021 }
        if (r2 != 0) goto L_0x001d;
    L_0x0014:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
    L_0x0015:
        if (r0 != 0) goto L_0x001c;
    L_0x0017:
        r0 = r3.repository;
        r0.emitNoAppenderWarning(r3);
    L_0x001c:
        return;
    L_0x001d:
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        r1 = r1.parent;
        goto L_0x0002;
    L_0x0021:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0021 }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: org.apache.log4j.Category.callAppenders(org.apache.log4j.spi.LoggingEvent):void");
    }

    synchronized void closeNestedAppenders() {
        Enumeration allAppenders = getAllAppenders();
        if (allAppenders != null) {
            while (allAppenders.hasMoreElements()) {
                Appender appender = (Appender) allAppenders.nextElement();
                if (appender instanceof AppenderAttachable) {
                    appender.close();
                }
            }
        }
    }

    public void debug(Object obj) {
        if (!this.repository.isDisabled(10000) && Level.DEBUG.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.DEBUG, obj, null);
        }
    }

    public void debug(Object obj, Throwable th) {
        if (!this.repository.isDisabled(10000) && Level.DEBUG.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.DEBUG, obj, th);
        }
    }

    public void error(Object obj) {
        if (!this.repository.isDisabled(Priority.ERROR_INT) && Level.ERROR.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.ERROR, obj, null);
        }
    }

    public void error(Object obj, Throwable th) {
        if (!this.repository.isDisabled(Priority.ERROR_INT) && Level.ERROR.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.ERROR, obj, th);
        }
    }

    public static Logger exists(String str) {
        return LogManager.exists(str);
    }

    public void fatal(Object obj) {
        if (!this.repository.isDisabled(50000) && Level.FATAL.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.FATAL, obj, null);
        }
    }

    public void fatal(Object obj, Throwable th) {
        if (!this.repository.isDisabled(50000) && Level.FATAL.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.FATAL, obj, th);
        }
    }

    protected void forcedLog(String str, Priority priority, Object obj, Throwable th) {
        callAppenders(new LoggingEvent(str, this, priority, obj, th));
    }

    public boolean getAdditivity() {
        return this.additive;
    }

    public synchronized Enumeration getAllAppenders() {
        Enumeration instance;
        if (this.aai == null) {
            instance = NullEnumeration.getInstance();
        } else {
            instance = this.aai.getAllAppenders();
        }
        return instance;
    }

    public synchronized Appender getAppender(String str) {
        Appender appender;
        if (this.aai == null || str == null) {
            appender = null;
        } else {
            appender = this.aai.getAppender(str);
        }
        return appender;
    }

    public Level getEffectiveLevel() {
        while (this != null) {
            if (this.level != null) {
                return this.level;
            }
            this = this.parent;
        }
        return null;
    }

    public Priority getChainedPriority() {
        while (this != null) {
            if (this.level != null) {
                return this.level;
            }
            this = this.parent;
        }
        return null;
    }

    public static Enumeration getCurrentCategories() {
        return LogManager.getCurrentLoggers();
    }

    public static LoggerRepository getDefaultHierarchy() {
        return LogManager.getLoggerRepository();
    }

    public LoggerRepository getHierarchy() {
        return this.repository;
    }

    public LoggerRepository getLoggerRepository() {
        return this.repository;
    }

    public static Category getInstance(String str) {
        return LogManager.getLogger(str);
    }

    public static Category getInstance(Class cls) {
        return LogManager.getLogger(cls);
    }

    public final String getName() {
        return this.name;
    }

    public final Category getParent() {
        return this.parent;
    }

    public final Level getLevel() {
        return this.level;
    }

    public final Level getPriority() {
        return this.level;
    }

    public static final Category getRoot() {
        return LogManager.getRootLogger();
    }

    public ResourceBundle getResourceBundle() {
        while (this != null) {
            if (this.resourceBundle != null) {
                return this.resourceBundle;
            }
            this = this.parent;
        }
        return null;
    }

    protected String getResourceBundleString(String str) {
        String str2 = null;
        ResourceBundle resourceBundle = getResourceBundle();
        if (resourceBundle != null) {
            try {
                str2 = resourceBundle.getString(str);
            } catch (MissingResourceException e) {
                error(new StringBuffer().append("No resource is associated with key \"").append(str).append("\".").toString());
            }
        }
        return str2;
    }

    public void info(Object obj) {
        if (!this.repository.isDisabled(20000) && Level.INFO.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.INFO, obj, null);
        }
    }

    public void info(Object obj, Throwable th) {
        if (!this.repository.isDisabled(20000) && Level.INFO.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.INFO, obj, th);
        }
    }

    public boolean isAttached(Appender appender) {
        if (appender == null || this.aai == null) {
            return false;
        }
        return this.aai.isAttached(appender);
    }

    public boolean isDebugEnabled() {
        if (this.repository.isDisabled(10000)) {
            return false;
        }
        return Level.DEBUG.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isEnabledFor(Priority priority) {
        if (this.repository.isDisabled(priority.level)) {
            return false;
        }
        return priority.isGreaterOrEqual(getEffectiveLevel());
    }

    public boolean isInfoEnabled() {
        if (this.repository.isDisabled(20000)) {
            return false;
        }
        return Level.INFO.isGreaterOrEqual(getEffectiveLevel());
    }

    public void l7dlog(Priority priority, String str, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            if (resourceBundleString != null) {
                str = resourceBundleString;
            }
            forcedLog(FQCN, priority, str, th);
        }
    }

    public void l7dlog(Priority priority, String str, Object[] objArr, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            String resourceBundleString = getResourceBundleString(str);
            if (resourceBundleString != null) {
                str = MessageFormat.format(resourceBundleString, objArr);
            }
            forcedLog(FQCN, priority, str, th);
        }
    }

    public void log(Priority priority, Object obj, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, priority, obj, th);
        }
    }

    public void log(Priority priority, Object obj) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, priority, obj, null);
        }
    }

    public void log(String str, Priority priority, Object obj, Throwable th) {
        if (!this.repository.isDisabled(priority.level) && priority.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(str, priority, obj, th);
        }
    }

    private void fireRemoveAppenderEvent(Appender appender) {
        if (appender == null) {
            return;
        }
        if (this.repository instanceof Hierarchy) {
            ((Hierarchy) this.repository).fireRemoveAppenderEvent(this, appender);
        } else if (this.repository instanceof HierarchyEventListener) {
            ((HierarchyEventListener) this.repository).removeAppenderEvent(this, appender);
        }
    }

    public synchronized void removeAllAppenders() {
        if (this.aai != null) {
            Vector vector = new Vector();
            Enumeration allAppenders = this.aai.getAllAppenders();
            while (allAppenders != null && allAppenders.hasMoreElements()) {
                vector.add(allAppenders.nextElement());
            }
            this.aai.removeAllAppenders();
            allAppenders = vector.elements();
            while (allAppenders.hasMoreElements()) {
                fireRemoveAppenderEvent((Appender) allAppenders.nextElement());
            }
            this.aai = null;
        }
    }

    public synchronized void removeAppender(Appender appender) {
        if (appender != null) {
            if (this.aai != null) {
                boolean isAttached = this.aai.isAttached(appender);
                this.aai.removeAppender(appender);
                if (isAttached) {
                    fireRemoveAppenderEvent(appender);
                }
            }
        }
    }

    public synchronized void removeAppender(String str) {
        if (str != null) {
            if (this.aai != null) {
                Appender appender = this.aai.getAppender(str);
                this.aai.removeAppender(str);
                if (appender != null) {
                    fireRemoveAppenderEvent(appender);
                }
            }
        }
    }

    public void setAdditivity(boolean z) {
        this.additive = z;
    }

    final void setHierarchy(LoggerRepository loggerRepository) {
        this.repository = loggerRepository;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public void setPriority(Priority priority) {
        this.level = (Level) priority;
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
    }

    public static void shutdown() {
        LogManager.shutdown();
    }

    public void warn(Object obj) {
        if (!this.repository.isDisabled(30000) && Level.WARN.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.WARN, obj, null);
        }
    }

    public void warn(Object obj, Throwable th) {
        if (!this.repository.isDisabled(30000) && Level.WARN.isGreaterOrEqual(getEffectiveLevel())) {
            forcedLog(FQCN, Level.WARN, obj, th);
        }
    }
}
