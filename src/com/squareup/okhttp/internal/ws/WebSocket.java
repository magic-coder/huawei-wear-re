package com.squareup.okhttp.internal.ws;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.NamedRunnable;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.ws.WebSocketReader.FrameCallback;
import java.io.IOException;
import java.net.ProtocolException;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.Collections;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.Okio;
import org.apache.http.client.methods.HttpGet;

public final class WebSocket {
    private static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    private static final int CLOSE_PROTOCOL_EXCEPTION = 1002;
    private final OkHttpClient client;
    private final Object closeLock = new Object();
    private boolean connected;
    private Connection connection;
    private final String key;
    private final Executor pongExecutor;
    private final Random random;
    private volatile boolean readerClosed;
    private final Request request;
    private WebSocketWriter writer;
    private volatile boolean writerClosed;

    class C26531 implements FrameCallback {
        C26531() {
        }

        public void onPing(final Buffer buffer) {
            WebSocket.this.pongExecutor.execute(new NamedRunnable("WebSocket PongWriter", new Object[0]) {
                protected void execute() {
                    try {
                        WebSocket.this.writer.writePong(buffer);
                    } catch (IOException e) {
                    }
                }
            });
        }

        public void onClose(Buffer buffer) throws IOException {
            WebSocket.this.peerClose(buffer);
        }
    }

    public enum PayloadType {
        TEXT,
        BINARY
    }

    class ReaderRunnable extends NamedRunnable {
        private final WebSocketListener listener;
        private final WebSocketReader reader;

        public ReaderRunnable(String str, WebSocketReader webSocketReader, WebSocketListener webSocketListener) {
            super("WebSocketReader " + str, new Object[0]);
            this.reader = webSocketReader;
            this.listener = webSocketListener;
        }

        protected void execute() {
            while (!WebSocket.this.readerClosed) {
                try {
                    this.reader.readMessage();
                } catch (IOException e) {
                    WebSocket.this.readerErrorClose(e, this.listener);
                    return;
                }
            }
        }
    }

    public static WebSocket newWebSocket(OkHttpClient okHttpClient, Request request) {
        OkHttpClient clone = okHttpClient.clone();
        clone.setProtocols(Collections.singletonList(Protocol.HTTP_1_1));
        return new WebSocket(clone, request, new SecureRandom());
    }

    WebSocket(OkHttpClient okHttpClient, Request request, Random random) {
        this.client = okHttpClient;
        this.random = random;
        Executor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new LinkedBlockingDeque());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.pongExecutor = threadPoolExecutor;
        if (HttpGet.METHOD_NAME.equals(request.method())) {
            String urlString = request.urlString();
            if (urlString.startsWith("ws://")) {
                urlString = "http://" + urlString.substring(5);
            } else if (urlString.startsWith("wss://")) {
                urlString = "https://" + urlString.substring(6);
            } else if (!(urlString.startsWith("http://") || urlString.startsWith("https://"))) {
                throw new IllegalArgumentException("Request url must use 'ws', 'wss', 'http', or 'https' scheme: " + urlString);
            }
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.key = ByteString.of(bArr).base64();
            this.request = request.newBuilder().url(urlString).header("Upgrade", "websocket").header("Connection", "Upgrade").header("Sec-WebSocket-Key", this.key).header("Sec-WebSocket-Version", "13").build();
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public Request request() {
        return this.request;
    }

    public Response connect(WebSocketListener webSocketListener) throws IOException {
        if (this.connected) {
            throw new IllegalStateException("Already connected");
        } else if (this.writerClosed) {
            throw new IllegalStateException("Closed");
        } else {
            Call newCall = Internal.instance.newCall(this.client, this.request);
            Response callGetResponse = Internal.instance.callGetResponse(newCall, true);
            if (callGetResponse.code() != 101) {
                Internal.instance.callEngineReleaseConnection(newCall);
            } else {
                String header = callGetResponse.header("Connection");
                if ("Upgrade".equalsIgnoreCase(header)) {
                    header = callGetResponse.header("Upgrade");
                    if ("websocket".equalsIgnoreCase(header)) {
                        header = callGetResponse.header("Sec-WebSocket-Accept");
                        String shaBase64 = Util.shaBase64(this.key + ACCEPT_MAGIC);
                        if (shaBase64.equals(header)) {
                            this.connection = Internal.instance.callEngineGetConnection(newCall);
                            if (Internal.instance.connectionClearOwner(this.connection)) {
                                Internal.instance.connectionSetOwner(this.connection, this);
                                this.connected = true;
                                Socket socket = this.connection.getSocket();
                                this.writer = new WebSocketWriter(true, Okio.buffer(Okio.sink(socket)), this.random);
                                new Thread(new ReaderRunnable(this.request.urlString(), new WebSocketReader(true, Okio.buffer(Okio.source(socket)), webSocketListener, new C26531()), webSocketListener)).start();
                            } else {
                                throw new IllegalStateException("Unable to take ownership of connection.");
                            }
                        }
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + shaBase64 + "' but was: " + header);
                    }
                    throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was: " + header);
                }
                throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was: " + header);
            }
            return callGetResponse;
        }
    }

    public BufferedSink newMessageSink(PayloadType payloadType) {
        if (this.writerClosed) {
            throw new IllegalStateException("Closed");
        } else if (this.connected) {
            return this.writer.newMessageSink(payloadType);
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    public void sendMessage(PayloadType payloadType, Buffer buffer) throws IOException {
        if (this.writerClosed) {
            throw new IllegalStateException("Closed");
        } else if (this.connected) {
            this.writer.sendMessage(payloadType, buffer);
        } else {
            throw new IllegalStateException("Not connected");
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close(int r3, java.lang.String r4) throws java.io.IOException {
        /*
        r2 = this;
        r1 = r2.closeLock;
        monitor-enter(r1);
        r0 = r2.writerClosed;	 Catch:{ all -> 0x001d }
        if (r0 == 0) goto L_0x0009;
    L_0x0007:
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
    L_0x0008:
        return;
    L_0x0009:
        r0 = 1;
        r2.writerClosed = r0;	 Catch:{ all -> 0x001d }
        r0 = r2.readerClosed;	 Catch:{ all -> 0x001d }
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        r1 = r2.writer;
        r1.writeClose(r3, r4);
        r1 = 0;
        r2.writer = r1;
        if (r0 == 0) goto L_0x0008;
    L_0x0019:
        r2.closeConnection();
        goto L_0x0008;
    L_0x001d:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x001d }
        throw r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.ws.WebSocket.close(int, java.lang.String):void");
    }

    private void peerClose(Buffer buffer) throws IOException {
        synchronized (this.closeLock) {
            this.readerClosed = true;
            boolean z = this.writerClosed;
            this.writerClosed = true;
        }
        if (z) {
            closeConnection();
        } else {
            this.writer.writeClose(buffer);
        }
    }

    private void readerErrorClose(IOException iOException, WebSocketListener webSocketListener) {
        Object obj = 1;
        synchronized (this.closeLock) {
            this.readerClosed = true;
            if (this.writerClosed) {
                obj = null;
            }
            this.writerClosed = true;
        }
        if (obj != null) {
            if (iOException instanceof ProtocolException) {
                try {
                    this.writer.writeClose(1002, null);
                } catch (IOException e) {
                }
            }
            try {
                closeConnection();
            } catch (IOException e2) {
            }
        }
        webSocketListener.onFailure(iOException);
    }

    private void closeConnection() throws IOException {
        Internal.instance.connectionCloseIfOwnedBy(this.connection, this);
        this.connection = null;
    }

    public boolean isClosed() {
        return this.writerClosed;
    }
}
