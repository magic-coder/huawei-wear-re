package com.huawei.uploadlog.p188c.p189a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: AES128_CBC_HEX */
public final class C2503c {
    public static String m12442a(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C2504d.m12444a(C2502b.m12439a(bArr, i, bArr2, i2), 0);
    }

    public static byte[] m12443a(String str, byte[] bArr, int i) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C2502b.m12441b(C2504d.m12445a(str), 0, bArr, i);
    }
}
