package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

/* compiled from: DeviceInfoTable */
public class C1395k {
    public String f3081a = "";
    public int f3082b = -1;
    public String f3083c = "";
    public String f3084d = "";
    public String f3085e = "";
    public String f3086f = "";
    public String f3087g = "";
    public String f3088h = "";
    public int f3089i = -1;
    public int f3090j = -1;
    public int f3091k = -1;
    public int f3092l = -1;
    public String f3093m = "";
    public String f3094n = "";
    public String f3095o = "";
    public String f3096p = "";
    public String f3097q = "";
    public String f3098r = "";
    public String f3099s = "";
    public String f3100t = "";
    public String f3101u = "";
    public String f3102v = "";
    public String f3103w = "";

    public C1395k() {
        m6339e();
    }

    private void m6339e() {
        this.f3082b = -1;
        this.f3083c = "";
        this.f3084d = "";
        this.f3085e = "";
        this.f3086f = "";
        this.f3087g = "";
        this.f3088h = "";
        this.f3089i = -1;
        this.f3090j = -1;
        this.f3091k = 2;
        this.f3092l = -1;
        this.f3093m = "";
        this.f3096p = "";
        this.f3094n = "";
        this.f3095o = "";
        this.f3097q = "";
        this.f3098r = "";
        this.f3099s = "";
    }

    public String toString() {
        String str = "DeviceInfoTable [DeviceCode = " + this.f3082b + ", Name = " + this.f3083c + ", LocalUrl = " + this.f3084d + ", Huid = " + this.f3081a + ", SmallPortraitUrl = " + this.f3085e + ", MiddlePortraitUrl = " + this.f3086f + ", LargePortraitUrl = " + this.f3087g + ", Height = " + this.f3089i + ", PrimaryHuid = " + this.f3097q + ", Birthday = " + this.f3088h + ", Height = " + this.f3089i + ", , Weight = " + this.f3090j + ", Sex = " + this.f3091k + ", Grade = " + this.f3092l + ", SimCardNum = " + this.f3093m + ", BtMac = " + this.f3096p + ", PortraitImgName = " + this.f3095o + ", data1 = " + this.f3099s + ",  PortraitImg = ";
        if ("".equals(this.f3094n)) {
            str = str + " is null";
        } else {
            str = str + " is not null";
        }
        return str + ", PortraitUrl = " + this.f3098r + " ]";
    }

    public String m6340a() {
        return (String) C1489i.m6887a(this.f3096p);
    }

    public int m6342b() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f3082b))).intValue();
    }

    public String m6343c() {
        return (String) C1489i.m6887a(this.f3081a);
    }

    public String m6344d() {
        return (String) C1489i.m6887a(this.f3084d);
    }

    public void m6341a(String str) {
        this.f3084d = (String) C1489i.m6887a(str);
    }
}
