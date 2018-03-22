package org.apache.log4j;

import org.apache.log4j.helpers.DateLayout;
import org.apache.log4j.spi.LoggingEvent;

public class TTCCLayout extends DateLayout {
    protected final StringBuffer buf = new StringBuffer(256);
    private boolean categoryPrefixing = true;
    private boolean contextPrinting = true;
    private boolean threadPrinting = true;

    public TTCCLayout() {
        setDateFormat(DateLayout.RELATIVE_TIME_DATE_FORMAT, null);
    }

    public TTCCLayout(String str) {
        setDateFormat(str);
    }

    public void setThreadPrinting(boolean z) {
        this.threadPrinting = z;
    }

    public boolean getThreadPrinting() {
        return this.threadPrinting;
    }

    public void setCategoryPrefixing(boolean z) {
        this.categoryPrefixing = z;
    }

    public boolean getCategoryPrefixing() {
        return this.categoryPrefixing;
    }

    public void setContextPrinting(boolean z) {
        this.contextPrinting = z;
    }

    public boolean getContextPrinting() {
        return this.contextPrinting;
    }

    public String format(LoggingEvent loggingEvent) {
        this.buf.setLength(0);
        dateFormat(this.buf, loggingEvent);
        if (this.threadPrinting) {
            this.buf.append('[');
            this.buf.append(loggingEvent.getThreadName());
            this.buf.append("] ");
        }
        this.buf.append(loggingEvent.getLevel().toString());
        this.buf.append(' ');
        if (this.categoryPrefixing) {
            this.buf.append(loggingEvent.getLoggerName());
            this.buf.append(' ');
        }
        if (this.contextPrinting) {
            String ndc = loggingEvent.getNDC();
            if (ndc != null) {
                this.buf.append(ndc);
                this.buf.append(' ');
            }
        }
        this.buf.append("- ");
        this.buf.append(loggingEvent.getRenderedMessage());
        this.buf.append(LINE_SEP);
        return this.buf.toString();
    }

    public boolean ignoresThrowable() {
        return true;
    }
}
