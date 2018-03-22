package com.huawei.p111o;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.common.Constant;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.o.c;
import com.huawei.p111o.p477a.C5693a;
import com.huawei.p111o.p478b.C5699d;
import com.huawei.p190v.C2538c;
import com.huawei.whitebox.C6169a;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: HWEncryptUtil */
public class C5704b {
    private static C5704b f19455a;
    private static byte[] f19456c = new byte[1];
    private C6169a f19457b = C6169a.m28546a();

    public static C5704b m26317a(Context context) {
        if (f19455a == null && context != null) {
            f19455a = new C5704b();
        }
        return f19455a;
    }

    private C5704b() {
    }

    public String m26325a(int i, String str) throws Exception {
        synchronized (f19456c) {
            if (m26320a(i)) {
                int blockSize = Cipher.getInstance("AES/CBC/PKCS7Padding").getBlockSize();
                if (str != null) {
                    Object bytes = str.trim().getBytes(GameManager.DEFAULT_CHARSET);
                    int length = bytes.length;
                    if (length % blockSize != 0) {
                        length += blockSize - (length % blockSize);
                    }
                    Object obj = new byte[length];
                    System.arraycopy(bytes, 0, obj, 0, bytes.length);
                    byte[] b = c.b(i);
                    C2538c.c("HWEncryptUtil", new Object[]{" encryptData getworkkey"});
                    byte[] a = c.a();
                    if (b == null || a == null) {
                        C2538c.c("HWEncryptUtil", new Object[]{" encryptData secret is null"});
                    } else {
                        byte[] a2 = C5694a.m26280a(2, b, a, obj);
                        str = C5699d.m26308b(a) + C5699d.m26308b(a2);
                        C2538c.c("HWEncryptUtil", new Object[]{" encryptData secret is not null"});
                    }
                } else {
                    C2538c.e("HWEncryptUtil", new Object[]{"strContent is null!"});
                    str = null;
                }
            } else {
                C2538c.c("HWEncryptUtil", new Object[]{"not need encrypt"});
            }
        }
        return str;
    }

    public String m26328b(int i, String str) throws Exception {
        synchronized (f19456c) {
            if (m26320a(i)) {
                C2538c.c("HWEncryptUtil", new Object[]{"decryptData dataType:" + i});
                if (TextUtils.isEmpty(str) || str.length() <= 24) {
                    C2538c.b("HWEncryptUtil", new Object[]{"decryptData strContent is: ", str});
                    str = "";
                } else {
                    C5706d.m26332a("HWEncryptUtil", " decryptData secret iv_str:", str.substring(0, 24), ";data_str:", str.substring(24, str.length()));
                    C5706d.m26332a("HWEncryptUtil", " decryptData rootkey is:" + C0973a.a(c.d(i).getBytes(GameManager.DEFAULT_CHARSET)));
                    String c = c.c(i);
                    C5706d.m26332a("HWEncryptUtil", " encryptData secret_str is:", c);
                    if (c == null) {
                        C2538c.c("HWEncryptUtil", new Object[]{"decryptData10 "});
                    } else {
                        String substring = c.substring(0, 24);
                        C5706d.m26332a("HWEncryptUtil", " decryptData key_info is:" + C0973a.a(C5699d.m26303a(c.substring(24, c.length()))) + ";iv_info is:" + C0973a.a(C5699d.m26303a(substring)));
                        byte[] a = c.a(r4, a, r5);
                        C2538c.c("HWEncryptUtil", new Object[]{"getworkkey ok"});
                        C5706d.m26332a("HWEncryptUtil", " decryptData secret original is:" + a.a(C5694a.m26282b(2, a, C5699d.m26303a(r0), C5699d.m26303a(r2))));
                        str = new String(r0, GameManager.DEFAULT_CHARSET).trim();
                        C2538c.c("HWEncryptUtil", new Object[]{"decryptData "});
                    }
                }
            } else {
                C2538c.c("HWEncryptUtil", new Object[]{"decryptData11 "});
                C2538c.c("HWEncryptUtil", new Object[]{"decryptData "});
            }
        }
        return str;
    }

    public String m26326a(String str) {
        return m26318a(str, 0);
    }

    private boolean m26320a(int i) {
        return C5693a.m26278a(i);
    }

    private String m26318a(String str, int i) {
        if (str == null) {
            return null;
        }
        try {
            if (str.length() < 32) {
                return null;
            }
            byte[] b;
            String substring = str.substring(0, 32);
            if (1 == i) {
                b = m26322b();
            } else {
                b = m26321a();
            }
            return m26319a(str.substring(32), b, m26323b(substring));
        } catch (Exception e) {
            C2538c.e("HWEncryptUtil", new Object[]{"decrypt--Exception:", e.getMessage()});
            return null;
        }
    }

    private byte[] m26321a() {
        return C5699d.m26303a(String.valueOf(m26318a("D4AAC76288A23005828B8FEF937D5650gjQUAXCxflcmPZ2H4/deJyHSeFoU71xl67CeEsCdM8UbcYpdKUEGhxRdwBmol2/q", 1)));
    }

    private byte[] m26322b() {
        char[] toCharArray = this.f19457b.m28549b().toCharArray();
        char[] toCharArray2 = Constant.ADL2.toCharArray();
        String c = m26324c("C6B6C6ABC5A84C1CC5B6C693C684C7B04E3EC7BEC6B3C48829C59EC79F74C792C49CC6B560C6A1C5ADC5A9C484C790C7B8C5A9C4BAC4B1C790C5A4C4BDC6A0C5A7C6AEC799C587C4AEC4A45026");
        if (c == null || c.isEmpty()) {
            return new byte[1];
        }
        char[] toCharArray3 = c.toCharArray();
        char[] cArr = new char[toCharArray.length];
        for (int i = 0; i < toCharArray.length; i++) {
            cArr[i] = (char) ((((toCharArray3[i] ^ (toCharArray2[i] << 2)) << 3) ^ toCharArray[i]) >> 4);
        }
        return C5699d.m26303a(String.valueOf(cArr));
    }

    private byte[] m26323b(String str) {
        if (str.length() < 1) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i * 2, (i * 2) + 1), 16) * 16) + Integer.parseInt(str.substring((i * 2) + 1, (i * 2) + 2), 16));
        }
        return bArr;
    }

    private String m26319a(String str, byte[] bArr, byte[] bArr2) throws Exception {
        byte[] a = C5699d.m26303a(str);
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return new String(instance.doFinal(a), GameManager.DEFAULT_CHARSET).trim();
    }

    private String m26324c(String str) {
        if (str == null) {
            return null;
        }
        char[] toCharArray = str.toCharArray();
        byte[] bArr = new byte[(str.length() / 2)];
        String str2 = "0123456789ABCDEF";
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = (byte) (((str2.indexOf(toCharArray[i * 2]) * 16) + str2.indexOf(toCharArray[(i * 2) + 1])) & 255);
        }
        try {
            return new String(bArr, "utf-8");
        } catch (UnsupportedEncodingException e) {
            C2538c.e("HWEncryptUtil", new Object[]{"hexToString() e = " + e});
            return null;
        }
    }

    public byte[] m26327a(int i, byte[] bArr) throws Exception {
        if (m26320a(i)) {
            int blockSize = Cipher.getInstance("AES/CBC/PKCS7Padding").getBlockSize();
            int length = bArr.length;
            if (length % blockSize != 0) {
                length += blockSize - (length % blockSize);
            }
            Object obj = new byte[length];
            System.arraycopy(bArr, 0, obj, 0, bArr.length);
            byte[] b = c.b(i);
            C2538c.c("HWEncryptUtil", new Object[]{" encryptByteData getworkkey"});
            byte[] a = c.a();
            if (b == null || a == null) {
                C2538c.c("HWEncryptUtil", new Object[]{" encryptData secret is null"});
                return bArr;
            }
            byte[] a2 = C5694a.m26280a(2, b, a, obj);
            String str = C5699d.m26308b(a) + C5699d.m26308b(a2);
            C2538c.c("HWEncryptUtil", new Object[]{" encryptData secret is not null"});
            return str.getBytes("utf-8");
        }
        C2538c.c("HWEncryptUtil", new Object[]{"not need encrypt"});
        return bArr;
    }

    public byte[] m26329c(int i, String str) throws Exception {
        if (m26320a(i)) {
            C2538c.c("HWEncryptUtil", new Object[]{"decryptData dataType:" + i});
            String substring = str.substring(0, 24);
            String substring2 = str.substring(24, str.length());
            byte[] bytes = c.d(i).getBytes(GameManager.DEFAULT_CHARSET);
            String c = c.c(i);
            if (c == null) {
                C2538c.c("HWEncryptUtil", new Object[]{"decryptData10 "});
                return str.getBytes("utf-8");
            }
            bytes = c.a(C5699d.m26303a(c.substring(24, c.length())), bytes, C5699d.m26303a(c.substring(0, 24)));
            C2538c.c("HWEncryptUtil", new Object[]{"getworkkey ok"});
            return C5694a.m26282b(2, bytes, C5699d.m26303a(substring), C5699d.m26303a(substring2));
        }
        C2538c.c("HWEncryptUtil", new Object[]{"decryptData11 "});
        return str.getBytes("utf-8");
    }
}
