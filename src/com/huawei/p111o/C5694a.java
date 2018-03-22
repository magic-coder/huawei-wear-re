package com.huawei.p111o;

import com.huawei.common.util.EncryptUtil;
import com.huawei.hwcommonmodel.C0973a;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: EncryptUtil */
public class C5694a {
    public static byte[] m26280a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return C5694a.m26281a(bArr, bArr2, bArr3);
    }

    public static byte[] m26282b(int i, byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        return C5694a.m26283b(bArr, bArr2, bArr3);
    }

    private static byte[] m26281a(byte[] bArr, byte[] bArr2, byte[] bArr3) throws Exception {
        Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
        instance.init(1, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
        return instance.doFinal(bArr3);
    }

    private static byte[] m26283b(byte[] bArr, byte[] bArr2, byte[] bArr3) {
        C5706d.m26332a(EncryptUtil.TAG, "decryptByAesCbc begin");
        try {
            C5706d.m26332a(EncryptUtil.TAG, "decryptByAesCbc key is:", C0973a.a(bArr), ";iv is:", C0973a.a(bArr2), ";data is:", C0973a.a(bArr3));
            Cipher instance = Cipher.getInstance("AES/CBC/PKCS7Padding");
            instance.init(2, new SecretKeySpec(bArr, "AES"), new IvParameterSpec(bArr2));
            return instance.doFinal(bArr3);
        } catch (Exception e) {
            C5706d.m26332a(EncryptUtil.TAG, "NoSuchAlgorithmException e" + C5694a.m26279a(e));
            return null;
        } catch (Exception e2) {
            C5706d.m26332a(EncryptUtil.TAG, "NoSuchPaddingException e" + C5694a.m26279a(e2));
            return null;
        } catch (Exception e22) {
            C5706d.m26332a(EncryptUtil.TAG, "InvalidKeyException e" + C5694a.m26279a(e22));
            return null;
        } catch (Exception e222) {
            C5706d.m26332a(EncryptUtil.TAG, "InvalidAlgorithmParameterException e" + C5694a.m26279a(e222));
            return null;
        } catch (Exception e2222) {
            C5706d.m26332a(EncryptUtil.TAG, "IllegalBlockSizeException e" + C5694a.m26279a(e2222));
            return null;
        } catch (Exception e22222) {
            C5706d.m26332a(EncryptUtil.TAG, "BadPaddingException e" + C5694a.m26279a(e22222));
            return null;
        }
    }

    private static String m26279a(Exception exception) {
        StringBuffer stringBuffer = new StringBuffer();
        StackTraceElement[] stackTrace = exception.getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            stringBuffer.append(stackTraceElement.toString() + "\n");
        }
        return stringBuffer.toString();
    }
}
