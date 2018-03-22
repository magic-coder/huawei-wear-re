package com.amap.api.mapcore.util;

import java.net.Proxy;

/* compiled from: DownloadManager */
public class dl {
    private dm f11722a;
    private dp f11723b;

    /* compiled from: DownloadManager */
    public interface C3272a {
        void mo3996a(Throwable th);

        void mo3997a(byte[] bArr, long j);

        void mo3998d();

        void mo3999e();
    }

    public dl(dp dpVar) {
        this(dpVar, 0, -1);
    }

    public dl(dp dpVar, long j, long j2) {
        Proxy proxy;
        this.f11723b = dpVar;
        if (dpVar.f11413i == null) {
            proxy = null;
        } else {
            proxy = dpVar.f11413i;
        }
        this.f11722a = new dm(this.f11723b.f11411g, this.f11723b.f11412h, proxy);
        this.f11722a.m16076b(j2);
        this.f11722a.m16074a(j);
    }

    public void m16065a(C3272a c3272a) {
        this.f11722a.m16075a(this.f11723b.mo4002a(), this.f11723b.mo4004c(), this.f11723b.mo4003b(), c3272a);
    }

    public void m16064a() {
        this.f11722a.m16073a();
    }
}
