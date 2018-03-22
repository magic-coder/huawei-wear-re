package com.amap.api.mapcore.util;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public class di implements Closeable {
    private final InputStream f11714a;
    private final Charset f11715b;
    private byte[] f11716c;
    private int f11717d;
    private int f11718e;

    public di(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public di(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(dj.f11719a)) {
            this.f11714a = inputStream;
            this.f11715b = charset;
            this.f11716c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f11714a) {
            if (this.f11716c != null) {
                this.f11716c = null;
                this.f11714a.close();
            }
        }
    }

    public String m16056a() throws IOException {
        String str;
        synchronized (this.f11714a) {
            if (this.f11716c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f11717d >= this.f11718e) {
                m16055b();
            }
            int i2 = this.f11717d;
            while (i2 != this.f11718e) {
                if (this.f11716c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f11717d || this.f11716c[i2 - 1] != TagName.PAY_CHANNEL) ? i2 : i2 - 1;
                    str = new String(this.f11716c, this.f11717d, i3 - this.f11717d, this.f11715b.name());
                    this.f11717d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c33151 = new ByteArrayOutputStream(this, (this.f11718e - this.f11717d) + 80) {
                final /* synthetic */ di f11713a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != TagName.PAY_CHANNEL) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f11713a.f11715b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c33151.write(this.f11716c, this.f11717d, this.f11718e - this.f11717d);
                this.f11718e = -1;
                m16055b();
                i = this.f11717d;
                while (i != this.f11718e) {
                    if (this.f11716c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f11717d) {
                c33151.write(this.f11716c, this.f11717d, i - this.f11717d);
            }
            this.f11717d = i + 1;
            str = c33151.toString();
        }
        return str;
    }

    private void m16055b() throws IOException {
        int read = this.f11714a.read(this.f11716c, 0, this.f11716c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f11717d = 0;
        this.f11718e = read;
    }
}
