package com.huawei.appmarket.service.p378b;

import java.util.Comparator;

public class C4324c implements Comparator<C4324c> {
    private String f16106a = null;
    private long f16107b = 0;
    private long f16108c = 0;
    private C4325d f16109d = C4325d.SYSTEM_STORAGE;

    public int m20827a(C4324c c4324c, C4324c c4324c2) {
        return c4324c.f16107b > c4324c2.f16107b ? 1 : c4324c.f16107b < c4324c2.f16107b ? -1 : 0;
    }

    public String m20828a() {
        return this.f16106a;
    }

    public void m20829a(long j) {
        this.f16108c = j;
    }

    public void m20830a(C4325d c4325d) {
        this.f16109d = c4325d;
    }

    public void m20831a(String str) {
        this.f16106a = str;
    }

    public long m20832b() {
        return this.f16108c;
    }

    public void m20833b(long j) {
        this.f16107b = j;
    }

    public C4325d m20834c() {
        return this.f16109d;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m20827a((C4324c) obj, (C4324c) obj2);
    }

    public long m20835d() {
        return this.f16107b;
    }

    public String toString() {
        return "StorageInfo[ storagePath = " + this.f16106a + ", totalSpace = " + this.f16108c + ", freeSpace = " + this.f16107b + ", storageType = " + this.f16109d;
    }
}
