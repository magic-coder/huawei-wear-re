package com.huawei.hwdevicemgr.dmsdatatype.datatype;

import com.huawei.hwcommonmodel.C0973a;

/* compiled from: OTAUtil */
public class C5007k {
    public static long m24047a(String str) {
        byte[] b = C5007k.m24049b(str);
        if (b != null) {
            return C5007k.m24048a(b);
        }
        return 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static byte[] m24049b(java.lang.String r5) {
        /*
        r0 = 0;
        r1 = new java.io.File;
        r1.<init>(r5);
        r2 = r1.length();
        r1 = (int) r2;
        if (r1 == 0) goto L_0x0022;
    L_0x000d:
        r2 = new byte[r1];
        r1 = new java.io.FileInputStream;	 Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x002e, all -> 0x0039 }
        r1.<init>(r5);	 Catch:{ FileNotFoundException -> 0x0023, IOException -> 0x002e, all -> 0x0039 }
        r3 = r1.read(r2);	 Catch:{ FileNotFoundException -> 0x004e, IOException -> 0x0049, all -> 0x0047 }
        if (r3 >= 0) goto L_0x0053;
    L_0x001a:
        r1.close();	 Catch:{ FileNotFoundException -> 0x0051, IOException -> 0x004c, all -> 0x0047 }
        if (r1 == 0) goto L_0x0022;
    L_0x001f:
        r1.close();	 Catch:{ IOException -> 0x0043 }
    L_0x0022:
        return r0;
    L_0x0023:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0026:
        if (r1 == 0) goto L_0x0022;
    L_0x0028:
        r1.close();	 Catch:{ IOException -> 0x002c }
        goto L_0x0022;
    L_0x002c:
        r1 = move-exception;
        goto L_0x0022;
    L_0x002e:
        r1 = move-exception;
        r1 = r0;
        r0 = r2;
    L_0x0031:
        if (r1 == 0) goto L_0x0022;
    L_0x0033:
        r1.close();	 Catch:{ IOException -> 0x0037 }
        goto L_0x0022;
    L_0x0037:
        r1 = move-exception;
        goto L_0x0022;
    L_0x0039:
        r1 = move-exception;
        r4 = r1;
        r1 = r0;
        r0 = r4;
    L_0x003d:
        if (r1 == 0) goto L_0x0042;
    L_0x003f:
        r1.close();	 Catch:{ IOException -> 0x0045 }
    L_0x0042:
        throw r0;
    L_0x0043:
        r1 = move-exception;
        goto L_0x0022;
    L_0x0045:
        r1 = move-exception;
        goto L_0x0042;
    L_0x0047:
        r0 = move-exception;
        goto L_0x003d;
    L_0x0049:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0031;
    L_0x004c:
        r2 = move-exception;
        goto L_0x0031;
    L_0x004e:
        r0 = move-exception;
        r0 = r2;
        goto L_0x0026;
    L_0x0051:
        r2 = move-exception;
        goto L_0x0026;
    L_0x0053:
        r0 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hwdevicemgr.dmsdatatype.datatype.k.b(java.lang.String):byte[]");
    }

    private static long m24048a(byte[] bArr) {
        return Long.parseLong(C0973a.a(bArr[7]) + C0973a.a(bArr[6]) + C0973a.a(bArr[5]) + C0973a.a(bArr[4]), 16) + 256;
    }
}
