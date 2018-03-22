package com.huawei.uploadlog.p188c.p189a;

import android.util.Base64;
import com.huawei.androidcommon.utils.StringUtils;
import com.huawei.uploadlog.p188c.C2507c;
import com.huawei.uploadlog.p188c.C2508d;
import com.huawei.uploadlog.p188c.C2510f;
import com.huawei.uploadlog.p188c.C2511g;
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
public final class C2501a {
    private static String f8979a = null;

    public static String m12432a() {
        return "EPYQ==";
    }

    public static String m12433a(String str) {
        String b = C2501a.m12434b();
        String str2 = "";
        if (!(str == null || str.isEmpty())) {
            try {
                str2 = C2503c.m12442a(C2501a.m12436c(str), 0, Base64.decode(b, 2), 0);
            } catch (InvalidKeyException e) {
                C2511g.m12484d("LogUpload Service", "InvalidKeyException");
            } catch (BadPaddingException e2) {
                C2511g.m12484d("LogUpload Service", "BadPaddingException");
            } catch (IllegalBlockSizeException e3) {
                C2511g.m12484d("LogUpload Service", "IllegalBlockSizeException");
            } catch (NoSuchAlgorithmException e4) {
                C2511g.m12484d("LogUpload Service", "NoSuchAlgorithmException");
            } catch (NoSuchPaddingException e5) {
                C2511g.m12484d("LogUpload Service", "NoSuchPaddingException");
            }
        }
        return str2;
    }

    public static String m12435b(String str) {
        String str2 = "";
        try {
            byte[] a = C2503c.m12443a(str, Base64.decode(C2501a.m12434b(), 2), 0);
            if (a == null) {
                return str2;
            }
            str2 = EncodingUtils.getString(a, GameManager.DEFAULT_CHARSET);
            Arrays.fill(a, (byte) 0);
            return str2;
        } catch (InvalidKeyException e) {
            C2511g.m12484d("LogUpload Service", "InvalidKeyException");
            return str2;
        } catch (BadPaddingException e2) {
            C2511g.m12484d("LogUpload Service", "BadPaddingException");
            return str2;
        } catch (IllegalBlockSizeException e3) {
            C2511g.m12484d("LogUpload Service", "IllegalBlockSizeException");
            return str2;
        } catch (NoSuchAlgorithmException e4) {
            C2511g.m12484d("LogUpload Service", "NoSuchAlgorithmException");
            return str2;
        } catch (NoSuchPaddingException e5) {
            C2511g.m12484d("LogUpload Service", "NoSuchPaddingException");
            return str2;
        }
    }

    private static byte[] m12436c(String str) {
        byte[] bArr = null;
        if (!StringUtils.isNullOrEmpty(str)) {
            try {
                bArr = str.getBytes(GameManager.DEFAULT_CHARSET);
            } catch (Exception e) {
            }
        }
        return bArr;
    }

    private static String m12434b() {
        String str;
        Lock reentrantLock = new ReentrantLock();
        reentrantLock.lock();
        try {
            if (f8979a != null) {
                str = f8979a;
                return str;
            }
            f8979a = C2507c.m12468h() + C2508d.m12471b() + C2510f.m12475b() + C2501a.m12432a();
            reentrantLock.unlock();
            return f8979a;
        } catch (Exception e) {
            str = e;
            C2511g.m12482b("LogUpload Service", "[AES128Encryptor.getKey]error", str);
        } finally {
            reentrantLock.unlock();
        }
    }
}
