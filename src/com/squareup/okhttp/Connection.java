package com.squareup.okhttp;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.squareup.okhttp.Request.Builder;
import com.squareup.okhttp.internal.Platform;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.HttpConnection;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.HttpTransport;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.SpdyTransport;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.spdy.SpdyConnection;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.Proxy.Type;
import java.net.Socket;
import java.net.URL;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLSocket;
import okio.Source;
import org.apache.http.auth.AUTH;

public final class Connection {
    private boolean connected = false;
    private Handshake handshake;
    private HttpConnection httpConnection;
    private long idleStartTimeNs;
    private Object owner;
    private final ConnectionPool pool;
    private Protocol protocol = Protocol.HTTP_1_1;
    private int recycleCount;
    private final Route route;
    private Socket socket;
    private SpdyConnection spdyConnection;

    public Connection(ConnectionPool connectionPool, Route route) {
        this.pool = connectionPool;
        this.route = route;
    }

    Object getOwner() {
        Object obj;
        synchronized (this.pool) {
            obj = this.owner;
        }
        return obj;
    }

    void setOwner(Object obj) {
        if (!isSpdy()) {
            synchronized (this.pool) {
                if (this.owner != null) {
                    throw new IllegalStateException("Connection already has an owner!");
                }
                this.owner = obj;
            }
        }
    }

    boolean clearOwner() {
        boolean z;
        synchronized (this.pool) {
            if (this.owner == null) {
                z = false;
            } else {
                this.owner = null;
                z = true;
            }
        }
        return z;
    }

    void closeIfOwnedBy(Object obj) throws IOException {
        if (isSpdy()) {
            throw new IllegalStateException();
        }
        synchronized (this.pool) {
            if (this.owner != obj) {
                return;
            }
            this.owner = null;
            this.socket.close();
        }
    }

    void connect(int i, int i2, int i3, Request request) throws IOException {
        if (this.connected) {
            throw new IllegalStateException("already connected");
        }
        if (this.route.proxy.type() == Type.DIRECT || this.route.proxy.type() == Type.HTTP) {
            this.socket = this.route.address.socketFactory.createSocket();
        } else {
            this.socket = new Socket(this.route.proxy);
        }
        this.socket.setSoTimeout(i2);
        Platform.get().connectSocket(this.socket, this.route.inetSocketAddress, i);
        if (this.route.address.sslSocketFactory != null) {
            upgradeToTls(request, i2, i3);
        } else {
            this.httpConnection = new HttpConnection(this.pool, this, this.socket);
        }
        this.connected = true;
    }

    void connectAndSetOwner(OkHttpClient okHttpClient, Object obj, Request request) throws IOException {
        setOwner(obj);
        if (!isConnected()) {
            connect(okHttpClient.getConnectTimeout(), okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout(), tunnelRequest(request));
            if (isSpdy()) {
                okHttpClient.getConnectionPool().share(this);
            }
            okHttpClient.routeDatabase().connected(getRoute());
        }
        setTimeouts(okHttpClient.getReadTimeout(), okHttpClient.getWriteTimeout());
    }

    private Request tunnelRequest(Request request) throws IOException {
        if (!this.route.requiresTunnel()) {
            return null;
        }
        String host = request.url().getHost();
        int effectivePort = Util.getEffectivePort(request.url());
        Builder header = new Builder().url(new URL("https", host, effectivePort, "/")).header("Host", effectivePort == Util.getDefaultPort("https") ? host : host + ":" + effectivePort).header("Proxy-Connection", "Keep-Alive");
        host = request.header("User-Agent");
        if (host != null) {
            header.header("User-Agent", host);
        }
        host = request.header(AUTH.PROXY_AUTH_RESP);
        if (host != null) {
            header.header(AUTH.PROXY_AUTH_RESP, host);
        }
        return header.build();
    }

    private void upgradeToTls(Request request, int i, int i2) throws IOException {
        Platform platform = Platform.get();
        if (request != null) {
            makeTunnel(request, i, i2);
        }
        this.socket = this.route.address.sslSocketFactory.createSocket(this.socket, this.route.address.uriHost, this.route.address.uriPort, true);
        SSLSocket sSLSocket = (SSLSocket) this.socket;
        this.route.connectionSpec.apply(sSLSocket, this.route);
        try {
            sSLSocket.startHandshake();
            if (this.route.connectionSpec.supportsTlsExtensions()) {
                String selectedProtocol = platform.getSelectedProtocol(sSLSocket);
                if (selectedProtocol != null) {
                    this.protocol = Protocol.get(selectedProtocol);
                }
            }
            platform.afterHandshake(sSLSocket);
            this.handshake = Handshake.get(sSLSocket.getSession());
            if (this.route.address.hostnameVerifier.verify(this.route.address.uriHost, sSLSocket.getSession())) {
                this.route.address.certificatePinner.check(this.route.address.uriHost, this.handshake.peerCertificates());
                if (this.protocol == Protocol.SPDY_3 || this.protocol == Protocol.HTTP_2) {
                    sSLSocket.setSoTimeout(0);
                    this.spdyConnection = new SpdyConnection.Builder(this.route.address.getUriHost(), true, this.socket).protocol(this.protocol).build();
                    this.spdyConnection.sendConnectionPreface();
                    return;
                }
                this.httpConnection = new HttpConnection(this.pool, this, this.socket);
                return;
            }
            X509Certificate x509Certificate = (X509Certificate) sSLSocket.getSession().getPeerCertificates()[0];
            throw new IOException("Hostname " + this.route.address.uriHost + " not verified:" + "\n    certificate: " + CertificatePinner.pin(x509Certificate) + "\n    DN: " + x509Certificate.getSubjectDN().getName() + "\n    subjectAltNames: " + OkHostnameVerifier.allSubjectAltNames(x509Certificate));
        } catch (Throwable th) {
            platform.afterHandshake(sSLSocket);
        }
    }

    boolean isConnected() {
        return this.connected;
    }

    public Route getRoute() {
        return this.route;
    }

    public Socket getSocket() {
        return this.socket;
    }

    boolean isAlive() {
        return (this.socket.isClosed() || this.socket.isInputShutdown() || this.socket.isOutputShutdown()) ? false : true;
    }

    boolean isReadable() {
        if (this.httpConnection != null) {
            return this.httpConnection.isReadable();
        }
        return true;
    }

    void resetIdleStartTime() {
        if (this.spdyConnection != null) {
            throw new IllegalStateException("spdyConnection != null");
        }
        this.idleStartTimeNs = System.nanoTime();
    }

    boolean isIdle() {
        return this.spdyConnection == null || this.spdyConnection.isIdle();
    }

    long getIdleStartTimeNs() {
        return this.spdyConnection == null ? this.idleStartTimeNs : this.spdyConnection.getIdleStartTimeNs();
    }

    public Handshake getHandshake() {
        return this.handshake;
    }

    Transport newTransport(HttpEngine httpEngine) throws IOException {
        return this.spdyConnection != null ? new SpdyTransport(httpEngine, this.spdyConnection) : new HttpTransport(httpEngine, this.httpConnection);
    }

    boolean isSpdy() {
        return this.spdyConnection != null;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    void setProtocol(Protocol protocol) {
        if (protocol == null) {
            throw new IllegalArgumentException("protocol == null");
        }
        this.protocol = protocol;
    }

    void setTimeouts(int i, int i2) throws IOException {
        if (!this.connected) {
            throw new IllegalStateException("setTimeouts - not connected");
        } else if (this.httpConnection != null) {
            this.socket.setSoTimeout(i);
            this.httpConnection.setTimeouts(i, i2);
        }
    }

    void incrementRecycleCount() {
        this.recycleCount++;
    }

    int recycleCount() {
        return this.recycleCount;
    }

    private void makeTunnel(Request request, int i, int i2) throws IOException {
        HttpConnection httpConnection = new HttpConnection(this.pool, this, this.socket);
        httpConnection.setTimeouts(i, i2);
        URL url = request.url();
        String str = "CONNECT " + url.getHost() + ":" + url.getPort() + " HTTP/1.1";
        do {
            httpConnection.writeRequest(request.headers(), str);
            httpConnection.flush();
            Response build = httpConnection.readResponse().request(request).build();
            long contentLength = OkHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = httpConnection.newFixedLengthSource(contentLength);
            Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            switch (build.code()) {
                case 200:
                    if (httpConnection.bufferSize() > 0) {
                        throw new IOException("TLS tunnel buffered too many bytes!");
                    }
                    return;
                case HttpStatus.SC_PROXY_AUTHENTICATION_REQUIRED /*407*/:
                    request = OkHeaders.processAuthHeader(this.route.address.authenticator, build, this.route.proxy);
                    break;
                default:
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
            }
        } while (request != null);
        throw new IOException("Failed to authenticate with proxy");
    }

    public String toString() {
        return "Connection{" + this.route.address.uriHost + ":" + this.route.address.uriPort + ", proxy=" + this.route.proxy + " hostAddress=" + this.route.inetSocketAddress.getAddress().getHostAddress() + " cipherSuite=" + (this.handshake != null ? this.handshake.cipherSuite() : "none") + " protocol=" + this.protocol + '}';
    }
}
