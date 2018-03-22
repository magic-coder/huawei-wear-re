package com.huawei.appmarket.sdk.service.download.bean;

import com.huawei.appmarket.sdk.service.p374d.p375a.C4306a;
import java.io.Serializable;

public class C4310a extends C4306a implements Serializable {
    public long f16033a;
    public long f16034b;
    long f16035c = 0;
    String f16036d;
    String f16037e;

    public long m20779a() {
        return this.f16035c;
    }

    public void m20780a(long j) {
        this.f16035c = j;
    }

    public String m20781b() {
        return this.f16036d;
    }

    public String toString() {
        return "DownloadChkInfo [hash_=" + this.f16036d + ", slice_=" + this.f16037e + ", start=" + this.f16033a + ", end=" + this.f16034b + ", status=" + this.f16035c;
    }
}
