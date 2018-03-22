package com.huawei.hwversionmgr.utils;

import com.sina.weibo.sdk.component.GameManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5Calculator */
public class C1079e {
    private static C1079e f2174b = null;
    private MessageDigest f2175a = null;

    private static C1079e m4590a() {
        if (f2174b == null) {
            f2174b = new C1079e();
        }
        return f2174b;
    }

    public C1079e() {
        try {
            this.f2175a = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
        }
    }

    public static String m4591a(String str) {
        C1079e a = C1079e.m4590a();
        if (str == null) {
            return null;
        }
        a.m4594c(str);
        byte[] digest = a.f2175a.digest();
        a.f2175a.reset();
        return C1079e.m4592a(digest, 0, digest.length);
    }

    public static String m4593b(String str) {
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            if (str != null) {
                byte[] digest = instance.digest(str.getBytes(GameManager.DEFAULT_CHARSET));
                instance.reset();
                str2 = C1079e.m4592a(digest, 0, digest.length);
            }
        } catch (NoSuchAlgorithmException e) {
        } catch (UnsupportedEncodingException e2) {
        }
        return str2;
    }

    private void m4594c(String str) {
        Throwable th;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            fileInputStream2 = new FileInputStream(str);
            try {
                byte[] bArr = new byte[4096];
                while (true) {
                    int read = fileInputStream2.read(bArr);
                    if (read <= 0) {
                        break;
                    }
                    this.f2175a.update(bArr, 0, read);
                }
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e) {
                    }
                }
            } catch (FileNotFoundException e2) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (IOException e4) {
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e5) {
                    }
                }
            } catch (Throwable th2) {
                Throwable th3 = th2;
                fileInputStream = fileInputStream2;
                th = th3;
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e6) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException e7) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (IOException e8) {
            fileInputStream2 = null;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
        } catch (Throwable th4) {
            th = th4;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    private static String m4592a(byte[] bArr, int i, int i2) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        StringBuilder stringBuilder = new StringBuilder();
        for (int i3 = i; i3 < i + i2; i3++) {
            byte b = bArr[i3];
            stringBuilder.append(cArr[(b >>> 4) & 15]);
            stringBuilder.append(cArr[b & 15]);
        }
        return stringBuilder.toString();
    }
}
