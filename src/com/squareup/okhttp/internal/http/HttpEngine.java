package com.squareup.okhttp.internal.http;

import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.squareup.okhttp.Address;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Interceptor.Chain;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Protocol;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.Response.Builder;
import com.squareup.okhttp.ResponseBody;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.Version;
import com.squareup.okhttp.internal.http.CacheStrategy.Factory;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.CookieHandler;
import java.net.ProtocolException;
import java.net.URL;
import java.security.cert.CertificateException;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.GzipSource;
import okio.Okio;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import org.apache.http.client.methods.HttpHead;

public final class HttpEngine {
    private static final ResponseBody EMPTY_BODY = new C26351();
    public static final int MAX_FOLLOW_UPS = 20;
    public final boolean bufferRequestBody;
    private BufferedSink bufferedRequestBody;
    private Response cacheResponse;
    private CacheStrategy cacheStrategy;
    private final boolean callerWritesRequestBody;
    final OkHttpClient client;
    private Connection connection;
    private final boolean forWebSocket;
    private Request networkRequest;
    private final Response priorResponse;
    private Sink requestBodyOut;
    private Route route;
    private RouteSelector routeSelector;
    long sentRequestMillis = -1;
    private CacheRequest storeRequest;
    private boolean transparentGzip;
    private Transport transport;
    private final Request userRequest;
    private Response userResponse;

    final class C26351 extends ResponseBody {
        C26351() {
        }

        public MediaType contentType() {
            return null;
        }

        public long contentLength() {
            return 0;
        }

        public BufferedSource source() {
            return new Buffer();
        }
    }

    class NetworkInterceptorChain implements Chain {
        private int calls;
        private final int index;
        private final Request request;

        NetworkInterceptorChain(int i, Request request) {
            this.index = i;
            this.request = request;
        }

        public Connection connection() {
            return HttpEngine.this.connection;
        }

        public Request request() {
            return this.request;
        }

        public Response proceed(Request request) throws IOException {
            Interceptor interceptor;
            this.calls++;
            if (this.index > 0) {
                interceptor = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index - 1);
                Address address = connection().getRoute().getAddress();
                if (!request.url().getHost().equals(address.getUriHost()) || Util.getEffectivePort(request.url()) != address.getUriPort()) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must retain the same host and port");
                } else if (this.calls > 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                }
            }
            if (this.index < HttpEngine.this.client.networkInterceptors().size()) {
                Object networkInterceptorChain = new NetworkInterceptorChain(this.index + 1, request);
                interceptor = (Interceptor) HttpEngine.this.client.networkInterceptors().get(this.index);
                Response intercept = interceptor.intercept(networkInterceptorChain);
                if (networkInterceptorChain.calls == 1) {
                    return intercept;
                }
                throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
            }
            HttpEngine.this.transport.writeRequestHeaders(request);
            if (HttpEngine.this.permitsRequestBody() && request.body() != null) {
                BufferedSink buffer = Okio.buffer(HttpEngine.this.transport.createRequestBody(request, request.body().contentLength()));
                request.body().writeTo(buffer);
                buffer.close();
            }
            return HttpEngine.this.readNetworkResponse();
        }
    }

    public HttpEngine(OkHttpClient okHttpClient, Request request, boolean z, boolean z2, boolean z3, Connection connection, RouteSelector routeSelector, RetryableSink retryableSink, Response response) {
        this.client = okHttpClient;
        this.userRequest = request;
        this.bufferRequestBody = z;
        this.callerWritesRequestBody = z2;
        this.forWebSocket = z3;
        this.connection = connection;
        this.routeSelector = routeSelector;
        this.requestBodyOut = retryableSink;
        this.priorResponse = response;
        if (connection != null) {
            Internal.instance.setOwner(connection, this);
            this.route = connection.getRoute();
            return;
        }
        this.route = null;
    }

    public void sendRequest() throws IOException {
        if (this.cacheStrategy == null) {
            if (this.transport != null) {
                throw new IllegalStateException();
            }
            Request networkRequest = networkRequest(this.userRequest);
            InternalCache internalCache = Internal.instance.internalCache(this.client);
            Response response = internalCache != null ? internalCache.get(networkRequest) : null;
            this.cacheStrategy = new Factory(System.currentTimeMillis(), networkRequest, response).get();
            this.networkRequest = this.cacheStrategy.networkRequest;
            this.cacheResponse = this.cacheStrategy.cacheResponse;
            if (internalCache != null) {
                internalCache.trackResponse(this.cacheStrategy);
            }
            if (response != null && this.cacheResponse == null) {
                Util.closeQuietly(response.body());
            }
            if (this.networkRequest != null) {
                if (this.connection == null) {
                    connect(this.networkRequest);
                }
                this.transport = Internal.instance.newTransport(this.connection, this);
                if (this.callerWritesRequestBody && permitsRequestBody() && this.requestBodyOut == null) {
                    long contentLength = OkHeaders.contentLength(networkRequest);
                    if (!this.bufferRequestBody) {
                        this.transport.writeRequestHeaders(this.networkRequest);
                        this.requestBodyOut = this.transport.createRequestBody(this.networkRequest, contentLength);
                        return;
                    } else if (contentLength > 2147483647L) {
                        throw new IllegalStateException("Use setFixedLengthStreamingMode() or setChunkedStreamingMode() for requests larger than 2 GiB.");
                    } else if (contentLength != -1) {
                        this.transport.writeRequestHeaders(this.networkRequest);
                        this.requestBodyOut = new RetryableSink((int) contentLength);
                        return;
                    } else {
                        this.requestBodyOut = new RetryableSink();
                        return;
                    }
                }
                return;
            }
            if (this.connection != null) {
                Internal.instance.recycle(this.client.getConnectionPool(), this.connection);
                this.connection = null;
            }
            if (this.cacheResponse != null) {
                this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).build();
            } else {
                this.userResponse = new Builder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).protocol(Protocol.HTTP_1_1).code(HttpStatus.SC_GATEWAY_TIMEOUT).message("Unsatisfiable Request (only-if-cached)").body(EMPTY_BODY).build();
            }
            this.userResponse = unzip(this.userResponse);
        }
    }

    private static Response stripBody(Response response) {
        return (response == null || response.body() == null) ? response : response.newBuilder().body(null).build();
    }

    private void connect(Request request) throws IOException {
        if (this.connection != null) {
            throw new IllegalStateException();
        }
        if (this.routeSelector == null) {
            this.routeSelector = RouteSelector.get(request, this.client);
        }
        this.connection = this.routeSelector.next(this);
        this.route = this.connection.getRoute();
    }

    public void writingRequestHeaders() {
        if (this.sentRequestMillis != -1) {
            throw new IllegalStateException();
        }
        this.sentRequestMillis = System.currentTimeMillis();
    }

    boolean permitsRequestBody() {
        return HttpMethod.permitsRequestBody(this.userRequest.method());
    }

    public Sink getRequestBody() {
        if (this.cacheStrategy != null) {
            return this.requestBodyOut;
        }
        throw new IllegalStateException();
    }

    public BufferedSink getBufferedRequestBody() {
        BufferedSink bufferedSink = this.bufferedRequestBody;
        if (bufferedSink != null) {
            return bufferedSink;
        }
        Sink requestBody = getRequestBody();
        if (requestBody == null) {
            return null;
        }
        bufferedSink = Okio.buffer(requestBody);
        this.bufferedRequestBody = bufferedSink;
        return bufferedSink;
    }

    public boolean hasResponse() {
        return this.userResponse != null;
    }

    public Request getRequest() {
        return this.userRequest;
    }

    public Response getResponse() {
        if (this.userResponse != null) {
            return this.userResponse;
        }
        throw new IllegalStateException();
    }

    public Connection getConnection() {
        return this.connection;
    }

    public HttpEngine recover(IOException iOException, Sink sink) {
        if (!(this.routeSelector == null || this.connection == null)) {
            this.routeSelector.connectFailed(this.connection, iOException);
        }
        Object obj = (sink == null || (sink instanceof RetryableSink)) ? 1 : null;
        if ((this.routeSelector == null && this.connection == null) || ((this.routeSelector != null && !this.routeSelector.hasNext()) || !isRecoverable(iOException) || obj == null)) {
            return null;
        }
        return new HttpEngine(this.client, this.userRequest, this.bufferRequestBody, this.callerWritesRequestBody, this.forWebSocket, close(), this.routeSelector, (RetryableSink) sink, this.priorResponse);
    }

    public HttpEngine recover(IOException iOException) {
        return recover(iOException, this.requestBodyOut);
    }

    private boolean isRecoverable(IOException iOException) {
        if (!this.client.getRetryOnConnectionFailure() || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (((iOException instanceof SSLHandshakeException) && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        return true;
    }

    public Route getRoute() {
        return this.route;
    }

    private void maybeCache() throws IOException {
        InternalCache internalCache = Internal.instance.internalCache(this.client);
        if (internalCache != null) {
            if (CacheStrategy.isCacheable(this.userResponse, this.networkRequest)) {
                this.storeRequest = internalCache.put(stripBody(this.userResponse));
            } else if (HttpMethod.invalidatesCache(this.networkRequest.method())) {
                try {
                    internalCache.remove(this.networkRequest);
                } catch (IOException e) {
                }
            }
        }
    }

    public void releaseConnection() throws IOException {
        if (!(this.transport == null || this.connection == null)) {
            this.transport.releaseConnectionOnIdle();
        }
        this.connection = null;
    }

    public void disconnect() {
        if (this.transport != null) {
            try {
                this.transport.disconnect(this);
            } catch (IOException e) {
            }
        }
    }

    public Connection close() {
        if (this.bufferedRequestBody != null) {
            Util.closeQuietly(this.bufferedRequestBody);
        } else if (this.requestBodyOut != null) {
            Util.closeQuietly(this.requestBodyOut);
        }
        if (this.userResponse == null) {
            if (this.connection != null) {
                Util.closeQuietly(this.connection.getSocket());
            }
            this.connection = null;
            return null;
        }
        Util.closeQuietly(this.userResponse.body());
        if (this.transport == null || this.connection == null || this.transport.canReuseConnection()) {
            if (!(this.connection == null || Internal.instance.clearOwner(this.connection))) {
                this.connection = null;
            }
            Connection connection = this.connection;
            this.connection = null;
            return connection;
        }
        Util.closeQuietly(this.connection.getSocket());
        this.connection = null;
        return null;
    }

    private Response unzip(Response response) throws IOException {
        if (!this.transparentGzip || !"gzip".equalsIgnoreCase(this.userResponse.header("Content-Encoding")) || response.body() == null) {
            return response;
        }
        Source gzipSource = new GzipSource(response.body().source());
        Headers build = response.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build();
        return response.newBuilder().headers(build).body(new RealResponseBody(build, Okio.buffer(gzipSource))).build();
    }

    public static boolean hasBody(Response response) {
        if (response.request().method().equals(HttpHead.METHOD_NAME)) {
            return false;
        }
        int code = response.code();
        if ((code < 100 || code >= 200) && code != 204 && code != HttpStatus.SC_NOT_MODIFIED) {
            return true;
        }
        if (OkHeaders.contentLength(response) != -1 || "chunked".equalsIgnoreCase(response.header("Transfer-Encoding"))) {
            return true;
        }
        return false;
    }

    private Request networkRequest(Request request) throws IOException {
        Request.Builder newBuilder = request.newBuilder();
        if (request.header("Host") == null) {
            newBuilder.header("Host", hostHeader(request.url()));
        }
        if ((this.connection == null || this.connection.getProtocol() != Protocol.HTTP_1_0) && request.header("Connection") == null) {
            newBuilder.header("Connection", "Keep-Alive");
        }
        if (request.header("Accept-Encoding") == null) {
            this.transparentGzip = true;
            newBuilder.header("Accept-Encoding", "gzip");
        }
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            OkHeaders.addCookies(newBuilder, cookieHandler.get(request.uri(), OkHeaders.toMultimap(newBuilder.build().headers(), null)));
        }
        if (request.header("User-Agent") == null) {
            newBuilder.header("User-Agent", Version.userAgent());
        }
        return newBuilder.build();
    }

    public static String hostHeader(URL url) {
        if (Util.getEffectivePort(url) != Util.getDefaultPort(url.getProtocol())) {
            return url.getHost() + ":" + url.getPort();
        }
        return url.getHost();
    }

    public void readResponse() throws IOException {
        if (this.userResponse == null) {
            if (this.networkRequest == null && this.cacheResponse == null) {
                throw new IllegalStateException("call sendRequest() first!");
            } else if (this.networkRequest != null) {
                Response readNetworkResponse;
                if (this.forWebSocket) {
                    this.transport.writeRequestHeaders(this.networkRequest);
                    readNetworkResponse = readNetworkResponse();
                } else if (this.callerWritesRequestBody) {
                    if (this.bufferedRequestBody != null && this.bufferedRequestBody.buffer().size() > 0) {
                        this.bufferedRequestBody.emit();
                    }
                    if (this.sentRequestMillis == -1) {
                        if (OkHeaders.contentLength(this.networkRequest) == -1 && (this.requestBodyOut instanceof RetryableSink)) {
                            this.networkRequest = this.networkRequest.newBuilder().header("Content-Length", Long.toString(((RetryableSink) this.requestBodyOut).contentLength())).build();
                        }
                        this.transport.writeRequestHeaders(this.networkRequest);
                    }
                    if (this.requestBodyOut != null) {
                        if (this.bufferedRequestBody != null) {
                            this.bufferedRequestBody.close();
                        } else {
                            this.requestBodyOut.close();
                        }
                        if (this.requestBodyOut instanceof RetryableSink) {
                            this.transport.writeRequestBody((RetryableSink) this.requestBodyOut);
                        }
                    }
                    readNetworkResponse = readNetworkResponse();
                } else {
                    readNetworkResponse = new NetworkInterceptorChain(0, this.networkRequest).proceed(this.networkRequest);
                }
                receiveHeaders(readNetworkResponse.headers());
                if (this.cacheResponse != null) {
                    if (validate(this.cacheResponse, readNetworkResponse)) {
                        this.userResponse = this.cacheResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).headers(combine(this.cacheResponse.headers(), readNetworkResponse.headers())).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
                        readNetworkResponse.body().close();
                        releaseConnection();
                        InternalCache internalCache = Internal.instance.internalCache(this.client);
                        internalCache.trackConditionalCacheHit();
                        internalCache.update(this.cacheResponse, stripBody(this.userResponse));
                        this.userResponse = unzip(this.userResponse);
                        return;
                    }
                    Util.closeQuietly(this.cacheResponse.body());
                }
                this.userResponse = readNetworkResponse.newBuilder().request(this.userRequest).priorResponse(stripBody(this.priorResponse)).cacheResponse(stripBody(this.cacheResponse)).networkResponse(stripBody(readNetworkResponse)).build();
                if (hasBody(this.userResponse)) {
                    maybeCache();
                    this.userResponse = unzip(cacheWritingResponse(this.storeRequest, this.userResponse));
                }
            }
        }
    }

    private Response readNetworkResponse() throws IOException {
        this.transport.finishRequest();
        Response build = this.transport.readResponseHeaders().request(this.networkRequest).handshake(this.connection.getHandshake()).header(OkHeaders.SENT_MILLIS, Long.toString(this.sentRequestMillis)).header(OkHeaders.RECEIVED_MILLIS, Long.toString(System.currentTimeMillis())).build();
        if (!this.forWebSocket) {
            build = build.newBuilder().body(this.transport.openResponseBody(build)).build();
        }
        Internal.instance.setProtocol(this.connection, build.protocol());
        return build;
    }

    private Response cacheWritingResponse(final CacheRequest cacheRequest, Response response) throws IOException {
        if (cacheRequest == null) {
            return response;
        }
        Sink body = cacheRequest.body();
        if (body == null) {
            return response;
        }
        final BufferedSource source = response.body().source();
        final BufferedSink buffer = Okio.buffer(body);
        return response.newBuilder().body(new RealResponseBody(response.headers(), Okio.buffer(new Source() {
            boolean cacheRequestClosed;

            public long read(Buffer buffer, long j) throws IOException {
                try {
                    long read = source.read(buffer, j);
                    if (read == -1) {
                        if (!this.cacheRequestClosed) {
                            this.cacheRequestClosed = true;
                            buffer.close();
                        }
                        return -1;
                    }
                    buffer.copyTo(buffer.buffer(), buffer.size() - read, read);
                    buffer.emitCompleteSegments();
                    return read;
                } catch (IOException e) {
                    if (!this.cacheRequestClosed) {
                        this.cacheRequestClosed = true;
                        cacheRequest.abort();
                    }
                    throw e;
                }
            }

            public Timeout timeout() {
                return source.timeout();
            }

            public void close() throws IOException {
                if (!(this.cacheRequestClosed || Util.discard(this, 100, TimeUnit.MILLISECONDS))) {
                    this.cacheRequestClosed = true;
                    cacheRequest.abort();
                }
                source.close();
            }
        }))).build();
    }

    private static boolean validate(Response response, Response response2) {
        if (response2.code() == HttpStatus.SC_NOT_MODIFIED) {
            return true;
        }
        Date date = response.headers().getDate("Last-Modified");
        if (date != null) {
            Date date2 = response2.headers().getDate("Last-Modified");
            if (date2 != null && date2.getTime() < date.getTime()) {
                return true;
            }
        }
        return false;
    }

    private static Headers combine(Headers headers, Headers headers2) throws IOException {
        int i;
        int i2 = 0;
        Headers.Builder builder = new Headers.Builder();
        int size = headers.size();
        for (i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (!("Warning".equalsIgnoreCase(name) && value.startsWith("1")) && (!OkHeaders.isEndToEnd(name) || headers2.get(name) == null)) {
                builder.add(name, value);
            }
        }
        i = headers2.size();
        while (i2 < i) {
            String name2 = headers2.name(i2);
            if (!"Content-Length".equalsIgnoreCase(name2) && OkHeaders.isEndToEnd(name2)) {
                builder.add(name2, headers2.value(i2));
            }
            i2++;
        }
        return builder.build();
    }

    public void receiveHeaders(Headers headers) throws IOException {
        CookieHandler cookieHandler = this.client.getCookieHandler();
        if (cookieHandler != null) {
            cookieHandler.put(this.userRequest.uri(), OkHeaders.toMultimap(headers, null));
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.squareup.okhttp.Request followUpRequest() throws java.io.IOException {
        /*
        r4 = this;
        r1 = 0;
        r0 = r4.userResponse;
        if (r0 != 0) goto L_0x000b;
    L_0x0005:
        r0 = new java.lang.IllegalStateException;
        r0.<init>();
        throw r0;
    L_0x000b:
        r0 = r4.getRoute();
        if (r0 == 0) goto L_0x0024;
    L_0x0011:
        r0 = r4.getRoute();
        r0 = r0.getProxy();
    L_0x0019:
        r2 = r4.userResponse;
        r2 = r2.code();
        switch(r2) {
            case 300: goto L_0x0066;
            case 301: goto L_0x0066;
            case 302: goto L_0x0066;
            case 303: goto L_0x0066;
            case 307: goto L_0x0048;
            case 308: goto L_0x0048;
            case 401: goto L_0x003b;
            case 407: goto L_0x002b;
            default: goto L_0x0022;
        };
    L_0x0022:
        r0 = r1;
    L_0x0023:
        return r0;
    L_0x0024:
        r0 = r4.client;
        r0 = r0.getProxy();
        goto L_0x0019;
    L_0x002b:
        r1 = r0.type();
        r2 = java.net.Proxy.Type.HTTP;
        if (r1 == r2) goto L_0x003b;
    L_0x0033:
        r0 = new java.net.ProtocolException;
        r1 = "Received HTTP_PROXY_AUTH (407) code while not using proxy";
        r0.<init>(r1);
        throw r0;
    L_0x003b:
        r1 = r4.client;
        r1 = r1.getAuthenticator();
        r2 = r4.userResponse;
        r0 = com.squareup.okhttp.internal.http.OkHeaders.processAuthHeader(r1, r2, r0);
        goto L_0x0023;
    L_0x0048:
        r0 = r4.userRequest;
        r0 = r0.method();
        r2 = "GET";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0056:
        r0 = r4.userRequest;
        r0 = r0.method();
        r2 = "HEAD";
        r0 = r0.equals(r2);
        if (r0 != 0) goto L_0x0066;
    L_0x0064:
        r0 = r1;
        goto L_0x0023;
    L_0x0066:
        r0 = r4.client;
        r0 = r0.getFollowRedirects();
        if (r0 != 0) goto L_0x0070;
    L_0x006e:
        r0 = r1;
        goto L_0x0023;
    L_0x0070:
        r0 = r4.userResponse;
        r2 = "Location";
        r0 = r0.header(r2);
        if (r0 != 0) goto L_0x007c;
    L_0x007a:
        r0 = r1;
        goto L_0x0023;
    L_0x007c:
        r2 = new java.net.URL;
        r3 = r4.userRequest;
        r3 = r3.url();
        r2.<init>(r3, r0);
        r0 = r2.getProtocol();
        r3 = "https";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00a1;
    L_0x0093:
        r0 = r2.getProtocol();
        r3 = "http";
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00a1;
    L_0x009f:
        r0 = r1;
        goto L_0x0023;
    L_0x00a1:
        r0 = r2.getProtocol();
        r3 = r4.userRequest;
        r3 = r3.url();
        r3 = r3.getProtocol();
        r0 = r0.equals(r3);
        if (r0 != 0) goto L_0x00c0;
    L_0x00b5:
        r0 = r4.client;
        r0 = r0.getFollowSslRedirects();
        if (r0 != 0) goto L_0x00c0;
    L_0x00bd:
        r0 = r1;
        goto L_0x0023;
    L_0x00c0:
        r0 = r4.userRequest;
        r0 = r0.newBuilder();
        r3 = r4.userRequest;
        r3 = r3.method();
        r3 = com.squareup.okhttp.internal.http.HttpMethod.permitsRequestBody(r3);
        if (r3 == 0) goto L_0x00e6;
    L_0x00d2:
        r3 = "GET";
        r0.method(r3, r1);
        r1 = "Transfer-Encoding";
        r0.removeHeader(r1);
        r1 = "Content-Length";
        r0.removeHeader(r1);
        r1 = "Content-Type";
        r0.removeHeader(r1);
    L_0x00e6:
        r1 = r4.sameConnection(r2);
        if (r1 != 0) goto L_0x00f1;
    L_0x00ec:
        r1 = "Authorization";
        r0.removeHeader(r1);
    L_0x00f1:
        r0 = r0.url(r2);
        r0 = r0.build();
        goto L_0x0023;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.okhttp.internal.http.HttpEngine.followUpRequest():com.squareup.okhttp.Request");
    }

    public boolean sameConnection(URL url) {
        URL url2 = this.userRequest.url();
        return url2.getHost().equals(url.getHost()) && Util.getEffectivePort(url2) == Util.getEffectivePort(url) && url2.getProtocol().equals(url.getProtocol());
    }
}
