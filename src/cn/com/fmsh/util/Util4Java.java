package cn.com.fmsh.util;

import cn.com.fmsh.FM_Exception;
import com.huawei.crowdtestsdk.report.ReportInfoUtils;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util4Java {
    private static final /* synthetic */ int[] f9851a;

    static {
        int[] iArr = new int[8];
        iArr[1] = 1;
        iArr[2] = 3;
        iArr[3] = 7;
        iArr[4] = 15;
        iArr[5] = 31;
        iArr[6] = 63;
        iArr[7] = 127;
        f9851a = iArr;
    }

    public static byte String2Byte(String str, byte b) {
        try {
            b = Byte.parseByte(str, 16);
        } catch (Exception e) {
        }
        return b;
    }

    public static int String2Int(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static String date2string(String str) {
        return date2string(null, str);
    }

    public static String date2string(Date date, String str) {
        if (date == null) {
            date = new Date();
        }
        if (str == null) {
            str = FM_Utils.regionMatches(118, ReportInfoUtils.FEEDBACK_SUCCESS, "?8%.\u0000\u0005nz}4GB?mv,b");
        }
        return new SimpleDateFormat(str).format(date);
    }

    public static String endsWith(String str, int i, int i2) {
        int i3 = i - 3;
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

    public static int getBitNumber(byte b, int i, int i2) {
        if (i2 > 8 || i2 < 0) {
            return -1;
        }
        int i3 = i - i2;
        return i3 >= 0 ? (b >> i3) & f9851a[i2] : -1;
    }

    public static String getCurrentTime() {
        return date2string(null, endsWith("I\u0018%#p6(y", 4, 79));
    }

    public static String getExceptionInfo(Exception exception) {
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        exception.printStackTrace(printStream);
        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
        if (printStream != null) {
            try {
                printStream.close();
            } catch (IOException e) {
                return "";
            }
        }
        if (byteArrayOutputStream == null) {
            return byteArrayOutputStream2;
        }
        byteArrayOutputStream.close();
        return byteArrayOutputStream2;
    }

    public static void main(String[] strArr) {
        System.out.println(String2Byte(FM_Exception.insert(3, 98, "6\u000b"), (byte) 0));
    }
}
