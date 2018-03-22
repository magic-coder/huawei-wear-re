package com.amap.api.services.core;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* compiled from: MD5 */
public class ab {
    public static String m16590a(String str) {
        if (str == null) {
            return null;
        }
        return ae.m16623c(m16594c(str));
    }

    public static String m16591a(byte[] bArr) {
        return ae.m16623c(m16593b(bArr));
    }

    public static String m16592b(String str) {
        return ae.m16624d(m16595d(str));
    }

    private static byte[] m16593b(byte[] bArr) {
        byte[] bArr2 = null;
        try {
            MessageDigest instance = MessageDigest.getInstance("MD5");
            instance.update(bArr);
            bArr2 = instance.digest();
        } catch (Throwable e) {
            ay.m16709a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
        } catch (Throwable e2) {
            ay.m16709a(e2, "MD5", "getMd5Bytes1");
            e2.printStackTrace();
        }
        return bArr2;
    }

    public static byte[] m16594c(String str) {
        try {
            return m16596e(str);
        } catch (Throwable e) {
            ay.m16709a(e, "MD5", "getMd5Bytes");
            e.printStackTrace();
            return new byte[0];
        } catch (Throwable e2) {
            ay.m16709a(e2, "MD5", "getMd5Bytes");
            e2.printStackTrace();
            return new byte[0];
        } catch (Throwable e22) {
            ay.m16709a(e22, "MD5", "getMd5Bytes");
            e22.printStackTrace();
            return new byte[0];
        }
    }

    private static byte[] m16595d(String str) {
        try {
            return m16596e(str);
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

    private static byte[] m16596e(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str == null) {
            return null;
        }
        MessageDigest instance = MessageDigest.getInstance("MD5");
        instance.update(str.getBytes("utf-8"));
        return instance.digest();
    }
}
