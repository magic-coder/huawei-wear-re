package com.huawei.hwid.core.encrypt;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.core.p435d.C5166b;
import com.huawei.hwid.core.p435d.C5176g;
import com.huawei.hwid.core.p435d.C5181l;
import com.huawei.hwid.core.p435d.p437b.C5165e;
import com.sina.weibo.sdk.component.GameManager;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: HwIDEncrypter */
public class C5201e {
    public static String m25304a(Context context, String str) {
        Throwable th;
        Throwable th2;
        String stringBuffer = new StringBuffer().append(HwAccountConstants.ENCODE_STR).append(AES128_ECB.PART_CODE_KEY).append(HEX.PART_CODE).append(C5181l.m25044e("562.")).toString();
        String str2 = "";
        try {
            byte[] decode = AES128_ECB_HEX.decode(str, C5166b.m24943d(stringBuffer), 0);
            if (decode != null) {
                stringBuffer = new String(decode, GameManager.DEFAULT_CHARSET);
                try {
                    Arrays.fill(decode, (byte) 0);
                    return stringBuffer;
                } catch (Throwable e) {
                    th = e;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "InvalidKeyException  ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                    return C5201e.m25308c(context, str);
                } catch (Throwable e2) {
                    th = e2;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "BadPaddingException  ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return C5201e.m25308c(context, str);
                    }
                    return str2;
                } catch (Throwable e22) {
                    th = e22;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "IllegalBlockSizeException ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                    return C5201e.m25308c(context, str);
                } catch (Throwable e222) {
                    th = e222;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "NoSuchAlgorithmException ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return C5201e.m25308c(context, str);
                    }
                    return str2;
                } catch (Throwable e2222) {
                    th = e2222;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "NoSuchPaddingException ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return str2;
                    }
                    return C5201e.m25308c(context, str);
                } catch (Throwable e22222) {
                    th = e22222;
                    str2 = stringBuffer;
                    th2 = th;
                    C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", th2);
                    if (TextUtils.isEmpty(str2)) {
                        return C5201e.m25308c(context, str);
                    }
                    return str2;
                }
            }
        } catch (InvalidKeyException e3) {
            th2 = e3;
            C5165e.m24911d("HwIDEncrypter", "InvalidKeyException  ", th2);
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            return C5201e.m25308c(context, str);
        } catch (BadPaddingException e4) {
            th2 = e4;
            C5165e.m24911d("HwIDEncrypter", "BadPaddingException  ", th2);
            if (TextUtils.isEmpty(str2)) {
                return C5201e.m25308c(context, str);
            }
            return str2;
        } catch (IllegalBlockSizeException e5) {
            th2 = e5;
            C5165e.m24911d("HwIDEncrypter", "IllegalBlockSizeException ", th2);
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            return C5201e.m25308c(context, str);
        } catch (NoSuchAlgorithmException e6) {
            th2 = e6;
            C5165e.m24911d("HwIDEncrypter", "NoSuchAlgorithmException ", th2);
            if (TextUtils.isEmpty(str2)) {
                return C5201e.m25308c(context, str);
            }
            return str2;
        } catch (NoSuchPaddingException e7) {
            th2 = e7;
            C5165e.m24911d("HwIDEncrypter", "NoSuchPaddingException ", th2);
            if (TextUtils.isEmpty(str2)) {
                return str2;
            }
            return C5201e.m25308c(context, str);
        } catch (UnsupportedEncodingException e8) {
            th2 = e8;
            C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", th2);
            if (TextUtils.isEmpty(str2)) {
                return C5201e.m25308c(context, str);
            }
            return str2;
        }
        if (TextUtils.isEmpty(str2)) {
            return C5201e.m25308c(context, str);
        }
        return str2;
    }

    public static void m25306a(Context context) {
        C5197a.m25285a(context);
    }

    public static String m25307b(Context context, String str) {
        if (VERSION.SDK_INT >= 23) {
            return C5202f.m25310a(context.getPackageName() + ".hwidsdk", str);
        }
        return C5197a.m25281a(context, str);
    }

    public static String m25308c(Context context, String str) {
        int parseInt;
        String str2;
        try {
            parseInt = Integer.parseInt(C5176g.m25017b(context, "encryptversion"));
        } catch (Exception e) {
            C5165e.m24906b("HwIDEncrypter", "get version of encrypted is null, use GRADE_VERSION_KEYSTORE directory");
            parseInt = 3;
        }
        if (VERSION.SDK_INT < 23 || r0 < 3) {
            str2 = null;
        } else {
            str2 = C5202f.m25312b(context.getPackageName() + ".hwidsdk", str);
        }
        if (TextUtils.isEmpty(str2)) {
            return C5197a.m25289b(context, str);
        }
        return str2;
    }

    public static String m25305a(String str) {
        String stringBuffer = new StringBuffer().append(HwAccountConstants.ENCODE_STR).append(AES128_ECB.PART_CODE_KEY).append(HEX.PART_CODE).append(C5181l.m25044e("562.")).toString();
        String str2 = null;
        try {
            str2 = C5199c.m25300a(C5166b.m24943d(str), C5166b.m24935b(stringBuffer));
        } catch (InvalidKeyException e) {
            C5165e.m24910d("HwIDEncrypter", "InvalidKeyException ");
        } catch (BadPaddingException e2) {
            C5165e.m24910d("HwIDEncrypter", "BadPaddingException ");
        } catch (IllegalBlockSizeException e3) {
            C5165e.m24910d("HwIDEncrypter", "IllegalBlockSizeException ");
        } catch (NoSuchAlgorithmException e4) {
            C5165e.m24910d("HwIDEncrypter", "NoSuchAlgorithmException ");
        } catch (NoSuchPaddingException e5) {
            C5165e.m24910d("HwIDEncrypter", "NoSuchPaddingException ");
        } catch (InvalidAlgorithmParameterException e6) {
            C5165e.m24910d("HwIDEncrypter", "NoSuchPaddingException ");
        }
        return str2;
    }

    public static String m25309d(Context context, String str) {
        Throwable e;
        Throwable th;
        String stringBuffer = new StringBuffer().append(HwAccountConstants.ENCODE_STR).append(AES128_ECB.PART_CODE_KEY).append(HEX.PART_CODE).append(C5181l.m25044e("562.")).toString();
        String str2 = "";
        try {
            String[] split = str.trim().split(":");
            if (split.length != 2 || TextUtils.isEmpty(split[0]) || TextUtils.isEmpty(split[1])) {
                return str2;
            }
            byte[] a = C5199c.m25302a(split[1], split[0], C5166b.m24943d(stringBuffer));
            if (a != null) {
                stringBuffer = new String(a, GameManager.DEFAULT_CHARSET);
                try {
                    Arrays.fill(a, (byte) 0);
                } catch (InvalidKeyException e2) {
                    e = e2;
                    C5165e.m24911d("HwIDEncrypter", "InvalidKeyException  ", e);
                    return stringBuffer;
                } catch (BadPaddingException e3) {
                    e = e3;
                    C5165e.m24911d("HwIDEncrypter", "BadPaddingException  ", e);
                    return stringBuffer;
                } catch (IllegalBlockSizeException e4) {
                    e = e4;
                    C5165e.m24911d("HwIDEncrypter", "IllegalBlockSizeException ", e);
                    return stringBuffer;
                } catch (NoSuchAlgorithmException e5) {
                    e = e5;
                    C5165e.m24911d("HwIDEncrypter", "NoSuchAlgorithmException ", e);
                    return stringBuffer;
                } catch (NoSuchPaddingException e6) {
                    e = e6;
                    C5165e.m24911d("HwIDEncrypter", "NoSuchPaddingException ", e);
                    return stringBuffer;
                } catch (UnsupportedEncodingException e7) {
                    e = e7;
                    C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", e);
                    return stringBuffer;
                } catch (InvalidAlgorithmParameterException e8) {
                    e = e8;
                    C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", e);
                    return stringBuffer;
                }
            }
            stringBuffer = str2;
            return stringBuffer;
        } catch (Throwable e9) {
            th = e9;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "InvalidKeyException  ", e);
            return stringBuffer;
        } catch (Throwable e92) {
            th = e92;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "BadPaddingException  ", e);
            return stringBuffer;
        } catch (Throwable e922) {
            th = e922;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "IllegalBlockSizeException ", e);
            return stringBuffer;
        } catch (Throwable e9222) {
            th = e9222;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "NoSuchAlgorithmException ", e);
            return stringBuffer;
        } catch (Throwable e92222) {
            th = e92222;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "NoSuchPaddingException ", e);
            return stringBuffer;
        } catch (Throwable e922222) {
            th = e922222;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", e);
            return stringBuffer;
        } catch (Throwable e9222222) {
            th = e9222222;
            stringBuffer = str2;
            e = th;
            C5165e.m24911d("HwIDEncrypter", "UnsupportedEncodingException ", e);
            return stringBuffer;
        }
    }
}
