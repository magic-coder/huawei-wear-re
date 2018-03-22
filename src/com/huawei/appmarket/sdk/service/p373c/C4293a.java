package com.huawei.appmarket.sdk.service.p373c;

import org.apache.http.ConnectionReuseStrategy;
import org.apache.http.client.AuthenticationHandler;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.RedirectHandler;
import org.apache.http.client.RequestDirector;
import org.apache.http.client.UserTokenHandler;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.routing.HttpRoutePlanner;
import org.apache.http.impl.client.AbstractHttpClient;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.HttpProcessor;
import org.apache.http.protocol.HttpRequestExecutor;

public abstract class C4293a extends AbstractHttpClient {
    private ThreadLocal<C4294b> f15983a;

    protected C4293a(ClientConnectionManager clientConnectionManager, HttpParams httpParams, ThreadLocal<C4294b> threadLocal) {
        super(clientConnectionManager, httpParams);
        this.f15983a = threadLocal;
    }

    protected RequestDirector createClientRequestDirector(HttpRequestExecutor httpRequestExecutor, ClientConnectionManager clientConnectionManager, ConnectionReuseStrategy connectionReuseStrategy, ConnectionKeepAliveStrategy connectionKeepAliveStrategy, HttpRoutePlanner httpRoutePlanner, HttpProcessor httpProcessor, HttpRequestRetryHandler httpRequestRetryHandler, RedirectHandler redirectHandler, AuthenticationHandler authenticationHandler, AuthenticationHandler authenticationHandler2, UserTokenHandler userTokenHandler, HttpParams httpParams) {
        return new C4303k(httpRequestExecutor, clientConnectionManager, connectionReuseStrategy, connectionKeepAliveStrategy, httpRoutePlanner, httpProcessor, httpRequestRetryHandler, redirectHandler, authenticationHandler, authenticationHandler2, userTokenHandler, httpParams, this.f15983a);
    }
}
