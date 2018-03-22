package com.huawei.phoneserviceuni.common.p132d.p133a.p135b;

import cn.com.fmsh.tsm.business.constants.Constants.TagName;

/* compiled from: Base64Coder */
public class C5765a {
    static final char[] f19545a = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '$', '='};

    public static String m26468a(byte[] bArr) {
        int i = 0;
        int length = bArr.length;
        byte[] bArr2 = new byte[]{(byte) 0, (byte) 0, (byte) 0};
        byte[] bArr3 = new byte[]{TagName.CARD_APP_VERSION, TagName.CARD_APP_VERSION, TagName.CARD_APP_VERSION, TagName.CARD_APP_VERSION};
        StringBuilder stringBuilder = new StringBuilder();
        int i2 = 0;
        int i3 = length;
        length = 0;
        while (i3 > 0) {
            int i4 = i3 - 1;
            int i5 = length + 1;
            i3 = i2 + 1;
            bArr2[length] = bArr[i2];
            if (i5 == 3) {
                bArr3[0] = (byte) ((bArr2[0] & 252) >> 2);
                bArr3[1] = (byte) (((bArr2[0] & 3) << 4) + ((bArr2[1] & 240) >> 4));
                bArr3[2] = (byte) (((bArr2[1] & 15) << 2) + ((bArr2[2] & 192) >> 6));
                bArr3[3] = (byte) (bArr2[2] & 63);
                for (length = 0; length < 4; length++) {
                    stringBuilder.append(f19545a[bArr3[length]]);
                }
                i2 = i3;
                length = 0;
                i3 = i4;
            } else {
                i2 = i3;
                length = i5;
                i3 = i4;
            }
        }
        if (length > 0) {
            for (i2 = length; i2 < 3; i2++) {
                bArr2[i2] = (byte) 0;
            }
            bArr3[0] = (byte) ((bArr2[0] & 252) >> 2);
            bArr3[1] = (byte) (((bArr2[0] & 3) << 4) + ((bArr2[1] & 240) >> 4));
            bArr3[2] = (byte) (((bArr2[1] & 15) << 2) + ((bArr2[2] & 192) >> 6));
            bArr3[3] = (byte) (bArr2[2] & 63);
            while (i < length + 1) {
                stringBuilder.append(f19545a[bArr3[i]]);
                i++;
            }
            while (true) {
                i = length + 1;
                if (length >= 3) {
                    break;
                }
                stringBuilder.append('=');
                length = i;
            }
        }
        return stringBuilder.toString();
    }
}
