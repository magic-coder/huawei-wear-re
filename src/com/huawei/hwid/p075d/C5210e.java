package com.huawei.hwid.p075d;

import com.huawei.hwid.core.p435d.p437b.C5165e;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: SHA256 */
public final class C5210e {
    public static byte[] m25343a(byte[] bArr) {
        try {
            return MessageDigest.getInstance("SHA-256").digest(bArr);
        } catch (NoSuchAlgorithmException e) {
            C5165e.m24910d("SHA256", "NoSuchAlgorithmException" + e.getMessage());
            return new byte[0];
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] m25342a(java.io.File r8) {
        /*
        r2 = 0;
        r0 = 0;
        r1 = "SHA-256";
        r3 = java.security.MessageDigest.getInstance(r1);	 Catch:{ NoSuchAlgorithmException -> 0x004c, IOException -> 0x0050, all -> 0x0042 }
        r1 = new java.io.BufferedInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x004c, IOException -> 0x0052, all -> 0x0042 }
        r4 = new java.io.FileInputStream;	 Catch:{ NoSuchAlgorithmException -> 0x004c, IOException -> 0x0054, all -> 0x0042 }
        r4.<init>(r8);	 Catch:{ NoSuchAlgorithmException -> 0x004c, IOException -> 0x0056, all -> 0x0042 }
        r1.<init>(r4);	 Catch:{ NoSuchAlgorithmException -> 0x004c, IOException -> 0x0058, all -> 0x0042 }
        r0 = 4096; // 0x1000 float:5.74E-42 double:2.0237E-320;
        r4 = new byte[r0];	 Catch:{ NoSuchAlgorithmException -> 0x0024, IOException -> 0x005a }
        r0 = r2;
    L_0x0017:
        r5 = r1.read(r4);	 Catch:{ NoSuchAlgorithmException -> 0x0024, IOException -> 0x005d }
        r6 = -1;
        if (r5 == r6) goto L_0x0034;
    L_0x001e:
        r0 = r0 + r5;
        r6 = 0;
        r3.update(r4, r6, r5);	 Catch:{ NoSuchAlgorithmException -> 0x0024, IOException -> 0x0060 }
        goto L_0x0017;
    L_0x0024:
        r0 = move-exception;
        r0 = r1;
    L_0x0026:
        r1 = r0;
        r0 = "SHA256";
        r3 = "An exception occurred while computing file 'SHA-256'.";
        com.huawei.hwid.core.p435d.p437b.C5165e.m24910d(r0, r3);	 Catch:{ all -> 0x004a }
        com.huawei.hwid.p075d.C5207c.m25333a(r1);
    L_0x0031:
        r0 = new byte[r2];
    L_0x0033:
        return r0;
    L_0x0034:
        if (r0 <= 0) goto L_0x003e;
    L_0x0036:
        r0 = r3.digest();	 Catch:{ NoSuchAlgorithmException -> 0x0024, IOException -> 0x0063 }
        com.huawei.hwid.p075d.C5207c.m25333a(r1);
        goto L_0x0033;
    L_0x003e:
        com.huawei.hwid.p075d.C5207c.m25333a(r1);
        goto L_0x0031;
    L_0x0042:
        r1 = move-exception;
        r7 = r1;
        r1 = r0;
        r0 = r7;
    L_0x0046:
        com.huawei.hwid.p075d.C5207c.m25333a(r1);
        throw r0;
    L_0x004a:
        r0 = move-exception;
        goto L_0x0046;
    L_0x004c:
        r1 = move-exception;
        goto L_0x0026;
    L_0x004e:
        r1 = move-exception;
        goto L_0x0026;
    L_0x0050:
        r1 = move-exception;
        goto L_0x0026;
    L_0x0052:
        r1 = move-exception;
        goto L_0x0026;
    L_0x0054:
        r1 = move-exception;
        goto L_0x0026;
    L_0x0056:
        r1 = move-exception;
        goto L_0x0026;
    L_0x0058:
        r1 = move-exception;
        goto L_0x0026;
    L_0x005a:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0026;
    L_0x005d:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0026;
    L_0x0060:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0026;
    L_0x0063:
        r0 = move-exception;
        r0 = r1;
        goto L_0x0026;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwid.d.e.a(java.io.File):byte[]");
    }
}
