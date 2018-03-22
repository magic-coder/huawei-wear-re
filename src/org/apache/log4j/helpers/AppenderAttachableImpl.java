package org.apache.log4j.helpers;

import java.util.Enumeration;
import java.util.Vector;
import org.apache.log4j.Appender;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

public class AppenderAttachableImpl implements AppenderAttachable {
    protected Vector appenderList;

    public void addAppender(Appender appender) {
        if (appender != null) {
            if (this.appenderList == null) {
                this.appenderList = new Vector(1);
            }
            if (!this.appenderList.contains(appender)) {
                this.appenderList.addElement(appender);
            }
        }
    }

    public int appendLoopOnAppenders(LoggingEvent loggingEvent) {
        if (this.appenderList == null) {
            return 0;
        }
        int size = this.appenderList.size();
        for (int i = 0; i < size; i++) {
            ((Appender) this.appenderList.elementAt(i)).doAppend(loggingEvent);
        }
        return size;
    }

    public Enumeration getAllAppenders() {
        if (this.appenderList == null) {
            return null;
        }
        return this.appenderList.elements();
    }

    public Appender getAppender(String str) {
        if (this.appenderList == null || str == null) {
            return null;
        }
        int size = this.appenderList.size();
        for (int i = 0; i < size; i++) {
            Appender appender = (Appender) this.appenderList.elementAt(i);
            if (str.equals(appender.getName())) {
                return appender;
            }
        }
        return null;
    }

    public boolean isAttached(Appender appender) {
        if (this.appenderList == null || appender == null) {
            return false;
        }
        int size = this.appenderList.size();
        for (int i = 0; i < size; i++) {
            if (((Appender) this.appenderList.elementAt(i)) == appender) {
                return true;
            }
        }
        return false;
    }

    public void removeAllAppenders() {
        if (this.appenderList != null) {
            int size = this.appenderList.size();
            for (int i = 0; i < size; i++) {
                ((Appender) this.appenderList.elementAt(i)).close();
            }
            this.appenderList.removeAllElements();
            this.appenderList = null;
        }
    }

    public void removeAppender(Appender appender) {
        if (appender != null && this.appenderList != null) {
            this.appenderList.removeElement(appender);
        }
    }

    public void removeAppender(String str) {
        if (str != null && this.appenderList != null) {
            int size = this.appenderList.size();
            for (int i = 0; i < size; i++) {
                if (str.equals(((Appender) this.appenderList.elementAt(i)).getName())) {
                    this.appenderList.removeElementAt(i);
                    return;
                }
            }
        }
    }
}
