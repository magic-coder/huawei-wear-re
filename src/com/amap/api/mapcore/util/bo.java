package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.sina.weibo.sdk.component.GameManager;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public class bo {
    public static String m15701a(Context context, bv bvVar, Map<String, String> map, boolean z) {
        try {
            byte[] bArr;
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m15705a(byteArrayOutputStream, bq.m15739q(context));
            m15705a(byteArrayOutputStream, bq.m15731i(context));
            String f = bq.m15728f(context);
            if (f == null) {
                f = "";
            }
            m15705a(byteArrayOutputStream, f);
            m15705a(byteArrayOutputStream, bm.m15687c(context));
            m15705a(byteArrayOutputStream, Build.MODEL);
            m15705a(byteArrayOutputStream, Build.MANUFACTURER);
            m15705a(byteArrayOutputStream, Build.DEVICE);
            m15705a(byteArrayOutputStream, bm.m15686b(context));
            m15705a(byteArrayOutputStream, bm.m15688d(context));
            m15705a(byteArrayOutputStream, String.valueOf(VERSION.SDK_INT));
            m15705a(byteArrayOutputStream, bq.m15740r(context));
            m15705a(byteArrayOutputStream, bq.m15738p(context));
            m15705a(byteArrayOutputStream, bq.m15735m(context) + "");
            m15705a(byteArrayOutputStream, bq.m15734l(context) + "");
            m15705a(byteArrayOutputStream, bq.m15741s(context));
            m15705a(byteArrayOutputStream, bq.m15733k(context));
            if (z) {
                m15705a(byteArrayOutputStream, "");
            } else {
                m15705a(byteArrayOutputStream, bq.m15730h(context));
            }
            if (z) {
                m15705a(byteArrayOutputStream, "");
            } else {
                m15705a(byteArrayOutputStream, bq.m15729g(context));
            }
            if (z) {
                m15705a(byteArrayOutputStream, "");
                m15705a(byteArrayOutputStream, "");
            } else {
                String[] j = bq.m15732j(context);
                m15705a(byteArrayOutputStream, j[0]);
                m15705a(byteArrayOutputStream, j[1]);
            }
            byte[] a = bw.m15804a(byteArrayOutputStream.toByteArray());
            Key a2 = bw.m15801a(context);
            if (a.length > 117) {
                byte[] bArr2 = new byte[117];
                System.arraycopy(a, 0, bArr2, 0, 117);
                Object a3 = br.m15749a(bArr2, a2);
                bArr = new byte[((a.length + 128) - 117)];
                System.arraycopy(a3, 0, bArr, 0, 128);
                System.arraycopy(a, 117, bArr, 128, a.length - 117);
            } else {
                bArr = br.m15749a(a, a2);
            }
            return br.m15751b(bArr);
        } catch (Throwable th) {
            cd.m15825a(th, "CInfo", "InitXInfo");
            return null;
        }
    }

    static String m15703a(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        Key a = bw.m15801a(context);
        if (a == null) {
            return null;
        }
        Object a2 = br.m15749a(encoded, a);
        Object a3 = br.m15750a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        byte[] a4 = bw.m15804a(bArr2);
        if (a4 != null) {
            return br.m15751b(a4);
        }
        return "";
    }

    public static String m15706b(Context context, byte[] bArr) {
        try {
            return m15703a(context, bArr);
        } catch (Throwable e) {
            cd.m15825a(e, "CInfo", "AESData");
            return "";
        } catch (Throwable e2) {
            cd.m15825a(e2, "CInfo", "AESData");
            return "";
        } catch (Throwable e22) {
            cd.m15825a(e22, "CInfo", "AESData");
            return "";
        } catch (Throwable e222) {
            cd.m15825a(e222, "CInfo", "AESData");
            return "";
        } catch (Throwable e2222) {
            cd.m15825a(e2222, "CInfo", "AESData");
            return "";
        } catch (Throwable e22222) {
            cd.m15825a(e22222, "CInfo", "AESData");
            return "";
        } catch (Throwable e222222) {
            cd.m15825a(e222222, "CInfo", "AESData");
            return "";
        } catch (Throwable e2222222) {
            cd.m15825a(e2222222, "CInfo", "AESData");
            return "";
        } catch (Throwable e22222222) {
            cd.m15825a(e22222222, "CInfo", "AESData");
            return "";
        }
    }

    public static String m15700a(Context context, bv bvVar) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sim\":\"").append(bq.m15727e(context)).append("\",\"sdkversion\":\"").append(bvVar.f11557a).append("\",\"product\":\"").append(bvVar.f11559c).append("\",\"ed\":\"").append(bvVar.m15795d()).append("\",\"nt\":\"").append(bq.m15725c(context)).append("\",\"np\":\"").append(bq.m15718a(context)).append("\",\"mnc\":\"").append(bq.m15723b(context)).append("\",\"ant\":\"").append(bq.m15726d(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static void m15705a(ByteArrayOutputStream byteArrayOutputStream, String str) {
        byte b;
        if (TextUtils.isEmpty(str)) {
            m15704a(byteArrayOutputStream, (byte) 0, new byte[0]);
            return;
        }
        if (str.getBytes().length > 255) {
            b = (byte) -1;
        } else {
            b = (byte) str.getBytes().length;
        }
        try {
            m15704a(byteArrayOutputStream, b, str.getBytes(GameManager.DEFAULT_CHARSET));
        } catch (UnsupportedEncodingException e) {
            m15704a(byteArrayOutputStream, b, str.getBytes());
        }
    }

    private static void m15704a(ByteArrayOutputStream byteArrayOutputStream, byte b, byte[] bArr) {
        int i = 1;
        try {
            byteArrayOutputStream.write(new byte[]{b});
            int i2 = b > (byte) 0 ? 1 : 0;
            if ((b & 255) >= 255) {
                i = 0;
            }
            if ((i & i2) != 0) {
                byteArrayOutputStream.write(bArr);
            } else if ((b & 255) == 255) {
                byteArrayOutputStream.write(bArr, 0, 255);
            }
        } catch (Throwable e) {
            cd.m15825a(e, "CInfo", "writeField");
        }
    }

    public static String m15699a() {
        String str;
        Throwable th;
        Throwable th2;
        String str2 = null;
        try {
            str2 = String.valueOf(System.currentTimeMillis());
            try {
                int length = str2.length();
                str = str2.substring(0, length - 2) + "1" + str2.substring(length - 1);
            } catch (Throwable th3) {
                th = th3;
                str = str2;
                th2 = th;
                cd.m15825a(th2, "CInfo", "getTS");
                return str;
            }
        } catch (Throwable th32) {
            th = th32;
            str = str2;
            th2 = th;
            cd.m15825a(th2, "CInfo", "getTS");
            return str;
        }
        return str;
    }

    public static String m15702a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = bs.m15758b(bm.m15689e(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            cd.m15825a(th, "CInfo", "Scode");
        }
        return str3;
    }
}
