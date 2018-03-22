package com.huawei.phoneserviceuni.common.p132d;

import android.text.TextUtils;
import com.huawei.phoneserviceuni.common.d.c;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PushbackInputStream;

/* compiled from: IoUtils */
public class C5767b {
    public static void m26475a(InputStream inputStream, String str) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeInputStream IOException");
            }
        }
    }

    public static void m26476a(OutputStream outputStream, String str) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeOutputStream IOException");
            }
        }
    }

    public static void m26472a(DataOutputStream dataOutputStream, String str) {
        if (dataOutputStream != null) {
            try {
                dataOutputStream.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeDataOutputStream IOException");
            }
        }
    }

    public static void m26473a(FileInputStream fileInputStream, String str) {
        if (fileInputStream != null) {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeFileInputStream IOException");
            }
        }
    }

    public static void m26474a(FileOutputStream fileOutputStream, String str) {
        if (fileOutputStream != null) {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeFileOutputStream IOException");
            }
        }
    }

    public static void m26477a(OutputStreamWriter outputStreamWriter, String str) {
        if (outputStreamWriter != null) {
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                c.d("IoUtils", "closeOutputStreamWriter IOException");
            }
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String m26471a(java.io.InputStream r5) {
        /*
        r0 = 0;
        if (r5 != 0) goto L_0x0004;
    L_0x0003:
        return r0;
    L_0x0004:
        r1 = new java.io.ByteArrayOutputStream;
        r1.<init>();
        r2 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r2 = new byte[r2];
    L_0x000d:
        r3 = r5.read(r2);	 Catch:{ IOException -> 0x0019 }
        r4 = -1;
        if (r3 == r4) goto L_0x002e;
    L_0x0014:
        r4 = 0;
        r1.write(r2, r4, r3);	 Catch:{ IOException -> 0x0019 }
        goto L_0x000d;
    L_0x0019:
        r2 = move-exception;
        r2 = "IoUtils";
        r3 = "readStream io error";
        com.huawei.phoneserviceuni.common.d.c.d(r2, r3);	 Catch:{ all -> 0x0041 }
        r1.close();	 Catch:{ IOException -> 0x0025 }
        goto L_0x0003;
    L_0x0025:
        r1 = move-exception;
        r1 = "IoUtils";
        r2 = "close io error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);
        goto L_0x0003;
    L_0x002e:
        r2 = "UTF-8";
        r0 = r1.toString(r2);	 Catch:{ IOException -> 0x0019 }
        r1.close();	 Catch:{ IOException -> 0x0038 }
        goto L_0x0003;
    L_0x0038:
        r1 = move-exception;
        r1 = "IoUtils";
        r2 = "close io error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);
        goto L_0x0003;
    L_0x0041:
        r0 = move-exception;
        r1.close();	 Catch:{ IOException -> 0x0046 }
    L_0x0045:
        throw r0;
    L_0x0046:
        r1 = move-exception;
        r1 = "IoUtils";
        r2 = "close io error";
        com.huawei.phoneserviceuni.common.d.c.d(r1, r2);
        goto L_0x0045;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneserviceuni.common.d.b.a(java.io.InputStream):java.lang.String");
    }

    public static boolean m26478a(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                return file.delete();
            }
        }
        return false;
    }

    public static InputStream m26479b(InputStream inputStream) {
        InputStream pushbackInputStream = new PushbackInputStream(inputStream);
        int read = pushbackInputStream.read();
        if (read != 239) {
            pushbackInputStream.unread(read);
        } else {
            read = pushbackInputStream.read();
            if (read != 187) {
                pushbackInputStream.unread(read);
                pushbackInputStream.unread(239);
            } else if (pushbackInputStream.read() != 191) {
                throw new IOException("error file");
            }
        }
        return pushbackInputStream;
    }
}
