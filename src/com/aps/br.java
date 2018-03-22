package com.aps;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

/* compiled from: StrictLineReader */
class br implements Closeable {
    private final InputStream f13063a;
    private final Charset f13064b;
    private byte[] f13065c;
    private int f13066d;
    private int f13067e;

    public br(InputStream inputStream, Charset charset) {
        this(inputStream, 8192, charset);
    }

    public br(InputStream inputStream, int i, Charset charset) {
        if (inputStream == null || charset == null) {
            throw new NullPointerException();
        } else if (i < 0) {
            throw new IllegalArgumentException("capacity <= 0");
        } else if (charset.equals(bt.f13069a)) {
            this.f13063a = inputStream;
            this.f13064b = charset;
            this.f13065c = new byte[i];
        } else {
            throw new IllegalArgumentException("Unsupported encoding");
        }
    }

    public void close() throws IOException {
        synchronized (this.f13063a) {
            if (this.f13065c != null) {
                this.f13065c = null;
                this.f13063a.close();
            }
        }
    }

    public String m17444a() throws IOException {
        String str;
        synchronized (this.f13063a) {
            if (this.f13065c == null) {
                throw new IOException("LineReader is closed");
            }
            int i;
            if (this.f13066d >= this.f13067e) {
                m17443b();
            }
            int i2 = this.f13066d;
            while (i2 != this.f13067e) {
                if (this.f13065c[i2] == (byte) 10) {
                    int i3 = (i2 == this.f13066d || this.f13065c[i2 - 1] != TagName.PAY_CHANNEL) ? i2 : i2 - 1;
                    str = new String(this.f13065c, this.f13066d, i3 - this.f13066d, this.f13064b.name());
                    this.f13066d = i2 + 1;
                } else {
                    i2++;
                }
            }
            ByteArrayOutputStream bsVar = new bs(this, (this.f13067e - this.f13066d) + 80);
            loop1:
            while (true) {
                bsVar.write(this.f13065c, this.f13066d, this.f13067e - this.f13066d);
                this.f13067e = -1;
                m17443b();
                i = this.f13066d;
                while (i != this.f13067e) {
                    if (this.f13065c[i] == (byte) 10) {
                        break loop1;
                    }
                    i++;
                }
            }
            if (i != this.f13066d) {
                bsVar.write(this.f13065c, this.f13066d, i - this.f13066d);
            }
            this.f13066d = i + 1;
            str = bsVar.toString();
        }
        return str;
    }

    private void m17443b() throws IOException {
        int read = this.f13063a.read(this.f13065c, 0, this.f13065c.length);
        if (read == -1) {
            throw new EOFException();
        }
        this.f13066d = 0;
        this.f13067e = read;
    }
}
