package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import java.io.FileDescriptor;

/* compiled from: ImageResizer */
public class bc extends bd {
    protected int f11488a;
    protected int f11489b;

    public bc(Context context, int i, int i2) {
        super(context);
        m15607a(i, i2);
    }

    public void m15607a(int i, int i2) {
        this.f11488a = i;
        this.f11489b = i2;
    }

    private Bitmap m15603a(int i) {
        bf.m15627a("ImageResizer", "processBitmap - " + i, 111);
        return m15604a(this.d, i, this.f11488a, this.f11489b, m15590a());
    }

    protected Bitmap mo4015a(Object obj) {
        return m15603a(Integer.parseInt(String.valueOf(obj)));
    }

    public static Bitmap m15604a(Resources resources, int i, int i2, int i3, ba baVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(resources, i, options);
        options.inSampleSize = m15602a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(resources, i, options);
    }

    public static Bitmap m15605a(FileDescriptor fileDescriptor, int i, int i2, ba baVar) {
        Options options = new Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
        options.inSampleSize = m15602a(options, i, i2);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFileDescriptor(fileDescriptor, null, options);
    }

    public static int m15602a(Options options, int i, int i2) {
        int i3 = options.outHeight;
        int i4 = options.outWidth;
        int i5 = 1;
        if (i3 > i2 || i4 > i) {
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
