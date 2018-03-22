package com.huawei.nfc.carrera.logic.ese.impl;

import com.huawei.nfc.carrera.util.LogX;

public class HexByteHelper {
    static String byteArrayToHexString(byte[] bArr) {
        char[] cArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        char[] cArr2 = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & 255;
            cArr2[i * 2] = cArr[i2 >>> 4];
            cArr2[(i * 2) + 1] = cArr[i2 & 15];
        }
        return new String(cArr2);
    }

    static byte[] hexStringToByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[(length / 2)];
        for (int i = 0; i < length; i += 2) {
            bArr[i / 2] = (byte) ((Character.digit(str.charAt(i), 16) << 4) + Character.digit(str.charAt(i + 1), 16));
        }
        return bArr;
    }

    static int hexStringToDecimalInteger(String str) {
        int i = 0;
        if (!(str == null || str.trim().equals(""))) {
            try {
                i = Integer.valueOf(str, 16).intValue();
            } catch (NumberFormatException e) {
                LogX.e("hexStringToDecimalInteger format exception");
            }
        }
        return i;
    }

    static int decimalStringToDecimalInteger(String str) {
        int i = 0;
        if (!(str == null || str.trim().equals(""))) {
            try {
                i = Integer.valueOf(str).intValue();
            } catch (NumberFormatException e) {
                LogX.e("decimalStringToDecimalInteger format exception");
            }
        }
        return i;
    }

    static String integerToHexStr(int i) {
        String toHexString = Integer.toHexString(i);
        if (toHexString.length() < 2) {
            return "0" + toHexString;
        }
        return toHexString;
    }
}
