package com.huawei.hwdatamigrate.hihealth.p409b.p411b;

import com.huawei.hihealth.p394c.C4540b;

/* compiled from: DayStatTable */
public class C4807a {
    private int f17762a;
    private int f17763b;
    private int f17764c;
    private int f17765d;
    private double f17766e;
    private int f17767f;
    private int f17768g;
    private int f17769h;
    private String f17770i;
    private int f17771j;
    private long f17772k;

    public int m23025a() {
        return this.f17763b;
    }

    public void m23027a(int i) {
        this.f17763b = i;
    }

    public void m23028a(long j) {
        this.f17763b = C4540b.m21750a(j);
    }

    public int m23030b() {
        return this.f17764c;
    }

    public void m23031b(int i) {
        this.f17764c = i;
    }

    public int m23033c() {
        return this.f17765d;
    }

    public void m23034c(int i) {
        this.f17765d = i;
    }

    public double m23035d() {
        return this.f17766e;
    }

    public void m23026a(double d) {
        this.f17766e = d;
    }

    public int m23037e() {
        return this.f17768g;
    }

    public void m23036d(int i) {
        this.f17768g = i;
    }

    public int m23039f() {
        return this.f17769h;
    }

    public void m23038e(int i) {
        this.f17769h = i;
    }

    public String m23041g() {
        return this.f17770i;
    }

    public void m23029a(String str) {
        this.f17770i = str;
    }

    public int m23043h() {
        return this.f17767f;
    }

    public void m23040f(int i) {
        this.f17767f = i;
    }

    public int m23044i() {
        return this.f17771j;
    }

    public void m23042g(int i) {
        this.f17771j = i;
    }

    public long m23045j() {
        return this.f17772k;
    }

    public void m23032b(long j) {
        this.f17772k = j;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("DayStatTable{");
        stringBuffer.append("id=").append(this.f17762a);
        stringBuffer.append(", date=").append(this.f17763b);
        stringBuffer.append(", hiHealthType=").append(this.f17764c);
        stringBuffer.append(", statType=").append(this.f17765d);
        stringBuffer.append(", value=").append(this.f17766e);
        stringBuffer.append(", unitID=").append(this.f17767f);
        stringBuffer.append(", who=").append(this.f17768g);
        stringBuffer.append(", clientID=").append(this.f17769h);
        stringBuffer.append(", timeZone='").append(this.f17770i).append('\'');
        stringBuffer.append(", syncStatus=").append(this.f17771j);
        stringBuffer.append(", modifyTime=").append(this.f17772k);
        stringBuffer.append('}');
        return stringBuffer.toString();
    }
}
