package org.apache.log4j.rewrite;

import java.util.Enumeration;
import java.util.Properties;
import org.apache.log4j.Appender;
import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.xml.UnrecognizedElementHandler;
import org.w3c.dom.Element;

public class RewriteAppender extends AppenderSkeleton implements AppenderAttachable, UnrecognizedElementHandler {
    static Class class$org$apache$log4j$rewrite$RewritePolicy;
    private final AppenderAttachableImpl appenders = new AppenderAttachableImpl();
    private RewritePolicy policy;

    protected void append(LoggingEvent loggingEvent) {
        if (this.policy != null) {
            loggingEvent = this.policy.rewrite(loggingEvent);
        }
        if (loggingEvent != null) {
            synchronized (this.appenders) {
                this.appenders.appendLoopOnAppenders(loggingEvent);
            }
        }
    }

    public void addAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.addAppender(appender);
        }
    }

    public Enumeration getAllAppenders() {
        Enumeration allAppenders;
        synchronized (this.appenders) {
            allAppenders = this.appenders.getAllAppenders();
        }
        return allAppenders;
    }

    public Appender getAppender(String str) {
        Appender appender;
        synchronized (this.appenders) {
            appender = this.appenders.getAppender(str);
        }
        return appender;
    }

    public void close() {
        this.closed = true;
        synchronized (this.appenders) {
            Enumeration allAppenders = this.appenders.getAllAppenders();
            if (allAppenders != null) {
                while (allAppenders.hasMoreElements()) {
                    Object nextElement = allAppenders.nextElement();
                    if (nextElement instanceof Appender) {
                        ((Appender) nextElement).close();
                    }
                }
            }
        }
    }

    public boolean isAttached(Appender appender) {
        boolean isAttached;
        synchronized (this.appenders) {
            isAttached = this.appenders.isAttached(appender);
        }
        return isAttached;
    }

    public boolean requiresLayout() {
        return false;
    }

    public void removeAllAppenders() {
        synchronized (this.appenders) {
            this.appenders.removeAllAppenders();
        }
    }

    public void removeAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(appender);
        }
    }

    public void removeAppender(String str) {
        synchronized (this.appenders) {
            this.appenders.removeAppender(str);
        }
    }

    public void setRewritePolicy(RewritePolicy rewritePolicy) {
        this.policy = rewritePolicy;
    }

    public boolean parseUnrecognizedElement(Element element, Properties properties) throws Exception {
        if (!"rewritePolicy".equals(element.getNodeName())) {
            return false;
        }
        Class class$;
        if (class$org$apache$log4j$rewrite$RewritePolicy == null) {
            class$ = class$("org.apache.log4j.rewrite.RewritePolicy");
            class$org$apache$log4j$rewrite$RewritePolicy = class$;
        } else {
            class$ = class$org$apache$log4j$rewrite$RewritePolicy;
        }
        Object parseElement = DOMConfigurator.parseElement(element, properties, class$);
        if (parseElement != null) {
            if (parseElement instanceof OptionHandler) {
                ((OptionHandler) parseElement).activateOptions();
            }
            setRewritePolicy((RewritePolicy) parseElement);
        }
        return true;
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable e) {
            throw new NoClassDefFoundError().initCause(e);
        }
    }
}
