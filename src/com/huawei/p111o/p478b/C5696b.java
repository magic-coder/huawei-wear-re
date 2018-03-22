package com.huawei.p111o.p478b;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/* compiled from: AES128_CBC_HEX */
public final class C5696b {
    public static byte[] m26286a(byte[] bArr, byte[] bArr2, String str) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidAlgorithmParameterException {
        return C5695a.m26285a(bArr, C5702h.m26312a(str), C5695a.m26284a(bArr2, 0));
    }
}
