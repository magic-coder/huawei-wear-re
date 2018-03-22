package com.p252d.p253a.p254a;

import org.apache.http.client.methods.HttpUriRequest;

/* compiled from: RangeFileAsyncHttpResponseHandler */
public abstract class C3559p extends C3552i {
    private long f13566b;
    private boolean f13567c;

    public void m17885a(HttpUriRequest httpUriRequest) {
        if (this.a.exists() && this.a.canWrite()) {
            this.f13566b = this.a.length();
        }
        if (this.f13566b > 0) {
            this.f13567c = true;
            httpUriRequest.setHeader("Range", "bytes=" + this.f13566b + "-");
        }
    }
}
