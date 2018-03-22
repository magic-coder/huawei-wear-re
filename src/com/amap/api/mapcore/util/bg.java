package com.amap.api.mapcore.util;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

/* compiled from: LruCache */
public class bg<K, V> {
    private final LinkedHashMap<K, V> f11458a;
    private int f11459b;
    private int f11460c;
    private int f11461d;
    private int f11462e;
    private int f11463f;
    private int f11464g;
    private int f11465h;

    public bg(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        }
        this.f11460c = i;
        this.f11458a = new LinkedHashMap(0, 0.75f, true);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final V m15550a(K r5) {
        /*
        r4 = this;
        if (r5 != 0) goto L_0x000a;
    L_0x0002:
        r0 = new java.lang.NullPointerException;
        r1 = "key == null";
        r0.<init>(r1);
        throw r0;
    L_0x000a:
        monitor-enter(r4);
        r0 = r4.f11458a;	 Catch:{ all -> 0x002a }
        r0 = r0.get(r5);	 Catch:{ all -> 0x002a }
        if (r0 == 0) goto L_0x001b;
    L_0x0013:
        r1 = r4.f11464g;	 Catch:{ all -> 0x002a }
        r1 = r1 + 1;
        r4.f11464g = r1;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
    L_0x001a:
        return r0;
    L_0x001b:
        r0 = r4.f11465h;	 Catch:{ all -> 0x002a }
        r0 = r0 + 1;
        r4.f11465h = r0;	 Catch:{ all -> 0x002a }
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        r1 = r4.m15553b(r5);
        if (r1 != 0) goto L_0x002d;
    L_0x0028:
        r0 = 0;
        goto L_0x001a;
    L_0x002a:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x002a }
        throw r0;
    L_0x002d:
        monitor-enter(r4);
        r0 = r4.f11462e;	 Catch:{ all -> 0x0053 }
        r0 = r0 + 1;
        r4.f11462e = r0;	 Catch:{ all -> 0x0053 }
        r0 = r4.f11458a;	 Catch:{ all -> 0x0053 }
        r0 = r0.put(r5, r1);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0049;
    L_0x003c:
        r2 = r4.f11458a;	 Catch:{ all -> 0x0053 }
        r2.put(r5, r0);	 Catch:{ all -> 0x0053 }
    L_0x0041:
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        if (r0 == 0) goto L_0x0056;
    L_0x0044:
        r2 = 0;
        r4.mo4014a(r2, r5, r1, r0);
        goto L_0x001a;
    L_0x0049:
        r2 = r4.f11459b;	 Catch:{ all -> 0x0053 }
        r3 = r4.m15548c(r5, r1);	 Catch:{ all -> 0x0053 }
        r2 = r2 + r3;
        r4.f11459b = r2;	 Catch:{ all -> 0x0053 }
        goto L_0x0041;
    L_0x0053:
        r0 = move-exception;
        monitor-exit(r4);	 Catch:{ all -> 0x0053 }
        throw r0;
    L_0x0056:
        r0 = r4.f11460c;
        r4.m15547a(r0);
        r0 = r1;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.bg.a(java.lang.Object):V");
    }

    public final V m15554b(K k, V v) {
        if (k == null || v == null) {
            throw new NullPointerException("key == null || value == null");
        }
        V put;
        synchronized (this) {
            this.f11461d++;
            this.f11459b += m15548c(k, v);
            put = this.f11458a.put(k, v);
            if (put != null) {
                this.f11459b -= m15548c(k, put);
            }
        }
        if (put != null) {
            mo4014a(false, k, put, v);
        }
        m15547a(this.f11460c);
        return put;
    }

    private void m15547a(int i) {
        while (true) {
            Object key;
            Object value;
            synchronized (this) {
                if (this.f11459b >= 0 && this.f11458a.isEmpty() && this.f11459b == 0) {
                }
                if (this.f11459b <= i) {
                    return;
                }
                Entry entry = null;
                for (Entry entry2 : this.f11458a.entrySet()) {
                }
                if (entry == null) {
                    return;
                }
                key = entry.getKey();
                value = entry.getValue();
                this.f11458a.remove(key);
                this.f11459b -= m15548c(key, value);
                this.f11463f++;
            }
            mo4014a(true, key, value, null);
        }
    }

    protected void mo4014a(boolean z, K k, V v, V v2) {
    }

    protected V m15553b(K k) {
        return null;
    }

    private int m15548c(K k, V v) {
        int a = mo4013a(k, v);
        if (a >= 0) {
            return a;
        }
        throw new IllegalStateException("Negative size: " + k + "=" + v);
    }

    protected int mo4013a(K k, V v) {
        return 1;
    }

    public final void m15551a() {
        m15547a(-1);
    }

    public final synchronized String toString() {
        String format;
        int i = 0;
        synchronized (this) {
            int i2 = this.f11464g + this.f11465h;
            if (i2 != 0) {
                i = (this.f11464g * 100) / i2;
            }
            format = String.format("LruCache[maxSize=%d,hits=%d,misses=%d,hitRate=%d%%]", new Object[]{Integer.valueOf(this.f11460c), Integer.valueOf(this.f11464g), Integer.valueOf(this.f11465h), Integer.valueOf(i)});
        }
        return format;
    }
}
