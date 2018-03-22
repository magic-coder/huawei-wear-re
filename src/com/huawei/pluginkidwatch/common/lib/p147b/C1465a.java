package com.huawei.pluginkidwatch.common.lib.p147b;

import android.graphics.Bitmap;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

/* compiled from: BitmapCache */
public class C1465a {
    private static long f3402c = LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME;
    private static C1465a f3403d = null;
    private Map<String, Bitmap> f3404a = Collections.synchronizedMap(new LinkedHashMap(10, 1.5f, true));
    private long f3405b = 0;

    public static C1465a m6770a() {
        if (f3403d == null) {
            f3403d = new C1465a();
            C1465a.m6771a(Runtime.getRuntime().maxMemory() / 4);
        }
        return f3403d;
    }

    public void m6774a(String str) {
        if (!"".equals(str) && this.f3404a != null && this.f3404a.containsKey(str)) {
            this.f3404a.remove(str);
        }
    }

    public static void m6771a(long j) {
        f3402c = j;
    }

    public Bitmap m6776b(String str) {
        if (!"".equals(str) && this.f3404a.containsKey(str)) {
            return (Bitmap) this.f3404a.get(str);
        }
        return null;
    }

    public void m6775a(String str, Bitmap bitmap) {
        try {
            if (this.f3404a.containsKey(str)) {
                this.f3405b -= m6773a((Bitmap) this.f3404a.get(str));
            }
            this.f3404a.put(str, bitmap);
            this.f3405b += m6773a(bitmap);
            m6772b();
        } catch (Throwable th) {
            C2538c.m12680e("MemoryCache", "Throwable th = " + th.getMessage());
        }
    }

    private void m6772b() {
        if (this.f3405b > f3402c) {
            Iterator it = this.f3404a.entrySet().iterator();
            while (it.hasNext()) {
                this.f3405b -= m6773a((Bitmap) ((Entry) it.next()).getValue());
                it.remove();
                if (this.f3405b <= f3402c) {
                    return;
                }
            }
        }
    }

    long m6773a(Bitmap bitmap) {
        if (bitmap == null) {
            return 0;
        }
        return ((long) bitmap.getRowBytes()) * ((long) bitmap.getHeight());
    }
}
