package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

/* compiled from: TrackInfoTable */
public class C1408x {
    public String f3187a = "";
    public String f3188b = "";
    public double f3189c;
    public int f3190d = -1;
    public double f3191e;
    public double f3192f;
    public double f3193g;
    public String f3194h = "";
    public String f3195i = "";
    public String f3196j = "";
    public String f3197k = "";
    public String f3198l = "";
    public String f3199m = "";
    public String f3200n = "";
    public String f3201o = "";
    public String f3202p = "";
    public String f3203q = "";
    public String f3204r = "";

    public String toString() {
        return "TrackInfoTable [DeviceCode=" + this.f3190d + ", Date=" + this.f3187a + ", Time=" + this.f3188b + ", Lon=" + this.f3189c + ", Lat=" + this.f3191e + ", Name=" + this.f3194h + ", Radius=" + this.f3195i + ", BuildingName=" + this.f3197k + ", StreetName=" + this.f3198l + ", EndTime=" + this.f3199m + ", Elev=" + this.f3192f + ", Hacc=" + this.f3193g + ", Type=" + this.f3196j + ", Data1=" + this.f3200n + ", Data2=" + this.f3201o + ", Data3=" + this.f3202p + ", Data4=" + this.f3203q + ", Data5=" + this.f3204r;
    }

    public int m6440a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f3190d))).intValue();
    }

    public String m6441b() {
        return (String) C1489i.m6887a(this.f3187a);
    }
}
