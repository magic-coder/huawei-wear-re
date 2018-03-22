package com.huawei.android.pushagent.plugin.p331a;

import android.content.Context;
import com.huawei.android.pushagent.c.a.c;
import com.huawei.android.pushagent.c.a.h;
import com.huawei.android.pushagent.p018c.p019a.p026a.C4100f;

public class C4125a extends c {
    public C4125a(Context context) {
        super(context, "PushPluginInfo");
        af();
    }

    public String m20171a() {
        return C4100f.m20116b(this.d, a("salt_v2", ""));
    }

    public void m20172a(long j) {
        a("lastReportLbs", Long.valueOf(j));
    }

    public void m20173a(String str) {
        a("salt_v2", C4100f.m20113a(this.d, str));
    }

    public void m20174a(String str, long j) {
        a(str + "LastRunTime", Long.valueOf(j));
    }

    public void m20175b(String str) {
        a("device_token", str);
    }

    public boolean m20176b() {
        this.c.remove("salt_v2");
        return m20178c("salt_v2");
    }

    public int m20177c() {
        return a("belongId", -1);
    }

    public boolean m20178c(String str) {
        return new h(this.d, this.b).f(str);
    }

    public String m20179d() {
        return a("device_token", "");
    }
}
