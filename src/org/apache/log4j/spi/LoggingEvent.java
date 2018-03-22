package org.apache.log4j.spi;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Collections;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.MDC;
import org.apache.log4j.NDC;
import org.apache.log4j.Priority;
import org.apache.log4j.helpers.Loader;
import org.apache.log4j.helpers.LogLog;

public class LoggingEvent implements Serializable {
    static final Integer[] PARAM_ARRAY = new Integer[1];
    static final String TO_LEVEL = "toLevel";
    static final Class[] TO_LEVEL_PARAMS = new Class[]{Integer.TYPE};
    static Class class$org$apache$log4j$Level = null;
    static final Hashtable methodCache = new Hashtable(3);
    static final long serialVersionUID = -868428216207166145L;
    private static long startTime = System.currentTimeMillis();
    public final String categoryName;
    public final transient String fqnOfCategoryClass;
    public transient Priority level;
    private LocationInfo locationInfo;
    private transient Category logger;
    private Hashtable mdcCopy;
    private boolean mdcCopyLookupRequired = true;
    private transient Object message;
    private String ndc;
    private boolean ndcLookupRequired = true;
    private String renderedMessage;
    private String threadName;
    private ThrowableInformation throwableInfo;
    public final long timeStamp;

    public LoggingEvent(String str, Category category, Priority priority, Object obj, Throwable th) {
        this.fqnOfCategoryClass = str;
        this.logger = category;
        this.categoryName = category.getName();
        this.level = priority;
        this.message = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th, category);
        }
        this.timeStamp = System.currentTimeMillis();
    }

    public LoggingEvent(String str, Category category, long j, Priority priority, Object obj, Throwable th) {
        this.fqnOfCategoryClass = str;
        this.logger = category;
        this.categoryName = category.getName();
        this.level = priority;
        this.message = obj;
        if (th != null) {
            this.throwableInfo = new ThrowableInformation(th, category);
        }
        this.timeStamp = j;
    }

    public LoggingEvent(String str, Category category, long j, Level level, Object obj, String str2, ThrowableInformation throwableInformation, String str3, LocationInfo locationInfo, Map map) {
        this.fqnOfCategoryClass = str;
        this.logger = category;
        if (category != null) {
            this.categoryName = category.getName();
        } else {
            this.categoryName = null;
        }
        this.level = level;
        this.message = obj;
        if (throwableInformation != null) {
            this.throwableInfo = throwableInformation;
        }
        this.timeStamp = j;
        this.threadName = str2;
        this.ndcLookupRequired = false;
        this.ndc = str3;
        this.locationInfo = locationInfo;
        this.mdcCopyLookupRequired = false;
        if (map != null) {
            this.mdcCopy = new Hashtable(map);
        }
    }

    public LocationInfo getLocationInformation() {
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(new Throwable(), this.fqnOfCategoryClass);
        }
        return this.locationInfo;
    }

    public Level getLevel() {
        return (Level) this.level;
    }

    public String getLoggerName() {
        return this.categoryName;
    }

    public Category getLogger() {
        return this.logger;
    }

    public Object getMessage() {
        if (this.message != null) {
            return this.message;
        }
        return getRenderedMessage();
    }

    public String getNDC() {
        if (this.ndcLookupRequired) {
            this.ndcLookupRequired = false;
            this.ndc = NDC.get();
        }
        return this.ndc;
    }

    public Object getMDC(String str) {
        if (this.mdcCopy != null) {
            Object obj = this.mdcCopy.get(str);
            if (obj != null) {
                return obj;
            }
        }
        return MDC.get(str);
    }

    public void getMDCCopy() {
        if (this.mdcCopyLookupRequired) {
            this.mdcCopyLookupRequired = false;
            Hashtable context = MDC.getContext();
            if (context != null) {
                this.mdcCopy = (Hashtable) context.clone();
            }
        }
    }

    public String getRenderedMessage() {
        if (this.renderedMessage == null && this.message != null) {
            if (this.message instanceof String) {
                this.renderedMessage = (String) this.message;
            } else {
                LoggerRepository loggerRepository = this.logger.getLoggerRepository();
                if (loggerRepository instanceof RendererSupport) {
                    this.renderedMessage = ((RendererSupport) loggerRepository).getRendererMap().findAndRender(this.message);
                } else {
                    this.renderedMessage = this.message.toString();
                }
            }
        }
        return this.renderedMessage;
    }

    public static long getStartTime() {
        return startTime;
    }

    public String getThreadName() {
        if (this.threadName == null) {
            this.threadName = Thread.currentThread().getName();
        }
        return this.threadName;
    }

    public ThrowableInformation getThrowableInformation() {
        return this.throwableInfo;
    }

    public String[] getThrowableStrRep() {
        if (this.throwableInfo == null) {
            return null;
        }
        return this.throwableInfo.getThrowableStrRep();
    }

    private void readLevel(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        int readInt = objectInputStream.readInt();
        try {
            String str = (String) objectInputStream.readObject();
            if (str == null) {
                this.level = Level.toLevel(readInt);
                return;
            }
            Method method = (Method) methodCache.get(str);
            if (method == null) {
                method = Loader.loadClass(str).getDeclaredMethod(TO_LEVEL, TO_LEVEL_PARAMS);
                methodCache.put(str, method);
            }
            this.level = (Level) method.invoke(null, new Integer[]{new Integer(readInt)});
        } catch (Throwable e) {
            if ((e.getTargetException() instanceof InterruptedException) || (e.getTargetException() instanceof InterruptedIOException)) {
                Thread.currentThread().interrupt();
            }
            LogLog.warn("Level deserialization failed, reverting to default.", e);
            this.level = Level.toLevel(readInt);
        } catch (Throwable e2) {
            LogLog.warn("Level deserialization failed, reverting to default.", e2);
            this.level = Level.toLevel(readInt);
        } catch (Throwable e22) {
            LogLog.warn("Level deserialization failed, reverting to default.", e22);
            this.level = Level.toLevel(readInt);
        } catch (Throwable e222) {
            LogLog.warn("Level deserialization failed, reverting to default.", e222);
            this.level = Level.toLevel(readInt);
        }
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        readLevel(objectInputStream);
        if (this.locationInfo == null) {
            this.locationInfo = new LocationInfo(null, null);
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        getThreadName();
        getRenderedMessage();
        getNDC();
        getMDCCopy();
        getThrowableStrRep();
        objectOutputStream.defaultWriteObject();
        writeLevel(objectOutputStream);
    }

    private void writeLevel(ObjectOutputStream objectOutputStream) throws IOException {
        Class class$;
        objectOutputStream.writeInt(this.level.toInt());
        Class cls = this.level.getClass();
        if (class$org$apache$log4j$Level == null) {
            class$ = class$("org.apache.log4j.Level");
            class$org$apache$log4j$Level = class$;
        } else {
            class$ = class$org$apache$log4j$Level;
        }
        if (cls == class$) {
            objectOutputStream.writeObject(null);
        } else {
            objectOutputStream.writeObject(cls.getName());
        }
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }

    public final void setProperty(String str, String str2) {
        if (this.mdcCopy == null) {
            getMDCCopy();
        }
        if (this.mdcCopy == null) {
            this.mdcCopy = new Hashtable();
        }
        this.mdcCopy.put(str, str2);
    }

    public final String getProperty(String str) {
        Object mdc = getMDC(str);
        if (mdc != null) {
            return mdc.toString();
        }
        return null;
    }

    public final boolean locationInformationExists() {
        return this.locationInfo != null;
    }

    public final long getTimeStamp() {
        return this.timeStamp;
    }

    public Set getPropertyKeySet() {
        return getProperties().keySet();
    }

    public Map getProperties() {
        Map hashMap;
        getMDCCopy();
        if (this.mdcCopy == null) {
            hashMap = new HashMap();
        } else {
            hashMap = this.mdcCopy;
        }
        return Collections.unmodifiableMap(hashMap);
    }

    public String getFQNOfLoggerClass() {
        return this.fqnOfCategoryClass;
    }

    public Object removeProperty(String str) {
        if (this.mdcCopy == null) {
            getMDCCopy();
        }
        if (this.mdcCopy == null) {
            this.mdcCopy = new Hashtable();
        }
        return this.mdcCopy.remove(str);
    }
}
