package com.huawei.android.pushagent.p018c.p019a.p026a;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public final class C4098c {
    public static byte[] m20110a(byte[] bArr, int i, byte[] bArr2, int i2) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C4097b.m20107a(bArr, i, bArr2, i2);
    }

    public static byte[] m20111a(byte[] bArr, byte[] bArr2, int i) throws BadPaddingException, IllegalBlockSizeException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException {
        return C4097b.m20109b(bArr, 0, bArr2, i);
    }
}
