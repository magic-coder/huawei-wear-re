package com.p252d.p253a.p254a;

import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpClient */
class C3544b implements HttpRequestInterceptor {
    final /* synthetic */ C3543a f13536a;

    C3544b(C3543a c3543a) {
        this.f13536a = c3543a;
    }

    public void process(HttpRequest httpRequest, HttpContext httpContext) {
        if (!httpRequest.containsHeader("Accept-Encoding")) {
            httpRequest.addHeader("Accept-Encoding", "gzip");
        }
        for (String str : this.f13536a.f13534i.keySet()) {
            if (httpRequest.containsHeader(str)) {
                C3543a.f13526a.mo4209b("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[]{str, this.f13536a.f13534i.get(str), r1.getName(), httpRequest.getFirstHeader(str).getValue()}));
                httpRequest.removeHeader(r1);
            }
            httpRequest.addHeader(str, (String) this.f13536a.f13534i.get(str));
        }
    }
}
