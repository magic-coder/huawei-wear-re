package com.huawei.phoneserviceuni.common.p132d;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import java.io.IOException;

/* compiled from: UiUtils */
public class C1374f {
    private static Toast f2959a = null;
    private static int f2960b = -1;

    public static int m6143a(Context context) {
        return C1374f.m6154f(context).widthPixels;
    }

    private static DisplayMetrics m6154f(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        if (context != null) {
            ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        }
        return displayMetrics;
    }

    public static void m6148a(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            if (f2959a == null) {
                f2959a = Toast.makeText(context, str, 1);
            } else {
                f2959a.setText(str);
                f2959a.setDuration(1);
            }
            f2959a.show();
        }
    }

    public static Bitmap m6144a(String str, int i, int i2) {
        if (str == null || str.isEmpty()) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        float f = (float) options.outWidth;
        float f2 = (float) options.outHeight;
        if (f <= 0.0f || f2 <= 0.0f) {
            return null;
        }
        Bitmap decodeFile;
        Bitmap a;
        float f3 = (float) i;
        float f4 = (float) i2;
        if (f3 <= 0.0f) {
            f3 = 312.0f;
        }
        if (f4 <= 0.0f) {
            f4 = BitmapDescriptorFactory.HUE_CYAN;
        }
        int ceil = (int) Math.ceil((double) (f / f3));
        int ceil2 = (int) Math.ceil((double) (f2 / f4));
        if (ceil <= 1 && ceil2 <= 1) {
            ceil2 = 1;
        } else if (ceil > ceil2) {
            ceil2 = ceil;
        }
        options.inSampleSize = ceil2;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            C1373c.m6141d("UiUtils", " get scale image error ,out of memory");
            decodeFile = null;
        }
        if (decodeFile != null) {
            a = C1374f.m6145a(str, decodeFile);
        } else {
            a = null;
        }
        if (a == null || a == decodeFile) {
            return decodeFile;
        }
        decodeFile.recycle();
        return a;
    }

    public static Bitmap m6145a(String str, Bitmap bitmap) {
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 0);
            if (attributeInt != 1) {
                Matrix matrix = new Matrix();
                switch (attributeInt) {
                    case 3:
                        matrix.postRotate(BitmapDescriptorFactory.HUE_CYAN);
                        break;
                    case 6:
                        matrix.postRotate(90.0f);
                        break;
                    case 8:
                        matrix.postRotate(BitmapDescriptorFactory.HUE_VIOLET);
                        break;
                }
                return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            }
        } catch (IOException e) {
            C1373c.m6141d("UiUtils", " can not rotate the img");
        }
        return null;
    }

    public static void m6146a(Activity activity) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService("input_method");
        View currentFocus = activity.getCurrentFocus();
        if (currentFocus != null) {
            inputMethodManager.hideSoftInputFromWindow(currentFocus.getWindowToken(), 2);
        }
    }

    public static boolean m6150b(Context context) {
        return context.getResources().getConfiguration().orientation == 2;
    }

    public static float m6142a(Context context, int i) {
        return ((float) i) * C1374f.m6154f(context).density;
    }

    public static boolean m6151c(Context context) {
        int i = context.getResources().getConfiguration().smallestScreenWidthDp;
        C1373c.m6139b("UiUtils", "isPad::smallSW=" + i);
        return i >= 530;
    }

    public static void m6147a(Context context, View view, boolean z) {
        if (z && view != null && C1374f.m6151c(context)) {
            view.setPadding(C1374f.m6152d(context), 0, C1374f.m6152d(context), 0);
        }
    }

    public static int m6152d(Context context) {
        if (C1374f.m6151c(context) && C1374f.m6150b(context)) {
            return C1374f.m6143a(context) / 12;
        }
        return 0;
    }

    public static int m6149b(Context context, int i) {
        if (context == null) {
            return -1;
        }
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(i) * 2;
        if (!C1374f.m6151c(context)) {
            return ((int) C1374f.m6142a(context, context.getResources().getConfiguration().smallestScreenWidthDp)) - dimensionPixelSize;
        }
        int a = C1374f.m6143a(context);
        if (C1374f.m6150b(context)) {
            return (a / 2) - dimensionPixelSize;
        }
        return (a - (a / 4)) - dimensionPixelSize;
    }

    public static int m6153e(Context context) {
        int identifier = context.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
        return identifier != 0 ? identifier : 16973934;
    }
}
