package com.huawei.wallet.utils.bitmap;

import android.graphics.Bitmap;
import android.text.TextUtils;
import java.util.concurrent.locks.ReentrantLock;

public final class BitmapLruCacheForLocal {
    private static volatile BitmapLruCacheForLocal f21608a;
    private static ReentrantLock f21609c = new ReentrantLock();
    private final BitmapCache f21610b = new BitmapCache(37748736);

    private BitmapLruCacheForLocal() {
    }

    public static BitmapLruCacheForLocal m28495a() {
        if (f21608a == null) {
            f21609c.lock();
            try {
                if (f21608a == null) {
                    f21608a = new BitmapLruCacheForLocal();
                }
                f21609c.unlock();
            } catch (Throwable th) {
                f21609c.unlock();
            }
        }
        return f21608a;
    }

    private void m28496a(Bitmap bitmap, String str) {
        f21609c.lock();
        try {
            if (TextUtils.isEmpty(str) || bitmap == null || bitmap.isRecycled()) {
                f21609c.unlock();
                return;
            }
            if (this.f21610b.get(str) == null) {
                this.f21610b.put(str, bitmap);
            }
            f21609c.unlock();
        } catch (Throwable th) {
            f21609c.unlock();
        }
    }

    public Bitmap m28497a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        Bitmap a = this.f21610b.m28493a(str);
        if (a != null && !a.isRecycled()) {
            return a;
        }
        a = BpDecodeUtil.m28500a(str, 984, 608);
        m28496a(a, str);
        return a;
    }

    public void m28498b(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f21610b.remove(str);
        }
    }
}
