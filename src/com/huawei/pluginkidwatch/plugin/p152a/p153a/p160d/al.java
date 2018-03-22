package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import com.huawei.hwid.core.constants.HwAccountConstants;

@SuppressLint({"DefaultLocale"})
/* compiled from: HEXUtils */
public class al {
    public static byte[] m7918a(String str) {
        if (str == null) {
            return null;
        }
        String replace = str.replace(HwAccountConstants.BLANK, "");
        int length = replace.length() / 2;
        byte[] bArr = new byte[length];
        String str2 = "";
        str2 = "";
        for (int i = 0; i < length; i++) {
            int i2 = (i * 2) + 1;
            int i3 = i2 + 1;
            String substring = replace.substring(i * 2, i2);
            bArr[i] = (byte) Integer.parseInt(substring + replace.substring(i2, i3), 16);
        }
        return bArr;
    }

    public static String m7917a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        String str = "";
        StringBuilder stringBuilder = new StringBuilder("");
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                stringBuilder.append("0" + toHexString);
            } else {
                stringBuilder.append(toHexString);
            }
        }
        return stringBuilder.toString().toUpperCase().trim();
    }
}
