package cn.com.xy.sms.sdk.p216h.p217a;

import java.io.ByteArrayOutputStream;
import java.security.Key;
import java.security.KeyFactory;
import java.security.spec.PKCS8EncodedKeySpec;
import javax.crypto.Cipher;

public final class C2989g {
    public static String m13432a(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer();
        for (byte b : bArr) {
            String toHexString = Integer.toHexString(b & 255);
            if (toHexString.length() == 1) {
                toHexString = "0" + toHexString;
            }
            stringBuffer.append(toHexString.toUpperCase());
        }
        return stringBuffer.toString();
    }

    public static byte[] m13433a(String str) {
        if (str.length() <= 0) {
            return null;
        }
        byte[] bArr = new byte[(str.length() / 2)];
        for (int i = 0; i < str.length() / 2; i++) {
            bArr[i] = (byte) ((Integer.parseInt(str.substring(i << 1, (i << 1) + 1), 16) << 4) + Integer.parseInt(str.substring((i << 1) + 1, (i << 1) + 2), 16));
        }
        return bArr;
    }

    public static byte[] m13434a(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C2985c.m13420a(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(1, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > 117 ? instance.doFinal(bArr, i2, 117) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 *= 117;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }

    public static byte[] m13435b(byte[] bArr, String str) {
        byte[] doFinal;
        Key generatePrivate = KeyFactory.getInstance("RSA").generatePrivate(new PKCS8EncodedKeySpec(C2985c.m13420a(str)));
        Cipher instance = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        instance.init(2, generatePrivate);
        int length = bArr.length;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        int i2 = 0;
        while (length - i2 > 0) {
            doFinal = length - i2 > 256 ? instance.doFinal(bArr, i2, 256) : instance.doFinal(bArr, i2, length - i2);
            byteArrayOutputStream.write(doFinal, 0, doFinal.length);
            i2 = i + 1;
            int i3 = i2;
            i2 <<= 8;
            i = i3;
        }
        doFinal = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();
        return doFinal;
    }
}
