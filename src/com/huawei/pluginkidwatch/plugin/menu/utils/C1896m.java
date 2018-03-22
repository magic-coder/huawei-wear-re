package com.huawei.pluginkidwatch.plugin.menu.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.widget.ImageView;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.lib.p147b.C1465a;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;

/* compiled from: ImageLoader */
public class C1896m {
    private C1465a f6214a = C1465a.m6770a();
    private C1885a f6215b;
    private Map<ImageView, String> f6216c = Collections.synchronizedMap(new WeakHashMap());

    public C1896m(Context context) {
        this.f6215b = new C1892i(context);
    }

    public Bitmap m9665a(String str) {
        Bitmap bitmap;
        File a = this.f6215b.m9645a(str);
        if (a == null || !a.exists()) {
            bitmap = null;
        } else {
            bitmap = m9664a(a);
        }
        return bitmap != null ? bitmap : null;
    }

    public Bitmap m9664a(File file) {
        try {
            Options options = new Options();
            options.inJustDecodeBounds = true;
            BitmapFactory.decodeStream(new FileInputStream(file), null, options);
            int i = options.outWidth;
            int i2 = options.outHeight;
            int i3 = 1;
            while (i / 2 >= 100 && i2 / 2 >= 100) {
                i /= 2;
                i2 /= 2;
                i3 *= 2;
            }
            Options options2 = new Options();
            options2.inSampleSize = i3;
            return BitmapFactory.decodeStream(new FileInputStream(file), null, options2);
        } catch (FileNotFoundException e) {
            C2538c.m12680e("ImageLoader", "Exception e = " + e.getMessage());
            return null;
        }
    }
}
