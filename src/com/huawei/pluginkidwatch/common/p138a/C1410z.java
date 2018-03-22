package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

/* compiled from: UpdateTable */
public class C1410z {
    public String f3209a = "";
    public boolean f3210b = false;
    public int f3211c = 0;
    public boolean f3212d = false;
    public String f3213e = "";
    public String f3214f = "";
    public int f3215g = -1;
    public String f3216h = "";
    public String f3217i = "";
    public String f3218j = "";

    public String toString() {
        return "DeviceInfoTable [DeviceCode=" + this.f3215g + ", Huid=" + this.f3209a + "data2=" + this.f3217i + ", data1=" + this.f3216h + ", data3=" + this.f3218j + ", isClickedFlag=" + this.f3210b + ", stutus=" + this.f3211c + ", success=" + this.f3212d + ", versionBefore=" + this.f3213e + ", versionAfter=" + this.f3214f;
    }

    public int m6448a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f3215g))).intValue();
    }

    public String m6449b() {
        return (String) C1489i.m6887a(this.f3209a);
    }
}
