package org.apache.log4j;

import com.huawei.hwappdfxmgr.upload.UploadFile;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.helpers.AppenderAttachableImpl;
import org.apache.log4j.helpers.LogLog;
import org.apache.log4j.spi.AppenderAttachable;
import org.apache.log4j.spi.LoggingEvent;

public class AsyncAppender extends AppenderSkeleton implements AppenderAttachable {
    public static final int DEFAULT_BUFFER_SIZE = 128;
    AppenderAttachableImpl aai = this.appenders;
    private final AppenderAttachableImpl appenders = new AppenderAttachableImpl();
    private boolean blocking = true;
    private final List buffer = new ArrayList();
    private int bufferSize = 128;
    private final Map discardMap = new HashMap();
    private final Thread dispatcher = new Thread(new Dispatcher(this, this.buffer, this.discardMap, this.appenders));
    private boolean locationInfo = false;

    final class DiscardSummary {
        private int count = 1;
        private LoggingEvent maxEvent;

        public DiscardSummary(LoggingEvent loggingEvent) {
            this.maxEvent = loggingEvent;
        }

        public void add(LoggingEvent loggingEvent) {
            if (loggingEvent.getLevel().toInt() > this.maxEvent.getLevel().toInt()) {
                this.maxEvent = loggingEvent;
            }
            this.count++;
        }

        public LoggingEvent createEvent() {
            return new LoggingEvent("org.apache.log4j.AsyncAppender.DONT_REPORT_LOCATION", Logger.getLogger(this.maxEvent.getLoggerName()), this.maxEvent.getLevel(), MessageFormat.format("Discarded {0} messages due to full event buffer including: {1}", new Object[]{new Integer(this.count), this.maxEvent.getMessage()}), null);
        }
    }

    class Dispatcher implements Runnable {
        private final AppenderAttachableImpl appenders;
        private final List buffer;
        private final Map discardMap;
        private final AsyncAppender parent;

        public Dispatcher(AsyncAppender asyncAppender, List list, Map map, AppenderAttachableImpl appenderAttachableImpl) {
            this.parent = asyncAppender;
            this.buffer = list;
            this.appenders = appenderAttachableImpl;
            this.discardMap = map;
        }

        public void run() {
            Object obj = 1;
            while (obj != null) {
                LoggingEvent[] loggingEventArr = null;
                try {
                    int size;
                    synchronized (this.buffer) {
                        obj = !this.parent.closed ? 1 : null;
                        size = this.buffer.size();
                        while (size == 0 && r6 != null) {
                            this.buffer.wait();
                            obj = !this.parent.closed ? 1 : null;
                            size = this.buffer.size();
                        }
                        if (size > 0) {
                            loggingEventArr = new LoggingEvent[(this.discardMap.size() + size)];
                            this.buffer.toArray(loggingEventArr);
                            int i = size;
                            for (DiscardSummary createEvent : this.discardMap.values()) {
                                int i2 = i + 1;
                                loggingEventArr[i] = createEvent.createEvent();
                                i = i2;
                            }
                            this.buffer.clear();
                            this.discardMap.clear();
                            this.buffer.notifyAll();
                        }
                    }
                    if (loggingEventArr != null) {
                        for (LoggingEvent appendLoopOnAppenders : loggingEventArr) {
                            synchronized (this.appenders) {
                                this.appenders.appendLoopOnAppenders(appendLoopOnAppenders);
                            }
                        }
                        continue;
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return;
                }
            }
        }
    }

    public AsyncAppender() {
        this.dispatcher.setDaemon(true);
        this.dispatcher.setName(new StringBuffer().append("AsyncAppender-Dispatcher-").append(this.dispatcher.getName()).toString());
        this.dispatcher.start();
    }

    public void addAppender(Appender appender) {
        synchronized (this.appenders) {
            this.appenders.addAppender(appender);
        }
    }

    public void append(LoggingEvent loggingEvent) {
        if (this.dispatcher == null || !this.dispatcher.isAlive() || this.bufferSize <= 0) {
            synchronized (this.appenders) {
                this.appenders.appendLoopOnAppenders(loggingEvent);
            }
            return;
        }
        loggingEvent.getNDC();
        loggingEvent.getThreadName();
        loggingEvent.getMDCCopy();
        if (this.locationInfo) {
            loggingEvent.getLocationInformation();
        }
        loggingEvent.getRenderedMessage();
        loggingEvent.getThrowableStrRep();
        synchronized (this.buffer) {
            Object obj;
            do {
                int size = this.buffer.size();
                if (size < this.bufferSize) {
                    this.buffer.add(loggingEvent);
                    if (size == 0) {
                        this.buffer.notifyAll();
                    }
                } else {
                    obj = 1;
                    if (!(!this.blocking || Thread.interrupted() || Thread.currentThread() == this.dispatcher)) {
                        try {
                            this.buffer.wait();
                            obj = null;
                            continue;
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            continue;
                        }
                    }
                }
            } while (obj == null);
            String loggerName = loggingEvent.getLoggerName();
            DiscardSummary discardSummary = (DiscardSummary) this.discardMap.get(loggerName);
            if (discardSummary == null) {
                this.discardMap.put(loggerName, new DiscardSummary(loggingEvent));
            } else {
                discardSummary.add(loggingEvent);
            }
        }
    }

    public void close() {
        synchronized (this.buffer) {
            this.closed = true;
            this.buffer.notifyAll();
        }
        try {
            this.dispatcher.join();
        } catch (Throwable e) {
            Thread.currentThread().interrupt();
            LogLog.error("Got an InterruptedException while waiting for the dispatcher to finish.", e);
        }
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

    public boolean getLocationInfo() {
        return this.locationInfo;
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

    public void setLocationInfo(boolean z) {
        this.locationInfo = z;
    }

    public void setBufferSize(int i) {
        if (i < 0) {
            throw new NegativeArraySizeException(UploadFile.SIZE_LABEL);
        }
        synchronized (this.buffer) {
            if (i < 1) {
                i = 1;
            }
            this.bufferSize = i;
            this.buffer.notifyAll();
        }
    }

    public int getBufferSize() {
        return this.bufferSize;
    }

    public void setBlocking(boolean z) {
        synchronized (this.buffer) {
            this.blocking = z;
            this.buffer.notifyAll();
        }
    }

    public boolean getBlocking() {
        return this.blocking;
    }
}
