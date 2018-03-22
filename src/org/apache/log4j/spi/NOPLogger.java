package org.apache.log4j.spi;

import java.util.Enumeration;
import java.util.ResourceBundle;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;

public final class NOPLogger extends Logger {
    public NOPLogger(NOPLoggerRepository nOPLoggerRepository, String str) {
        super(str);
        this.repository = nOPLoggerRepository;
        this.level = Level.OFF;
        this.parent = this;
    }

    public void addAppender(Appender appender) {
    }

    public void assertLog(boolean z, String str) {
    }

    public void callAppenders(LoggingEvent loggingEvent) {
    }

    void closeNestedAppenders() {
    }

    public void debug(Object obj) {
    }

    public void debug(Object obj, Throwable th) {
    }

    public void error(Object obj) {
    }

    public void error(Object obj, Throwable th) {
    }

    public void fatal(Object obj) {
    }

    public void fatal(Object obj, Throwable th) {
    }

    public Enumeration getAllAppenders() {
        return new Vector().elements();
    }

    public Appender getAppender(String str) {
        return null;
    }

    public Level getEffectiveLevel() {
        return Level.OFF;
    }

    public Priority getChainedPriority() {
        return getEffectiveLevel();
    }

    public ResourceBundle getResourceBundle() {
        return null;
    }

    public void info(Object obj) {
    }

    public void info(Object obj, Throwable th) {
    }

    public boolean isAttached(Appender appender) {
        return false;
    }

    public boolean isDebugEnabled() {
        return false;
    }

    public boolean isEnabledFor(Priority priority) {
        return false;
    }

    public boolean isInfoEnabled() {
        return false;
    }

    public void l7dlog(Priority priority, String str, Throwable th) {
    }

    public void l7dlog(Priority priority, String str, Object[] objArr, Throwable th) {
    }

    public void log(Priority priority, Object obj, Throwable th) {
    }

    public void log(Priority priority, Object obj) {
    }

    public void log(String str, Priority priority, Object obj, Throwable th) {
    }

    public void removeAllAppenders() {
    }

    public void removeAppender(Appender appender) {
    }

    public void removeAppender(String str) {
    }

    public void setLevel(Level level) {
    }

    public void setPriority(Priority priority) {
    }

    public void setResourceBundle(ResourceBundle resourceBundle) {
    }

    public void warn(Object obj) {
    }

    public void warn(Object obj, Throwable th) {
    }

    public void trace(Object obj) {
    }

    public void trace(Object obj, Throwable th) {
    }

    public boolean isTraceEnabled() {
        return false;
    }
}
