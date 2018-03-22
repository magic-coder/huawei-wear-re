package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;
import java.util.Date;

/* compiled from: DataRawSleepData */
public class C5020c {
    private long f18200a;
    private int f18201b;
    private int f18202c;
    private int f18203d;

    public long m24188a() {
        return ((Long) C0978h.a(Long.valueOf(this.f18200a))).longValue();
    }

    public void m24190a(long j) {
        this.f18200a = ((Long) C0978h.a(Long.valueOf((j / 60) * 60))).longValue();
    }

    public int m24191b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18202c))).intValue();
    }

    public void m24189a(int i) {
        this.f18202c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24193c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18201b))).intValue();
    }

    public void m24192b(int i) {
        this.f18201b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public String toString() {
        return "DataRawSleepData{startTime=" + new Date(this.f18200a * 1000) + ", currentStatus=" + this.f18201b + ", totalCalorie=" + this.f18202c + ", totalSleepTime=" + this.f18203d + '}';
    }
}
