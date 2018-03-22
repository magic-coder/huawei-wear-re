package com.huawei.appmarket.sdk.foundation.p367e;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.C4241a;
import com.huawei.appmarket.sdk.foundation.pm.C4290a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class C4282b {
    public static String m20660a(File file) {
        Object a = C4282b.m20666a(file, 32);
        if (a == null) {
            return "No_hash";
        }
        try {
            Object bytes = Long.toString(file.length()).getBytes(GameManager.DEFAULT_CHARSET);
            Object obj = new byte[(a.length + bytes.length)];
            System.arraycopy(a, 0, obj, 0, a.length);
            System.arraycopy(bytes, 0, obj, a.length, bytes.length);
            String str = "";
            try {
                MessageDigest instance = MessageDigest.getInstance("md5");
                instance.update(obj);
                return C4275a.m20647a(instance.digest());
            } catch (NoSuchAlgorithmException e) {
                C4241a.m20532b("FileUtil", "getHashCode exception!" + e.getMessage());
                return str;
            }
        } catch (UnsupportedEncodingException e2) {
            return null;
        }
    }

    public static String m20661a(String str) {
        FileInputStream fileInputStream;
        Throwable e;
        Throwable th;
        String str2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("md5");
            fileInputStream = new FileInputStream(str);
            try {
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    instance.update(bArr, 0, read);
                }
                str2 = C4275a.m20647a(instance.digest());
                if (fileInputStream != null) {
                    try {
                        fileInputStream.close();
                    } catch (IOException e2) {
                        C4241a.m20532b("FileUtil", "Close FileInputStream failed!");
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    C4241a.m20530a("FileUtil", "getFileMD5 exception", e);
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            C4241a.m20532b("FileUtil", "Close FileInputStream failed!");
                        }
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e5) {
                            C4241a.m20532b("FileUtil", "Close FileInputStream failed!");
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e6) {
            e = e6;
            Object obj = str2;
            C4241a.m20530a("FileUtil", "getFileMD5 exception", e);
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            return str2;
        } catch (Throwable e7) {
            fileInputStream = str2;
            th = e7;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
        return str2;
    }

    public static String m20662a(String str, Context context) {
        PackageInfo a = C4290a.m20698a(str, context);
        return (a == null || a.applicationInfo == null || a.applicationInfo.sourceDir == null || "".equals(a.applicationInfo.sourceDir)) ? null : a.applicationInfo.sourceDir.toString();
    }

    public static void m20663a(InputStream inputStream) {
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (Throwable e) {
                C4241a.m20530a("FileUtil", "close InputStream error!", e);
            }
        }
    }

    public static void m20664a(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable e) {
                C4241a.m20530a("FileUtil", "close OutputStream error!", e);
            }
        }
    }

    public static void m20665a(RandomAccessFile randomAccessFile) {
        if (randomAccessFile != null) {
            try {
                randomAccessFile.close();
            } catch (Throwable e) {
                C4241a.m20530a("FileUtil", "closeFileStream exception", e);
            }
        }
    }

    public static byte[] m20666a(File file, int i) {
        InputStream fileInputStream;
        OutputStream byteArrayOutputStream;
        Throwable e;
        Throwable th;
        byte[] bArr = null;
        if (file == null) {
            C4282b.m20663a(null);
            C4282b.m20664a(null);
        } else {
            try {
                fileInputStream = new FileInputStream(file);
                try {
                    byteArrayOutputStream = new ByteArrayOutputStream(i);
                    if (!(fileInputStream == null || byteArrayOutputStream == null)) {
                        try {
                            byte[] bArr2 = new byte[i];
                            int read = fileInputStream.read(bArr2);
                            if (read != -1) {
                                byteArrayOutputStream.write(bArr2, 0, read);
                            }
                            bArr = byteArrayOutputStream.toByteArray();
                        } catch (IOException e2) {
                            e = e2;
                            try {
                                C4241a.m20530a("FileUtil", "helper:get bytes from file process error!", e);
                                C4282b.m20663a(fileInputStream);
                                C4282b.m20664a(byteArrayOutputStream);
                                return bArr;
                            } catch (Throwable th2) {
                                th = th2;
                                C4282b.m20663a(fileInputStream);
                                C4282b.m20664a(byteArrayOutputStream);
                                throw th;
                            }
                        }
                    }
                    C4282b.m20663a(fileInputStream);
                    C4282b.m20664a(byteArrayOutputStream);
                } catch (IOException e3) {
                    e = e3;
                    byteArrayOutputStream = null;
                    C4241a.m20530a("FileUtil", "helper:get bytes from file process error!", e);
                    C4282b.m20663a(fileInputStream);
                    C4282b.m20664a(byteArrayOutputStream);
                    return bArr;
                } catch (Throwable e4) {
                    byteArrayOutputStream = null;
                    th = e4;
                    C4282b.m20663a(fileInputStream);
                    C4282b.m20664a(byteArrayOutputStream);
                    throw th;
                }
            } catch (IOException e5) {
                e4 = e5;
                byteArrayOutputStream = null;
                fileInputStream = null;
                C4241a.m20530a("FileUtil", "helper:get bytes from file process error!", e4);
                C4282b.m20663a(fileInputStream);
                C4282b.m20664a(byteArrayOutputStream);
                return bArr;
            } catch (Throwable e42) {
                byteArrayOutputStream = null;
                fileInputStream = null;
                th = e42;
                C4282b.m20663a(fileInputStream);
                C4282b.m20664a(byteArrayOutputStream);
                throw th;
            }
        }
        return bArr;
    }

    public static String m20667b(String str) {
        if (str == null) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(".");
        return lastIndexOf < 0 ? null : str.substring(lastIndexOf + 1, str.length());
    }
}
