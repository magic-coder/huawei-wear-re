package com.huawei.common.applog.bean;

/* compiled from: SdCardPermission */
public final class C0673d {
    private static final C0673d f1227a = new C0673d();
    private boolean f1228b = true;
    private Object f1229c = null;
    private boolean f1230d = true;

    private C0673d() {
    }

    public static C0673d m2673a() {
        return f1227a;
    }

    public boolean m2677b() {
        return this.f1228b;
    }

    public void m2675a(boolean z) {
        this.f1228b = z;
    }

    public Object m2678c() {
        return this.f1229c;
    }

    public void m2674a(Object obj) {
        this.f1229c = obj;
    }

    public boolean m2679d() {
        return this.f1230d;
    }

    public void m2676b(boolean z) {
        this.f1230d = z;
    }

    public void m2680e() {
        this.f1229c = null;
        this.f1228b = true;
        this.f1230d = true;
    }
}
