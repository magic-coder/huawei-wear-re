package com.huawei.hwcommonmodel.p064d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import com.huawei.p190v.C2538c;
import java.io.File;

/* compiled from: ImageProcessingUtils */
public class C4728f {
    public static Bitmap m22629a(Context context, String str) {
        if (context == null || str == null || !new File(str).exists()) {
            return null;
        }
        Bitmap a = C4728f.m22631a(str, 200);
        if (a != null) {
            return C4728f.m22630a(a);
        }
        return null;
    }

    private static Bitmap m22631a(String str, int i) {
        Bitmap bitmap = null;
        File file = new File(str);
        if (file.exists()) {
            String absolutePath = file.getAbsolutePath();
            Options options = new Options();
            options.inJustDecodeBounds = true;
            Bitmap decodeFile = BitmapFactory.decodeFile(absolutePath, options);
            options.inJustDecodeBounds = false;
            if (options.outWidth >= i || options.outHeight >= i) {
                options.inSampleSize = 2;
            } else {
                options.inSampleSize = 1;
            }
            if (decodeFile == null || decodeFile.isRecycled()) {
                bitmap = decodeFile;
            } else {
                decodeFile.recycle();
            }
            try {
                bitmap = BitmapFactory.decodeFile(absolutePath, options);
            } catch (OutOfMemoryError e) {
                C2538c.e("AchieveImageLoader", new Object[]{"getThumbnailImage  OutOfMemoryError e = " + e.getMessage()});
            }
        }
        return bitmap;
    }

    public static Bitmap m22630a(Bitmap bitmap) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width <= height) {
            f = (float) width;
            f2 = (float) width;
            f3 = (float) width;
            f4 = (float) width;
            f5 = ((float) width) / 2.0f;
            height = width;
            f6 = 0.0f;
        } else {
            f5 = ((float) height) / 2.0f;
            f6 = ((float) (width - height)) / 2.0f;
            f2 = ((float) width) - f6;
            f = (float) height;
            f3 = (float) height;
            f4 = (float) height;
            width = height;
        }
        Bitmap createBitmap = Bitmap.createBitmap(height, width, Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect((int) f6, (int) null, (int) f2, (int) f);
        Rect rect2 = new Rect((int) null, (int) null, (int) f3, (int) f4);
        RectF rectF = new RectF(rect2);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f5, f5, paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect2, paint);
        return createBitmap;
    }
}
