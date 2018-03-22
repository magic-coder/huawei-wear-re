package com.huawei.hihealth.p394c;

import android.content.Context;
import com.huawei.p190v.C2538c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.FileInputStream;
import java.io.IOException;

/* compiled from: HiFileUtil */
public class C4542d {
    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static boolean m21776a(android.content.Context r8, java.lang.String r9, java.lang.String r10) {
        /*
        r5 = 2;
        r0 = 1;
        r1 = 0;
        if (r10 == 0) goto L_0x0009;
    L_0x0005:
        if (r9 == 0) goto L_0x0009;
    L_0x0007:
        if (r8 != 0) goto L_0x000b;
    L_0x0009:
        r0 = r1;
    L_0x000a:
        return r0;
    L_0x000b:
        r2 = 0;
        r3 = 0;
        r2 = r8.openFileOutput(r10, r3);	 Catch:{ IOException -> 0x0034, Exception -> 0x0050, all -> 0x006c }
        r3 = "UTF-8";
        r3 = r9.getBytes(r3);	 Catch:{ IOException -> 0x0034, Exception -> 0x0050, all -> 0x008a }
        r2.write(r3);	 Catch:{ IOException -> 0x0034, Exception -> 0x0050, all -> 0x008a }
        if (r2 == 0) goto L_0x000a;
    L_0x001c:
        r2.close();	 Catch:{ IOException -> 0x0020 }
        goto L_0x000a;
    L_0x0020:
        r2 = move-exception;
        r3 = "Debug_HiFileUtil";
        r4 = new java.lang.Object[r5];
        r5 = "writeDataToFile fout close error = ";
        r4[r1] = r5;
        r1 = r2.getMessage();
        r4[r0] = r1;
        com.huawei.v.c.e(r3, r4);
        goto L_0x000a;
    L_0x0034:
        r3 = move-exception;
        if (r2 == 0) goto L_0x003a;
    L_0x0037:
        r2.close();	 Catch:{ IOException -> 0x003c }
    L_0x003a:
        r0 = r1;
        goto L_0x000a;
    L_0x003c:
        r2 = move-exception;
        r3 = "Debug_HiFileUtil";
        r4 = new java.lang.Object[r5];
        r5 = "writeDataToFile fout close error = ";
        r4[r1] = r5;
        r2 = r2.getMessage();
        r4[r0] = r2;
        com.huawei.v.c.e(r3, r4);
        goto L_0x003a;
    L_0x0050:
        r3 = move-exception;
        if (r2 == 0) goto L_0x0056;
    L_0x0053:
        r2.close();	 Catch:{ IOException -> 0x0058 }
    L_0x0056:
        r0 = r1;
        goto L_0x000a;
    L_0x0058:
        r2 = move-exception;
        r3 = "Debug_HiFileUtil";
        r4 = new java.lang.Object[r5];
        r5 = "writeDataToFile fout close error = ";
        r4[r1] = r5;
        r2 = r2.getMessage();
        r4[r0] = r2;
        com.huawei.v.c.e(r3, r4);
        goto L_0x0056;
    L_0x006c:
        r3 = move-exception;
        r7 = r3;
        r3 = r2;
        r2 = r7;
    L_0x0070:
        if (r3 == 0) goto L_0x0075;
    L_0x0072:
        r3.close();	 Catch:{ IOException -> 0x0076 }
    L_0x0075:
        throw r2;
    L_0x0076:
        r3 = move-exception;
        r4 = "Debug_HiFileUtil";
        r5 = new java.lang.Object[r5];
        r6 = "writeDataToFile fout close error = ";
        r5[r1] = r6;
        r1 = r3.getMessage();
        r5[r0] = r1;
        com.huawei.v.c.e(r4, r5);
        goto L_0x0075;
    L_0x008a:
        r3 = move-exception;
        r7 = r3;
        r3 = r2;
        r2 = r7;
        goto L_0x0070;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hihealth.c.d.a(android.content.Context, java.lang.String, java.lang.String):boolean");
    }

    public static String m21775a(Context context, String str) {
        FileInputStream openFileInput;
        IOException e;
        Throwable th;
        if (str == null || context == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        try {
            openFileInput = context.openFileInput(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = openFileInput.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    stringBuilder.append(new String(bArr, 0, read, GameManager.DEFAULT_CHARSET));
                }
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException e2) {
                        C2538c.e("Debug_HiFileUtil", new Object[]{"readFiletoData final IOException = ", e2.getMessage()});
                    }
                }
            } catch (IOException e3) {
                e2 = e3;
                try {
                    C2538c.e("Debug_HiFileUtil", new Object[]{"readFiletoData IOException = ", e2.getMessage()});
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e22) {
                            C2538c.e("Debug_HiFileUtil", new Object[]{"readFiletoData final IOException = ", e22.getMessage()});
                        }
                    }
                    return stringBuilder.toString();
                } catch (Throwable th2) {
                    th = th2;
                    if (openFileInput != null) {
                        try {
                            openFileInput.close();
                        } catch (IOException e4) {
                            C2538c.e("Debug_HiFileUtil", new Object[]{"readFiletoData final IOException = ", e4.getMessage()});
                        }
                    }
                    throw th;
                }
            }
        } catch (IOException e42) {
            IOException iOException = e42;
            openFileInput = null;
            e22 = iOException;
            C2538c.e("Debug_HiFileUtil", new Object[]{"readFiletoData IOException = ", e22.getMessage()});
            if (openFileInput != null) {
                openFileInput.close();
            }
            return stringBuilder.toString();
        } catch (Throwable th3) {
            Throwable th4 = th3;
            openFileInput = null;
            th = th4;
            if (openFileInput != null) {
                openFileInput.close();
            }
            throw th;
        }
        return stringBuilder.toString();
    }
}
