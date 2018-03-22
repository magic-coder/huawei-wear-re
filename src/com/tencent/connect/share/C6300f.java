package com.tencent.connect.share;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.text.TextUtils;
import com.tencent.connect.share.C6294a.C62921;
import com.tencent.connect.share.C6294a.C62933;
import com.tencent.open.p532d.C6295g;
import com.tencent.open.p532d.C6412y;
import com.tencent.open.p541a.C6367n;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/* compiled from: ProGuard */
public class C6300f {
    public static final void m28904a(Context context, String str, C6295g c6295g) {
        C6367n.m29107b("AsynScaleCompressImage", "scaleCompressImage");
        if (TextUtils.isEmpty(str)) {
            c6295g.mo5300a(1, null);
        } else if (C6412y.m29253b()) {
            new Thread(new C6301g(str, new C62921(context.getMainLooper(), c6295g))).start();
        } else {
            c6295g.mo5300a(2, null);
        }
    }

    public static final void m28905a(Context context, ArrayList<String> arrayList, C6295g c6295g) {
        C6367n.m29107b("AsynScaleCompressImage", "batchScaleCompressImage");
        if (arrayList == null) {
            c6295g.mo5300a(1, null);
        } else {
            new Thread(new C6302h(arrayList, new C62933(context.getMainLooper(), c6295g))).start();
        }
    }

    private static Bitmap m28901a(Bitmap bitmap, int i) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            width = height;
        }
        float f = ((float) i) / ((float) width);
        matrix.postScale(f, f);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    protected static final String m28903a(Bitmap bitmap, String str, String str2) {
        File file = new File(str);
        if (!file.exists()) {
            file.mkdirs();
        }
        String stringBuffer = new StringBuffer(str).append(str2).toString();
        File file2 = new File(stringBuffer);
        if (file2.exists()) {
            file2.delete();
        }
        if (bitmap != null) {
            try {
                OutputStream fileOutputStream = new FileOutputStream(file2);
                bitmap.compress(CompressFormat.JPEG, 80, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                bitmap.recycle();
                return stringBuffer;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static final boolean m28908b(String str, int i, int i2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return false;
        }
        int i5 = i3 > i4 ? i3 : i4;
        if (i3 >= i4) {
            i3 = i4;
        }
        C6367n.m29107b("AsynScaleCompressImage", "longSide=" + i5 + "shortSide=" + i3);
        options.inPreferredConfig = Config.RGB_565;
        if (i5 > i2 || i3 > i) {
            return true;
        }
        return false;
    }

    public static final Bitmap m28902a(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
        }
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (options.mCancel || options.outWidth == -1 || options.outHeight == -1) {
            return null;
        }
        Bitmap decodeFile;
        if (i2 <= i3) {
            i2 = i3;
        }
        options.inPreferredConfig = Config.RGB_565;
        if (i2 > i) {
            options.inSampleSize = C6300f.m28900a(options, -1, i * i);
        }
        options.inJustDecodeBounds = false;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e2) {
            e2.printStackTrace();
            decodeFile = null;
        }
        if (decodeFile == null) {
            return null;
        }
        i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 <= i4) {
            i3 = i4;
        }
        if (i3 > i) {
            return C6300f.m28901a(decodeFile, i);
        }
        return decodeFile;
    }

    public static final int m28900a(Options options, int i, int i2) {
        int b = C6300f.m28907b(options, i, i2);
        if (b > 8) {
            return ((b + 7) / 8) * 8;
        }
        int i3 = 1;
        while (i3 < b) {
            i3 <<= 1;
        }
        return i3;
    }

    private static int m28907b(Options options, int i, int i2) {
        double d = (double) options.outWidth;
        double d2 = (double) options.outHeight;
        int ceil = i2 == -1 ? 1 : (int) Math.ceil(Math.sqrt((d * d2) / ((double) i2)));
        int min = i == -1 ? 128 : (int) Math.min(Math.floor(d / ((double) i)), Math.floor(d2 / ((double) i)));
        if (min < ceil) {
            return ceil;
        }
        if (i2 == -1 && i == -1) {
            return 1;
        }
        if (i != -1) {
            return min;
        }
        return ceil;
    }
}
