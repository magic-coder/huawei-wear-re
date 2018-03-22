package com.p230a.p231b.p232b.p233a.p236a;

import java.io.ByteArrayOutputStream;

public class C3096j extends ByteArrayOutputStream {
    private final C3087b f10387a;

    public C3096j(C3087b c3087b, int i) {
        this.f10387a = c3087b;
        this.buf = this.f10387a.m13802a(Math.max(i, 256));
    }

    private void m13836a(int i) {
        if (this.count + i > this.buf.length) {
            Object a = this.f10387a.m13802a((this.count + i) << 1);
            System.arraycopy(this.buf, 0, a, 0, this.count);
            this.f10387a.m13801a(this.buf);
            this.buf = a;
        }
    }

    public void close() {
        this.f10387a.m13801a(this.buf);
        this.buf = null;
        super.close();
    }

    public void finalize() {
        this.f10387a.m13801a(this.buf);
    }

    public synchronized void write(int i) {
        m13836a(1);
        super.write(i);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        m13836a(i2);
        super.write(bArr, i, i2);
    }
}
