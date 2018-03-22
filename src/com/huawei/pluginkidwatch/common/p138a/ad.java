package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

/* compiled from: WatchStatusTable */
public class ad {
    private String f3018a = "";
    private int f3019b = -1;
    private double f3020c;
    private double f3021d;
    private String f3022e;
    private String f3023f;
    private String f3024g;
    private String f3025h = "";
    private String f3026i = "";
    private String f3027j = "";

    public String toString() {
        return "DeviceInfoTable [DeviceCode=" + this.f3019b + ", Huid=" + this.f3018a + ", Lng=" + this.f3021d + ", Lat=" + this.f3020c + ", WatchStatus=" + this.f3022e + ", BuildingName=" + this.f3023f + ", StreetName=" + this.f3024g + ", data2=" + this.f3026i + ", data1=" + this.f3025h + ", data3=" + this.f3027j;
    }

    public int m6225a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f3019b))).intValue();
    }

    public void m6227a(int i) {
        this.f3019b = ((Integer) C1489i.m6887a(Integer.valueOf(i))).intValue();
    }

    public String m6229b() {
        return (String) C1489i.m6887a(this.f3018a);
    }

    public void m6228a(String str) {
        this.f3018a = (String) C1489i.m6887a(str);
    }

    public double m6232c() {
        return ((Double) C1489i.m6887a(Double.valueOf(this.f3020c))).doubleValue();
    }

    public void m6226a(double d) {
        this.f3020c = ((Double) C1489i.m6887a(Double.valueOf(d))).doubleValue();
    }

    public double m6234d() {
        return ((Double) C1489i.m6887a(Double.valueOf(this.f3021d))).doubleValue();
    }

    public void m6230b(double d) {
        this.f3021d = ((Double) C1489i.m6887a(Double.valueOf(d))).doubleValue();
    }

    public String m6236e() {
        return (String) C1489i.m6887a(this.f3022e);
    }

    public void m6231b(String str) {
        this.f3022e = (String) C1489i.m6887a(str);
    }

    public String m6238f() {
        return (String) C1489i.m6887a(this.f3023f);
    }

    public void m6233c(String str) {
        this.f3023f = (String) C1489i.m6887a(str);
    }

    public String m6240g() {
        return (String) C1489i.m6887a(this.f3024g);
    }

    public void m6235d(String str) {
        this.f3024g = (String) C1489i.m6887a(str);
    }

    public String m6242h() {
        return (String) C1489i.m6887a(this.f3025h);
    }

    public void m6237e(String str) {
        this.f3025h = (String) C1489i.m6887a(str);
    }

    public String m6243i() {
        return (String) C1489i.m6887a(this.f3026i);
    }

    public void m6239f(String str) {
        this.f3026i = (String) C1489i.m6887a(str);
    }

    public String m6244j() {
        return (String) C1489i.m6887a(this.f3027j);
    }

    public void m6241g(String str) {
        this.f3027j = (String) C1489i.m6887a(str);
    }
}
