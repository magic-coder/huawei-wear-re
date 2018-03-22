package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

final class C0410b extends LruCache<C0414f, Bitmap> {
    protected int m506a(C0414f c0414f, Bitmap bitmap) {
        return bitmap.getHeight() * bitmap.getRowBytes();
    }

    protected void m507a(boolean z, C0414f c0414f, Bitmap bitmap, Bitmap bitmap2) {
        super.entryRemoved(z, c0414f, bitmap, bitmap2);
    }

    protected /* synthetic */ void entryRemoved(boolean z, Object obj, Object obj2, Object obj3) {
        m507a(z, (C0414f) obj, (Bitmap) obj2, (Bitmap) obj3);
    }

    protected /* synthetic */ int sizeOf(Object obj, Object obj2) {
        return m506a((C0414f) obj, (Bitmap) obj2);
    }
}
