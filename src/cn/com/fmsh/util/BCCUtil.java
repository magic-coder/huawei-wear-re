package cn.com.fmsh.util;

public class BCCUtil {
    public static byte calculateBCC(byte[] bArr) {
        int i = 1;
        if (bArr == null || bArr.length < 1) {
            return (byte) 0;
        }
        if (bArr.length == 1) {
            return bArr[0];
        }
        byte b = bArr[0];
        while (i < bArr.length) {
            b = (byte) (b ^ bArr[i]);
            i++;
        }
        return b;
    }

    public static String getChars(String str, int i, int i2) {
        int i3 = i - 16;
        char[] toCharArray = str.toCharArray();
        int length = toCharArray.length;
        int i4 = i3;
        i3 = 0;
        while (i3 != length) {
            int i5 = i4 + i2;
            i4 = i3 + 1;
            toCharArray[i3] = (char) ((i4 & 95) ^ toCharArray[i3]);
            i3 = i4;
            i4 = i5;
        }
        return String.valueOf(toCharArray, 0, length).intern();
    }

    public static void main(String[] strArr) {
        byte calculateBCC = calculateBCC(FM_Bytes.hexStringToBytes(FM_CN.equals("ek\u000f(2$<hww\u0014wP4'6gxiz+<->o`qbs$5&7hyj{,=.?0arct%6'8izk|->/ 1bsdu&7(9j{l}.?0!2ctet'9-:l~o+%8':m\u0003o\u0002.:^>iuo\n\u0005TD\"1ls\u0011\r)8)8lw\u0019atW:$5fwhy", 3)));
        System.out.println(String.format(Util4Java.endsWith("$D", 4, 59), new Object[]{Byte.valueOf(calculateBCC)}));
    }
}
