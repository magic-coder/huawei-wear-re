package com.huawei.p086k.p462a;

import com.huawei.p086k.p462a.p463a.C5405a;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;

/* compiled from: IOUtils */
public final class C5408c {
    public static void m25998a(InputStream inputStream) {
        C5408c.m25997a((Closeable) inputStream);
    }

    public static void m25997a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C5405a.m25989a("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static InputStream m25996a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }
}
