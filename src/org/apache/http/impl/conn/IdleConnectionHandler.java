package org.apache.http.impl.conn;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.TimeUnit;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpConnection;

@Deprecated
public class IdleConnectionHandler {
    private final Map<HttpConnection, TimeValues> connectionToTimes = new HashMap();
    private final Log log = LogFactory.getLog(getClass());

    public void add(HttpConnection httpConnection, long j, TimeUnit timeUnit) {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Adding connection at: " + currentTimeMillis);
        }
        this.connectionToTimes.put(httpConnection, new TimeValues(currentTimeMillis, j, timeUnit));
    }

    public boolean remove(HttpConnection httpConnection) {
        TimeValues timeValues = (TimeValues) this.connectionToTimes.remove(httpConnection);
        if (timeValues == null) {
            this.log.warn("Removing a connection that never existed!");
            return true;
        }
        return System.currentTimeMillis() <= TimeValues.access$000(timeValues);
    }

    public void removeAll() {
        this.connectionToTimes.clear();
    }

    public void closeIdleConnections(long j) {
        long currentTimeMillis = System.currentTimeMillis() - j;
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for connections, idle timeout: " + currentTimeMillis);
        }
        for (Entry entry : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) entry.getKey();
            long access$100 = TimeValues.access$100((TimeValues) entry.getValue());
            if (access$100 <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing idle connection, connection time: " + access$100);
                }
                try {
                    httpConnection.close();
                } catch (Throwable e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }

    public void closeExpiredConnections() {
        long currentTimeMillis = System.currentTimeMillis();
        if (this.log.isDebugEnabled()) {
            this.log.debug("Checking for expired connections, now: " + currentTimeMillis);
        }
        for (Entry entry : this.connectionToTimes.entrySet()) {
            HttpConnection httpConnection = (HttpConnection) entry.getKey();
            TimeValues timeValues = (TimeValues) entry.getValue();
            if (TimeValues.access$000(timeValues) <= currentTimeMillis) {
                if (this.log.isDebugEnabled()) {
                    this.log.debug("Closing connection, expired @: " + TimeValues.access$000(timeValues));
                }
                try {
                    httpConnection.close();
                } catch (Throwable e) {
                    this.log.debug("I/O error closing connection", e);
                }
            }
        }
    }
}
