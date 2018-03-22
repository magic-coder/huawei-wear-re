package com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.p363a;

import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p361d.C4268e;
import com.huawei.appmarket.sdk.foundation.p356b.p357a.p358a.p362c.C4262a;

public class C4251d {
    public static String m20583a(Character ch) {
        if (ch == null) {
            return null;
        }
        char charValue = ch.charValue();
        if (C4262a.m20630d(charValue)) {
            return String.valueOf(charValue);
        }
        StringBuilder stringBuilder = new StringBuilder(6);
        stringBuilder.append("\\u");
        stringBuilder.append(C4268e.m20640a(charValue >> 12));
        stringBuilder.append(C4268e.m20640a(charValue >> 8));
        stringBuilder.append(C4268e.m20640a(charValue >> 4));
        stringBuilder.append(C4268e.m20640a(charValue >> 0));
        return stringBuilder.toString();
    }
}
