package cn.com.fmsh.util;

import cn.com.fmsh.FM_Exception;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.Character.UnicodeBlock;

public class FM_Utils {
    private static /* synthetic */ String f9850a = FM_Exception.insert(4, 43, "8\"l: j<\"x2W\u0003OS\u0007K");

    public static int String2Int(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static void exceptionHandle(Exception exception) {
        try {
            throw exception;
        } catch (Exception e) {
        }
    }

    public static String getExceptionInfo(Exception exception) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        exception.printStackTrace(new PrintStream(byteArrayOutputStream));
        return byteArrayOutputStream.toString();
    }

    public static long hexStringToLong(String str) {
        int length = str.length();
        char[] toCharArray = str.toCharArray();
        long j = 0;
        for (int i = 0; i < length; i++) {
            int parseInt = Integer.parseInt(new StringBuilder(String.valueOf(toCharArray[i])).toString(), 16);
            for (int i2 = 0; i2 < (length - i) - 1 && parseInt != 0; i2++) {
                parseInt <<= 4;
            }
            j += (long) parseInt;
        }
        return j;
    }

    public static String intToHexString(int i, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        byte[] intToBytes = FM_Bytes.intToBytes(i, i2);
        for (byte b : intToBytes) {
            stringBuffer.append(f9850a.charAt((b & 240) >> 4));
            stringBuffer.append(f9850a.charAt(b & 15));
        }
        return stringBuffer.toString();
    }

    public static boolean isChinese(char c) {
        UnicodeBlock of = UnicodeBlock.of(c);
        return of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS || of == UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS || of == UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A || of == UnicodeBlock.GENERAL_PUNCTUATION || of == UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION || of == UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS;
    }

    public static boolean isNotEmpty(String str) {
        return (str == null || "".equals(str)) ? false : true;
    }

    public static String regionMatches(int i, int i2, String str) {
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
}
