package com.p230a.p231b.p232b.p233a.p236a;

import java.io.FilterInputStream;
import java.io.InputStream;

final class C3100n extends FilterInputStream {
    private int f10395a;

    private C3100n(InputStream inputStream) {
        super(inputStream);
        this.f10395a = 0;
    }

    public final int read() {
        int read = super.read();
        if (read != -1) {
            this.f10395a++;
        }
        return read;
    }

    public final int read(byte[] bArr, int i, int i2) {
        int read = super.read(bArr, i, i2);
        if (read != -1) {
            this.f10395a += read;
        }
        return read;
    }
}
