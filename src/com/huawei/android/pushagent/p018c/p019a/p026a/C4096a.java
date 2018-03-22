package com.huawei.android.pushagent.p018c.p019a.p026a;

import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.p018c.p019a.C4104d;
import com.sina.weibo.sdk.component.GameManager;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class C4096a {
    public static String m20099a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] a = C4096a.m20101a();
            if (a.length == 0) {
                return "";
            }
            Key secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            byte[] bArr = new byte[16];
            new SecureRandom().nextBytes(bArr);
            instance.init(1, secretKeySpec, new IvParameterSpec(bArr));
            return C4096a.m20100a(C4103b.m20123a(bArr), C4103b.m20123a(instance.doFinal(str.getBytes(GameManager.DEFAULT_CHARSET))));
        } catch (Throwable e) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e);
            return null;
        } catch (Throwable e2) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e2);
            return null;
        } catch (Throwable e22) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e22);
            return null;
        } catch (Throwable e222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e222);
            return null;
        } catch (Throwable e2222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e2222);
            return null;
        } catch (Throwable e22222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e22222);
            return null;
        } catch (Throwable e222222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e222222);
            return null;
        } catch (Throwable e2222222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e2222222);
            return null;
        } catch (Throwable e22222222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e22222222);
            return null;
        }
    }

    private static String m20100a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str2.substring(0, 6));
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str2.substring(6, 10));
            stringBuffer.append(str.substring(6, 16));
            stringBuffer.append(str2.substring(10, 16));
            stringBuffer.append(str.substring(16));
            stringBuffer.append(str2.substring(16));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.d("AES128_CBC", e.toString());
            return "";
        }
    }

    private static byte[] m20101a() {
        byte[] c = C4103b.m20126c(C4104d.m20127a());
        byte[] c2 = C4103b.m20126c(C4099d.m20112a());
        return C4096a.m20102a(C4096a.m20103a(C4096a.m20103a(c, c2), C4103b.m20126c("2A57086C86EF54970C1E6EB37BFC72B1")));
    }

    private static byte[] m20102a(byte[] bArr) {
        int i = 0;
        if (bArr == null || bArr.length == 0) {
            return new byte[0];
        }
        while (i < bArr.length) {
            bArr[i] = (byte) (bArr[i] >> 2);
            i++;
        }
        return bArr;
    }

    private static byte[] m20103a(byte[] bArr, byte[] bArr2) {
        int i = 0;
        if (bArr == null || bArr2 == null || bArr.length == 0 || bArr2.length == 0) {
            return new byte[0];
        }
        int length = bArr.length;
        if (length != bArr2.length) {
            return new byte[0];
        }
        byte[] bArr3 = new byte[length];
        while (i < length) {
            bArr3[i] = (byte) (bArr[i] ^ bArr2[i]);
            i++;
        }
        return bArr3;
    }

    public static String m20104b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            byte[] a = C4096a.m20101a();
            if (a.length == 0) {
                return "";
            }
            Key secretKeySpec = new SecretKeySpec(a, "AES");
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Object c = C4096a.m20105c(str);
            Object d = C4096a.m20106d(str);
            if (TextUtils.isEmpty(c) || TextUtils.isEmpty(d)) {
                e.b("AES128_CBC", "ivParameter or encrypedWord is null");
                return "";
            }
            instance.init(2, secretKeySpec, new IvParameterSpec(C4103b.m20126c(c)));
            return new String(instance.doFinal(C4103b.m20126c(d)), GameManager.DEFAULT_CHARSET);
        } catch (Throwable e) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e);
            return "";
        } catch (Throwable e2) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e2);
            return "";
        } catch (Throwable e22) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e22);
            return "";
        } catch (Throwable e222) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e222);
            return "";
        } catch (Throwable e2222) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e2222);
            return "";
        } catch (Throwable e22222) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e22222);
            return "";
        } catch (Throwable e222222) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e222222);
            return "";
        } catch (Throwable e2222222) {
            e.c("AES128_CBC", "aes cbc decrypter data error", e2222222);
            return "";
        } catch (Throwable e22222222) {
            e.c("AES128_CBC", "aes cbc encrypter data error", e22222222);
            return "";
        }
    }

    private static String m20105c(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(6, 12));
            stringBuffer.append(str.substring(16, 26));
            stringBuffer.append(str.substring(32, 48));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.d("AES128_CBC", e.toString());
            return "";
        }
    }

    private static String m20106d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 6));
            stringBuffer.append(str.substring(12, 16));
            stringBuffer.append(str.substring(26, 32));
            stringBuffer.append(str.substring(48));
            return stringBuffer.toString();
        } catch (Exception e) {
            e.d("AES128_CBC", e.toString());
            return "";
        }
    }
}
