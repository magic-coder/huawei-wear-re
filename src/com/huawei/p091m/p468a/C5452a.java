package com.huawei.p091m.p468a;

import com.huawei.hwcommonmodel.p064d.C0978h;

/* compiled from: TruSleepLastSyncTime */
public class C5452a {
    private String f19293a;
    private String f19294b;

    public String m26124a() {
        return (String) C0978h.a(this.f19293a);
    }

    public void m26125a(String str) {
        this.f19293a = (String) C0978h.a(str);
    }

    public String m26126b() {
        return (String) C0978h.a(this.f19294b);
    }

    public void m26127b(String str) {
        this.f19294b = (String) C0978h.a(str);
    }

    public String toString() {
        return "TruSleepLastSynctime:deviceMac = " + this.f19293a + ",lastSyncTime = " + this.f19294b;
    }
}
