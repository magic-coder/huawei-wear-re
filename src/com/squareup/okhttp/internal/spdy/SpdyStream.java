package com.squareup.okhttp.internal.spdy;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

public final class SpdyStream {
    static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
    long bytesLeftInWriteWindow;
    private final SpdyConnection connection;
    private ErrorCode errorCode = null;
    private final int id;
    private final SpdyTimeout readTimeout = new SpdyTimeout();
    private long readTimeoutMillis = 0;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final SpdyDataSink sink;
    private final SpdyDataSource source;
    long unacknowledgedBytesRead = 0;
    private final SpdyTimeout writeTimeout = new SpdyTimeout();

    final class SpdyDataSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
        private boolean closed;
        private boolean finished;

        SpdyDataSink() {
        }

        public void write(Buffer buffer, long j) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                while (j > 0) {
                    long min;
                    synchronized (SpdyStream.this) {
                        SpdyStream.this.writeTimeout.enter();
                        while (SpdyStream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                            try {
                                SpdyStream.this.waitForIo();
                            } catch (Throwable th) {
                                SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                            }
                        }
                        SpdyStream.this.writeTimeout.exitAndThrowIfTimedOut();
                        SpdyStream.this.checkOutNotClosed();
                        min = Math.min(SpdyStream.this.bytesLeftInWriteWindow, j);
                        SpdyStream spdyStream = SpdyStream.this;
                        spdyStream.bytesLeftInWriteWindow -= min;
                    }
                    j -= min;
                    SpdyStream.this.connection.writeData(SpdyStream.this.id, false, buffer, min);
                }
                return;
            }
            throw new AssertionError();
        }

        public void flush() throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                synchronized (SpdyStream.this) {
                    SpdyStream.this.checkOutNotClosed();
                }
                SpdyStream.this.connection.flush();
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return SpdyStream.this.writeTimeout;
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void close() throws java.io.IOException {
            /*
            r6 = this;
            r2 = 1;
            r0 = $assertionsDisabled;
            if (r0 != 0) goto L_0x0013;
        L_0x0005:
            r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r0 = java.lang.Thread.holdsLock(r0);
            if (r0 == 0) goto L_0x0013;
        L_0x000d:
            r0 = new java.lang.AssertionError;
            r0.<init>();
            throw r0;
        L_0x0013:
            r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            monitor-enter(r1);
            r0 = r6.closed;	 Catch:{ all -> 0x004d }
            if (r0 == 0) goto L_0x001c;
        L_0x001a:
            monitor-exit(r1);	 Catch:{ all -> 0x004d }
        L_0x001b:
            return;
        L_0x001c:
            monitor-exit(r1);	 Catch:{ all -> 0x004d }
            r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r0 = r0.sink;
            r0 = r0.finished;
            if (r0 != 0) goto L_0x0037;
        L_0x0025:
            r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r0 = r0.connection;
            r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r1 = r1.id;
            r3 = 0;
            r4 = 0;
            r0.writeData(r1, r2, r3, r4);
        L_0x0037:
            r1 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            monitor-enter(r1);
            r0 = 1;
            r6.closed = r0;	 Catch:{ all -> 0x0050 }
            monitor-exit(r1);	 Catch:{ all -> 0x0050 }
            r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r0 = r0.connection;
            r0.flush();
            r0 = com.squareup.okhttp.internal.spdy.SpdyStream.this;
            r0.cancelStreamIfNecessary();
            goto L_0x001b;
        L_0x004d:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x004d }
            throw r0;
        L_0x0050:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0050 }
            throw r0;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyStream.SpdyDataSink.close():void");
        }
    }

    final class SpdyDataSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = (!SpdyStream.class.desiredAssertionStatus());
        private boolean closed;
        private boolean finished;
        private final long maxByteCount;
        private final Buffer readBuffer;
        private final Buffer receiveBuffer;

        private SpdyDataSource(long j) {
            this.receiveBuffer = new Buffer();
            this.readBuffer = new Buffer();
            this.maxByteCount = j;
        }

        public long read(Buffer buffer, long j) throws IOException {
            if (j < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j);
            }
            long j2;
            synchronized (SpdyStream.this) {
                waitUntilReadable();
                checkNotClosed();
                if (this.readBuffer.size() == 0) {
                    j2 = -1;
                } else {
                    j2 = this.readBuffer.read(buffer, Math.min(j, this.readBuffer.size()));
                    SpdyStream spdyStream = SpdyStream.this;
                    spdyStream.unacknowledgedBytesRead += j2;
                    if (SpdyStream.this.unacknowledgedBytesRead >= ((long) (SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                        SpdyStream.this.connection.writeWindowUpdateLater(SpdyStream.this.id, SpdyStream.this.unacknowledgedBytesRead);
                        SpdyStream.this.unacknowledgedBytesRead = 0;
                    }
                    synchronized (SpdyStream.this.connection) {
                        SpdyConnection access$500 = SpdyStream.this.connection;
                        access$500.unacknowledgedBytesRead += j2;
                        if (SpdyStream.this.connection.unacknowledgedBytesRead >= ((long) (SpdyStream.this.connection.okHttpSettings.getInitialWindowSize(65536) / 2))) {
                            SpdyStream.this.connection.writeWindowUpdateLater(0, SpdyStream.this.connection.unacknowledgedBytesRead);
                            SpdyStream.this.connection.unacknowledgedBytesRead = 0;
                        }
                    }
                }
            }
            return j2;
        }

        private void waitUntilReadable() throws IOException {
            SpdyStream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && SpdyStream.this.errorCode == null) {
                try {
                    SpdyStream.this.waitForIo();
                } catch (Throwable th) {
                    SpdyStream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
            SpdyStream.this.readTimeout.exitAndThrowIfTimedOut();
        }

        void receive(BufferedSource bufferedSource, long j) throws IOException {
            if ($assertionsDisabled || !Thread.holdsLock(SpdyStream.this)) {
                while (j > 0) {
                    boolean z;
                    Object obj;
                    synchronized (SpdyStream.this) {
                        z = this.finished;
                        obj = this.readBuffer.size() + j > this.maxByteCount ? 1 : null;
                    }
                    if (obj != null) {
                        bufferedSource.skip(j);
                        SpdyStream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                        return;
                    } else if (z) {
                        bufferedSource.skip(j);
                        return;
                    } else {
                        long read = bufferedSource.read(this.receiveBuffer, j);
                        if (read == -1) {
                            throw new EOFException();
                        }
                        j -= read;
                        synchronized (SpdyStream.this) {
                            if (this.readBuffer.size() == 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            this.readBuffer.writeAll(this.receiveBuffer);
                            if (obj != null) {
                                SpdyStream.this.notifyAll();
                            }
                        }
                    }
                }
                return;
            }
            throw new AssertionError();
        }

        public Timeout timeout() {
            return SpdyStream.this.readTimeout;
        }

        public void close() throws IOException {
            synchronized (SpdyStream.this) {
                this.closed = true;
                this.readBuffer.clear();
                SpdyStream.this.notifyAll();
            }
            SpdyStream.this.cancelStreamIfNecessary();
        }

        private void checkNotClosed() throws IOException {
            if (this.closed) {
                throw new IOException("stream closed");
            } else if (SpdyStream.this.errorCode != null) {
                throw new IOException("stream was reset: " + SpdyStream.this.errorCode);
            }
        }
    }

    class SpdyTimeout extends AsyncTimeout {
        SpdyTimeout() {
        }

        protected void timedOut() {
            SpdyStream.this.closeLater(ErrorCode.CANCEL);
        }

        public void exitAndThrowIfTimedOut() throws InterruptedIOException {
            if (exit()) {
                throw new InterruptedIOException("timeout");
            }
        }
    }

    SpdyStream(int i, SpdyConnection spdyConnection, boolean z, boolean z2, List<Header> list) {
        if (spdyConnection == null) {
            throw new NullPointerException("connection == null");
        } else if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        } else {
            this.id = i;
            this.connection = spdyConnection;
            this.bytesLeftInWriteWindow = (long) spdyConnection.peerSettings.getInitialWindowSize(65536);
            this.source = new SpdyDataSource((long) spdyConnection.okHttpSettings.getInitialWindowSize(65536));
            this.sink = new SpdyDataSink();
            this.source.finished = z2;
            this.sink.finished = z;
            this.requestHeaders = list;
        }
    }

    public int getId() {
        return this.id;
    }

    public synchronized boolean isOpen() {
        boolean z = false;
        synchronized (this) {
            if (this.errorCode == null) {
                if (!(this.source.finished || this.source.closed) || (!(this.sink.finished || this.sink.closed) || this.responseHeaders == null)) {
                    z = true;
                }
            }
        }
        return z;
    }

    public boolean isLocallyInitiated() {
        boolean z;
        if ((this.id & 1) == 1) {
            z = true;
        } else {
            z = false;
        }
        return this.connection.client == z;
    }

    public SpdyConnection getConnection() {
        return this.connection;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public synchronized List<Header> getResponseHeaders() throws IOException {
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        if (this.responseHeaders != null) {
        } else {
            throw new IOException("stream was reset: " + this.errorCode);
        }
        return this.responseHeaders;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public void reply(List<Header> list, boolean z) throws IOException {
        boolean z2 = true;
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (list == null) {
                    throw new NullPointerException("responseHeaders == null");
                } else if (this.responseHeaders != null) {
                    throw new IllegalStateException("reply already sent");
                } else {
                    this.responseHeaders = list;
                    if (z) {
                        z2 = false;
                    } else {
                        this.sink.finished = true;
                    }
                }
            }
            this.connection.writeSynReply(this.id, z2, list);
            if (z2) {
                this.connection.flush();
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }

    public Source getSource() {
        return this.source;
    }

    public Sink getSink() {
        synchronized (this) {
            if (this.responseHeaders != null || isLocallyInitiated()) {
            } else {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.id, errorCode);
        }
    }

    private boolean closeInternal(ErrorCode errorCode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            synchronized (this) {
                if (this.errorCode != null) {
                    return false;
                } else if (this.source.finished && this.sink.finished) {
                    return false;
                } else {
                    this.errorCode = errorCode;
                    notifyAll();
                    this.connection.removeStream(this.id);
                    return true;
                }
            }
        }
        throw new AssertionError();
    }

    void receiveHeaders(List<Header> list, HeadersMode headersMode) {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            ErrorCode errorCode = null;
            boolean z = true;
            synchronized (this) {
                if (this.responseHeaders == null) {
                    if (headersMode.failIfHeadersAbsent()) {
                        errorCode = ErrorCode.PROTOCOL_ERROR;
                    } else {
                        this.responseHeaders = list;
                        z = isOpen();
                        notifyAll();
                    }
                } else if (headersMode.failIfHeadersPresent()) {
                    errorCode = ErrorCode.STREAM_IN_USE;
                } else {
                    List arrayList = new ArrayList();
                    arrayList.addAll(this.responseHeaders);
                    arrayList.addAll(list);
                    this.responseHeaders = arrayList;
                }
            }
            if (errorCode != null) {
                closeLater(errorCode);
                return;
            } else if (!z) {
                this.connection.removeStream(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void receiveData(BufferedSource bufferedSource, int i) throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            this.source.receive(bufferedSource, (long) i);
            return;
        }
        throw new AssertionError();
    }

    void receiveFin() {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            boolean isOpen;
            synchronized (this) {
                this.source.finished = true;
                isOpen = isOpen();
                notifyAll();
            }
            if (!isOpen) {
                this.connection.removeStream(this.id);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    private void cancelStreamIfNecessary() throws IOException {
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            Object obj;
            boolean isOpen;
            synchronized (this) {
                obj = (!this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed)) ? 1 : null;
                isOpen = isOpen();
            }
            if (obj != null) {
                close(ErrorCode.CANCEL);
                return;
            } else if (!isOpen) {
                this.connection.removeStream(this.id);
                return;
            } else {
                return;
            }
        }
        throw new AssertionError();
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    private void checkOutNotClosed() throws IOException {
        if (this.sink.closed) {
            throw new IOException("stream closed");
        } else if (this.sink.finished) {
            throw new IOException("stream finished");
        } else if (this.errorCode != null) {
            throw new IOException("stream was reset: " + this.errorCode);
        }
    }

    private void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException e) {
            throw new InterruptedIOException();
        }
    }
}
