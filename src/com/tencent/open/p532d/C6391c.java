package com.tencent.open.p532d;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.ProtocolException;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Properties;

/* compiled from: ProGuard */
class C6391c {
    Properties f22218a;
    byte[] f22219b;

    private C6391c() {
        this.f22218a = new Properties();
    }

    void m29175a(byte[] bArr) throws IOException {
        if (bArr != null) {
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int length = C6389a.f22212b.m29173a().length;
            byte[] bArr2 = new byte[length];
            wrap.get(bArr2);
            if (!C6389a.f22212b.equals(new ac(bArr2))) {
                throw new ProtocolException("unknow protocl [" + Arrays.toString(bArr) + "]");
            } else if (bArr.length - length > 2) {
                bArr2 = new byte[2];
                wrap.get(bArr2);
                int b = new ac(bArr2).m29174b();
                if ((bArr.length - length) - 2 >= b) {
                    byte[] bArr3 = new byte[b];
                    wrap.get(bArr3);
                    this.f22218a.load(new ByteArrayInputStream(bArr3));
                    length = ((bArr.length - length) - b) - 2;
                    if (length > 0) {
                        this.f22219b = new byte[length];
                        wrap.get(this.f22219b);
                    }
                }
            }
        }
    }

    public String toString() {
        return "ApkExternalInfo [p=" + this.f22218a + ", otherData=" + Arrays.toString(this.f22219b) + "]";
    }
}
