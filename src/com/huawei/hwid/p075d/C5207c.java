package com.huawei.hwid.p075d;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/* compiled from: IOUtils */
public final class C5207c {
    public static void m25333a(InputStream inputStream) {
        C5207c.m25332a((Closeable) inputStream);
    }

    public static void m25334a(OutputStream outputStream) {
        C5207c.m25332a((Closeable) outputStream);
    }

    public static void m25332a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C5165e.m24910d("IOUtils", "An exception occurred while closing the 'Closeable' object.");
            }
        }
    }

    public static InputStream m25331a(byte[] bArr) throws IOException {
        return new ByteArrayInputStream(bArr);
    }
}
