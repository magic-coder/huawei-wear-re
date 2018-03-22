package com.squareup.okhttp.internal.spdy;

import android.support.v4.internal.view.SupportMenu;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.spdy.FrameReader.Handler;
import java.io.Closeable;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class SpdyConnection implements Closeable {
    static final /* synthetic */ boolean $assertionsDisabled;
    private static final int OKHTTP_CLIENT_WINDOW_SIZE = 16777216;
    private static final ExecutorService executor = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp SpdyConnection", true));
    long bytesLeftInWriteWindow;
    final boolean client;
    private final Set<Integer> currentPushRequests;
    final FrameWriter frameWriter;
    private final IncomingStreamHandler handler;
    private final String hostName;
    private long idleStartTimeNs;
    private int lastGoodStreamId;
    private int nextPingId;
    private int nextStreamId;
    final Settings okHttpSettings;
    final Settings peerSettings;
    private Map<Integer, Ping> pings;
    final Protocol protocol;
    private final ExecutorService pushExecutor;
    private final PushObserver pushObserver;
    final Reader readerRunnable;
    private boolean receivedInitialPeerSettings;
    private boolean shutdown;
    final Socket socket;
    private final Map<Integer, SpdyStream> streams;
    long unacknowledgedBytesRead;
    final Variant variant;

    public class Builder {
        private boolean client;
        private IncomingStreamHandler handler;
        private String hostName;
        private Protocol protocol;
        private PushObserver pushObserver;
        private Socket socket;

        public Builder(boolean z, Socket socket) throws IOException {
            this(((InetSocketAddress) socket.getRemoteSocketAddress()).getHostName(), z, socket);
        }

        public Builder(String str, boolean z, Socket socket) throws IOException {
            this.handler = IncomingStreamHandler.REFUSE_INCOMING_STREAMS;
            this.protocol = Protocol.SPDY_3;
            this.pushObserver = PushObserver.CANCEL;
            this.hostName = str;
            this.client = z;
            this.socket = socket;
        }

        public Builder handler(IncomingStreamHandler incomingStreamHandler) {
            this.handler = incomingStreamHandler;
            return this;
        }

        public Builder protocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver) {
            this.pushObserver = pushObserver;
            return this;
        }

        public SpdyConnection build() throws IOException {
            return new SpdyConnection();
        }
    }

    class Reader extends NamedRunnable implements Handler {
        FrameReader frameReader;

        private Reader() {
            super("OkHttp %s", r5.hostName);
        }

        protected void execute() {
            ErrorCode errorCode;
            Throwable th;
            ErrorCode errorCode2 = ErrorCode.INTERNAL_ERROR;
            ErrorCode errorCode3 = ErrorCode.INTERNAL_ERROR;
            try {
                this.frameReader = SpdyConnection.this.variant.newReader(Okio.buffer(Okio.source(SpdyConnection.this.socket)), SpdyConnection.this.client);
                if (!SpdyConnection.this.client) {
                    this.frameReader.readConnectionPreface();
                }
                do {
                } while (this.frameReader.nextFrame(this));
                try {
                    SpdyConnection.this.close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
                } catch (IOException e) {
                }
                Util.closeQuietly(this.frameReader);
            } catch (IOException e2) {
                errorCode = ErrorCode.PROTOCOL_ERROR;
                try {
                    SpdyConnection.this.close(errorCode, ErrorCode.PROTOCOL_ERROR);
                } catch (IOException e3) {
                }
                Util.closeQuietly(this.frameReader);
            } catch (Throwable th2) {
                th = th2;
                SpdyConnection.this.close(errorCode, errorCode3);
                Util.closeQuietly(this.frameReader);
                throw th;
            }
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushDataLater(i, bufferedSource, i2, z);
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream == null) {
                SpdyConnection.this.writeSynResetLater(i, ErrorCode.INVALID_STREAM);
                bufferedSource.skip((long) i2);
                return;
            }
            stream.receiveData(bufferedSource, i2);
            if (z) {
                stream.receiveFin();
            }
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r9, boolean r10, int r11, int r12, java.util.List<com.squareup.okhttp.internal.spdy.Header> r13, com.squareup.okhttp.internal.spdy.HeadersMode r14) {
            /*
            r8 = this;
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;
            r0 = r0.pushedStream(r11);
            if (r0 == 0) goto L_0x000e;
        L_0x0008:
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;
            r0.pushHeadersLater(r11, r13, r10);
        L_0x000d:
            return;
        L_0x000e:
            r6 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;
            monitor-enter(r6);
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r0 = r0.shutdown;	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x001e;
        L_0x0019:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x001b:
            r0 = move-exception;
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            throw r0;
        L_0x001e:
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r0 = r0.getStream(r11);	 Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x008d;
        L_0x0026:
            r0 = r14.failIfStreamAbsent();	 Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0035;
        L_0x002c:
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r1 = com.squareup.okhttp.internal.spdy.ErrorCode.INVALID_STREAM;	 Catch:{ all -> 0x001b }
            r0.writeSynResetLater(r11, r1);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x0035:
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r0 = r0.lastGoodStreamId;	 Catch:{ all -> 0x001b }
            if (r11 > r0) goto L_0x003f;
        L_0x003d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x003f:
            r0 = r11 % 2;
            r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r1 = r1.nextStreamId;	 Catch:{ all -> 0x001b }
            r1 = r1 % 2;
            if (r0 != r1) goto L_0x004d;
        L_0x004b:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x004d:
            r0 = new com.squareup.okhttp.internal.spdy.SpdyStream;	 Catch:{ all -> 0x001b }
            r2 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r1 = r11;
            r3 = r9;
            r4 = r10;
            r5 = r13;
            r0.<init>(r1, r2, r3, r4, r5);	 Catch:{ all -> 0x001b }
            r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r1.lastGoodStreamId = r11;	 Catch:{ all -> 0x001b }
            r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r1 = r1.streams;	 Catch:{ all -> 0x001b }
            r2 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r1.put(r2, r0);	 Catch:{ all -> 0x001b }
            r1 = com.squareup.okhttp.internal.spdy.SpdyConnection.executor;	 Catch:{ all -> 0x001b }
            r2 = new com.squareup.okhttp.internal.spdy.SpdyConnection$Reader$1;	 Catch:{ all -> 0x001b }
            r3 = "OkHttp %s stream %d";
            r4 = 2;
            r4 = new java.lang.Object[r4];	 Catch:{ all -> 0x001b }
            r5 = 0;
            r7 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;	 Catch:{ all -> 0x001b }
            r7 = r7.hostName;	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r5 = 1;
            r7 = java.lang.Integer.valueOf(r11);	 Catch:{ all -> 0x001b }
            r4[r5] = r7;	 Catch:{ all -> 0x001b }
            r2.<init>(r3, r4, r0);	 Catch:{ all -> 0x001b }
            r1.submit(r2);	 Catch:{ all -> 0x001b }
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            goto L_0x000d;
        L_0x008d:
            monitor-exit(r6);	 Catch:{ all -> 0x001b }
            r1 = r14.failIfStreamPresent();
            if (r1 == 0) goto L_0x00a0;
        L_0x0094:
            r1 = com.squareup.okhttp.internal.spdy.ErrorCode.PROTOCOL_ERROR;
            r0.closeLater(r1);
            r0 = com.squareup.okhttp.internal.spdy.SpdyConnection.this;
            r0.removeStream(r11);
            goto L_0x000d;
        L_0x00a0:
            r0.receiveHeaders(r13, r14);
            if (r10 == 0) goto L_0x000d;
        L_0x00a5:
            r0.receiveFin();
            goto L_0x000d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.spdy.SpdyConnection.Reader.headers(boolean, boolean, int, int, java.util.List, com.squareup.okhttp.internal.spdy.HeadersMode):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (SpdyConnection.this.pushedStream(i)) {
                SpdyConnection.this.pushResetLater(i, errorCode);
                return;
            }
            SpdyStream removeStream = SpdyConnection.this.removeStream(i);
            if (removeStream != null) {
                removeStream.receiveRstStream(errorCode);
            }
        }

        public void settings(boolean z, Settings settings) {
            SpdyStream[] spdyStreamArr;
            synchronized (SpdyConnection.this) {
                long j;
                int initialWindowSize = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                if (z) {
                    SpdyConnection.this.peerSettings.clear();
                }
                SpdyConnection.this.peerSettings.merge(settings);
                if (SpdyConnection.this.getProtocol() == Protocol.HTTP_2) {
                    ackSettingsLater(settings);
                }
                int initialWindowSize2 = SpdyConnection.this.peerSettings.getInitialWindowSize(65536);
                if (initialWindowSize2 == -1 || initialWindowSize2 == initialWindowSize) {
                    spdyStreamArr = null;
                    j = 0;
                } else {
                    j = (long) (initialWindowSize2 - initialWindowSize);
                    if (!SpdyConnection.this.receivedInitialPeerSettings) {
                        SpdyConnection.this.addBytesToWriteWindow(j);
                        SpdyConnection.this.receivedInitialPeerSettings = true;
                    }
                    spdyStreamArr = !SpdyConnection.this.streams.isEmpty() ? (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]) : null;
                }
            }
            if (spdyStreamArr != null && j != 0) {
                for (SpdyStream spdyStream : spdyStreamArr) {
                    synchronized (spdyStream) {
                        spdyStream.addBytesToWriteWindow(j);
                    }
                }
            }
        }

        private void ackSettingsLater(final Settings settings) {
            SpdyConnection.executor.submit(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{SpdyConnection.this.hostName}) {
                public void execute() {
                    try {
                        SpdyConnection.this.frameWriter.ackSettings(settings);
                    } catch (IOException e) {
                    }
                }
            });
        }

        public void ackSettings() {
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                Ping access$2200 = SpdyConnection.this.removePing(i);
                if (access$2200 != null) {
                    access$2200.receive();
                    return;
                }
                return;
            }
            SpdyConnection.this.writePingLater(true, i, i2, null);
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            if (byteString.size() > 0) {
            }
            synchronized (SpdyConnection.this) {
                SpdyStream[] spdyStreamArr = (SpdyStream[]) SpdyConnection.this.streams.values().toArray(new SpdyStream[SpdyConnection.this.streams.size()]);
                SpdyConnection.this.shutdown = true;
            }
            for (SpdyStream spdyStream : spdyStreamArr) {
                if (spdyStream.getId() > i && spdyStream.isLocallyInitiated()) {
                    spdyStream.receiveRstStream(ErrorCode.REFUSED_STREAM);
                    SpdyConnection.this.removeStream(spdyStream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (SpdyConnection.this) {
                    SpdyConnection spdyConnection = SpdyConnection.this;
                    spdyConnection.bytesLeftInWriteWindow += j;
                    SpdyConnection.this.notifyAll();
                }
                return;
            }
            SpdyStream stream = SpdyConnection.this.getStream(i);
            if (stream != null) {
                synchronized (stream) {
                    stream.addBytesToWriteWindow(j);
                }
            }
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            SpdyConnection.this.pushRequestLater(i2, list);
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }
    }

    static {
        boolean z;
        if (SpdyConnection.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        $assertionsDisabled = z;
    }

    private SpdyConnection(Builder builder) throws IOException {
        int i = 2;
        this.streams = new HashMap();
        this.idleStartTimeNs = System.nanoTime();
        this.unacknowledgedBytesRead = 0;
        this.okHttpSettings = new Settings();
        this.peerSettings = new Settings();
        this.receivedInitialPeerSettings = false;
        this.currentPushRequests = new LinkedHashSet();
        this.protocol = builder.protocol;
        this.pushObserver = builder.pushObserver;
        this.client = builder.client;
        this.handler = builder.handler;
        this.nextStreamId = builder.client ? 1 : 2;
        if (builder.client && this.protocol == Protocol.HTTP_2) {
            this.nextStreamId += 2;
        }
        if (builder.client) {
            i = 1;
        }
        this.nextPingId = i;
        if (builder.client) {
            this.okHttpSettings.set(7, 0, 16777216);
        }
        this.hostName = builder.hostName;
        if (this.protocol == Protocol.HTTP_2) {
            this.variant = new Http20Draft16();
            this.pushExecutor = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), Util.threadFactory(String.format("OkHttp %s Push Observer", new Object[]{this.hostName}), true));
            this.peerSettings.set(7, 0, SupportMenu.USER_MASK);
            this.peerSettings.set(5, 0, 16384);
        } else if (this.protocol == Protocol.SPDY_3) {
            this.variant = new Spdy3();
            this.pushExecutor = null;
        } else {
            throw new AssertionError(this.protocol);
        }
        this.bytesLeftInWriteWindow = (long) this.peerSettings.getInitialWindowSize(65536);
        this.socket = builder.socket;
        this.frameWriter = this.variant.newWriter(Okio.buffer(Okio.sink(builder.socket)), this.client);
        this.readerRunnable = new Reader();
        new Thread(this.readerRunnable).start();
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public synchronized int openStreamCount() {
        return this.streams.size();
    }

    synchronized SpdyStream getStream(int i) {
        return (SpdyStream) this.streams.get(Integer.valueOf(i));
    }

    synchronized SpdyStream removeStream(int i) {
        SpdyStream spdyStream;
        spdyStream = (SpdyStream) this.streams.remove(Integer.valueOf(i));
        if (spdyStream != null && this.streams.isEmpty()) {
            setIdle(true);
        }
        return spdyStream;
    }

    private synchronized void setIdle(boolean z) {
        this.idleStartTimeNs = z ? System.nanoTime() : Long.MAX_VALUE;
    }

    public synchronized boolean isIdle() {
        return this.idleStartTimeNs != Long.MAX_VALUE;
    }

    public synchronized long getIdleStartTimeNs() {
        return this.idleStartTimeNs;
    }

    public SpdyStream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (this.client) {
            throw new IllegalStateException("Client cannot push requests.");
        } else if (this.protocol == Protocol.HTTP_2) {
            return newStream(i, list, z, false);
        } else {
            throw new IllegalStateException("protocol != HTTP_2");
        }
    }

    public SpdyStream newStream(List<Header> list, boolean z, boolean z2) throws IOException {
        return newStream(0, list, z, z2);
    }

    private SpdyStream newStream(int i, List<Header> list, boolean z, boolean z2) throws IOException {
        SpdyStream spdyStream;
        boolean z3 = true;
        boolean z4 = !z;
        if (z2) {
            z3 = false;
        }
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    throw new IOException("shutdown");
                }
                int i2 = this.nextStreamId;
                this.nextStreamId += 2;
                spdyStream = new SpdyStream(i2, this, z4, z3, list);
                if (spdyStream.isOpen()) {
                    this.streams.put(Integer.valueOf(i2), spdyStream);
                    setIdle(false);
                }
            }
            if (i == 0) {
                this.frameWriter.synStream(z4, z3, i2, i, list);
            } else if (this.client) {
                throw new IllegalArgumentException("client streams shouldn't have associated stream IDs");
            } else {
                this.frameWriter.pushPromise(i, i2, list);
            }
        }
        if (!z) {
            this.frameWriter.flush();
        }
        return spdyStream;
    }

    void writeSynReply(int i, boolean z, List<Header> list) throws IOException {
        this.frameWriter.synReply(z, i, list);
    }

    public void writeData(int i, boolean z, Buffer buffer, long j) throws IOException {
        if (j == 0) {
            this.frameWriter.data(z, i, buffer, 0);
            return;
        }
        while (j > 0) {
            int min;
            boolean z2;
            synchronized (this) {
                while (this.bytesLeftInWriteWindow <= 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new InterruptedIOException();
                    }
                }
                min = Math.min((int) Math.min(j, this.bytesLeftInWriteWindow), this.frameWriter.maxDataLength());
                this.bytesLeftInWriteWindow -= (long) min;
            }
            j -= (long) min;
            FrameWriter frameWriter = this.frameWriter;
            if (z && j == 0) {
                z2 = true;
            } else {
                z2 = false;
            }
            frameWriter.data(z2, i, buffer, min);
        }
    }

    void addBytesToWriteWindow(long j) {
        this.bytesLeftInWriteWindow += j;
        if (j > 0) {
            notifyAll();
        }
    }

    void writeSynResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        executor.submit(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    SpdyConnection.this.writeSynReset(i2, errorCode2);
                } catch (IOException e) {
                }
            }
        });
    }

    void writeSynReset(int i, ErrorCode errorCode) throws IOException {
        this.frameWriter.rstStream(i, errorCode);
    }

    void writeWindowUpdateLater(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        executor.submit(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.hostName, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    SpdyConnection.this.frameWriter.windowUpdate(i2, j2);
                } catch (IOException e) {
                }
            }
        });
    }

    public Ping ping() throws IOException {
        int i;
        Ping ping = new Ping();
        synchronized (this) {
            if (this.shutdown) {
                throw new IOException("shutdown");
            }
            i = this.nextPingId;
            this.nextPingId += 2;
            if (this.pings == null) {
                this.pings = new HashMap();
            }
            this.pings.put(Integer.valueOf(i), ping);
        }
        writePing(false, i, 1330343787, ping);
        return ping;
    }

    private void writePingLater(boolean z, int i, int i2, Ping ping) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final Ping ping2 = ping;
        executor.submit(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.hostName, Integer.valueOf(i), Integer.valueOf(i2)}) {
            public void execute() {
                try {
                    SpdyConnection.this.writePing(z2, i3, i4, ping2);
                } catch (IOException e) {
                }
            }
        });
    }

    private void writePing(boolean z, int i, int i2, Ping ping) throws IOException {
        synchronized (this.frameWriter) {
            if (ping != null) {
                ping.send();
            }
            this.frameWriter.ping(z, i, i2);
        }
    }

    private synchronized Ping removePing(int i) {
        return this.pings != null ? (Ping) this.pings.remove(Integer.valueOf(i)) : null;
    }

    public void flush() throws IOException {
        this.frameWriter.flush();
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.frameWriter) {
            synchronized (this) {
                if (this.shutdown) {
                    return;
                }
                this.shutdown = true;
                int i = this.lastGoodStreamId;
                this.frameWriter.goAway(i, errorCode, Util.EMPTY_BYTE_ARRAY);
            }
        }
    }

    public void close() throws IOException {
        close(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    private void close(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        IOException iOException;
        IOException e;
        if ($assertionsDisabled || !Thread.holdsLock(this)) {
            SpdyStream[] spdyStreamArr;
            Ping[] pingArr;
            try {
                shutdown(errorCode);
                iOException = null;
            } catch (IOException e2) {
                iOException = e2;
            }
            synchronized (this) {
                if (this.streams.isEmpty()) {
                    spdyStreamArr = null;
                } else {
                    SpdyStream[] spdyStreamArr2 = (SpdyStream[]) this.streams.values().toArray(new SpdyStream[this.streams.size()]);
                    this.streams.clear();
                    setIdle(false);
                    spdyStreamArr = spdyStreamArr2;
                }
                if (this.pings != null) {
                    Ping[] pingArr2 = (Ping[]) this.pings.values().toArray(new Ping[this.pings.size()]);
                    this.pings = null;
                    pingArr = pingArr2;
                } else {
                    pingArr = null;
                }
            }
            if (spdyStreamArr != null) {
                e2 = iOException;
                for (SpdyStream close : spdyStreamArr) {
                    try {
                        close.close(errorCode2);
                    } catch (IOException iOException2) {
                        if (e2 != null) {
                            e2 = iOException2;
                        }
                    }
                }
                iOException2 = e2;
            }
            if (pingArr != null) {
                for (Ping cancel : pingArr) {
                    cancel.cancel();
                }
            }
            try {
                this.frameWriter.close();
                e2 = iOException2;
            } catch (IOException e3) {
                e2 = e3;
                if (iOException2 != null) {
                    e2 = iOException2;
                }
            }
            try {
                this.socket.close();
            } catch (IOException e4) {
                e2 = e4;
            }
            if (e2 != null) {
                throw e2;
            }
            return;
        }
        throw new AssertionError();
    }

    public void sendConnectionPreface() throws IOException {
        this.frameWriter.connectionPreface();
        this.frameWriter.settings(this.okHttpSettings);
        int initialWindowSize = this.okHttpSettings.getInitialWindowSize(65536);
        if (initialWindowSize != 65536) {
            this.frameWriter.windowUpdate(0, (long) (initialWindowSize - 65536));
        }
    }

    private boolean pushedStream(int i) {
        return this.protocol == Protocol.HTTP_2 && i != 0 && (i & 1) == 0;
    }

    private void pushRequestLater(int i, List<Header> list) {
        synchronized (this) {
            if (this.currentPushRequests.contains(Integer.valueOf(i))) {
                writeSynResetLater(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.currentPushRequests.add(Integer.valueOf(i));
            final int i2 = i;
            final List<Header> list2 = list;
            this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
                public void execute() {
                    if (SpdyConnection.this.pushObserver.onRequest(i2, list2)) {
                        try {
                            SpdyConnection.this.frameWriter.rstStream(i2, ErrorCode.CANCEL);
                            synchronized (SpdyConnection.this) {
                                SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException e) {
                        }
                    }
                }
            });
        }
    }

    private void pushHeadersLater(int i, List<Header> list, boolean z) {
        final int i2 = i;
        final List<Header> list2 = list;
        final boolean z2 = z;
        this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            public void execute() {
                boolean onHeaders = SpdyConnection.this.pushObserver.onHeaders(i2, list2, z2);
                if (onHeaders) {
                    try {
                        SpdyConnection.this.frameWriter.rstStream(i2, ErrorCode.CANCEL);
                    } catch (IOException e) {
                        return;
                    }
                }
                if (onHeaders || z2) {
                    synchronized (SpdyConnection.this) {
                        SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    private void pushDataLater(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        bufferedSource.require((long) i2);
        bufferedSource.read(buffer, (long) i2);
        if (buffer.size() != ((long) i2)) {
            throw new IOException(buffer.size() + " != " + i2);
        }
        final int i3 = i;
        final int i4 = i2;
        final boolean z2 = z;
        this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    boolean onData = SpdyConnection.this.pushObserver.onData(i3, buffer, i4, z2);
                    if (onData) {
                        SpdyConnection.this.frameWriter.rstStream(i3, ErrorCode.CANCEL);
                    }
                    if (onData || z2) {
                        synchronized (SpdyConnection.this) {
                            SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i3));
                        }
                    }
                } catch (IOException e) {
                }
            }
        });
    }

    private void pushResetLater(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.pushExecutor.submit(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.hostName, Integer.valueOf(i)}) {
            public void execute() {
                SpdyConnection.this.pushObserver.onReset(i2, errorCode2);
                synchronized (SpdyConnection.this) {
                    SpdyConnection.this.currentPushRequests.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
