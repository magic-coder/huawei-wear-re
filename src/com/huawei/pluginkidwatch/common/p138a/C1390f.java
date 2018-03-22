package com.huawei.pluginkidwatch.common.p138a;

import com.huawei.pluginkidwatch.common.lib.utils.C1489i;

/* compiled from: CheckVersionTable */
public class C1390f {
    public String f3058a = "";
    public int f3059b = -1;
    public String f3060c = "";
    public String f3061d = "";
    public String f3062e = "";
    public String f3063f = "";
    public String f3064g = "";

    public String toString() {
        return "CheckVersionTable{huid='" + this.f3058a + '\'' + ", deviceCode=" + this.f3059b + ", lastTime=" + this.f3060c + ", data1='" + this.f3061d + '\'' + ", data2='" + this.f3062e + '\'' + ", data3='" + this.f3063f + '\'' + ", data4='" + this.f3064g + '\'' + '}';
    }

    public int m6257a() {
        return ((Integer) C1489i.m6887a(Integer.valueOf(this.f3059b))).intValue();
    }

    public String m6258b() {
        return (String) C1489i.m6887a(this.f3058a);
    }
}
