package exocr.exocrengine;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v4.view.MotionEventCompat;
import android.support.v4.view.ViewCompat;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huawei.crowdtestsdk.httpaccess.HttpStatus;
import com.huawei.wallet.utils.log.LogC;
import com.sina.weibo.sdk.constant.WBConstants;
import exocr.base.ExBaseCardInfo;
import java.util.concurrent.atomic.AtomicInteger;

public class EXOCREngine {
    private static AtomicInteger f22876a = new AtomicInteger(0);
    private static final byte[] f22877b = new byte[0];

    private static native int nativeCheckSignature(Context context);

    private static native int nativeDone();

    private static native int nativeInit(byte[] bArr);

    public static native int nativeRecoScanLineRawdata(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr2, int i10);

    static {
        try {
            System.loadLibrary("exocrenginec");
        } catch (Throwable e) {
            LogC.m28526a("BankCardRecog loadLibrary error , BankCardRecog.so not found！", e, false);
        }
    }

    public static int m29925a(Activity activity) {
        if (activity == null) {
            return 3;
        }
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 0:
                return 3;
            case 1:
                return 1;
            case 2:
                return 4;
            case 3:
                return 2;
            default:
                return 3;
        }
    }

    public static boolean m29931a(Context context) {
        String absolutePath = context.getApplicationContext().getFilesDir().getAbsolutePath();
        byte[] bArr = new byte[(absolutePath.length() + 1)];
        for (int i = 0; i < absolutePath.length(); i++) {
            bArr[i] = (byte) absolutePath.charAt(i);
        }
        bArr[absolutePath.length()] = (byte) 0;
        m29926a(bArr);
        m29933b(context.getApplicationContext());
        return true;
    }

    public static boolean m29932a(byte[] bArr, int i, int i2, Rect rect) {
        int width = rect.width();
        int i3 = rect.left;
        int i4 = rect.right - 1;
        int[] iArr = new int[WBConstants.SDK_NEW_PAY_VERSION];
        int[] iArr2 = new int[WBConstants.SDK_NEW_PAY_VERSION];
        int i5 = 0;
        while (i3 <= i4) {
            iArr[i5] = bArr[i3];
            i3++;
            i5++;
        }
        i5 = 0;
        for (i3 = 0; i3 < 8; i3++) {
            i5 += iArr[i3];
        }
        i4 = 0;
        i3 = 8;
        int i6 = 8;
        while (i4 <= 8) {
            i3++;
            i5 += iArr[i6];
            iArr2[i4] = i5 / i3;
            i4++;
            i6++;
        }
        int i7 = i6;
        i6 = 0;
        int i8 = i7;
        while (i4 < width - 8) {
            i5 += iArr[i8] - iArr[i6];
            iArr2[i4] = i5 / i3;
            i4++;
            i8++;
            i6++;
        }
        while (i4 < width) {
            i3--;
            i5 -= iArr[i6];
            iArr2[i4] = i5 / i3;
            i4++;
            i6++;
        }
        for (i3 = 0; i3 < width; i3++) {
            i5 = (iArr[i3] + 128) - iArr2[i3];
            if (i5 < 0) {
                i5 = 0;
            }
            if (i5 > 255) {
                i5 = 255;
            }
            iArr2[i3] = i5;
        }
        i5 = 0;
        i4 = 255;
        i3 = 0;
        i6 = 0;
        while (i6 < width) {
            if (iArr2[i6] > i5) {
                i5 = iArr2[i6];
            }
            if (iArr2[i6] < i4) {
                i4 = iArr2[i6];
            }
            if ((i6 & 7) == 7) {
                i5 -= i4;
                if (i5 <= i3) {
                    i5 = i3;
                }
                i4 = 0;
                i3 = 255;
            } else {
                i7 = i3;
                i3 = i4;
                i4 = i5;
                i5 = i7;
            }
            i6++;
            i7 = i5;
            i5 = i4;
            i4 = i3;
            i3 = i7;
        }
        if (i3 > 10) {
            return true;
        }
        return false;
    }

    public static ExBaseCardInfo m29930a(byte[] bArr, int i, ExBaseCardInfo exBaseCardInfo) {
        int i2 = (bArr[1] & 255) + ((bArr[0] & 255) << 8);
        i2 = (bArr[3] & 255) + ((bArr[2] & 255) << 8);
        int i3 = ((bArr[4] & 255) << 8) + (bArr[5] & 255);
        i2 = 0;
        int i4 = 6;
        while (i4 < i - 9) {
            int i5 = i4 + 1;
            int i6 = i5 + 1;
            i5 = (bArr[i5] & 255) + ((bArr[i4] & 255) << 8);
            i4 = i6 + 1;
            int i7 = i4 + 1;
            i6 = ((bArr[i6] & 255) << 8) + (bArr[i4] & 255);
            i4 = i7 + 1;
            int i8 = i4 + 1;
            i7 = ((bArr[i7] & 255) << 8) + (bArr[i4] & 255);
            i4 = i8 + 1;
            int i9 = i4 + 1;
            i8 = ((bArr[i8] & 255) << 8) + (bArr[i4] & 255);
            int i10 = i9 + 1;
            i4 = i10 + 1;
            i9 = ((bArr[i9] & 255) << 8) + (bArr[i10] & 255);
            exBaseCardInfo.setNumbersAtIndex((char) i5, i2);
            exBaseCardInfo.setRectsAtIndex(new Rect(i6, i7, i8, i9), i2);
            i2++;
        }
        exBaseCardInfo.setNumbersAtIndex('\u0000', i2);
        exBaseCardInfo.setCharCount(i2);
        int charCount = exBaseCardInfo.getCharCount();
        exBaseCardInfo.setStrNumbers();
        if (charCount < 6 || charCount > 64 || i2 != i3) {
            return null;
        }
        return exBaseCardInfo;
    }

    public static Bitmap m29929a(byte[] bArr, int i, int i2, int i3, int i4, Rect rect) {
        int width = rect.width();
        int height = rect.height();
        if (i3 != 17 && i3 != 20) {
            return null;
        }
        int[] iArr = new int[(width * height)];
        int i5 = rect.left + (rect.top * i);
        int i6 = (((rect.top / 2) * i) + ((rect.left / 2) * 2)) + (i * i2);
        int i7 = 0;
        int i8 = i5;
        while (i7 < height) {
            int i9;
            int i10 = i7 * width;
            for (int i11 = 0; i11 < width; i11++) {
                i5 = (i11 >> 1) << 1;
                int i12 = (bArr[i6 + i5] & 255) - 128;
                int i13 = (bArr[(i5 + i6) + 1] & 255) - 128;
                i9 = ((bArr[i8 + i11] & 255) - 16) * 1192;
                int i14 = i9 + (i12 * 1634);
                i5 = (i9 - (i12 * 833)) - (i13 * HttpStatus.SC_BAD_REQUEST);
                i9 += i13 * 2066;
                if (i14 < 0) {
                    i14 = 0;
                } else if (i14 > 262143) {
                    i14 = 262143;
                }
                if (i5 < 0) {
                    i5 = 0;
                } else if (i5 > 262143) {
                    i5 = 262143;
                }
                if (i9 < 0) {
                    i9 = 0;
                } else if (i9 > 262143) {
                    i9 = 262143;
                }
                i9 = (i9 >> 10) & 255;
                iArr[i10 + i11] = i9 | (((i5 >> 2) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (((i14 << 6) & 16711680) | ViewCompat.MEASURED_STATE_MASK));
            }
            i5 = i8 + i;
            if (((rect.top + i7) & 1) == 1) {
                i9 = i6 + i;
            } else {
                i9 = i6;
            }
            i7++;
            i8 = i5;
            i6 = i9;
        }
        Bitmap createBitmap = Bitmap.createBitmap(width, height, Config.ARGB_8888);
        createBitmap.setPixels(iArr, 0, width, 0, 0, width, height);
        return m29928a(createBitmap, i4);
    }

    private static Bitmap m29928a(Bitmap bitmap, int i) {
        if (i == 3) {
            Matrix matrix = new Matrix();
            matrix.setRotate(90.0f, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            float height = (float) bitmap.getHeight();
            float[] fArr = new float[9];
            matrix.getValues(fArr);
            matrix.postTranslate(height - fArr[2], 0.0f - fArr[5]);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap.getHeight(), bitmap.getWidth(), Config.ARGB_8888);
            new Canvas(createBitmap).drawBitmap(bitmap, matrix, new Paint());
            return createBitmap;
        } else if (i != 2) {
            return bitmap;
        } else {
            Matrix matrix2 = new Matrix();
            matrix2.setRotate(BitmapDescriptorFactory.HUE_CYAN, ((float) bitmap.getWidth()) / 2.0f, ((float) bitmap.getHeight()) / 2.0f);
            return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
        }
    }

    public static int m29933b(Context context) throws UnsatisfiedLinkError {
        try {
            return nativeCheckSignature(context);
        } catch (Throwable e) {
            LogC.m28526a("CardRecog nativeCheckSignature error", e, false);
            throw e;
        }
    }

    public static int m29926a(byte[] bArr) {
        int i = 0;
        synchronized (f22877b) {
            if (f22876a.incrementAndGet() != 1) {
                LogC.m28532c("exocrenginec has init. the total is " + f22876a, false);
            } else {
                try {
                    i = nativeInit(bArr);
                } catch (Throwable e) {
                    LogC.m28526a("CardRecog nativeInit error", e, false);
                }
            }
        }
        return i;
    }

    public static int m29924a() {
        int i = 0;
        synchronized (f22877b) {
            if (f22876a.decrementAndGet() != 0) {
                LogC.m28532c("exocrenginec initNum is not 0.the last times is " + f22876a, false);
            } else {
                try {
                    i = nativeDone();
                } catch (Throwable e) {
                    LogC.m28526a("CardRecog nativeDone error", e, false);
                }
            }
        }
        return i;
    }

    public static int m29927a(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, byte[] bArr2, int i10) {
        int nativeRecoScanLineRawdata;
        boolean z = false;
        try {
            nativeRecoScanLineRawdata = nativeRecoScanLineRawdata(bArr, i, i2, i3, i4, i5, i6, i7, i8, i9, bArr2, i10);
        } catch (Throwable e) {
            LogC.m28526a("CardRecog recoScanLineRawdata error", e, z);
        }
        return nativeRecoScanLineRawdata;
    }
}
