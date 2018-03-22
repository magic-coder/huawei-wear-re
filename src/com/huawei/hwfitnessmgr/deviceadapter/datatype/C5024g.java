package com.huawei.hwfitnessmgr.deviceadapter.datatype;

import com.huawei.hwcommonmodel.p064d.C0978h;

import java.util.ArrayList;
import java.util.List;

/* compiled from: DeviceReportThroshold */
public class C5024g {
    private int f18214a;
    private int f18215b;
    private int f18216c;
    private int f18217d;

    public void m24215a(int i) {
        this.f18214a = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24217b(int i) {
        this.f18215b = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24219c(int i) {
        this.f18216c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public void m24221d(int i) {
        this.f18217d = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m24214a() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18214a))).intValue();
    }

    public int m24216b() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18215b))).intValue();
    }

    public int m24218c() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18216c))).intValue();
    }

    public int m24220d() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f18217d))).intValue();
    }

    public static List<C5024g> m24213e() {
        List<C5024g> arrayList = new ArrayList();
        C5024g c5024g = new C5024g();
        c5024g.m24215a(1);
        c5024g.m24217b(3);
        c5024g.m24219c(500);
        c5024g.m24221d(2);
        arrayList.add(c5024g);
        c5024g = new C5024g();
        c5024g.m24215a(3);
        c5024g.m24217b(3);
        c5024g.m24219c(100);
        c5024g.m24221d(2);
        arrayList.add(c5024g);
        c5024g = new C5024g();
        c5024g.m24215a(4);
        c5024g.m24217b(3);
        c5024g.m24219c(3600);
        c5024g.m24221d(2);
        arrayList.add(c5024g);
        return arrayList;
    }

    public String toString() {
        return "DeviceReportThroshold{dataType=" + this.f18214a + ", valueType=" + this.f18215b + ", value=" + this.f18216c + ", action=" + this.f18217d + '}';
    }
}
