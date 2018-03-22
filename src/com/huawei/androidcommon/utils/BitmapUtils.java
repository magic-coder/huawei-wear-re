package com.huawei.androidcommon.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.ExifInterface;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import android.util.Log;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.huawei.androidcommon.constants.AC;
import java.lang.ref.WeakReference;

public class BitmapUtils {
    public static Bitmap convertToBitmap(String str, int i, int i2) {
        float f;
        float f2 = 0.0f;
        Options options = new Options();
        options.inJustDecodeBounds = true;
        options.inPreferredConfig = Config.ARGB_8888;
        BitmapFactory.decodeFile(str, options);
        int i3 = options.outWidth;
        int i4 = options.outHeight;
        if (i3 > i || i4 > i2) {
            f = ((float) i3) / ((float) i);
            f2 = ((float) i4) / ((float) i2);
        } else {
            f = 0.0f;
        }
        options.inJustDecodeBounds = false;
        options.inSampleSize = (int) Math.max(f, f2);
        return Bitmap.createScaledBitmap((Bitmap) new WeakReference(BitmapFactory.decodeFile(str, options)).get(), i, i2, true);
    }

    public static Bitmap ImageCrop(String str, boolean z) {
        Bitmap bitmap = null;
        Bitmap decodeFile = BitmapFactory.decodeFile(str);
        if (decodeFile != null) {
            int i;
            int width = decodeFile.getWidth();
            int height = decodeFile.getHeight();
            int i2 = width > height ? height : width;
            if (width > height) {
                i = (width - height) / 2;
            } else {
                i = 0;
            }
            bitmap = Bitmap.createBitmap(decodeFile, i, width > height ? 0 : (height - width) / 2, i2, i2, null, false);
            if (!(!z || decodeFile == null || decodeFile.equals(bitmap) || decodeFile.isRecycled())) {
                decodeFile.recycle();
            }
        }
        return bitmap;
    }

    public static Bitmap getScaleBitmap(String str, int i) {
        Bitmap decodeFile;
        if (str == null || str.isEmpty()) {
            return null;
        }
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        int i2 = options.outWidth;
        int i3 = options.outHeight;
        if (i2 <= 0 || i3 <= 0) {
            return null;
        }
        int i4;
        Bitmap bitmap;
        if (i2 <= i || i3 <= i) {
            i4 = i2 > i3 ? i3 : i2;
        } else {
            i4 = i;
        }
        i2 = (int) Math.floor((double) (((float) i2) / ((float) i4)));
        int floor = (int) Math.floor((double) (((float) i3) / ((float) i4)));
        if (i2 <= 1 && floor <= 1) {
            floor = 1;
        } else if (i2 <= floor) {
            floor = i2;
        }
        if (floor < 1) {
            floor = 1;
        }
        options.inSampleSize = floor;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
            if (decodeFile != null) {
                try {
                    i2 = decodeFile.getWidth();
                    int height = decodeFile.getHeight();
                    bitmap = decodeFile;
                    decodeFile = Bitmap.createBitmap(decodeFile, i2 > height ? (i2 - height) / 2 : 0, i2 > height ? 0 : (height - i2) / 2, i4, i4, null, false);
                } catch (OutOfMemoryError e) {
                    Log.e(AC.TAG, " get scale image error ,out of memory");
                    bitmap = decodeFile;
                    decodeFile = null;
                    if (bitmap == null) {
                        return decodeFile;
                    }
                    bitmap.recycle();
                    return decodeFile;
                }
                if (bitmap == null) {
                    return decodeFile;
                }
                bitmap.recycle();
                return decodeFile;
            }
        } catch (OutOfMemoryError e2) {
            decodeFile = null;
            Log.e(AC.TAG, " get scale image error ,out of memory");
            bitmap = decodeFile;
            decodeFile = null;
            if (bitmap == null) {
                return decodeFile;
            }
            bitmap.recycle();
            return decodeFile;
        }
        bitmap = decodeFile;
        decodeFile = null;
        if (bitmap == null) {
            return decodeFile;
        }
        bitmap.recycle();
        return decodeFile;
    }

    public static Bitmap getImageThumbnail(String str, int i, int i2) {
        int i3 = 1;
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeFile(str, options);
            options.inJustDecodeBounds = false;
            int i4 = options.outWidth / i;
            int i5 = options.outHeight / i2;
            if (i4 >= i5) {
                i4 = i5;
            }
            if (i4 > 0) {
                i3 = i4;
            }
            options.inSampleSize = i3;
            return ThumbnailUtils.extractThumbnail(BitmapFactory.decodeFile(str, options), i, i2, 2);
        } catch (Exception e) {
            return null;
        }
    }

    public static Bitmap getScaleBitmap(String str, int i, int i2) {
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
        Bitmap rotateBitmap;
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
        if (ceil2 < 1) {
            ceil2 = 1;
        }
        options.inSampleSize = ceil2;
        options.inJustDecodeBounds = false;
        options.inPurgeable = true;
        options.inInputShareable = true;
        try {
            decodeFile = BitmapFactory.decodeFile(str, options);
        } catch (OutOfMemoryError e) {
            Log.e(AC.TAG, " get scale image error ,out of memory");
            decodeFile = null;
        }
        if (decodeFile != null) {
            rotateBitmap = rotateBitmap(str, decodeFile);
        } else {
            rotateBitmap = null;
        }
        if (rotateBitmap == null || rotateBitmap == decodeFile) {
            return decodeFile;
        }
        decodeFile.recycle();
        return rotateBitmap;
    }

    public static Bitmap rotateBitmap(String str, Bitmap bitmap) {
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
        } catch (Throwable e) {
            Log.e(AC.TAG, " can not rotate the img", e);
        }
        return null;
    }

    public static Bitmap rotateBitmap(String str, int i, int i2) {
        Object obj = 1;
        Bitmap decodeSampledBitmap = decodeSampledBitmap(str, i, i2);
        try {
            int attributeInt = new ExifInterface(str).getAttributeInt("Orientation", 1);
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
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                return Bitmap.createBitmap(decodeSampledBitmap, 0, 0, decodeSampledBitmap.getWidth(), decodeSampledBitmap.getHeight(), matrix, true);
            }
            return decodeSampledBitmap;
        } catch (Throwable e) {
            Log.e(AC.TAG, "Error", e);
            return decodeSampledBitmap;
        }
    }

    public static Bitmap decodeSampledBitmap(Resources resources, int i, int i2, int i3) {
        return decodeSampledBitmap(i2, i3, null, resources, i);
    }

    public static Bitmap decodeSampledBitmap(String str, int i, int i2) {
        return decodeSampledBitmap(i, i2, str, null, 0);
    }

    public static Bitmap decodeSampledBitmap(int i, int i2, String str, Resources resources, int i3) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        if (TextUtils.isEmpty(str)) {
            BitmapFactory.decodeResource(resources, i3, options);
        } else {
            BitmapFactory.decodeFile(str, options);
        }
        options.inSampleSize = calculateInSampleSize(options, i, i2);
        options.inJustDecodeBounds = false;
        if (TextUtils.isEmpty(str)) {
            return BitmapFactory.decodeResource(resources, i3, options);
        }
        return BitmapFactory.decodeFile(str, options);
    }

    public static int calculateInSampleSize(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        if (i3 <= i2 && i4 <= i) {
            return 1;
        }
        if (i4 - i > i3 - i2) {
            return Math.round(((float) i4) / ((float) i));
        }
        return Math.round(((float) i3) / ((float) i2));
    }

    public static Drawable resizeImage(Context context, int i, int i2, int i3) {
        Bitmap decodeResource = BitmapFactory.decodeResource(context.getResources(), i);
        int width = decodeResource.getWidth();
        int height = decodeResource.getHeight();
        float f = ((float) i2) / ((float) width);
        float f2 = ((float) i3) / ((float) height);
        Matrix matrix = new Matrix();
        matrix.postScale(f, f2);
        return new BitmapDrawable(context.getResources(), Bitmap.createBitmap(decodeResource, 0, 0, width, height, matrix, true));
    }

    public static Bitmap readBitMap(Context context, int i) {
        Options options = new Options();
        options.inPreferredConfig = Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        return BitmapFactory.decodeStream(context.getResources().openRawResource(i), null, options);
    }
}
