package com.huawei.android.pushagent.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.plugin.p331a.C4126b;
import com.huawei.android.pushagent.plugin.p333c.C4133a;

public class PushPlugins {
    private static String f15515a = "PushLogSC2712";
    private Context f15516b;

    public PushPlugins(Context context) {
        this.f15516b = context;
    }

    private void m20169a(C4133a c4133a, C4126b c4126b, long j) {
        new C4132b(this.f15516b).m20205a(c4133a.mo4381a(this.f15516b), c4133a.mo4380a(), c4133a.mo4383c());
        c4133a.m20208a(this.f15516b, System.currentTimeMillis());
    }

    private void m20170a(String str, long j) {
        if (TextUtils.isEmpty(str)) {
            e.b(f15515a, "tagInfo is empty, cannot report");
        } else {
            new Thread(new C4130a(this, str, j)).start();
        }
    }

    public C4126b getPluginType(int i) {
        return C4126b.LBS.m20181b() == i ? C4126b.LBS : C4126b.TAG.m20181b() == i ? C4126b.TAG : null;
    }

    public void reportPlus(int i, String str, long j) {
        if (C4126b.TAG.m20181b() == i) {
            m20170a(str, j);
        } else {
            e.b(f15515a, "plusType is error, cannot match any plugin");
        }
    }
}
