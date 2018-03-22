package com.p230a.p231b.p237c;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.zip.GZIPInputStream;

public class C3128a {
    public static byte[] m13931a(byte[] bArr) {
        byte[] bArr2;
        Exception e;
        try {
            InputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(new BufferedInputStream(byteArrayInputStream));
            bArr2 = new byte[1024];
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            while (true) {
                int read = gZIPInputStream.read(bArr2, 0, bArr2.length);
                if (read == -1) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            bArr2 = byteArrayOutputStream.toByteArray();
            try {
                byteArrayOutputStream.flush();
                byteArrayOutputStream.close();
                gZIPInputStream.close();
                byteArrayInputStream.close();
            } catch (Exception e2) {
                e = e2;
                e.printStackTrace();
                return bArr2;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            bArr2 = null;
            e = exception;
        }
        return bArr2;
    }
}
