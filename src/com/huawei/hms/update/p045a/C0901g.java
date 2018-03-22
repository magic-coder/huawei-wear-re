package com.huawei.hms.update.p045a;

import java.io.File;
import java.io.IOException;

/* compiled from: OtaUpdateDownload */
class C0901g extends C0900h {
    final /* synthetic */ int f1479a;
    final /* synthetic */ C0899f f1480b;
    private long f1481c = 0;
    private int f1482d = this.f1480b.f1477e.m3133b();

    C0901g(C0899f c0899f, File file, int i, int i2) {
        this.f1480b = c0899f;
        this.f1479a = i2;
        super(file, i);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        super.write(bArr, i, i2);
        this.f1482d += i2;
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f1481c) > 1000) {
            this.f1481c = currentTimeMillis;
            m3163a(this.f1482d);
        }
        if (this.f1482d == this.f1479a) {
            m3163a(this.f1482d);
        }
    }

    private void m3163a(int i) {
        this.f1480b.f1477e.m3131a(this.f1480b.mo2264a(), i);
        this.f1480b.m3153a(2100, i, this.f1479a);
    }
}
