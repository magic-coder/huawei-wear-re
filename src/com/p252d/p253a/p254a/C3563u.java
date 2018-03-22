package com.p252d.p253a.p254a;

import android.content.Context;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;

/* compiled from: SyncHttpClient */
public class C3563u extends C3543a {
    public C3563u() {
        super(false, 80, 443);
    }

    public C3563u(SchemeRegistry schemeRegistry) {
        super(schemeRegistry);
    }

    protected C3560q mo4214b(DefaultHttpClient defaultHttpClient, HttpContext httpContext, HttpUriRequest httpUriRequest, String str, C3549s c3549s, Context context) {
        if (str != null) {
            httpUriRequest.addHeader("Content-Type", str);
        }
        c3549s.mo4190a(true);
        m17805a(defaultHttpClient, httpContext, httpUriRequest, str, c3549s, context).run();
        return new C3560q(null);
    }
}
