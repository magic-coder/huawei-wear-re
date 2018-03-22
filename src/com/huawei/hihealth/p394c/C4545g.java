package com.huawei.hihealth.p394c;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/* compiled from: HiZipUtil */
public class C4545g {
    public static String m21790a(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        gZIPOutputStream.write(str.getBytes("utf-8"));
        gZIPOutputStream.close();
        return byteArrayOutputStream.toString("ISO-8859-1");
    }

    public static String m21791b(String str) throws IOException {
        if (str == null || str.length() == 0) {
            return str;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(str.getBytes("ISO-8859-1")));
        byte[] bArr = new byte[256];
        while (true) {
            int read = gZIPInputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                gZIPInputStream.close();
                return byteArrayOutputStream.toString("utf-8");
            }
        }
    }
}
