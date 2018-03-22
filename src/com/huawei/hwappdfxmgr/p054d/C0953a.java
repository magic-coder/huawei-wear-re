package com.huawei.hwappdfxmgr.p054d;

import android.os.Build;
import android.os.Build.VERSION;
import android.os.Process;
import com.huawei.hwappdfxmgr.d.c;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.security.Provider;
import java.security.SecureRandom;
import java.security.Security;

/* compiled from: PRNGFixes */
public final class C0953a {
    private static final byte[] f1549a = C0953a.m3336g();

    private C0953a() {
    }

    public static void m3330a() {
        C0953a.m3332c();
        C0953a.m3333d();
    }

    private static void m3332c() throws SecurityException {
        if (VERSION.SDK_INT >= 16 && VERSION.SDK_INT <= 18) {
            try {
                Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_seed", new Class[]{byte[].class}).invoke(null, new Object[]{C0953a.m3334e()});
                int intValue = ((Integer) Class.forName("org.apache.harmony.xnet.provider.jsse.NativeCrypto").getMethod("RAND_load_file", new Class[]{String.class, Long.TYPE}).invoke(null, new Object[]{"/dev/urandom", Integer.valueOf(1024)})).intValue();
                if (intValue != 1024) {
                    throw new IOException("Unexpected number of bytes read from Linux PRNG: " + intValue);
                }
            } catch (Throwable e) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e);
            } catch (Throwable e2) {
                throw new SecurityException("Failed to seed OpenSSL PRNG", e2);
            }
        }
    }

    private static void m3333d() throws SecurityException {
        if (VERSION.SDK_INT <= 18) {
            Provider[] providers = Security.getProviders("SecureRandom.SHA1PRNG");
            if (providers == null || providers.length < 1 || !c.class.equals(providers[0].getClass())) {
                Security.insertProviderAt(new c(), 1);
            }
            SecureRandom secureRandom = new SecureRandom();
            if (c.class.equals(secureRandom.getProvider().getClass())) {
                try {
                    secureRandom = SecureRandom.getInstance("SHA1PRNG");
                    if (!c.class.equals(secureRandom.getProvider().getClass())) {
                        throw new SecurityException("SecureRandom.getInstance(\"SHA1PRNG\") backed by wrong Provider: " + secureRandom.getProvider().getClass());
                    }
                    return;
                } catch (Throwable e) {
                    throw new SecurityException("SHA1PRNG not available", e);
                }
            }
            throw new SecurityException("new SecureRandom() backed by wrong Provider: " + secureRandom.getProvider().getClass());
        }
    }

    private static byte[] m3334e() {
        try {
            OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeLong(System.currentTimeMillis());
            dataOutputStream.writeLong(System.nanoTime());
            dataOutputStream.writeInt(Process.myPid());
            dataOutputStream.writeInt(Process.myUid());
            dataOutputStream.write(f1549a);
            dataOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable e) {
            throw new SecurityException("Failed to generate seed", e);
        }
    }

    private static String m3335f() {
        try {
            return (String) Build.class.getField("SERIAL").get(null);
        } catch (RuntimeException e) {
            return null;
        } catch (Exception e2) {
            return null;
        }
    }

    private static byte[] m3336g() {
        StringBuilder stringBuilder = new StringBuilder();
        String str = Build.FINGERPRINT;
        if (str != null) {
            stringBuilder.append(str);
        }
        str = C0953a.m3335f();
        if (str != null) {
            stringBuilder.append(str);
        }
        try {
            return stringBuilder.toString().getBytes(GameManager.DEFAULT_CHARSET);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 encoding not supported");
        }
    }
}
