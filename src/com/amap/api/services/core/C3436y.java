package com.amap.api.services.core;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.huawei.nfc.carrera.logic.spi.snb.constant.SNBConstant;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;
import java.util.Map.Entry;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;

/* compiled from: ClientInfo */
public class C3436y {
    public static String m16999a(Context context, ad adVar, Map<String, String> map) {
        String str = null;
        try {
            String b = C3436y.m17002b(context, adVar, map);
            if (!"".equals(b)) {
                str = C3436y.m17003b(context, b.getBytes("utf-8"));
            }
        } catch (Throwable e) {
            ay.m16709a(e, "CInfo", "rsaInfo");
            e.printStackTrace();
        }
        return str;
    }

    private static String m17004c(Context context, byte[] bArr) throws InvalidKeyException, IOException, InvalidKeySpecException, NoSuchPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, BadPaddingException, CertificateException {
        KeyGenerator instance = KeyGenerator.getInstance("AES");
        if (instance == null) {
            return null;
        }
        instance.init(256);
        byte[] encoded = instance.generateKey().getEncoded();
        Key a = ae.m16620a(context);
        if (a == null) {
            return null;
        }
        Object a2 = aa.m16584a(encoded, a);
        Object a3 = aa.m16585a(encoded, bArr);
        byte[] bArr2 = new byte[(a2.length + a3.length)];
        System.arraycopy(a2, 0, bArr2, 0, a2.length);
        System.arraycopy(a3, 0, bArr2, a2.length, a3.length);
        byte[] a4 = ae.m16621a(bArr2);
        if (a4 != null) {
            return aa.m16583a(a4);
        }
        return "";
    }

    public static String m17001a(Context context, byte[] bArr) {
        try {
            return C3436y.m17004c(context, bArr);
        } catch (InvalidKeyException e) {
            e.printStackTrace();
            return "";
        } catch (NoSuchAlgorithmException e2) {
            e2.printStackTrace();
            return "";
        } catch (NoSuchPaddingException e3) {
            e3.printStackTrace();
            return "";
        } catch (IllegalBlockSizeException e4) {
            e4.printStackTrace();
            return "";
        } catch (BadPaddingException e5) {
            e5.printStackTrace();
            return "";
        } catch (InvalidKeySpecException e6) {
            e6.printStackTrace();
            return "";
        } catch (CertificateException e7) {
            e7.printStackTrace();
            return "";
        } catch (IOException e8) {
            e8.printStackTrace();
            return "";
        } catch (Throwable th) {
            th.printStackTrace();
            return "";
        }
    }

    public static String m17003b(Context context, byte[] bArr) {
        try {
            return C3436y.m17004c(context, bArr);
        } catch (Throwable e) {
            ay.m16709a(e, "CInfo", "AESData");
            e.printStackTrace();
            return "";
        } catch (Throwable e2) {
            ay.m16709a(e2, "CInfo", "AESData");
            e2.printStackTrace();
            return "";
        } catch (Throwable e22) {
            ay.m16709a(e22, "CInfo", "AESData");
            e22.printStackTrace();
            return "";
        } catch (Throwable e222) {
            ay.m16709a(e222, "CInfo", "AESData");
            e222.printStackTrace();
            return "";
        } catch (Throwable e2222) {
            ay.m16709a(e2222, "CInfo", "AESData");
            e2222.printStackTrace();
            return "";
        } catch (Throwable e22222) {
            ay.m16709a(e22222, "CInfo", "AESData");
            e22222.printStackTrace();
            return "";
        } catch (Throwable e222222) {
            ay.m16709a(e222222, "CInfo", "AESData");
            e222222.printStackTrace();
            return "";
        } catch (Throwable e2222222) {
            ay.m16709a(e2222222, "CInfo", "AESData");
            e2222222.printStackTrace();
            return "";
        } catch (Throwable e22222222) {
            ay.m16709a(e22222222, "CInfo", "AESData");
            e22222222.printStackTrace();
            return "";
        }
    }

    public static String m16998a(Context context, ad adVar) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"sim\":\"").append(C3438z.m17025q(context)).append("\",\"av\":\"").append(adVar.f12314a).append("\",\"pro\":\"").append(adVar.f12316c).append("\",\"ed\":\"").append(adVar.m16616d()).append("\",\"nt\":\"").append(C3438z.m17019k(context)).append("\",\"np\":\"").append(C3438z.m17024p(context)).append("\",\"mnc\":\"").append(C3438z.m17013e(context)).append("\",\"lnt\":\"").append(C3438z.m17014f(context)).append("\",\"ant\":\"").append(C3438z.m17016h(context)).append("\"");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String m16997a(Context context) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            stringBuilder.append("\"key\":\"").append(C3434w.m16993f(context)).append("\",\"ct\":\"android\",\"ime\":\"").append(C3438z.m17021m(context)).append("\",\"pkg\":\"").append(C3434w.m16989b(context)).append("\",\"mod\":\"").append(Build.MODEL).append("\",\"apn\":\"").append(C3434w.m16987a(context)).append("\",\"apv\":\"").append(C3434w.m16990c(context)).append("\",\"sv\":\"").append(VERSION.RELEASE).append("\",");
        } catch (Throwable th) {
            ay.m16709a(th, "CInfo", "getPublicJSONInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    private static String m17002b(Context context, ad adVar, Map<String, String> map) {
        StringBuilder stringBuilder = new StringBuilder();
        try {
            String m = C3438z.m17021m(context);
            stringBuilder.append("ct=android");
            stringBuilder.append("&ime=").append(m);
            stringBuilder.append("&pkg=").append(C3434w.m16989b(context));
            stringBuilder.append("&mod=");
            stringBuilder.append(Build.MODEL);
            stringBuilder.append("&apn=").append(C3434w.m16987a(context));
            stringBuilder.append("&apv=").append(C3434w.m16990c(context));
            stringBuilder.append("&sv=");
            stringBuilder.append(VERSION.RELEASE);
            stringBuilder.append("&sim=").append(C3438z.m17022n(context));
            stringBuilder.append("&av=").append(adVar.f12314a);
            stringBuilder.append("&pro=").append(adVar.f12316c);
            stringBuilder.append("&cid=").append(C3438z.m17012d(context));
            stringBuilder.append("&dmac=").append(C3438z.m17011c(context));
            stringBuilder.append("&wmac=").append(C3438z.m17010b(context));
            stringBuilder.append("&nt=");
            stringBuilder.append(C3438z.m17020l(context));
            m = C3438z.m17023o(context);
            stringBuilder.append("&np=");
            stringBuilder.append(m);
            stringBuilder.append("&ia=1&");
            m = C3438z.m17005a(context);
            if (m == null) {
                m = "";
            }
            stringBuilder.append("utd=").append(m).append(SNBConstant.FILTER);
            m = C3434w.m16993f(context);
            if (m != null && m.length() > 0) {
                stringBuilder.append("key=");
                stringBuilder.append(m);
                stringBuilder.append(SNBConstant.FILTER);
            }
            stringBuilder.append("ctm=" + System.currentTimeMillis());
            stringBuilder.append("&re=" + C3438z.m17018j(context));
            if (map != null) {
                for (Entry entry : map.entrySet()) {
                    stringBuilder.append(SNBConstant.FILTER).append((String) entry.getKey()).append("=").append((String) entry.getValue());
                }
            }
        } catch (Throwable th) {
            ay.m16709a(th, "CInfo", "InitXInfo");
            th.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String m16996a() {
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
                ay.m16709a(th2, "CInfo", "getTS");
                th2.printStackTrace();
                return str;
            }
        } catch (Throwable th32) {
            th = th32;
            str = str2;
            th2 = th;
            ay.m16709a(th2, "CInfo", "getTS");
            th2.printStackTrace();
            return str;
        }
        return str;
    }

    public static String m17000a(Context context, String str, String str2) {
        String str3 = null;
        try {
            str3 = ab.m16590a(C3434w.m16991d(context) + ":" + str.substring(0, str.length() - 3) + ":" + str2);
        } catch (Throwable th) {
            ay.m16709a(th, "CInfo", "Scode");
            th.printStackTrace();
        }
        return str3;
    }
}
