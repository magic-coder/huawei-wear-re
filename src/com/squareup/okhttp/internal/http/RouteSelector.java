package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.Address;
import com.squareup.okhttp.CertificatePinner;
import com.squareup.okhttp.Connection;
import com.squareup.okhttp.ConnectionPool;
import com.squareup.okhttp.ConnectionSpec;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Route;
import com.squareup.okhttp.internal.Internal;
import com.squareup.okhttp.internal.Network;
import com.squareup.okhttp.internal.RouteDatabase;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.URI;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocketFactory;
import org.apache.http.client.methods.HttpGet;

public final class RouteSelector {
    private final Address address;
    private final OkHttpClient client;
    private List<ConnectionSpec> connectionSpecs = Collections.emptyList();
    private List<InetSocketAddress> inetSocketAddresses = Collections.emptyList();
    private InetSocketAddress lastInetSocketAddress;
    private Proxy lastProxy;
    private ConnectionSpec lastSpec;
    private final Network network;
    private int nextInetSocketAddressIndex;
    private int nextProxyIndex;
    private int nextSpecIndex;
    private final ConnectionPool pool;
    private final List<Route> postponedRoutes = new ArrayList();
    private List<Proxy> proxies = Collections.emptyList();
    private final Request request;
    private final RouteDatabase routeDatabase;
    private final URI uri;

    private RouteSelector(Address address, URI uri, OkHttpClient okHttpClient, Request request) {
        this.address = address;
        this.uri = uri;
        this.client = okHttpClient;
        this.pool = okHttpClient.getConnectionPool();
        this.routeDatabase = Internal.instance.routeDatabase(okHttpClient);
        this.network = Internal.instance.network(okHttpClient);
        this.request = request;
        resetNextProxy(uri, address.getProxy());
    }

    public static RouteSelector get(Request request, OkHttpClient okHttpClient) throws IOException {
        CertificatePinner certificatePinner = null;
        String host = request.url().getHost();
        if (host == null || host.length() == 0) {
            throw new UnknownHostException(request.url().toString());
        }
        SSLSocketFactory sslSocketFactory;
        HostnameVerifier hostnameVerifier;
        if (request.isHttps()) {
            sslSocketFactory = okHttpClient.getSslSocketFactory();
            hostnameVerifier = okHttpClient.getHostnameVerifier();
            certificatePinner = okHttpClient.getCertificatePinner();
        } else {
            hostnameVerifier = null;
            sslSocketFactory = null;
        }
        return new RouteSelector(new Address(host, Util.getEffectivePort(request.url()), okHttpClient.getSocketFactory(), sslSocketFactory, hostnameVerifier, certificatePinner, okHttpClient.getAuthenticator(), okHttpClient.getProxy(), okHttpClient.getProtocols(), okHttpClient.getConnectionSpecs(), okHttpClient.getProxySelector()), request.uri(), okHttpClient, request);
    }

    public boolean hasNext() {
        return hasNextConnectionSpec() || hasNextInetSocketAddress() || hasNextProxy() || hasNextPostponed();
    }

    public Connection next(HttpEngine httpEngine) throws IOException {
        Connection nextUnconnected = nextUnconnected();
        Internal.instance.connectAndSetOwner(this.client, nextUnconnected, httpEngine, this.request);
        return nextUnconnected;
    }

    Connection nextUnconnected() throws IOException {
        while (true) {
            Connection connection = this.pool.get(this.address);
            if (connection == null) {
                break;
            } else if (this.request.method().equals(HttpGet.METHOD_NAME) || Internal.instance.isReadable(connection)) {
                return connection;
            } else {
                connection.getSocket().close();
            }
        }
        if (!hasNextConnectionSpec()) {
            if (!hasNextInetSocketAddress()) {
                if (hasNextProxy()) {
                    this.lastProxy = nextProxy();
                } else if (hasNextPostponed()) {
                    return new Connection(this.pool, nextPostponed());
                } else {
                    throw new NoSuchElementException();
                }
            }
            this.lastInetSocketAddress = nextInetSocketAddress();
        }
        this.lastSpec = nextConnectionSpec();
        Route route = new Route(this.address, this.lastProxy, this.lastInetSocketAddress, this.lastSpec, shouldSendTlsFallbackIndicator(this.lastSpec));
        if (!this.routeDatabase.shouldPostpone(route)) {
            return new Connection(this.pool, route);
        }
        this.postponedRoutes.add(route);
        return nextUnconnected();
    }

    private boolean shouldSendTlsFallbackIndicator(ConnectionSpec connectionSpec) {
        if (connectionSpec == this.connectionSpecs.get(0) || !connectionSpec.isTls()) {
            return false;
        }
        return true;
    }

    public void connectFailed(Connection connection, IOException iOException) {
        if (Internal.instance.recycleCount(connection) <= 0) {
            Route route = connection.getRoute();
            if (!(route.getProxy().type() == Type.DIRECT || this.address.getProxySelector() == null)) {
                this.address.getProxySelector().connectFailed(this.uri, route.getProxy().address(), iOException);
            }
            this.routeDatabase.failed(route);
            if (!(iOException instanceof SSLHandshakeException) && !(iOException instanceof SSLProtocolException)) {
                while (this.nextSpecIndex < this.connectionSpecs.size()) {
                    List list = this.connectionSpecs;
                    int i = this.nextSpecIndex;
                    this.nextSpecIndex = i + 1;
                    ConnectionSpec connectionSpec = (ConnectionSpec) list.get(i);
                    this.routeDatabase.failed(new Route(this.address, this.lastProxy, this.lastInetSocketAddress, connectionSpec, shouldSendTlsFallbackIndicator(connectionSpec)));
                }
            }
        }
    }

    private void resetNextProxy(URI uri, Proxy proxy) {
        if (proxy != null) {
            this.proxies = Collections.singletonList(proxy);
        } else {
            this.proxies = new ArrayList();
            Collection select = this.client.getProxySelector().select(uri);
            if (select != null) {
                this.proxies.addAll(select);
            }
            this.proxies.removeAll(Collections.singleton(Proxy.NO_PROXY));
            this.proxies.add(Proxy.NO_PROXY);
        }
        this.nextProxyIndex = 0;
    }

    private boolean hasNextProxy() {
        return this.nextProxyIndex < this.proxies.size();
    }

    private Proxy nextProxy() throws IOException {
        if (hasNextProxy()) {
            List list = this.proxies;
            int i = this.nextProxyIndex;
            this.nextProxyIndex = i + 1;
            Proxy proxy = (Proxy) list.get(i);
            resetNextInetSocketAddress(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted proxy configurations: " + this.proxies);
    }

    private void resetNextInetSocketAddress(Proxy proxy) throws UnknownHostException {
        int effectivePort;
        this.inetSocketAddresses = new ArrayList();
        String uriHost;
        if (proxy.type() == Type.DIRECT || proxy.type() == Type.SOCKS) {
            uriHost = this.address.getUriHost();
            effectivePort = Util.getEffectivePort(this.uri);
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                uriHost = getHostString(inetSocketAddress);
                effectivePort = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        for (InetAddress inetSocketAddress2 : this.network.resolveInetAddresses(r1)) {
            this.inetSocketAddresses.add(new InetSocketAddress(inetSocketAddress2, effectivePort));
        }
        this.nextInetSocketAddressIndex = 0;
    }

    static String getHostString(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    private boolean hasNextInetSocketAddress() {
        return this.nextInetSocketAddressIndex < this.inetSocketAddresses.size();
    }

    private InetSocketAddress nextInetSocketAddress() throws IOException {
        if (hasNextInetSocketAddress()) {
            List list = this.inetSocketAddresses;
            int i = this.nextInetSocketAddressIndex;
            this.nextInetSocketAddressIndex = i + 1;
            InetSocketAddress inetSocketAddress = (InetSocketAddress) list.get(i);
            resetConnectionSpecs();
            return inetSocketAddress;
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted inet socket addresses: " + this.inetSocketAddresses);
    }

    private void resetConnectionSpecs() {
        this.connectionSpecs = new ArrayList();
        List connectionSpecs = this.address.getConnectionSpecs();
        int size = connectionSpecs.size();
        for (int i = 0; i < size; i++) {
            ConnectionSpec connectionSpec = (ConnectionSpec) connectionSpecs.get(i);
            if (this.request.isHttps() == connectionSpec.isTls()) {
                this.connectionSpecs.add(connectionSpec);
            }
        }
        this.nextSpecIndex = 0;
    }

    private boolean hasNextConnectionSpec() {
        return this.nextSpecIndex < this.connectionSpecs.size();
    }

    private ConnectionSpec nextConnectionSpec() throws IOException {
        if (hasNextConnectionSpec()) {
            List list = this.connectionSpecs;
            int i = this.nextSpecIndex;
            this.nextSpecIndex = i + 1;
            return (ConnectionSpec) list.get(i);
        }
        throw new SocketException("No route to " + this.address.getUriHost() + "; exhausted connection specs: " + this.connectionSpecs);
    }

    private boolean hasNextPostponed() {
        return !this.postponedRoutes.isEmpty();
    }

    private Route nextPostponed() {
        return (Route) this.postponedRoutes.remove(0);
    }
}
