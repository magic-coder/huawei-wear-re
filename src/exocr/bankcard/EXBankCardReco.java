package exocr.bankcard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.wallet.utils.log.LogC;
import com.sina.weibo.sdk.component.GameManager;
import com.snowballtech.business.constant.BusinessCode;
import java.io.UnsupportedEncodingException;

public final class EXBankCardReco {
    private static boolean f22875a = false;

    private static native int nativeCheckSignature(Context context);

    private static native float nativeFocusScore(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native int nativeGetVersion(byte[] bArr);

    private static native Bitmap nativeRecoNV21ST(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, byte[] bArr2, int i11, int[] iArr);

    private static synchronized void m29921b() {
        synchronized (EXBankCardReco.class) {
            if (!f22875a) {
                try {
                    System.loadLibrary("BankCardRecog");
                    f22875a = true;
                    LogC.m28532c("ExBankCardRecog version : " + m29919a(), false);
                } catch (Throwable e) {
                    LogC.m28526a("BankCardRecog loadLibrary error , BankCardRecog.so not found！", e, false);
                }
            }
        }
    }

    public static boolean m29920a(byte[] bArr, int i, EXBankCardInfo eXBankCardInfo) {
        boolean z = true;
        m29921b();
        if (eXBankCardInfo == null || i < BusinessCode.CURRENCY_CODE_RMB) {
            return false;
        }
        int i2 = ((bArr[0] & 255) << 8) + (bArr[1] & 255);
        i2 = (bArr[3] & 255) + ((bArr[2] & 255) << 8);
        int i3 = 133;
        for (i2 = 1; i2 < 8; i2++) {
            i3++;
        }
        i2 = i3 + 1;
        int i4 = i2 + 1;
        i2 = (bArr[i2] & 255) + ((bArr[i3] & 255) << 8);
        i2 = i4 + 1;
        i3 = bArr[i4] & 255;
        i4 = i2 + 1;
        i2 = (bArr[i2] & 255) + (i3 << 8);
        i3 = i4 + 1;
        i4 = ((bArr[i4] & 255) << 8) + (bArr[i3] & 255);
        i3++;
        i2 = 0;
        while (i3 < i - 9) {
            int i5 = i3 + 1;
            int i6 = i5 + 1;
            i5 = (bArr[i5] & 255) + ((bArr[i3] & 255) << 8);
            i3 = i6 + 1;
            int i7 = i3 + 1;
            i6 = ((bArr[i6] & 255) << 8) + (bArr[i3] & 255);
            i3 = i7 + 1;
            int i8 = i3 + 1;
            i7 = ((bArr[i7] & 255) << 8) + (bArr[i3] & 255);
            i3 = i8 + 1;
            int i9 = i3 + 1;
            i8 = ((bArr[i8] & 255) << 8) + (bArr[i3] & 255);
            int i10 = i9 + 1;
            i3 = i10 + 1;
            i9 = ((bArr[i9] & 255) << 8) + (bArr[i10] & 255);
            eXBankCardInfo.setNumbersAtIndex((char) i5, i2);
            eXBankCardInfo.setRectsAtIndex(new Rect(i6, i7, i8 + i6, i9 + i7), i2);
            i2++;
        }
        eXBankCardInfo.setNumbersAtIndex('\u0000', i2);
        eXBankCardInfo.setCharCount(i2);
        i3 = eXBankCardInfo.getCharCount();
        eXBankCardInfo.setStrNumbers();
        if (i3 < 10 || i3 > 24 || i2 != i4) {
            z = false;
        }
        return z;
    }

    private static float m29915a(byte[] bArr, int i, int i2) {
        int i3;
        int i4 = 0;
        int i5 = (i2 / 2) - (i2 / 4);
        int i6 = (i2 / 2) + (i2 / 4);
        int i7 = (i / 2) - (i / 4);
        int i8 = (i / 2) + (i / 4);
        int i9 = 0;
        for (int i10 = i5; i10 < i6; i10++) {
            i3 = (i10 * i) + i7;
            int i11 = i7;
            while (i11 < i8) {
                int abs = Math.abs((((bArr[(i3 - i) - 1] & 255) + (bArr[(i3 + i) + 1] & 255)) - (bArr[(i3 - i) + 1] & 255)) - (bArr[(i3 + i) - 1] & 255));
                i9 += abs;
                i4 += abs * abs;
                i11++;
                i3++;
            }
        }
        i3 = (i8 - i7) * (i6 - i5);
        double d = (double) ((((float) i9) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i3));
        return (float) Math.sqrt(((double) ((((float) i4) * DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) / ((float) i3))) - (d * d));
    }

    public static String m29919a() {
        m29921b();
        byte[] bArr = new byte[256];
        try {
            nativeGetVersion(bArr);
            int i = 0;
            int i2 = 0;
            while (i < bArr.length && bArr[i] != (byte) 0) {
                i2++;
                i++;
            }
            try {
                return new String(bArr, 0, i2, GameManager.DEFAULT_CHARSET);
            } catch (UnsupportedEncodingException e) {
                LogC.m28532c("BankCardRecog version encoding error ", false);
                return null;
            }
        } catch (Throwable e2) {
            LogC.m28526a("BankCardRecog nativeGetVersion error", e2, false);
        }
    }

    public static Bitmap m29918a(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, byte[] bArr2, int i9, int[] iArr) {
        m29921b();
        try {
            return nativeRecoNV21ST(bArr, i, i2, i3, i4, i5, i6, i7, i8, 1, 1, bArr2, i9, iArr);
        } catch (Throwable e) {
            LogC.m28526a("BankCardRecog nativeRecoRawdat error", e, false);
            return null;
        }
    }

    public static float m29916a(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        m29921b();
        try {
            return nativeFocusScore(bArr, i, i2, i3, i4, i5, i6, i7);
        } catch (Throwable e) {
            LogC.m28526a("BankCardRecog nativeFocusScore error", e, false);
            float a = m29915a(bArr, i, i2);
            LogC.m28532c("getFocusScore result: " + a, false);
            return a;
        }
    }

    public static int m29917a(Context context) throws UnsatisfiedLinkError {
        m29921b();
        try {
            return nativeCheckSignature(context);
        } catch (Throwable e) {
            LogC.m28526a("BankCardRecog nativeCheckSignature error", e, false);
            throw e;
        }
    }
}
