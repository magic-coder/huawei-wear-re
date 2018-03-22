package com.aps;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* compiled from: SimpleDiskCache */
class bp extends FilterOutputStream {
    private final az f13060a;
    private boolean f13061b;

    private bp(OutputStream outputStream, az azVar) {
        super(outputStream);
        this.f13061b = false;
        this.f13060a = azVar;
    }

    public void close() throws IOException {
        IOException iOException = null;
        try {
            super.close();
        } catch (IOException e) {
            iOException = e;
        }
        if (this.f13061b) {
            this.f13060a.m17387b();
        } else {
            this.f13060a.m17386a();
        }
        if (iOException != null) {
            throw iOException;
        }
    }

    public void flush() throws IOException {
        try {
            super.flush();
        } catch (IOException e) {
            this.f13061b = true;
            throw e;
        }
    }

    public void write(int i) throws IOException {
        try {
            super.write(i);
        } catch (IOException e) {
            this.f13061b = true;
            throw e;
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            super.write(bArr);
        } catch (IOException e) {
            this.f13061b = true;
            throw e;
        }
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        try {
            super.write(bArr, i, i2);
        } catch (IOException e) {
            this.f13061b = true;
            throw e;
        }
    }
}
