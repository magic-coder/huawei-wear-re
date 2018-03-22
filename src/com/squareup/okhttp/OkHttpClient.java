package com.squareup.okhttp;

import com.squareup.okhttp.Headers.Builder;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.AuthenticatorAdapter;
import com.squareup.okhttp.internal.http.HttpEngine;
import com.squareup.okhttp.internal.http.Transport;
import com.squareup.okhttp.internal.tls.OkHostnameVerifier;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.Proxy;
import java.net.ProxySelector;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public class OkHttpClient implements Cloneable {
    private static final List<ConnectionSpec> DEFAULT_CONNECTION_SPECS = Util.immutableList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT);
    private static final List<Protocol> DEFAULT_PROTOCOLS = Util.immutableList(Protocol.HTTP_2, Protocol.SPDY_3, Protocol.HTTP_1_1);
    private static SSLSocketFactory defaultSslSocketFactory;
    private Authenticator authenticator;
    private Cache cache;
    private CertificatePinner certificatePinner;
    private int connectTimeout;
    private ConnectionPool connectionPool;
    private List<ConnectionSpec> connectionSpecs;
    private CookieHandler cookieHandler;
    private Dispatcher dispatcher;
    private boolean followRedirects;
    private boolean followSslRedirects;
    private HostnameVerifier hostnameVerifier;
    private final List<Interceptor> interceptors;
    private InternalCache internalCache;
    private Network network;
    private final List<Interceptor> networkInterceptors;
    private List<Protocol> protocols;
    private Proxy proxy;
    private ProxySelector proxySelector;
    private int readTimeout;
    private boolean retryOnConnectionFailure;
    private final RouteDatabase routeDatabase;
    private SocketFactory socketFactory;
    private SSLSocketFactory sslSocketFactory;
    private int writeTimeout;

    final class C26201 extends Internal {
        C26201() {
        }

        public Transport newTransport(Connection connection, HttpEngine httpEngine) throws IOException {
            return connection.newTransport(httpEngine);
        }

        public boolean clearOwner(Connection connection) {
            return connection.clearOwner();
        }

        public void closeIfOwnedBy(Connection connection, Object obj) throws IOException {
            connection.closeIfOwnedBy(obj);
        }

        public int recycleCount(Connection connection) {
            return connection.recycleCount();
        }

        public void setProtocol(Connection connection, Protocol protocol) {
            connection.setProtocol(protocol);
        }

        public void setOwner(Connection connection, HttpEngine httpEngine) {
            connection.setOwner(httpEngine);
        }

        public boolean isReadable(Connection connection) {
            return connection.isReadable();
        }

        public void addLine(Builder builder, String str) {
            builder.addLine(str);
        }

        public void setCache(OkHttpClient okHttpClient, InternalCache internalCache) {
            okHttpClient.setInternalCache(internalCache);
        }

        public InternalCache internalCache(OkHttpClient okHttpClient) {
            return okHttpClient.internalCache();
        }

        public void recycle(ConnectionPool connectionPool, Connection connection) {
            connectionPool.recycle(connection);
        }

        public RouteDatabase routeDatabase(OkHttpClient okHttpClient) {
            return okHttpClient.routeDatabase();
        }

        public Network network(OkHttpClient okHttpClient) {
            return okHttpClient.network;
        }

        public void setNetwork(OkHttpClient okHttpClient, Network network) {
            okHttpClient.network = network;
        }

        public void connectAndSetOwner(OkHttpClient okHttpClient, Connection connection, HttpEngine httpEngine, Request request) throws IOException {
            connection.connectAndSetOwner(okHttpClient, httpEngine, request);
        }

        public Call newCall(OkHttpClient okHttpClient, Request request) {
            return new Call(okHttpClient, request);
        }

        public Response callGetResponse(Call call, boolean z) throws IOException {
            return call.getResponse(call.originalRequest, z);
        }

        public void callEngineReleaseConnection(Call call) throws IOException {
            call.engine.releaseConnection();
        }

        public Connection callEngineGetConnection(Call call) {
            return call.engine.getConnection();
        }

        public boolean connectionClearOwner(Connection connection) {
            return connection.clearOwner();
        }

        public void connectionSetOwner(Connection connection, Object obj) {
            connection.setOwner(obj);
        }

        public void connectionCloseIfOwnedBy(Connection connection, Object obj) throws IOException {
            connection.closeIfOwnedBy(obj);
        }
    }

    static {
        Internal.instance = new C26201();
    }

    public OkHttpClient() {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.routeDatabase = new RouteDatabase();
        this.dispatcher = new Dispatcher();
    }

    private OkHttpClient(OkHttpClient okHttpClient) {
        this.interceptors = new ArrayList();
        this.networkInterceptors = new ArrayList();
        this.followSslRedirects = true;
        this.followRedirects = true;
        this.retryOnConnectionFailure = true;
        this.routeDatabase = okHttpClient.routeDatabase;
        this.dispatcher = okHttpClient.dispatcher;
        this.proxy = okHttpClient.proxy;
        this.protocols = okHttpClient.protocols;
        this.connectionSpecs = okHttpClient.connectionSpecs;
        this.interceptors.addAll(okHttpClient.interceptors);
        this.networkInterceptors.addAll(okHttpClient.networkInterceptors);
        this.proxySelector = okHttpClient.proxySelector;
        this.cookieHandler = okHttpClient.cookieHandler;
        this.cache = okHttpClient.cache;
        this.internalCache = this.cache != null ? this.cache.internalCache : okHttpClient.internalCache;
        this.socketFactory = okHttpClient.socketFactory;
        this.sslSocketFactory = okHttpClient.sslSocketFactory;
        this.hostnameVerifier = okHttpClient.hostnameVerifier;
        this.certificatePinner = okHttpClient.certificatePinner;
        this.authenticator = okHttpClient.authenticator;
        this.connectionPool = okHttpClient.connectionPool;
        this.network = okHttpClient.network;
        this.followSslRedirects = okHttpClient.followSslRedirects;
        this.followRedirects = okHttpClient.followRedirects;
        this.retryOnConnectionFailure = okHttpClient.retryOnConnectionFailure;
        this.connectTimeout = okHttpClient.connectTimeout;
        this.readTimeout = okHttpClient.readTimeout;
        this.writeTimeout = okHttpClient.writeTimeout;
    }

    public final void setConnectTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            this.connectTimeout = (int) toMillis;
        }
    }

    public final int getConnectTimeout() {
        return this.connectTimeout;
    }

    public final void setReadTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            this.readTimeout = (int) toMillis;
        }
    }

    public final int getReadTimeout() {
        return this.readTimeout;
    }

    public final void setWriteTimeout(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException("timeout < 0");
        } else if (timeUnit == null) {
            throw new IllegalArgumentException("unit == null");
        } else {
            long toMillis = timeUnit.toMillis(j);
            if (toMillis > 2147483647L) {
                throw new IllegalArgumentException("Timeout too large.");
            }
            this.writeTimeout = (int) toMillis;
        }
    }

    public final int getWriteTimeout() {
        return this.writeTimeout;
    }

    public final OkHttpClient setProxy(Proxy proxy) {
        this.proxy = proxy;
        return this;
    }

    public final Proxy getProxy() {
        return this.proxy;
    }

    public final OkHttpClient setProxySelector(ProxySelector proxySelector) {
        this.proxySelector = proxySelector;
        return this;
    }

    public final ProxySelector getProxySelector() {
        return this.proxySelector;
    }

    public final OkHttpClient setCookieHandler(CookieHandler cookieHandler) {
        this.cookieHandler = cookieHandler;
        return this;
    }

    public final CookieHandler getCookieHandler() {
        return this.cookieHandler;
    }

    final void setInternalCache(InternalCache internalCache) {
        this.internalCache = internalCache;
        this.cache = null;
    }

    final InternalCache internalCache() {
        return this.internalCache;
    }

    public final OkHttpClient setCache(Cache cache) {
        this.cache = cache;
        this.internalCache = null;
        return this;
    }

    public final Cache getCache() {
        return this.cache;
    }

    public final OkHttpClient setSocketFactory(SocketFactory socketFactory) {
        this.socketFactory = socketFactory;
        return this;
    }

    public final SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public final OkHttpClient setSslSocketFactory(SSLSocketFactory sSLSocketFactory) {
        this.sslSocketFactory = sSLSocketFactory;
        return this;
    }

    public final SSLSocketFactory getSslSocketFactory() {
        return this.sslSocketFactory;
    }

    public final OkHttpClient setHostnameVerifier(HostnameVerifier hostnameVerifier) {
        this.hostnameVerifier = hostnameVerifier;
        return this;
    }

    public final HostnameVerifier getHostnameVerifier() {
        return this.hostnameVerifier;
    }

    public final OkHttpClient setCertificatePinner(CertificatePinner certificatePinner) {
        this.certificatePinner = certificatePinner;
        return this;
    }

    public final CertificatePinner getCertificatePinner() {
        return this.certificatePinner;
    }

    public final OkHttpClient setAuthenticator(Authenticator authenticator) {
        this.authenticator = authenticator;
        return this;
    }

    public final Authenticator getAuthenticator() {
        return this.authenticator;
    }

    public final OkHttpClient setConnectionPool(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
        return this;
    }

    public final ConnectionPool getConnectionPool() {
        return this.connectionPool;
    }

    public final OkHttpClient setFollowSslRedirects(boolean z) {
        this.followSslRedirects = z;
        return this;
    }

    public final boolean getFollowSslRedirects() {
        return this.followSslRedirects;
    }

    public final void setFollowRedirects(boolean z) {
        this.followRedirects = z;
    }

    public final boolean getFollowRedirects() {
        return this.followRedirects;
    }

    public final void setRetryOnConnectionFailure(boolean z) {
        this.retryOnConnectionFailure = z;
    }

    public final boolean getRetryOnConnectionFailure() {
        return this.retryOnConnectionFailure;
    }

    final RouteDatabase routeDatabase() {
        return this.routeDatabase;
    }

    public final OkHttpClient setDispatcher(Dispatcher dispatcher) {
        if (dispatcher == null) {
            throw new IllegalArgumentException("dispatcher == null");
        }
        this.dispatcher = dispatcher;
        return this;
    }

    public final Dispatcher getDispatcher() {
        return this.dispatcher;
    }

    public final OkHttpClient setProtocols(List<Protocol> list) {
        List immutableList = Util.immutableList((List) list);
        if (!immutableList.contains(Protocol.HTTP_1_1)) {
            throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + immutableList);
        } else if (immutableList.contains(Protocol.HTTP_1_0)) {
            throw new IllegalArgumentException("protocols must not contain http/1.0: " + immutableList);
        } else if (immutableList.contains(null)) {
            throw new IllegalArgumentException("protocols must not contain null");
        } else {
            this.protocols = Util.immutableList(immutableList);
            return this;
        }
    }

    public final List<Protocol> getProtocols() {
        return this.protocols;
    }

    public final OkHttpClient setConnectionSpecs(List<ConnectionSpec> list) {
        this.connectionSpecs = Util.immutableList((List) list);
        return this;
    }

    public final List<ConnectionSpec> getConnectionSpecs() {
        return this.connectionSpecs;
    }

    public List<Interceptor> interceptors() {
        return this.interceptors;
    }

    public List<Interceptor> networkInterceptors() {
        return this.networkInterceptors;
    }

    public Call newCall(Request request) {
        return new Call(this, request);
    }

    public OkHttpClient cancel(Object obj) {
        getDispatcher().cancel(obj);
        return this;
    }

    final OkHttpClient copyWithDefaults() {
        OkHttpClient okHttpClient = new OkHttpClient(this);
        if (okHttpClient.proxySelector == null) {
            okHttpClient.proxySelector = ProxySelector.getDefault();
        }
        if (okHttpClient.cookieHandler == null) {
            okHttpClient.cookieHandler = CookieHandler.getDefault();
        }
        if (okHttpClient.socketFactory == null) {
            okHttpClient.socketFactory = SocketFactory.getDefault();
        }
        if (okHttpClient.sslSocketFactory == null) {
            okHttpClient.sslSocketFactory = getDefaultSSLSocketFactory();
        }
        if (okHttpClient.hostnameVerifier == null) {
            okHttpClient.hostnameVerifier = OkHostnameVerifier.INSTANCE;
        }
        if (okHttpClient.certificatePinner == null) {
            okHttpClient.certificatePinner = CertificatePinner.DEFAULT;
        }
        if (okHttpClient.authenticator == null) {
            okHttpClient.authenticator = AuthenticatorAdapter.INSTANCE;
        }
        if (okHttpClient.connectionPool == null) {
            okHttpClient.connectionPool = ConnectionPool.getDefault();
        }
        if (okHttpClient.protocols == null) {
            okHttpClient.protocols = DEFAULT_PROTOCOLS;
        }
        if (okHttpClient.connectionSpecs == null) {
            okHttpClient.connectionSpecs = DEFAULT_CONNECTION_SPECS;
        }
        if (okHttpClient.network == null) {
            okHttpClient.network = Network.DEFAULT;
        }
        return okHttpClient;
    }

    private synchronized SSLSocketFactory getDefaultSSLSocketFactory() {
        if (defaultSslSocketFactory == null) {
            try {
                SSLContext instance = SSLContext.getInstance(org.apache.http.conn.ssl.SSLSocketFactory.TLS);
                instance.init(null, null, null);
                defaultSslSocketFactory = instance.getSocketFactory();
            } catch (GeneralSecurityException e) {
                throw new AssertionError();
            }
        }
        return defaultSslSocketFactory;
    }

    public final OkHttpClient clone() {
        try {
            return (OkHttpClient) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
