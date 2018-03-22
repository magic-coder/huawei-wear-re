package com.p252d.p253a.p254a;

import org.apache.http.Header;
import org.apache.http.HeaderElement;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpResponseInterceptor;
import org.apache.http.protocol.HttpContext;

/* compiled from: AsyncHttpClient */
class C3545c implements HttpResponseInterceptor {
    final /* synthetic */ C3543a f13537a;

    C3545c(C3543a c3543a) {
        this.f13537a = c3543a;
    }

    public void process(HttpResponse httpResponse, HttpContext httpContext) {
        HttpEntity entity = httpResponse.getEntity();
        if (entity != null) {
            Header contentEncoding = entity.getContentEncoding();
            if (contentEncoding != null) {
                for (HeaderElement name : contentEncoding.getElements()) {
                    if (name.getName().equalsIgnoreCase("gzip")) {
                        httpResponse.setEntity(new C3547e(entity));
                        return;
                    }
                }
            }
        }
    }
}
