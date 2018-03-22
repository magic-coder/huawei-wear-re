package com.huawei.pluginkidwatch.common.ui.simplecropimage;

import android.app.Activity;
import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.media.ExifInterface;
import android.os.Handler;
import com.android.volley.DefaultRetryPolicy;
import com.huawei.p190v.C2538c;
import java.io.Closeable;
import java.io.IOException;

/* compiled from: Util */
public class C1562y {
    public static Bitmap m7179a(Matrix matrix, Bitmap bitmap, int i, int i2, boolean z) {
        int width = bitmap.getWidth() - i;
        int height = bitmap.getHeight() - i2;
        if (z || (width >= 0 && height >= 0)) {
            Matrix matrix2;
            Bitmap createBitmap;
            float width2 = (float) bitmap.getWidth();
            float height2 = (float) bitmap.getHeight();
            if (width2 / height2 > ((float) i) / ((float) i2)) {
                width2 = ((float) i2) / height2;
                if (width2 < 0.9f || width2 > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    matrix.setScale(width2, width2);
                } else {
                    matrix = null;
                }
                matrix2 = matrix;
            } else {
                width2 = ((float) i) / width2;
                if (width2 < 0.9f || width2 > DefaultRetryPolicy.DEFAULT_BACKOFF_MULT) {
                    matrix.setScale(width2, width2);
                    matrix2 = matrix;
                } else {
                    matrix2 = null;
                }
            }
            if (matrix2 != null) {
                createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix2, true);
            } else {
                createBitmap = bitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap, Math.max(0, createBitmap.getWidth() - i) / 2, Math.max(0, createBitmap.getHeight() - i2) / 2, i, i2);
            if (createBitmap != bitmap) {
                createBitmap.recycle();
            }
            return createBitmap2;
        }
        Bitmap createBitmap3 = Bitmap.createBitmap(i, i2, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap3);
        width = Math.max(0, width / 2);
        int max = Math.max(0, height / 2);
        Rect rect = new Rect(width, max, Math.min(i, bitmap.getWidth()) + width, Math.min(i2, bitmap.getHeight()) + max);
        max = (i - rect.width()) / 2;
        width = (i2 - rect.height()) / 2;
        canvas.drawBitmap(bitmap, rect, new Rect(max, width, i - max, i2 - width), null);
        return createBitmap3;
    }

    public static void m7181a(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                C2538c.m12680e("db.Util", "IOException e = " + e.getMessage());
            }
        }
    }

    public static void m7180a(MonitoredActivity monitoredActivity, String str, String str2, Runnable runnable, Handler handler) {
        new Thread(new C1563z(monitoredActivity, runnable, ProgressDialog.show(monitoredActivity, str, str2, true, false), handler)).start();
    }

    public static Bitmap m7178a(Bitmap bitmap, float f) {
        Bitmap createBitmap;
        Matrix matrix = new Matrix();
        matrix.postRotate(f);
        try {
            createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError e) {
            C2538c.m12680e("db.Util", "Exception e = " + e.getMessage());
            createBitmap = null;
        }
        if (createBitmap == null) {
            createBitmap = bitmap;
        }
        if (bitmap != createBitmap) {
            bitmap.recycle();
        }
        return createBitmap;
    }

    public static int m7176a(Activity activity) {
        switch (activity.getWindowManager().getDefaultDisplay().getRotation()) {
            case 1:
                return 90;
            case 2:
                return 180;
            case 3:
                return 270;
            default:
                return 0;
        }
    }

    public static int m7177a(String str) {
        try {
            switch (new ExifInterface(str).getAttributeInt("Orientation", 1)) {
                case 3:
                    return 180;
                case 6:
                    return 90;
                case 8:
                    return 270;
                default:
                    return 0;
            }
        } catch (IOException e) {
            C2538c.m12680e("db.Util", "Exception e = " + e.getMessage());
            return 0;
        }
    }
}
