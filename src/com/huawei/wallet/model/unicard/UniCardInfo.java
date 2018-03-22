package com.huawei.wallet.model.unicard;

import com.huawei.hwcommonmodel.p064d.C0978h;

public class UniCardInfo extends BaseInfo {
    private String f21316a = "";
    private String f21317b;
    private int f21318c;
    private int f21319d;
    private String f21320e;
    private String f21321f;
    private String f21322g;
    private long f21323h;
    private String f21324i;
    private String f21325j;
    private int f21326k;
    private int f21327l;
    private boolean f21328m;

    public int m28102a() {
        return this.f21326k;
    }

    public void m28103a(int i) {
        this.f21326k = i;
    }

    public String m28107b() {
        return this.f21324i;
    }

    public void m28105a(String str) {
        this.f21324i = str;
    }

    public String m28110c() {
        return (String) C0978h.a(this.f21325j);
    }

    public void m28109b(String str) {
        this.f21325j = str;
    }

    public int m28113d() {
        return this.f21327l;
    }

    public void m28108b(int i) {
        this.f21327l = i;
    }

    public boolean m28116e() {
        return this.f21328m;
    }

    public void m28106a(boolean z) {
        this.f21328m = z;
    }

    public int hashCode() {
        return this.f21316a.hashCode();
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof UniCardInfo)) {
            return false;
        }
        if (this.f21316a.equals(((UniCardInfo) obj).f21316a)) {
            return true;
        }
        return false;
    }

    public String m28117f() {
        return (String) C0978h.a(this.f21316a);
    }

    public void m28112c(String str) {
        this.f21316a = str;
    }

    public void m28114d(String str) {
        this.f21317b = str;
    }

    public int m28119g() {
        return ((Integer) C0978h.a(Integer.valueOf(this.f21318c))).intValue();
    }

    public void m28111c(int i) {
        this.f21318c = ((Integer) C0978h.a(Integer.valueOf(i))).intValue();
    }

    public int m28121h() {
        return this.f21319d;
    }

    public String m28122i() {
        return this.f21320e;
    }

    public void m28115e(String str) {
        this.f21320e = str;
    }

    public String m28123j() {
        return this.f21321f;
    }

    public void m28118f(String str) {
        this.f21321f = str;
    }

    public String m28124k() {
        return this.f21322g;
    }

    public void m28120g(String str) {
        this.f21322g = str;
    }

    public long m28125l() {
        return ((Long) C0978h.a(Long.valueOf(this.f21323h))).longValue();
    }

    public void m28104a(long j) {
        this.f21323h = ((Long) C0978h.a(Long.valueOf(j))).longValue();
    }
}
