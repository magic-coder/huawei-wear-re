package com.huawei.wallet.logic.tlv;

import cn.com.fmsh.script.constants.ScriptToolsConst.TagName;
import com.huawei.hwid.core.constants.HwAccountConstants;
import java.nio.ByteBuffer;
import java.util.Locale;

public class TlvUtil {
    private static final char[] f21300a = "0123456789ABCDEF".toCharArray();
    private static final byte[] f21301b = new byte[128];

    static {
        for (int i = 0; i < 10; i++) {
            f21301b[i + 48] = (byte) i;
            f21301b[i + 65] = (byte) (i + 10);
            f21301b[i + 97] = (byte) (i + 10);
        }
    }

    public static String m28096a(byte[] bArr) {
        return m28097a(bArr, 0, bArr.length);
    }

    public static byte[] m28098a(String str) {
        int i = 0;
        char[] toCharArray = str.replace("\n", "").replace(HwAccountConstants.BLANK, "").toUpperCase(Locale.US).toCharArray();
        byte[] bArr = new byte[(toCharArray.length / 2)];
        int i2 = 0;
        while (i < bArr.length) {
            int i3 = i2 + 1;
            byte b = f21301b[toCharArray[i2] & 127];
            i2 = i3 + 1;
            bArr[i] = (byte) ((b << 4) + f21301b[toCharArray[i3] & 127]);
            i++;
        }
        return bArr;
    }

    public static String m28097a(byte[] bArr, int i, int i2) {
        char[] cArr = new char[(i2 * 2)];
        int i3 = 0;
        for (int i4 = i; i4 < i + i2; i4++) {
            byte b = bArr[i4];
            int i5 = i3 + 1;
            cArr[i3] = f21300a[(b & 240) >>> 4];
            i3 = i5 + 1;
            cArr[i5] = f21300a[b & 15];
        }
        return new String(cArr);
    }

    public static byte[] m28099b(String str) {
        int i = 0;
        if (str == null || str.equals("")) {
            return new byte[0];
        }
        String toUpperCase = str.toUpperCase(Locale.US);
        int length = toUpperCase.length() / 2;
        char[] toCharArray = toUpperCase.toCharArray();
        byte[] bArr = new byte[length];
        while (i < length) {
            int i2 = i * 2;
            bArr[i] = (byte) (m28095a(toCharArray[i2 + 1]) | (m28095a(toCharArray[i2]) << 4));
            i++;
        }
        return bArr;
    }

    private static byte m28095a(char c) {
        return (byte) "0123456789ABCDEF".indexOf(c);
    }

    public static byte[] m28100b(byte[] bArr) {
        ByteBuffer allocate = ByteBuffer.allocate(bArr.length + 6);
        allocate.put((byte) 0).put(TagName.CommandMultiple).put((byte) 4).put((byte) 0).put((byte) bArr.length).put(bArr).put((byte) 0);
        return allocate.array();
    }
}
