package com.huawei.android.pushagent.plugin.p333c;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import com.huawei.android.pushagent.plugin.p331a.C4126b;
import org.json.JSONArray;

public class C4134b extends C4133a {
    private String f15536a = "";

    public C4134b(String str) {
        this.f15536a = str;
    }

    public int mo4380a() {
        return C4126b.TAG.m20181b();
    }

    public String mo4381a(Context context) {
        if (TextUtils.isEmpty(this.f15536a)) {
            e.b("PushLogSC2712", "tag is null");
            return null;
        }
        JSONArray b = C4103b.m20125b(this.f15536a);
        return b != null ? b.toString() : null;
    }

    public String mo4382b() {
        return C4126b.TAG.m20180a();
    }

    public int mo4383c() {
        return mo4380a();
    }
}
