package com.google.android.gms.wearable.internal;

import com.google.android.gms.common.internal.C0424f;
import com.google.android.gms.wearable.C0530i;
import java.io.IOException;
import java.io.InputStream;

public final class du extends InputStream {
    private final InputStream f1050a;
    private volatile di f1051b;

    public du(InputStream inputStream) {
        this.f1050a = (InputStream) C0424f.m649a((Object) inputStream);
    }

    private int m2156a(int i) throws C0530i {
        if (i == -1) {
            di diVar = this.f1051b;
            if (diVar != null) {
                throw new C0530i("Channel closed unexpectedly before stream was finished", diVar.f1030a, diVar.f1031b);
            }
        }
        return i;
    }

    C0540d m2157a() {
        return new dv(this);
    }

    void m2158a(di diVar) {
        this.f1051b = (di) C0424f.m649a((Object) diVar);
    }

    public int available() throws IOException {
        return this.f1050a.available();
    }

    public void close() throws IOException {
        this.f1050a.close();
    }

    public void mark(int i) {
        this.f1050a.mark(i);
    }

    public boolean markSupported() {
        return this.f1050a.markSupported();
    }

    public int read() throws IOException {
        return m2156a(this.f1050a.read());
    }

    public int read(byte[] bArr) throws IOException {
        return m2156a(this.f1050a.read(bArr));
    }

    public int read(byte[] bArr, int i, int i2) throws IOException {
        return m2156a(this.f1050a.read(bArr, i, i2));
    }

    public void reset() throws IOException {
        this.f1050a.reset();
    }

    public long skip(long j) throws IOException {
        return this.f1050a.skip(j);
    }
}
