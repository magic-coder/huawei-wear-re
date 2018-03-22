package com.huawei.appmarket.sdk.service.p373c;

import java.io.IOException;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.protocol.HttpContext;

class C4300g implements HttpRequestInterceptor {
    final /* synthetic */ C4297e f16007a;

    private C4300g(C4297e c4297e) {
        this.f16007a = c4297e;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) throws HttpException, IOException {
        C4301h a = this.f16007a.f16005d;
        if (a != null && a.m20741a() && (httpRequest instanceof HttpUriRequest)) {
            a.m20740a(C4297e.m20737b((HttpUriRequest) httpRequest, false));
        }
    }
}
