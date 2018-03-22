package org.apache.log4j.spi;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.Category;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;

public final class NOPLoggerRepository implements LoggerRepository {
    public void addHierarchyEventListener(HierarchyEventListener hierarchyEventListener) {
    }

    public boolean isDisabled(int i) {
        return true;
    }

    public void setThreshold(Level level) {
    }

    public void setThreshold(String str) {
    }

    public void emitNoAppenderWarning(Category category) {
    }

    public Level getThreshold() {
        return Level.OFF;
    }

    public Logger getLogger(String str) {
        return new NOPLogger(this, str);
    }

    public Logger getLogger(String str, LoggerFactory loggerFactory) {
        return new NOPLogger(this, str);
    }

    public Logger getRootLogger() {
        return new NOPLogger(this, "root");
    }

    public Logger exists(String str) {
        return null;
    }

    public void shutdown() {
    }

    public Enumeration getCurrentLoggers() {
        return new Vector().elements();
    }

    public Enumeration getCurrentCategories() {
        return getCurrentLoggers();
    }

    public void fireAddAppenderEvent(Category category, Appender appender) {
    }

    public void resetConfiguration() {
    }
}
