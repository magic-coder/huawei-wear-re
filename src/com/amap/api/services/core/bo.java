package com.amap.api.services.core;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
public class bo implements Closeable {
    private final InputStream f12456a;
    private final Charset f12457b;
    private byte[] f12458c;
    private int f12459d;
    private int f12460e;

    public bo(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public bo(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(bp.f12461a)) {
            this.f12456a = inputStream;
            this.f12457b = charset;
            this.f12458c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f12456a) {
            if (this.f12458c != null) {
                this.f12458c = null;
                this.f12456a.close();
            }
        }
    }

    public String m16844a() throws IOException {
        String str;
        synchronized (this.f12456a) {
            if (this.f12458c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f12459d >= this.f12460e) {
                m16843b();
            }
            int i2 = this.f12459d;
            while (i2 != this.f12460e) {
                if (this.f12458c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f12459d || this.f12458c[i2 - 1] != TagName.PAY_CHANNEL) ? i2 : i2 - 1;
                    str = new String(this.f12458c, this.f12459d, i3 - this.f12459d, this.f12457b.name());
                    this.f12459d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream c34051 = new ByteArrayOutputStream(this, (this.f12460e - this.f12459d) + 80) {
                final /* synthetic */ bo f12455a;

                public String toString() {
                    int i = (this.count <= 0 || this.buf[this.count - 1] != TagName.PAY_CHANNEL) ? this.count : this.count - 1;
                    try {
                        return new String(this.buf, 0, i, this.f12455a.f12457b.name());
                    } catch (UnsupportedEncodingException e) {
                        throw new AssertionError(e);
                    }
                }
            };
            loop1:
            while (true) {
                c34051.write(this.f12458c, this.f12459d, this.f12460e - this.f12459d);
                this.f12460e = -1;
                m16843b();
                i = this.f12459d;
                while (i != this.f12460e) {
                    if (this.f12458c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f12459d) {
                c34051.write(this.f12458c, this.f12459d, i - this.f12459d);
            }
            this.f12459d = i + 1;
            str = c34051.toString();
        }
        return str;
    }

    private void m16843b() throws IOException {
        int read = this.f12456a.read(this.f12458c, 0, this.f12458c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f12459d = 0;
        this.f12460e = read;
    }
}
