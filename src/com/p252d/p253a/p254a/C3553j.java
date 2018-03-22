package com.p252d.p253a.p254a;

import java.net.URI;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpGet;

/* compiled from: HttpGet */
public final class C3553j extends HttpEntityEnclosingRequestBase {
    public C3553j(String str) {
        setURI(URI.create(str));
    }

    public String getMethod() {
        return HttpGet.METHOD_NAME;
    }
}
