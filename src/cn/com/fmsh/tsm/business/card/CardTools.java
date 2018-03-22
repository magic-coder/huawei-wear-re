package cn.com.fmsh.tsm.business.card;

import cn.com.fmsh.util.FM_Bytes;

public class CardTools {
    public static String getFaceID4UID(byte[] bArr) {
        if (bArr == null || bArr.length < 1) {
            return null;
        }
        int i;
        int i2;
        byte[] join = FM_Bytes.join(new byte[1], bArr);
        String str = new String("");
        int[] iArr = new int[20];
        long bytesToLong = FM_Bytes.bytesToLong(join);
        int i3 = 0;
        while (bytesToLong > 0) {
            i = i3 + 1;
            iArr[i3] = (int) (bytesToLong % 10);
            bytesToLong /= 10;
            i3 = i;
        }
        i = 0;
        for (i2 = 0; i2 < i3; i2++) {
            if ((i2 & 1) == 0) {
                int i4 = iArr[i2] + iArr[i2];
                i = (i + (i4 % 10)) + (i4 / 10);
            } else {
                i += iArr[i2];
            }
        }
        String stringBuilder = new StringBuilder(String.valueOf(str)).append((10 - (i % 10)) % 10).toString();
        long bytesToLong2 = FM_Bytes.bytesToLong(join);
        String str2 = stringBuilder;
        i2 = 1;
        while (i2 < 11) {
            int i5 = (int) (bytesToLong2 % 100);
            bytesToLong2 /= 100;
            i2 += 2;
            str2 = new StringBuilder(String.valueOf(new StringBuilder(String.valueOf(str2)).append(i5 / 10).toString())).append(i5 % 10).toString();
        }
        return str2;
    }

    public static String getFaceNo4uidByLnt(byte[] bArr) {
        return FM_Bytes.bytesToHexString(bArr);
    }
}
