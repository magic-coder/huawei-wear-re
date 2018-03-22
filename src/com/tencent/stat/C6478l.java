package com.tencent.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

class C6478l extends DefaultConnectionKeepAliveStrategy {
    final /* synthetic */ C6477k f22522a;

    C6478l(C6477k c6477k) {
        this.f22522a = c6477k;
    }

    public long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? 20000 : keepAliveDuration;
    }
}
