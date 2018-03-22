package org.apache.log4j;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Vector;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.or.ObjectRenderer;
import org.apache.log4j.or.RendererMap;
import org.apache.log4j.spi.HierarchyEventListener;
import org.apache.log4j.spi.LoggerFactory;
import org.apache.log4j.spi.LoggerRepository;
import org.apache.log4j.spi.RendererSupport;
import org.apache.log4j.spi.ThrowableRenderer;
import org.apache.log4j.spi.ThrowableRendererSupport;

public class Hierarchy implements LoggerRepository, RendererSupport, ThrowableRendererSupport {
    private LoggerFactory defaultFactory;
    boolean emittedNoAppenderWarning = false;
    boolean emittedNoResourceBundleWarning = false;
    Hashtable ht = new Hashtable();
    private Vector listeners = new Vector(1);
    RendererMap rendererMap;
    Logger root;
    Level threshold;
    int thresholdInt;
    private ThrowableRenderer throwableRenderer = null;

    public Hierarchy(Logger logger) {
        this.root = logger;
        setThreshold(Level.ALL);
        this.root.setHierarchy(this);
        this.rendererMap = new RendererMap();
        this.defaultFactory = new DefaultCategoryFactory();
    }

    public void addRenderer(Class cls, ObjectRenderer objectRenderer) {
        this.rendererMap.put(cls, objectRenderer);
    }

    public void addHierarchyEventListener(HierarchyEventListener hierarchyEventListener) {
        if (this.listeners.contains(hierarchyEventListener)) {
            LogLog.warn("Ignoring attempt to add an existent listener.");
        } else {
            this.listeners.addElement(hierarchyEventListener);
        }
    }

    public void clear() {
        this.ht.clear();
    }

    public void emitNoAppenderWarning(Category category) {
        if (!this.emittedNoAppenderWarning) {
            LogLog.warn(new StringBuffer().append("No appenders could be found for logger (").append(category.getName()).append(").").toString());
            LogLog.warn("Please initialize the log4j system properly.");
            LogLog.warn("See http://logging.apache.org/log4j/1.2/faq.html#noconfig for more info.");
            this.emittedNoAppenderWarning = true;
        }
    }

    public Logger exists(String str) {
        Object obj = this.ht.get(new CategoryKey(str));
        if (obj instanceof Logger) {
            return (Logger) obj;
        }
        return null;
    }

    public void setThreshold(String str) {
        Level toLevel = Level.toLevel(str, null);
        if (toLevel != null) {
            setThreshold(toLevel);
        } else {
            LogLog.warn(new StringBuffer().append("Could not convert [").append(str).append("] to Level.").toString());
        }
    }

    public void setThreshold(Level level) {
        if (level != null) {
            this.thresholdInt = level.level;
            this.threshold = level;
        }
    }

    public void fireAddAppenderEvent(Category category, Appender appender) {
        if (this.listeners != null) {
            int size = this.listeners.size();
            for (int i = 0; i < size; i++) {
                ((HierarchyEventListener) this.listeners.elementAt(i)).addAppenderEvent(category, appender);
            }
        }
    }

    void fireRemoveAppenderEvent(Category category, Appender appender) {
        if (this.listeners != null) {
            int size = this.listeners.size();
            for (int i = 0; i < size; i++) {
                ((HierarchyEventListener) this.listeners.elementAt(i)).removeAppenderEvent(category, appender);
            }
        }
    }

    public Level getThreshold() {
        return this.threshold;
    }

    public Logger getLogger(String str) {
        return getLogger(str, this.defaultFactory);
    }

    public Logger getLogger(String str, LoggerFactory loggerFactory) {
        CategoryKey categoryKey = new CategoryKey(str);
        synchronized (this.ht) {
            Object obj = this.ht.get(categoryKey);
            Logger makeNewLoggerInstance;
            if (obj == null) {
                makeNewLoggerInstance = loggerFactory.makeNewLoggerInstance(str);
                makeNewLoggerInstance.setHierarchy(this);
                this.ht.put(categoryKey, makeNewLoggerInstance);
                updateParents(makeNewLoggerInstance);
                return makeNewLoggerInstance;
            } else if (obj instanceof Logger) {
                makeNewLoggerInstance = (Logger) obj;
                return makeNewLoggerInstance;
            } else if (obj instanceof ProvisionNode) {
                Logger makeNewLoggerInstance2 = loggerFactory.makeNewLoggerInstance(str);
                makeNewLoggerInstance2.setHierarchy(this);
                this.ht.put(categoryKey, makeNewLoggerInstance2);
                updateChildren((ProvisionNode) obj, makeNewLoggerInstance2);
                updateParents(makeNewLoggerInstance2);
                return makeNewLoggerInstance2;
            } else {
                return null;
            }
        }
    }

    public Enumeration getCurrentLoggers() {
        Vector vector = new Vector(this.ht.size());
        Enumeration elements = this.ht.elements();
        while (elements.hasMoreElements()) {
            Object nextElement = elements.nextElement();
            if (nextElement instanceof Logger) {
                vector.addElement(nextElement);
            }
        }
        return vector.elements();
    }

    public Enumeration getCurrentCategories() {
        return getCurrentLoggers();
    }

    public RendererMap getRendererMap() {
        return this.rendererMap;
    }

    public Logger getRootLogger() {
        return this.root;
    }

    public boolean isDisabled(int i) {
        return this.thresholdInt > i;
    }

    public void overrideAsNeeded(String str) {
        LogLog.warn("The Hiearchy.overrideAsNeeded method has been deprecated.");
    }

    public void resetConfiguration() {
        getRootLogger().setLevel(Level.DEBUG);
        this.root.setResourceBundle(null);
        setThreshold(Level.ALL);
        synchronized (this.ht) {
            shutdown();
            Enumeration currentLoggers = getCurrentLoggers();
            while (currentLoggers.hasMoreElements()) {
                Logger logger = (Logger) currentLoggers.nextElement();
                logger.setLevel(null);
                logger.setAdditivity(true);
                logger.setResourceBundle(null);
            }
        }
        this.rendererMap.clear();
        this.throwableRenderer = null;
    }

    public void setDisableOverride(String str) {
        LogLog.warn("The Hiearchy.setDisableOverride method has been deprecated.");
    }

    public void setRenderer(Class cls, ObjectRenderer objectRenderer) {
        this.rendererMap.put(cls, objectRenderer);
    }

    public void setThrowableRenderer(ThrowableRenderer throwableRenderer) {
        this.throwableRenderer = throwableRenderer;
    }

    public ThrowableRenderer getThrowableRenderer() {
        return this.throwableRenderer;
    }

    public void shutdown() {
        Logger rootLogger = getRootLogger();
        rootLogger.closeNestedAppenders();
        synchronized (this.ht) {
            Enumeration currentLoggers = getCurrentLoggers();
            while (currentLoggers.hasMoreElements()) {
                ((Logger) currentLoggers.nextElement()).closeNestedAppenders();
            }
            rootLogger.removeAllAppenders();
            Enumeration currentLoggers2 = getCurrentLoggers();
            while (currentLoggers2.hasMoreElements()) {
                ((Logger) currentLoggers2.nextElement()).removeAllAppenders();
            }
        }
    }

    private final void updateParents(Logger logger) {
        int i;
        String str = logger.name;
        for (int lastIndexOf = str.lastIndexOf(46, str.length() - 1); lastIndexOf >= 0; lastIndexOf = str.lastIndexOf(46, lastIndexOf - 1)) {
            CategoryKey categoryKey = new CategoryKey(str.substring(0, lastIndexOf));
            Object obj = this.ht.get(categoryKey);
            if (obj == null) {
                this.ht.put(categoryKey, new ProvisionNode(logger));
            } else if (obj instanceof Category) {
                logger.parent = (Category) obj;
                i = 1;
                break;
            } else if (obj instanceof ProvisionNode) {
                ((ProvisionNode) obj).addElement(logger);
            } else {
                new IllegalStateException(new StringBuffer().append("unexpected object type ").append(obj.getClass()).append(" in ht.").toString()).printStackTrace();
            }
        }
        i = 0;
        if (i == 0) {
            logger.parent = this.root;
        }
    }

    private final void updateChildren(ProvisionNode provisionNode, Logger logger) {
        int size = provisionNode.size();
        for (int i = 0; i < size; i++) {
            Logger logger2 = (Logger) provisionNode.elementAt(i);
            if (!logger2.parent.name.startsWith(logger.name)) {
                logger.parent = logger2.parent;
                logger2.parent = logger;
            }
        }
    }
}
