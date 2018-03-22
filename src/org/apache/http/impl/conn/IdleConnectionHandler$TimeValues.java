package org.apache.http.impl.conn;

import java.util.concurrent.TimeUnit;

class IdleConnectionHandler$TimeValues {
    private final long timeAdded;
    private final long timeExpires;

    IdleConnectionHandler$TimeValues(long j, long j2, TimeUnit timeUnit) {
        this.timeAdded = j;
        if (j2 > 0) {
            this.timeExpires = timeUnit.toMillis(j2) + j;
        } else {
            this.timeExpires = Long.MAX_VALUE;
        }
    }
}
