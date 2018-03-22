package com.huawei.pluginkidwatch.common.ui.p150a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import com.huawei.p190v.C2538c;
import java.io.FileNotFoundException;

/* compiled from: MediaManager */
public class C1508i {
    public static Bitmap m6981a(Context context, Uri uri) {
        try {
            return BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            C2538c.m12680e("MediaManager", "Exception e = " + e.getMessage());
            return null;
        }
    }
}
