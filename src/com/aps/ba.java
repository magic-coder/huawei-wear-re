package com.aps;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: DiskLruCache */
class ba extends FilterOutputStream {
    final /* synthetic */ az f13005a;

    private ba(az azVar, OutputStream outputStream) {
        this.f13005a = azVar;
        super(outputStream);
    }

    public void write(int i) {
        try {
            this.out.write(i);
        } catch (IOException e) {
            this.f13005a.f13003d = true;
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        try {
            this.out.write(bArr, i, i2);
        } catch (IOException e) {
            this.f13005a.f13003d = true;
        }
    }

    public void close() {
        try {
            this.out.close();
        } catch (IOException e) {
            this.f13005a.f13003d = true;
        }
    }

    public void flush() {
        try {
            this.out.flush();
        } catch (IOException e) {
            this.f13005a.f13003d = true;
        }
    }
}
