package com.huawei.pay.p130e.p489b;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.nfc.carrera.constant.Constant;
import com.huawei.nfc.carrera.util.FusionField;
import com.huawei.nfc.carrera.util.Util;
import com.huawei.pay.e.c.a;
import com.huawei.pay.p484c.p485a.C5724a;
import com.huawei.wallet.utils.PhoneDeviceUtil;
import com.huawei.wallet.utils.crypto.AES;

/* compiled from: EncryptHelper */
public class C5728a {
    public static String m26400a(String str) {
        if (!TextUtils.isEmpty(str) && str.length() >= 16) {
            return str.substring(0, 16);
        }
        a.d("key is illeagal", false);
        return str;
    }

    public static String m26402a(String str, Context context) {
        return C5728a.m26405b(str, C5728a.m26399a(context));
    }

    public static String m26403a(String str, String str2) {
        String a = C5728a.m26400a(str2);
        if (!TextUtils.isEmpty(a) && a.length() == 16 && !TextUtils.isEmpty(str)) {
            return AES.m28507b(str, a);
        }
        a.d("aesKey is illeagal", false);
        return null;
    }

    public static String m26405b(String str, String str2) {
        String a = C5728a.m26400a(str2);
        if (!TextUtils.isEmpty(a) && a.length() == 16 && !TextUtils.isEmpty(str)) {
            return AES.m28502a(str, a);
        }
        a.d("aesKey is illeagal", false);
        return null;
    }

    public static String m26404b(String str, Context context) {
        return C5728a.m26403a(str, C5728a.m26399a(context));
    }

    public static String m26399a(Context context) {
        String a = C5724a.m26386a(context).m26389a(Util.CHAOS_UUID, null);
        StringBuilder stringBuilder = new StringBuilder();
        if (TextUtils.isEmpty(a)) {
            a = C5728a.m26401a(PhoneDeviceUtil.m28465a().substring(0, 8), 3);
            C5724a.m26386a(context).m26392b(Util.CHAOS_UUID, a);
        }
        stringBuilder.append(C5728a.m26401a(a, 5)).append(C5728a.m26401a(Util.SECTION_1, 7)).append(C5728a.m26401a(FusionField.SECTION_2, 6)).append(C5728a.m26401a(Constant.SECTION_3, 5)).append(C5728a.m26401a(Util.SECTION_4, 4));
        return stringBuilder.toString();
    }

    public static String m26401a(String str, int i) {
        if (str == null || i >= 8) {
            return str;
        }
        byte[] a = AES.m28505a(str);
        int length = a.length;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = (byte) (((a[i2] & 255) << i) | ((a[i2] & 255) >>> (8 - i)));
        }
        return AES.m28504a(bArr);
    }
}
