package com.aps;

import java.io.Closeable;
import java.io.InputStream;

/* compiled from: DiskLruCache */
public final class bc implements Closeable {
    final /* synthetic */ ay f13012a;
    private final String f13013b;
    private final long f13014c;
    private final InputStream[] f13015d;
    private final long[] f13016e;

    private bc(ay ayVar, String str, long j, InputStream[] inputStreamArr, long[] jArr) {
        this.f13012a = ayVar;
        this.f13013b = str;
        this.f13014c = j;
        this.f13015d = inputStreamArr;
        this.f13016e = jArr;
    }

    public InputStream m17403a(int i) {
        return this.f13015d[i];
    }

    public void close() {
        for (Closeable a : this.f13015d) {
            bt.m17445a(a);
        }
    }
}
