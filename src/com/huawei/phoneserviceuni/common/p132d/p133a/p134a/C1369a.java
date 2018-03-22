package com.huawei.phoneserviceuni.common.p132d.p133a.p134a;

import android.text.TextUtils;
import android.util.Base64;
import com.huawei.phoneserviceuni.common.d.a.a.b;
import com.huawei.phoneserviceuni.common.d.a.a.c;
import com.huawei.phoneserviceuni.common.d.a.a.d;
import com.huawei.phoneserviceuni.common.p132d.C1373c;
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
public final class C1369a {
    private static String f2952a = null;

    public static String m6092a() {
        return "EPYQ==";
    }

    public static String m6093a(String str) {
        String str2 = "";
        try {
            str2 = c.a(C1369a.m6096c(str), 0, Base64.decode(C1369a.m6094b(), 2), 0);
        } catch (InvalidKeyException e) {
            C1373c.m6141d("LogUpload Service", "encrypterCbc InvalidKeyException");
        } catch (BadPaddingException e2) {
            C1373c.m6141d("LogUpload Service", "encrypterCbc BadPaddingException");
        } catch (IllegalBlockSizeException e3) {
            C1373c.m6141d("LogUpload Service", "encrypterCbc IllegalBlockSizeException");
        } catch (NoSuchAlgorithmException e4) {
            C1373c.m6141d("LogUpload Service", "encrypterCbc NoSuchAlgorithmException");
        } catch (NoSuchPaddingException e5) {
            C1373c.m6141d("LogUpload Service", "encrypterCbc NoSuchPaddingException");
        }
        return str2;
    }

    public static String m6095b(String str) {
        String str2 = "";
        try {
            byte[] a = c.a(str, Base64.decode(C1369a.m6094b(), 2), 0);
            str2 = EncodingUtils.getString(a, GameManager.DEFAULT_CHARSET);
            Arrays.fill(a, (byte) 0);
            return str2;
        } catch (InvalidKeyException e) {
            C1373c.m6141d("LogUpload Service", "decrypterCbc InvalidKeyException");
            return str2;
        } catch (BadPaddingException e2) {
            C1373c.m6141d("LogUpload Service", "decrypterCbc BadPaddingException");
            return str2;
        } catch (IllegalBlockSizeException e3) {
            C1373c.m6141d("LogUpload Service", "decrypterCbc IllegalBlockSizeException");
            return str2;
        } catch (NoSuchAlgorithmException e4) {
            C1373c.m6141d("LogUpload Service", "decrypterCbc NoSuchAlgorithmException");
            return str2;
        } catch (NoSuchPaddingException e5) {
            C1373c.m6141d("LogUpload Service", "decrypterCbc NoSuchPaddingException");
            return str2;
        }
    }

    private static byte[] m6096c(String str) {
        byte[] bArr = null;
        if (!TextUtils.isEmpty(str)) {
            try {
                bArr = str.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
                C1373c.m6141d("LogUpload Service", "getUTF8Bytes Exception");
            }
        }
        return bArr;
    }

    private static String m6094b() {
        String str;
        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            if (f2952a != null) {
                str = f2952a;
                return str;
            }
            f2952a = d.a() + b.a() + c.a() + C1369a.m6092a();
            reentrantLock.unlock();
            return f2952a;
        } catch (Exception e) {
            str = "LogUpload Service";
            C1373c.m6141d(str, "HEX or AES128_CBC or AES128_CBC_HEX getExcerpt error");
        } finally {
            reentrantLock.unlock();
        }
    }
}
