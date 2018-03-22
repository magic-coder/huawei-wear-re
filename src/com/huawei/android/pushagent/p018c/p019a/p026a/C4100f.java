package com.huawei.android.pushagent.p018c.p019a.p026a;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;

public class C4100f {
    public static String m20113a(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C4096a.m20099a(str);
    }

    public static byte[] m20114a(byte[] bArr, String str) {
        byte[] bArr2 = null;
        try {
            bArr2 = C4101g.m20119a(bArr, str);
        } catch (Throwable e) {
            e.c("PushLogSC2712", "rsa encrypt data error ", e);
        }
        return bArr2;
    }

    public static byte[] m20115a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            bArr3 = C4098c.m20110a(bArr, 0, bArr2, 0);
        } catch (Throwable e) {
            e.c("PushLogSC2712", "InvalidKeyException:" + e.getMessage(), e);
        } catch (Throwable e2) {
            e.c("PushLogSC2712", "BadPaddingException:" + e2.getMessage(), e2);
        } catch (Throwable e22) {
            e.c("PushLogSC2712", "IllegalBlockSizeException:" + e22.getMessage(), e22);
        } catch (Throwable e222) {
            e.c("PushLogSC2712", "NoSuchAlgorithmException:" + e222.getMessage(), e222);
        } catch (Throwable e2222) {
            e.c("PushLogSC2712", "NoSuchPaddingException:" + e2222.getMessage(), e2222);
        } catch (Throwable e22222) {
            e.c("PushLogSC2712", "Exception:" + e22222.getMessage(), e22222);
        }
        return bArr3;
    }

    public static String m20116b(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : C4096a.m20104b(str);
    }

    public static byte[] m20117b(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = null;
        try {
            bArr3 = C4098c.m20111a(bArr, bArr2, 0);
        } catch (Throwable e) {
            e.c("PushLogSC2712", "InvalidKeyException:" + e.getMessage(), e);
        } catch (Throwable e2) {
            e.c("PushLogSC2712", "BadPaddingException:" + e2.getMessage(), e2);
        } catch (Throwable e22) {
            e.c("PushLogSC2712", "IllegalBlockSizeException:" + e22.getMessage(), e22);
        } catch (Throwable e222) {
            e.c("PushLogSC2712", "NoSuchAlgorithmException:" + e222.getMessage(), e222);
        } catch (Throwable e2222) {
            e.c("PushLogSC2712", "NoSuchPaddingException:" + e2222.getMessage(), e2222);
        } catch (Throwable e22222) {
            e.c("PushLogSC2712", "Exception:" + e22222.getMessage(), e22222);
        }
        return bArr3;
    }
}
