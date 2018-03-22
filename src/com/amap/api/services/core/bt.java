package com.amap.api.services.core;

import java.util.Map;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;

/* compiled from: Request */
public abstract class bt {
    int f12298e = 20000;
    int f12299f = 20000;
    HttpHost f12300g = null;

    public abstract String mo4103b();

    public abstract Map<String, String> c_();

    public abstract Map<String, String> d_();

    public abstract HttpEntity mo4099e();

    public final void m16565c(int i) {
        this.f12298e = i;
    }

    public final void m16566d(int i) {
        this.f12299f = i;
    }

    public byte[] e_() {
        return null;
    }

    public final void m16563a(HttpHost httpHost) {
        this.f12300g = httpHost;
    }
}
