package com.huawei.appmarket.sdk.service.p373c;

import org.apache.http.client.protocol.ClientContext;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.params.HttpParams;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.BasicHttpProcessor;
import org.apache.http.protocol.HttpContext;

class C4299f extends C4298i {
    final /* synthetic */ C4297e f16006a;

    C4299f(C4297e c4297e, ClientConnectionManager clientConnectionManager, HttpParams httpParams, ThreadLocal threadLocal) {
        this.f16006a = c4297e;
        super(clientConnectionManager, httpParams, threadLocal);
    }

    protected HttpContext createHttpContext() {
        HttpContext basicHttpContext = new BasicHttpContext();
        basicHttpContext.setAttribute(ClientContext.AUTHSCHEME_REGISTRY, getAuthSchemes());
        basicHttpContext.setAttribute(ClientContext.COOKIESPEC_REGISTRY, getCookieSpecs());
        basicHttpContext.setAttribute(ClientContext.CREDS_PROVIDER, getCredentialsProvider());
        return basicHttpContext;
    }

    protected BasicHttpProcessor createHttpProcessor() {
        BasicHttpProcessor createHttpProcessor = super.createHttpProcessor();
        createHttpProcessor.addRequestInterceptor(new C4300g(this.f16006a));
        return createHttpProcessor;
    }
}
