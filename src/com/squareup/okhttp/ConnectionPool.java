package com.squareup.okhttp;

import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class ConnectionPool {
    private static final long DEFAULT_KEEP_ALIVE_DURATION_MS = 300000;
    private static final ConnectionPool systemDefault;
    private final LinkedList<Connection> connections = new LinkedList();
    private final Runnable connectionsCleanupRunnable = new C26171();
    private Executor executor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory("OkHttp ConnectionPool", true));
    private final long keepAliveDurationNs;
    private final int maxIdleConnections;

    class C26171 implements Runnable {
        C26171() {
        }

        public void run() {
            ConnectionPool.this.runCleanupUntilPoolIsEmpty();
        }
    }

    static {
        String property = System.getProperty("http.keepAlive");
        String property2 = System.getProperty("http.keepAliveDuration");
        String property3 = System.getProperty("http.maxConnections");
        long parseLong = property2 != null ? Long.parseLong(property2) : 300000;
        if (property != null && !Boolean.parseBoolean(property)) {
            systemDefault = new ConnectionPool(0, parseLong);
        } else if (property3 != null) {
            systemDefault = new ConnectionPool(Integer.parseInt(property3), parseLong);
        } else {
            systemDefault = new ConnectionPool(5, parseLong);
        }
    }

    public ConnectionPool(int i, long j) {
        this.maxIdleConnections = i;
        this.keepAliveDurationNs = (j * 1000) * 1000;
    }

    public static ConnectionPool getDefault() {
        return systemDefault;
    }

    public synchronized int getConnectionCount() {
        return this.connections.size();
    }

    @Deprecated
    public synchronized int getSpdyConnectionCount() {
        return getMultiplexedConnectionCount();
    }

    public synchronized int getMultiplexedConnectionCount() {
        int i;
        i = 0;
        Iterator it = this.connections.iterator();
        while (it.hasNext()) {
            int i2;
            if (((Connection) it.next()).isSpdy()) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        return i;
    }

    public synchronized int getHttpConnectionCount() {
        return this.connections.size() - getMultiplexedConnectionCount();
    }

    public synchronized Connection get(Address address) {
        Connection connection;
        ListIterator listIterator = this.connections.listIterator(this.connections.size());
        while (listIterator.hasPrevious()) {
            connection = (Connection) listIterator.previous();
            if (connection.getRoute().getAddress().equals(address) && connection.isAlive() && System.nanoTime() - connection.getIdleStartTimeNs() < this.keepAliveDurationNs) {
                listIterator.remove();
                if (connection.isSpdy()) {
                    break;
                }
                try {
                    Platform.get().tagSocket(connection.getSocket());
                    break;
                } catch (SocketException e) {
                    Util.closeQuietly(connection.getSocket());
                    Platform.get().logW("Unable to tagSocket(): " + e);
                }
            }
        }
        connection = null;
        if (connection != null) {
            if (connection.isSpdy()) {
                this.connections.addFirst(connection);
            }
        }
        return connection;
    }

    void recycle(Connection connection) {
        if (connection.isSpdy() || !connection.clearOwner()) {
            return;
        }
        if (connection.isAlive()) {
            try {
                Platform.get().untagSocket(connection.getSocket());
                synchronized (this) {
                    addConnection(connection);
                    connection.incrementRecycleCount();
                    connection.resetIdleStartTime();
                }
                return;
            } catch (SocketException e) {
                Platform.get().logW("Unable to untagSocket(): " + e);
                Util.closeQuietly(connection.getSocket());
                return;
            }
        }
        Util.closeQuietly(connection.getSocket());
    }

    private void addConnection(Connection connection) {
        boolean isEmpty = this.connections.isEmpty();
        this.connections.addFirst(connection);
        if (isEmpty) {
            this.executor.execute(this.connectionsCleanupRunnable);
        } else {
            notifyAll();
        }
    }

    void share(Connection connection) {
        if (!connection.isSpdy()) {
            throw new IllegalArgumentException();
        } else if (connection.isAlive()) {
            synchronized (this) {
                addConnection(connection);
            }
        }
    }

    public void evictAll() {
        List arrayList;
        synchronized (this) {
            arrayList = new ArrayList(this.connections);
            this.connections.clear();
        }
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            Util.closeQuietly(((Connection) arrayList.get(i)).getSocket());
        }
    }

    private void runCleanupUntilPoolIsEmpty() {
        do {
        } while (performCleanup());
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    boolean performCleanup() {
        /*
        r18 = this;
        monitor-enter(r18);
        r0 = r18;
        r2 = r0.connections;	 Catch:{ all -> 0x00b9 }
        r2 = r2.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x000e;
    L_0x000b:
        r2 = 0;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
    L_0x000d:
        return r2;
    L_0x000e:
        r7 = new java.util.ArrayList;	 Catch:{ all -> 0x00b9 }
        r7.<init>();	 Catch:{ all -> 0x00b9 }
        r3 = 0;
        r8 = java.lang.System.nanoTime();	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r4 = r0.keepAliveDurationNs;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r2 = r0.connections;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r6 = r0.connections;	 Catch:{ all -> 0x00b9 }
        r6 = r6.size();	 Catch:{ all -> 0x00b9 }
        r10 = r2.listIterator(r6);	 Catch:{ all -> 0x00b9 }
    L_0x002c:
        r2 = r10.hasPrevious();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x006d;
    L_0x0032:
        r2 = r10.previous();	 Catch:{ all -> 0x00b9 }
        r2 = (com.squareup.okhttp.Connection) r2;	 Catch:{ all -> 0x00b9 }
        r12 = r2.getIdleStartTimeNs();	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r14 = r0.keepAliveDurationNs;	 Catch:{ all -> 0x00b9 }
        r12 = r12 + r14;
        r12 = r12 - r8;
        r14 = 0;
        r6 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1));
        if (r6 <= 0) goto L_0x004e;
    L_0x0048:
        r6 = r2.isAlive();	 Catch:{ all -> 0x00b9 }
        if (r6 != 0) goto L_0x005f;
    L_0x004e:
        r10.remove();	 Catch:{ all -> 0x00b9 }
        r7.add(r2);	 Catch:{ all -> 0x00b9 }
        r16 = r4;
        r4 = r3;
        r2 = r16;
    L_0x0059:
        r16 = r2;
        r3 = r4;
        r4 = r16;
        goto L_0x002c;
    L_0x005f:
        r2 = r2.isIdle();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x00dc;
    L_0x0065:
        r6 = r3 + 1;
        r2 = java.lang.Math.min(r4, r12);	 Catch:{ all -> 0x00b9 }
        r4 = r6;
        goto L_0x0059;
    L_0x006d:
        r0 = r18;
        r2 = r0.connections;	 Catch:{ all -> 0x00b9 }
        r0 = r18;
        r6 = r0.connections;	 Catch:{ all -> 0x00b9 }
        r6 = r6.size();	 Catch:{ all -> 0x00b9 }
        r6 = r2.listIterator(r6);	 Catch:{ all -> 0x00b9 }
    L_0x007d:
        r2 = r6.hasPrevious();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x009f;
    L_0x0083:
        r0 = r18;
        r2 = r0.maxIdleConnections;	 Catch:{ all -> 0x00b9 }
        if (r3 <= r2) goto L_0x009f;
    L_0x0089:
        r2 = r6.previous();	 Catch:{ all -> 0x00b9 }
        r2 = (com.squareup.okhttp.Connection) r2;	 Catch:{ all -> 0x00b9 }
        r8 = r2.isIdle();	 Catch:{ all -> 0x00b9 }
        if (r8 == 0) goto L_0x00da;
    L_0x0095:
        r7.add(r2);	 Catch:{ all -> 0x00b9 }
        r6.remove();	 Catch:{ all -> 0x00b9 }
        r2 = r3 + -1;
    L_0x009d:
        r3 = r2;
        goto L_0x007d;
    L_0x009f:
        r2 = r7.isEmpty();	 Catch:{ all -> 0x00b9 }
        if (r2 == 0) goto L_0x00bd;
    L_0x00a5:
        r2 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r2 = r4 / r2;
        r8 = 1000000; // 0xf4240 float:1.401298E-39 double:4.940656E-318;
        r8 = r8 * r2;
        r4 = r4 - r8;
        r4 = (int) r4;	 Catch:{ InterruptedException -> 0x00bc }
        r0 = r18;
        r0.wait(r2, r4);	 Catch:{ InterruptedException -> 0x00bc }
        r2 = 1;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        goto L_0x000d;
    L_0x00b9:
        r2 = move-exception;
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        throw r2;
    L_0x00bc:
        r2 = move-exception;
    L_0x00bd:
        monitor-exit(r18);	 Catch:{ all -> 0x00b9 }
        r2 = 0;
        r4 = r7.size();
        r3 = r2;
    L_0x00c4:
        if (r3 >= r4) goto L_0x00d7;
    L_0x00c6:
        r2 = r7.get(r3);
        r2 = (com.squareup.okhttp.Connection) r2;
        r2 = r2.getSocket();
        com.squareup.okhttp.internal.Util.closeQuietly(r2);
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x00c4;
    L_0x00d7:
        r2 = 1;
        goto L_0x000d;
    L_0x00da:
        r2 = r3;
        goto L_0x009d;
    L_0x00dc:
        r16 = r4;
        r4 = r3;
        r2 = r16;
        goto L_0x0059;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.ConnectionPool.performCleanup():boolean");
    }

    void replaceCleanupExecutorForTests(Executor executor) {
        this.executor = executor;
    }

    synchronized List<Connection> getConnections() {
        return new ArrayList(this.connections);
    }
}
