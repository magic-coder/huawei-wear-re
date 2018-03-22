package com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a;

import android.content.Context;
import android.os.Environment;
import cn.com.fmsh.script.constants.ScriptToolsConst;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.huawei.phoneserviceuni.common.d.b;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
import com.huawei.phoneserviceuni.common.p132d.p133a.p134a.C1369a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AES */
public class C1370a {
    private static final byte[] f2953a = new byte[]{TagName.APK_SIZE, TagName.NOTICE_ID, TagName.NOTICE_TITLE, TagName.ACTIVITY_CODE_LIST, TagName.NOTICE_BODY, (byte) 53, TagName.NOTICE_START_TIME, TagName.NOTICE_END_TIME, ScriptToolsConst.TagName.TagSerial, ScriptToolsConst.TagName.TagApdu, TagName.MAIN_ORDER_LIST, TagName.OPERATE_TIMING, TagName.PAY_ORDER, TagName.PAY_ORDER_LIST, TagName.ORDER_TYPE, (byte) 102};

    public static File m6098a(File file, String str, boolean z, Context context) {
        File file2;
        InputStream inputStream;
        Throwable th;
        OutputStream outputStream = null;
        if (file == null || str == null || context == null) {
            return null;
        }
        File file3;
        String b = C1369a.m6095b(str);
        String str2 = "";
        if (z) {
            str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Huawei/";
            String str3 = str2 + "phoneservice/";
            C1373c.m6139b("AES", "firstfilePath" + str2);
            C1373c.m6139b("AES", "secondfilePath" + str3);
            if (!C1370a.m6101a(new File(str2))) {
                return null;
            }
            file2 = new File(str3);
            if (!C1370a.m6101a(file2)) {
                return null;
            }
            str2 = file2.getAbsolutePath() + "/" + file.getName();
            C1373c.m6139b("AES", "local_file" + str2);
        } else {
            file3 = new File(context.getFilesDir().getPath() + File.separator + "feedbackuploadlogs");
            if (!C1370a.m6101a(file3)) {
                return null;
            }
            str2 = file3.getAbsolutePath() + "/" + file.getName();
        }
        file3 = new File(str2);
        if (file3.exists()) {
            C1373c.m6139b("AES", "创建文件失败,需要创建的文件已存在");
            return file3;
        }
        InputStream fileInputStream;
        OutputStream fileOutputStream;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                C1373c.m6139b("AES", "encrypfile" + file3.getAbsolutePath());
                fileOutputStream = new FileOutputStream(file3);
                try {
                    byte[] bArr = new byte[1024];
                    while (true) {
                        int read = fileInputStream.read(bArr);
                        if (read <= 0) {
                            break;
                        }
                        byte[] a = C1370a.m6102a(bArr, 0, read, b);
                        if (a != null) {
                            fileOutputStream.write(a, 0, a.length);
                        }
                    }
                    b.a(fileInputStream, "AES");
                    b.a(fileOutputStream, "AES");
                    file2 = file3;
                } catch (FileNotFoundException e) {
                    inputStream = fileInputStream;
                    try {
                        C1373c.m6139b("AES", "FileNotFound");
                        b.a(inputStream, "AES");
                        b.a(fileOutputStream, "AES");
                        file2 = null;
                        if (file2 != null) {
                            return file2;
                        }
                        C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
                        return file2;
                    } catch (Throwable th2) {
                        fileInputStream = inputStream;
                        OutputStream outputStream2 = fileOutputStream;
                        th = th2;
                        outputStream = outputStream2;
                        b.a(fileInputStream, "AES");
                        b.a(outputStream, "AES");
                        throw th;
                    }
                } catch (IOException e2) {
                    try {
                        C1373c.m6139b("AES", "IOException");
                        b.a(fileInputStream, "AES");
                        b.a(fileOutputStream, "AES");
                        file2 = null;
                        if (file2 != null) {
                            return file2;
                        }
                        C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
                        return file2;
                    } catch (Throwable th22) {
                        Throwable th3 = th22;
                        outputStream = fileOutputStream;
                        th = th3;
                        b.a(fileInputStream, "AES");
                        b.a(outputStream, "AES");
                        throw th;
                    }
                }
            } catch (FileNotFoundException e3) {
                fileOutputStream = null;
                inputStream = fileInputStream;
                C1373c.m6139b("AES", "FileNotFound");
                b.a(inputStream, "AES");
                b.a(fileOutputStream, "AES");
                file2 = null;
                if (file2 != null) {
                    return file2;
                }
                C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
                return file2;
            } catch (IOException e4) {
                fileOutputStream = null;
                C1373c.m6139b("AES", "IOException");
                b.a(fileInputStream, "AES");
                b.a(fileOutputStream, "AES");
                file2 = null;
                if (file2 != null) {
                    return file2;
                }
                C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
                return file2;
            } catch (Throwable th4) {
                th = th4;
                b.a(fileInputStream, "AES");
                b.a(outputStream, "AES");
                throw th;
            }
        } catch (FileNotFoundException e5) {
            fileOutputStream = null;
            inputStream = null;
            C1373c.m6139b("AES", "FileNotFound");
            b.a(inputStream, "AES");
            b.a(fileOutputStream, "AES");
            file2 = null;
            if (file2 != null) {
                return file2;
            }
            C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
            return file2;
        } catch (IOException e6) {
            fileOutputStream = null;
            fileInputStream = null;
            C1373c.m6139b("AES", "IOException");
            b.a(fileInputStream, "AES");
            b.a(fileOutputStream, "AES");
            file2 = null;
            if (file2 != null) {
                return file2;
            }
            C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
            return file2;
        } catch (Throwable th5) {
            th = th5;
            fileInputStream = null;
            b.a(fileInputStream, "AES");
            b.a(outputStream, "AES");
            throw th;
        }
        if (file2 != null) {
            return file2;
        }
        C1373c.m6139b("AES", "encryptFile" + file2.getAbsolutePath());
        return file2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.io.File m6097a(java.io.File r7, java.lang.String r8, java.lang.String r9) {
        /*
        r1 = 0;
        if (r7 == 0) goto L_0x000b;
    L_0x0003:
        if (r8 == 0) goto L_0x000b;
    L_0x0005:
        r0 = r7.exists();
        if (r0 != 0) goto L_0x000d;
    L_0x000b:
        r0 = r1;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = "AppLogApi";
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "begin decryptFile ";
        r2 = r2.append(r3);
        r2 = r2.append(r9);
        r2 = r2.toString();
        com.huawei.phoneserviceuni.common.p132d.C1373c.m6141d(r0, r2);
        r3 = new java.io.FileInputStream;	 Catch:{ IOException -> 0x007f, all -> 0x006a }
        r3.<init>(r7);	 Catch:{ IOException -> 0x007f, all -> 0x006a }
        r0 = new java.io.File;	 Catch:{ IOException -> 0x0083, all -> 0x0077 }
        r0.<init>(r9);	 Catch:{ IOException -> 0x0083, all -> 0x0077 }
        r2 = new java.io.FileOutputStream;	 Catch:{ IOException -> 0x0087, all -> 0x0077 }
        r2.<init>(r0);	 Catch:{ IOException -> 0x0087, all -> 0x0077 }
        r1 = 1024; // 0x400 float:1.435E-42 double:5.06E-321;
        r1 = new byte[r1];	 Catch:{ IOException -> 0x004a, all -> 0x0079 }
    L_0x0038:
        r4 = r3.read(r1);	 Catch:{ IOException -> 0x004a, all -> 0x0079 }
        if (r4 <= 0) goto L_0x005f;
    L_0x003e:
        r4 = com.huawei.phoneserviceuni.common.p132d.p133a.p135b.p136a.C1370a.m6103a(r1, r8);	 Catch:{ IOException -> 0x004a, all -> 0x0079 }
        if (r4 == 0) goto L_0x0038;
    L_0x0044:
        r5 = 0;
        r6 = r4.length;	 Catch:{ IOException -> 0x004a, all -> 0x0079 }
        r2.write(r4, r5, r6);	 Catch:{ IOException -> 0x004a, all -> 0x0079 }
        goto L_0x0038;
    L_0x004a:
        r1 = move-exception;
        r1 = r2;
        r2 = r3;
    L_0x004d:
        r3 = "AppLogApi";
        r4 = "decryptFile IOException";
        com.huawei.phoneserviceuni.common.p132d.C1373c.m6141d(r3, r4);	 Catch:{ all -> 0x007c }
        r3 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r2, r3);
        r2 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r1, r2);
        goto L_0x000c;
    L_0x005f:
        r1 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r3, r1);
        r1 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r2, r1);
        goto L_0x000c;
    L_0x006a:
        r0 = move-exception;
        r3 = r1;
    L_0x006c:
        r2 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r3, r2);
        r2 = "AES";
        com.huawei.phoneserviceuni.common.d.b.a(r1, r2);
        throw r0;
    L_0x0077:
        r0 = move-exception;
        goto L_0x006c;
    L_0x0079:
        r0 = move-exception;
        r1 = r2;
        goto L_0x006c;
    L_0x007c:
        r0 = move-exception;
        r3 = r2;
        goto L_0x006c;
    L_0x007f:
        r0 = move-exception;
        r0 = r1;
        r2 = r1;
        goto L_0x004d;
    L_0x0083:
        r0 = move-exception;
        r0 = r1;
        r2 = r3;
        goto L_0x004d;
    L_0x0087:
        r2 = move-exception;
        r2 = r3;
        goto L_0x004d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.phoneserviceuni.common.d.a.b.a.a.a(java.io.File, java.lang.String, java.lang.String):java.io.File");
    }

    public static byte[] m6102a(byte[] bArr, int i, int i2, String str) {
        try {
            return C1370a.m6099a(1, str).doFinal(bArr, i, i2);
        } catch (Exception e) {
            C1373c.m6139b("AES", "AES:encrypt Exception");
            return new byte[0];
        }
    }

    public static byte[] m6103a(byte[] bArr, String str) {
        try {
            return C1370a.m6099a(2, str).doFinal(bArr);
        } catch (Exception e) {
            C1373c.m6139b("AES", "AES decrypt:decrypt Exception");
            return new byte[0];
        }
    }

    private static Cipher m6099a(int i, String str) {
        Cipher instance = Cipher.getInstance("AES/CFB/NoPadding");
        instance.init(i, C1370a.m6100a(str), new IvParameterSpec(f2953a));
        return instance;
    }

    private static SecretKeySpec m6100a(String str) {
        byte[] bytes = str.getBytes(GameManager.DEFAULT_CHARSET);
        byte[] bArr = new byte[16];
        int i = 0;
        while (i < bytes.length && i < bArr.length) {
            bArr[i] = bytes[i];
            i++;
        }
        return new SecretKeySpec(bArr, "AES");
    }

    private static boolean m6101a(File file) {
        if (file == null) {
            C1373c.m6141d("AES", "file is null");
            return false;
        }
        if (!file.exists()) {
            C1373c.m6139b("AES", "文件夹不存在，创建文件夹");
            if (!file.mkdirs()) {
                C1373c.m6139b("AES", "文件夹不存在，创建文件夹失败");
                return false;
            }
        }
        return true;
    }
}
