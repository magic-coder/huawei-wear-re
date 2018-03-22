package com.huawei.android.pushagent.plugin.p331a;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import org.json.JSONObject;

public class C4128d {
    private int f15523a = -1;
    private String f15524b;

    public int m20189a() {
        return this.f15523a;
    }

    public void m20190a(String str) {
        JSONObject a = C4103b.m20124a(str);
        if (a == null) {
            e.a("PushLogSC2712", "enter ReportRsp.loadFromString, json is null");
            return;
        }
        this.f15523a = a.optInt("resultcode", -1);
        this.f15524b = a.optString("info");
    }

    public String m20191b() {
        return this.f15524b;
    }

    public String toString() {
        return "resultCode:" + this.f15523a + ";errorInfo:" + this.f15524b;
    }
}
