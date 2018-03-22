package com.huawei.android.pushagent.plugin.p331a;

import com.huawei.android.pushagent.c.a.e;
import com.huawei.android.pushagent.p018c.p019a.C4103b;
import org.json.JSONObject;

public class C4129e {
    private String f15525a;
    private String f15526b;
    private int f15527c = -1;
    private long f15528d = 0;
    private long f15529e = 0;

    public String m20192a() {
        return this.f15526b;
    }

    public void m20193a(String str) {
        JSONObject a = C4103b.m20124a(str);
        if (a == null) {
            e.a("PushLogSC2712", "enter SaltRsp.loadFromString, json is null");
            return;
        }
        this.f15525a = a.optString("resultcode");
        this.f15526b = a.optString("salt");
        this.f15527c = a.optInt("belongId", -1);
        this.f15528d = a.optLong("minUp", 0);
        this.f15529e = a.optLong("maxUp", 0);
    }

    public int m20194b() {
        return this.f15527c;
    }

    public long m20195c() {
        return this.f15528d * 1000;
    }

    public long m20196d() {
        return this.f15529e * 1000;
    }

    public String toString() {
        return "resultCode:" + this.f15525a + ";salt:" + this.f15526b + ";belongId:" + this.f15527c + ";minUp:" + this.f15528d + ";maxUp:" + this.f15529e;
    }
}
