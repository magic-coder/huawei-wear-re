package com.huawei.p111o.p478b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import java.util.Locale;

/* compiled from: HEX */
public final class C5702h {
    public static byte[] m26312a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        String toUpperCase = str.toUpperCase(Locale.ENGLISH);
        for (int i = 0; i < length; i++) {
            char charAt = toUpperCase.charAt(i);
            if (('0' > charAt || charAt > '9') && ('A' > charAt || charAt > 'F')) {
                return new byte[0];
            }
        }
        int i2 = length / 2;
        byte[] bArr = new byte[i2];
        byte[] bArr2 = new byte[2];
        length = 0;
        int i3 = 0;
        while (i3 < i2) {
            int i4 = length + 1;
            bArr2[0] = (byte) toUpperCase.charAt(length);
            int i5 = i4 + 1;
            bArr2[1] = (byte) toUpperCase.charAt(i4);
            length = 0;
            while (length < 2) {
                if (TagName.TERMINAL_BACK_CONTENT > bArr2[length] || bArr2[length] > TagName.TERMINAL_BASEBAND_VERSION) {
                    bArr2[length] = (byte) (bArr2[length] - 48);
                } else {
                    bArr2[length] = (byte) (bArr2[length] - 55);
                }
                length++;
            }
            bArr[i3] = (byte) ((bArr2[0] << 4) | bArr2[1]);
            i3++;
            length = i5;
        }
        return bArr;
    }
}
