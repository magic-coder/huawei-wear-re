package com.google.zxing.client.android.p290c;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.util.Log;

/* compiled from: BitmapUtil */
public class C3783a {
    public static Bitmap m19012a(String str, int i, int i2) {
        Bitmap bitmap = null;
        Options options = new Options();
        try {
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inSampleSize = C3783a.m19010a(options, i, i2);
            options.inJustDecodeBounds = false;
            bitmap = C3783a.m19011a(BitmapFactory.decodeFile(str, options));
        } catch (OutOfMemoryError e) {
            Log.e("BitmapUtil", "hwsns decodeSampledBitmapFromFile OutOfMemoryError ");
        }
        return bitmap;
    }

    private static Bitmap m19011a(Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        if (width >= height) {
            width = height;
        }
        height = (width / 2) * 2;
        width = bitmap.getWidth();
        int height2 = bitmap.getHeight();
        Bitmap createBitmap = height2 > width ? Bitmap.createBitmap(bitmap, 0, (height2 - width) / 2, width, width) : height2 < width ? Bitmap.createBitmap(bitmap, (width - height2) / 2, 0, height2, height2) : bitmap;
        if (createBitmap.getWidth() == height && createBitmap.getHeight() == height) {
            bitmap2 = createBitmap;
        } else {
            bitmap2 = Bitmap.createScaledBitmap(createBitmap, height, height, true);
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(bitmap2.getWidth(), bitmap2.getHeight(), Config.ARGB_8888);
        if (createBitmap2 != null) {
            Canvas canvas = new Canvas(createBitmap2);
            Paint paint = new Paint();
            Rect rect = new Rect(0, 0, bitmap2.getWidth(), bitmap2.getHeight());
            paint.setAntiAlias(true);
            paint.setFilterBitmap(true);
            paint.setDither(true);
            canvas.drawARGB(0, 0, 0, 0);
            int width2 = bitmap2.getWidth() / 2;
            canvas.drawCircle((float) width2, (float) (bitmap2.getHeight() / 2), (float) width2, paint);
            paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
            canvas.drawBitmap(bitmap2, rect, rect, paint);
        }
        bitmap.recycle();
        if (!(createBitmap == null || createBitmap.isRecycled())) {
            createBitmap.recycle();
        }
        if (!(bitmap2 == null || bitmap2.isRecycled())) {
            bitmap2.recycle();
        }
        return createBitmap2;
    }

    private static int m19010a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i2 > 0 && i > 0 && (i3 > i2 || i4 > i)) {
            i5 = Math.round(((float) i3) / ((float) i2));
            int round = Math.round(((float) i4) / ((float) i));
            if (i5 >= round) {
                i5 = round;
            }
            float f = (float) (i4 * i3);
            while (f / ((float) (i5 * i5)) > ((float) ((i * i2) * 2))) {
                i5++;
            }
        }
        return i5;
    }
}
