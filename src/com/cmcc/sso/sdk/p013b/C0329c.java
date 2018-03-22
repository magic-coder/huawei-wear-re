package com.cmcc.sso.sdk.p013b;

import com.huawei.hwid.core.constants.HwAccountConstants;

public final class C0329c {
    private static final char[] f185a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public static String m210a(byte[] bArr) {
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer((bArr.length * 3) / 2);
        int i = length - 3;
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            int i4 = (((bArr[i3] & 255) << 16) | ((bArr[i3 + 1] & 255) << 8)) | (bArr[i3 + 2] & 255);
            stringBuffer.append(f185a[(i4 >> 18) & 63]);
            stringBuffer.append(f185a[(i4 >> 12) & 63]);
            stringBuffer.append(f185a[(i4 >> 6) & 63]);
            stringBuffer.append(f185a[i4 & 63]);
            i4 = i3 + 3;
            i3 = i2 + 1;
            if (i2 >= 14) {
                stringBuffer.append(HwAccountConstants.BLANK);
                i3 = 0;
            }
            i2 = i3;
            i3 = i4;
        }
        if (i3 == (length + 0) - 2) {
            i3 = ((bArr[i3 + 1] & 255) << 8) | ((bArr[i3] & 255) << 16);
            stringBuffer.append(f185a[(i3 >> 18) & 63]);
            stringBuffer.append(f185a[(i3 >> 12) & 63]);
            stringBuffer.append(f185a[(i3 >> 6) & 63]);
            stringBuffer.append("=");
        } else if (i3 == (length + 0) - 1) {
            i3 = (bArr[i3] & 255) << 16;
            stringBuffer.append(f185a[(i3 >> 18) & 63]);
            stringBuffer.append(f185a[(i3 >> 12) & 63]);
            stringBuffer.append("==");
        }
        return stringBuffer.toString();
    }
}
