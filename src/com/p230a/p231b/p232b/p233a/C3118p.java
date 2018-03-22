package com.p230a.p231b.p232b.p233a;

public class C3118p {
    public final Object f10465a;
    public final C3104c f10466b;
    public final C3102w f10467c;
    public boolean f10468d;

    private C3118p(C3102w c3102w) {
        this.f10468d = false;
        this.f10465a = null;
        this.f10466b = null;
        this.f10467c = c3102w;
    }

    private C3118p(Object obj, C3104c c3104c) {
        this.f10468d = false;
        this.f10465a = obj;
        this.f10466b = c3104c;
        this.f10467c = null;
    }

    public static C3118p m13902a(C3102w c3102w) {
        return new C3118p(c3102w);
    }

    public static C3118p m13903a(Object obj, C3104c c3104c) {
        return new C3118p(obj, c3104c);
    }

    public boolean m13904a() {
        return this.f10467c == null;
    }
}
