package org.apache.log4j;

import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.helpers.OnlyOnceErrorHandler;
import org.apache.log4j.spi.ErrorHandler;
import org.apache.log4j.spi.Filter;
import org.apache.log4j.spi.LoggingEvent;
import org.apache.log4j.spi.OptionHandler;

public abstract class AppenderSkeleton implements Appender, OptionHandler {
    protected boolean closed = false;
    protected ErrorHandler errorHandler = new OnlyOnceErrorHandler();
    protected Filter headFilter;
    protected Layout layout;
    protected String name;
    protected Filter tailFilter;
    protected Priority threshold;

    protected abstract void append(LoggingEvent loggingEvent);

    protected AppenderSkeleton(boolean z) {
    }

    public void activateOptions() {
    }

    public void addFilter(Filter filter) {
        if (this.headFilter == null) {
            this.tailFilter = filter;
            this.headFilter = filter;
            return;
        }
        this.tailFilter.setNext(filter);
        this.tailFilter = filter;
    }

    public void clearFilters() {
        this.tailFilter = null;
        this.headFilter = null;
    }

    public void finalize() {
        if (!this.closed) {
            LogLog.debug(new StringBuffer().append("Finalizing appender named [").append(this.name).append("].").toString());
            close();
        }
    }

    public ErrorHandler getErrorHandler() {
        return this.errorHandler;
    }

    public Filter getFilter() {
        return this.headFilter;
    }

    public final Filter getFirstFilter() {
        return this.headFilter;
    }

    public Layout getLayout() {
        return this.layout;
    }

    public final String getName() {
        return this.name;
    }

    public Priority getThreshold() {
        return this.threshold;
    }

    public boolean isAsSevereAsThreshold(Priority priority) {
        return this.threshold == null || priority.isGreaterOrEqual(this.threshold);
    }

    public synchronized void doAppend(LoggingEvent loggingEvent) {
        if (this.closed) {
            LogLog.error(new StringBuffer().append("Attempted to append to closed appender named [").append(this.name).append("].").toString());
        } else if (isAsSevereAsThreshold(loggingEvent.getLevel())) {
            Filter filter = this.headFilter;
            while (filter != null) {
                switch (filter.decide(loggingEvent)) {
                    case -1:
                        break;
                    case 0:
                        filter = filter.getNext();
                        continue;
                    case 1:
                        break;
                    default:
                        continue;
                }
                append(loggingEvent);
            }
            append(loggingEvent);
        }
    }

    public synchronized void setErrorHandler(ErrorHandler errorHandler) {
        if (errorHandler == null) {
            LogLog.warn("You have tried to set a null error-handler.");
        } else {
            this.errorHandler = errorHandler;
        }
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setThreshold(Priority priority) {
        this.threshold = priority;
    }
}
