package com.huawei.hwid.openapi.p445e.p446a;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

public class C5242d {
    public static String m25417a(byte[] bArr, int i) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return null;
        }
        if (i <= 0 || i > bArr.length) {
            i = bArr.length;
        }
        for (int i2 = 0; i2 < i; i2++) {
            String toHexString = Integer.toHexString(bArr[i2] & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] m25418a(String str) {
        byte[] bArr = null;
        if (str != null) {
            int length = str.length();
            if (length % 2 == 0) {
                int i;
                String toUpperCase = str.toUpperCase();
                for (i = 0; i < length; i++) {
                    char charAt = toUpperCase.charAt(i);
                    if (('0' > charAt || charAt > '9') && ('A' > charAt || charAt > 'F')) {
                        break;
                    }
                }
                int i2 = length / 2;
                bArr = new byte[i2];
                byte[] bArr2 = new byte[2];
                i = 0;
                int i3 = 0;
                while (i3 < i2) {
                    int i4 = i + 1;
                    bArr2[0] = (byte) toUpperCase.charAt(i);
                    length = i4 + 1;
                    bArr2[1] = (byte) toUpperCase.charAt(i4);
                    i = 0;
                    while (i < 2) {
                        if (TagName.TERMINAL_BACK_CONTENT > bArr2[i] || bArr2[i] > TagName.TERMINAL_BASEBAND_VERSION) {
                            bArr2[i] = (byte) (bArr2[i] - 48);
                        } else {
                            bArr2[i] = (byte) (bArr2[i] - 55);
                        }
                        i++;
                    }
                    bArr[i3] = (byte) ((bArr2[0] << 4) | bArr2[1]);
                    i3++;
                    i = length;
                }
            }
        }
        return bArr;
    }
}
