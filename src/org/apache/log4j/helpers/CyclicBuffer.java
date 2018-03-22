package org.apache.log4j.helpers;

import org.apache.log4j.spi.LoggingEvent;

public class CyclicBuffer {
    LoggingEvent[] ea;
    int first;
    int last;
    int maxSize;
    int numElems;

    public CyclicBuffer(int i) throws IllegalArgumentException {
        if (i < 1) {
            throw new IllegalArgumentException(new StringBuffer().append("The maxSize argument (").append(i).append(") is not a positive integer.").toString());
        }
        this.maxSize = i;
        this.ea = new LoggingEvent[i];
        this.first = 0;
        this.last = 0;
        this.numElems = 0;
    }

    public void add(LoggingEvent loggingEvent) {
        this.ea[this.last] = loggingEvent;
        int i = this.last + 1;
        this.last = i;
        if (i == this.maxSize) {
            this.last = 0;
        }
        if (this.numElems < this.maxSize) {
            this.numElems++;
            return;
        }
        i = this.first + 1;
        this.first = i;
        if (i == this.maxSize) {
            this.first = 0;
        }
    }

    public LoggingEvent get(int i) {
        if (i < 0 || i >= this.numElems) {
            return null;
        }
        return this.ea[(this.first + i) % this.maxSize];
    }

    public int getMaxSize() {
        return this.maxSize;
    }

    public LoggingEvent get() {
        if (this.numElems <= 0) {
            return null;
        }
        this.numElems--;
        LoggingEvent loggingEvent = this.ea[this.first];
        this.ea[this.first] = null;
        int i = this.first + 1;
        this.first = i;
        if (i != this.maxSize) {
            return loggingEvent;
        }
        this.first = 0;
        return loggingEvent;
    }

    public int length() {
        return this.numElems;
    }

    public void resize(int i) {
        if (i < 0) {
            throw new IllegalArgumentException(new StringBuffer().append("Negative array size [").append(i).append("] not allowed.").toString());
        } else if (i != this.numElems) {
            LoggingEvent[] loggingEventArr = new LoggingEvent[i];
            int i2 = i < this.numElems ? i : this.numElems;
            for (int i3 = 0; i3 < i2; i3++) {
                loggingEventArr[i3] = this.ea[this.first];
                this.ea[this.first] = null;
                int i4 = this.first + 1;
                this.first = i4;
                if (i4 == this.numElems) {
                    this.first = 0;
                }
            }
            this.ea = loggingEventArr;
            this.first = 0;
            this.numElems = i2;
            this.maxSize = i;
            if (i2 == i) {
                this.last = 0;
            } else {
                this.last = i2;
            }
        }
    }
}
