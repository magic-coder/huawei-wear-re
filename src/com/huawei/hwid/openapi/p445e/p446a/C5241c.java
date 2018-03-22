package com.huawei.hwid.openapi.p445e.p446a;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.huawei.hwid.openapi.p440a.C5213b;
import com.huawei.hwid.openapi.p445e.C5246b;
import com.huawei.hwid.openapi.p445e.C5248c;
import com.huawei.hwid.openapi.p445e.C5251f;
import com.sina.weibo.sdk.component.GameManager;
import java.security.SecureRandom;

public class C5241c {
    private static final String f18877a = C5213b.f18818a;

    public static String m25414a(Context context, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        SharedPreferences a = C5246b.m25435a(context);
        str2 = a.getString("OxSb13_2d", null);
        if (str2 == null) {
            str2 = String.valueOf(new SecureRandom().nextLong());
            a.edit().putString("OxSb13_2d", str2).commit();
        }
        return C5240b.m25412a(C5251f.m25463b(str), 0, C5251f.m25463b(new StringBuffer().append(C5241c.m25415a("NikHweTd")).append(str2).toString()), 0);
    }

    private static String m25415a(String str) {
        int i = 0;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        char[] toCharArray = str.toCharArray();
        char[] cArr = new char[toCharArray.length];
        int length = toCharArray.length;
        int i2 = 0;
        while (i < length) {
            cArr[i2] = (char) (toCharArray[i] + 2);
            i2++;
            i++;
        }
        return new String(cArr);
    }

    public static String m25416b(Context context, String str) {
        String str2 = "";
        if (TextUtils.isEmpty(str)) {
            return str2;
        }
        Object string = C5246b.m25435a(context).getString("OxSb13_2d", null);
        if (TextUtils.isEmpty(string)) {
            return str2;
        }
        String str3;
        try {
            byte[] a = C5240b.m25413a(str, C5251f.m25463b(new StringBuffer().append(C5241c.m25415a("NikHweTd")).append(string).toString()), 0);
            if (a != null) {
                str3 = new String(a, GameManager.DEFAULT_CHARSET);
                return str3;
            }
        } catch (Throwable e) {
            C5248c.m25448b(f18877a, "UnsupportedEncodingException:" + e.getMessage(), e);
        }
        str3 = str2;
        return str3;
    }
}
