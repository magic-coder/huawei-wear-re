package com.amap.api.mapcore.util;

import android.text.TextUtils;
import com.sina.weibo.sdk.component.GameManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class bs {
    public static String m15755a(String str) {
        Throwable e;
        String str2;
        String str3;
        Throwable th;
        String str4 = null;
        FileInputStream fileInputStream = null;
        FileInputStream fileInputStream2;
        try {
            if (TextUtils.isEmpty(str)) {
                if (str4 != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        e = e2;
                        str2 = "MD5";
                        str3 = "getMd5FromFile";
                        cd.m15825a(e, str2, str3);
                        return str4;
                    }
                }
                return str4;
            }
            File file = new File(str);
            if (file.isFile() && file.exists()) {
                byte[] bArr = new byte[2048];
                MessageDigest instance = MessageDigest.getInstance("MD5");
                fileInputStream2 = new FileInputStream(file);
                while (true) {
                    try {
                        int read = fileInputStream2.read(bArr);
                        if (read == -1) {
                            break;
                        }
                        instance.update(bArr, 0, read);
                    } catch (Throwable th2) {
                        e = th2;
                    }
                }
                str4 = bw.m15807c(instance.digest());
                if (fileInputStream2 != null) {
                    try {
                        fileInputStream2.close();
                    } catch (IOException e3) {
                        e = e3;
                        str2 = "MD5";
                        str3 = "getMd5FromFile";
                        cd.m15825a(e, str2, str3);
                        return str4;
                    }
                }
                return str4;
            }
            if (str4 != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e4) {
                    e = e4;
                    str2 = "MD5";
                    str3 = "getMd5FromFile";
                    cd.m15825a(e, str2, str3);
                    return str4;
                }
            }
            return str4;
        } catch (Throwable e5) {
            fileInputStream2 = str4;
            th = e5;
            if (fileInputStream2 != null) {
                fileInputStream2.close();
            }
            throw th;
        }
    }

    public static String m15758b(String str) {
        if (str == null) {
            return null;
        }
        return bw.m15807c(m15761d(str));
    }

    public static String m15756a(byte[] bArr) {
        return bw.m15807c(m15759b(bArr));
    }

    public static String m15760c(String str) {
        return bw.m15808d(m15762e(str));
    }

    public static byte[] m15757a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance(str);
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Throwable e) {
            cd.m15825a(e, "MD5", "getMd5Bytes");
        } catch (Throwable e2) {
            cd.m15825a(e2, "MD5", "getMd5Bytes1");
        }
        return bArr2;
    }

    private static byte[] m15759b(byte[] bArr) {
        return m15757a(bArr, "MD5");
    }

    public static byte[] m15761d(String str) {
        try {
            return m15763f(str);
        } catch (Throwable e) {
            cd.m15825a(e, "MD5", "getMd5Bytes");
            return new byte[0];
        } catch (Throwable e2) {
            cd.m15825a(e2, "MD5", "getMd5Bytes");
            return new byte[0];
        } catch (Throwable e22) {
            cd.m15825a(e22, "MD5", "getMd5Bytes");
            return new byte[0];
        }
    }

    private static byte[] m15762e(String str) {
        try {
            return m15763f(str);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return new byte[0];
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable th) {
            th.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] m15763f(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes(GameManager.DEFAULT_CHARSET));
        return instance.digest();
    }
}
