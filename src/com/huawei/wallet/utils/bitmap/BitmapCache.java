package com.huawei.wallet.utils.bitmap;

import android.graphics.Bitmap;
import android.util.LruCache;

public class BitmapCache extends LruCache<String, Bitmap> {
    protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        m28494a(z, (String) obj, (Bitmap) obj2, (Bitmap) obj3);
    }

    protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return m28492a((String) obj, (Bitmap) obj2);
    }

    public BitmapCache(int i) {
        super(i);
    }

    protected void m28494a(boolean z, String str, Bitmap bitmap, Bitmap bitmap2) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
    }

    public Bitmap m28493a(String str) {
        return (Bitmap) get(str);
    }

    protected int m28492a(String str, Bitmap bitmap) {
        return bitmap.getByteCount();
    }
}
