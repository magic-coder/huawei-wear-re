package cn.com.fmsh.util;

import android.support.v4.internal.view.SupportMenu;

public class CRCUtil {
    public static byte[] calculateCRC16(byte[] bArr) {
        int length = bArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = (short) (bArr[i] << 8);
            int i4 = i2;
            for (i2 = 0; i2 < 8; i2++) {
                i4 = ((short) (i4 ^ i3)) <= (short) 0 ? (short) (((short) (i4 << 1)) ^ 4129) : (short) (i4 << 1);
                i3 = (short) (i3 << 1);
            }
            i++;
            i2 = i4;
        }
        return FM_Bytes.intToBytes(i2, 2);
    }

    public static void main(String[] strArr) {
        System.out.println(FM_Bytes.bytesToHexString(calculateCRC16(FM_Bytes.hexStringToBytes(FM_CN.equals("dtfw(9*;l}np!2#4fvgx):+<m~o`q\"3$5fwhy*;,=npar#4%6gxiz+<->o`qbs$5&7hyj{,=.?0arct%6'8izk|->/ 1bsdu&7(9i{e|.J0 2bt\u0010w'<+9ixi}/#9!1`qeu+;.?o|m{t%6 0`ugp\\:*<l", 1)))));
        System.out.println(SupportMenu.USER_MASK);
    }

    public static String substring(int i, String str) {
        int i2 = i + 13;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i3 = i2;
        i2 = 0;
        while (i2 != length) {
            int i4 = i3 + 11;
            i3 = i2 + 1;
            toCharArray[i2] = (char) ((i3 & 95) ^ toCharArray[i2]);
            i2 = i3;
            i3 = i4;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }
}
