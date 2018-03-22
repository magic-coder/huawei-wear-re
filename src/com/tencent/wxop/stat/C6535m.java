package com.tencent.wxop.stat;

import org.apache.http.HttpResponse;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.protocol.HttpContext;

final class C6535m extends DefaultConnectionKeepAliveStrategy {
    final /* synthetic */ C6534l f22765a;

    C6535m(C6534l c6534l) {
        this.f22765a = c6534l;
    }

    public final long getKeepAliveDuration(HttpResponse httpResponse, HttpContext httpContext) {
        long keepAliveDuration = super.getKeepAliveDuration(httpResponse, httpContext);
        return keepAliveDuration == -1 ? StatisticConfig.MIN_UPLOAD_INTERVAL : keepAliveDuration;
    }
}
