package com.huawei.logupload.p090c.p467a;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.logupload.c.c;
import com.huawei.logupload.c.f;
import com.huawei.logupload.p090c.C5440d;
import com.huawei.logupload.p090c.C5441e;
import com.sina.weibo.sdk.component.GameManager;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import org.apache.http.util.EncodingUtils;

/* compiled from: AES128Encryptor */
public final class C5435a {
    private static String f19270a = null;

    public static String m26070a() {
        return "EPYQ==";
    }

    public static String m26071a(String str) {
        String str2 = "";
        try {
            str2 = C5437c.m26080a(C5435a.m26074c(str), 0, Base64.decode(C5435a.m26072b(), 2), 0);
        } catch (InvalidKeyException e) {
            f.e("LogUpload Service", "InvalidKeyException");
        } catch (BadPaddingException e2) {
            f.e("LogUpload Service", "BadPaddingException");
        } catch (IllegalBlockSizeException e3) {
            f.e("LogUpload Service", "IllegalBlockSizeException");
        } catch (NoSuchAlgorithmException e4) {
            f.e("LogUpload Service", "NoSuchAlgorithmException");
        } catch (NoSuchPaddingException e5) {
            f.e("LogUpload Service", "NoSuchPaddingException");
        }
        return str2;
    }

    public static String m26073b(String str) {
        String str2 = "";
        try {
            byte[] a = C5437c.m26081a(str, Base64.decode(C5435a.m26072b(), 2), 0);
            if (a == null) {
                return str2;
            }
            str2 = EncodingUtils.getString(a, GameManager.DEFAULT_CHARSET);
            Arrays.fill(a, (byte) 0);
            return str2;
        } catch (InvalidKeyException e) {
            f.e("LogUpload Service", "InvalidKeyException");
            return str2;
        } catch (BadPaddingException e2) {
            f.e("LogUpload Service", "BadPaddingException");
            return str2;
        } catch (IllegalBlockSizeException e3) {
            f.e("LogUpload Service", "IllegalBlockSizeException");
            return str2;
        } catch (NoSuchAlgorithmException e4) {
            f.e("LogUpload Service", "NoSuchAlgorithmException");
            return str2;
        } catch (NoSuchPaddingException e5) {
            f.e("LogUpload Service", "NoSuchPaddingException");
            return str2;
        }
    }

    private static byte[] m26074c(String str) {
        byte[] bArr = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = str.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
            }
        }
        return bArr;
    }

    private static String m26072b() {
        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            if (f19270a != null) {
                String str = f19270a;
                reentrantLock.unlock();
                return str;
            }
            f19270a = c.h() + C5440d.m26091b() + C5441e.m26094b() + C5435a.m26070a();
            reentrantLock.unlock();
            return f19270a;
        } catch (Exception e) {
            if (f.a(4)) {
                f.e("LogUpload Service", e.getMessage());
            }
            reentrantLock.unlock();
        } catch (Throwable th) {
            reentrantLock.unlock();
        }
    }
}
