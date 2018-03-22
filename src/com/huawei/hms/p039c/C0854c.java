package com.huawei.hms.p039c;

import com.huawei.hms.support.log.C0887a;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IOUtils */
public final class C0854c {
    public static void m3009a(InputStream inputStream) {
        C0854c.m3008a((Closeable) inputStream);
    }

    public static void m3010a(OutputStream outputStream) {
        C0854c.m3008a((Closeable) outputStream);
    }

    public static void m3008a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C0887a.m3098d("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static InputStream m3007a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }
}
