package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

public class BoundedFIFO {
    LoggingEvent[] buf;
    int first = 0;
    int maxSize;
    int next = 0;
    int numElements = 0;

    public BoundedFIFO(int i) {
        if (i < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("The maxSize argument (").append(i).append(") is not a positive integer.").toString());
        }
        this.maxSize = i;
        this.buf = new LoggingEvent[i];
    }

    public LoggingEvent get() {
        if (this.numElements == 0) {
            return null;
        }
        LoggingEvent loggingEvent = this.buf[this.first];
        this.buf[this.first] = null;
        int i = this.first + 1;
        this.first = i;
        if (i == this.maxSize) {
            this.first = 0;
        }
        this.numElements--;
        return loggingEvent;
    }

    public void put(LoggingEvent loggingEvent) {
        if (this.numElements != this.maxSize) {
            this.buf[this.next] = loggingEvent;
            int i = this.next + 1;
            this.next = i;
            if (i == this.maxSize) {
                this.next = 0;
            }
            this.numElements++;
        }
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public boolean isFull() {
        return this.numElements == this.maxSize;
    }

    public int length() {
        return this.numElements;
    }

    int min(int i, int i2) {
        return i < i2 ? i : i2;
    }

    public synchronized void resize(int i) {
        int i2 = 0;
        synchronized (this) {
            if (i != this.maxSize) {
                Object obj = new LoggingEvent[i];
                int min = min(min(this.maxSize - this.first, i), this.numElements);
                System.arraycopy(this.buf, this.first, obj, 0, min);
                if (min < this.numElements && min < i) {
                    i2 = min(this.numElements - min, i - min);
                    System.arraycopy(this.buf, 0, obj, min, i2);
                }
                this.buf = obj;
                this.maxSize = i;
                this.first = 0;
                this.numElements = i2 + min;
                this.next = this.numElements;
                if (this.next == this.maxSize) {
                    this.next = 0;
                }
            }
        }
    }

    public boolean wasEmpty() {
        return this.numElements == 1;
    }

    public boolean wasFull() {
        return this.numElements + 1 == this.maxSize;
    }
}
