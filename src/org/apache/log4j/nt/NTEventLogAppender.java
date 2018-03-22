package org.apache.log4j.nt;

import org.apache.log4j.AppenderSkeleton;
import org.apache.log4j.Layout;
import org.apache.log4j.TTCCLayout;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.LoggingEvent;

public class NTEventLogAppender extends AppenderSkeleton {
    private int _handle;
    private String server;
    private String source;

    private native void deregisterEventSource(int i);

    private native int registerEventSource(String str, String str2);

    private native void reportEvent(int i, String str, int i2);

    public NTEventLogAppender() {
        this(null, null, null);
    }

    public NTEventLogAppender(String str) {
        this(null, str, null);
    }

    public NTEventLogAppender(String str, String str2) {
        this(str, str2, null);
    }

    public NTEventLogAppender(Layout layout) {
        this(null, null, layout);
    }

    public NTEventLogAppender(String str, Layout layout) {
        this(null, str, layout);
    }

    public NTEventLogAppender(String str, String str2, Layout layout) {
        this._handle = 0;
        this.source = null;
        this.server = null;
        if (str2 == null) {
            str2 = "Log4j";
        }
        if (layout == null) {
            this.layout = new TTCCLayout();
        } else {
            this.layout = layout;
        }
        try {
            this._handle = registerEventSource(str, str2);
        } catch (Exception e) {
            e.printStackTrace();
            this._handle = 0;
        }
    }

    public void close() {
    }

    public void activateOptions() {
        if (this.source != null) {
            try {
                this._handle = registerEventSource(this.server, this.source);
            } catch (Throwable e) {
                LogLog.error("Could not register event source.", e);
                this._handle = 0;
            }
        }
    }

    public void append(LoggingEvent loggingEvent) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(this.layout.format(loggingEvent));
        if (this.layout.ignoresThrowable()) {
            String[] throwableStrRep = loggingEvent.getThrowableStrRep();
            if (throwableStrRep != null) {
                for (String append : throwableStrRep) {
                    stringBuffer.append(append);
                }
            }
        }
        reportEvent(this._handle, stringBuffer.toString(), loggingEvent.getLevel().toInt());
    }

    public void finalize() {
        deregisterEventSource(this._handle);
        this._handle = 0;
    }

    public void setSource(String str) {
        this.source = str.trim();
    }

    public String getSource() {
        return this.source;
    }

    public boolean requiresLayout() {
        return true;
    }

    static {
        String[] strArr;
        int i = 0;
        try {
            strArr = new String[]{System.getProperty("os.arch")};
        } catch (SecurityException e) {
            strArr = new String[]{"amd64", "ia64", "x86"};
        }
        int i2 = 0;
        while (i2 < strArr.length) {
            try {
                System.loadLibrary(new StringBuffer().append("NTEventLogAppender.").append(strArr[i2]).toString());
                i = 1;
                break;
            } catch (UnsatisfiedLinkError e2) {
                i2++;
            }
        }
        if (i == 0) {
            System.loadLibrary("NTEventLogAppender");
        }
    }
}
