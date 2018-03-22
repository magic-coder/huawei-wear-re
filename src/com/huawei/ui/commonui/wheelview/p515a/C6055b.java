package com.huawei.ui.commonui.wheelview.p515a;

/* compiled from: NumericWheelAdapter */
public class C6055b implements C6053c {
    private String f20916a;
    private int f20917b;
    private int f20918c;

    public C6055b() {
        this(9, 0);
    }

    public C6055b(int i, int i2) {
        this(i, i2, null);
    }

    public C6055b(int i, int i2, String str) {
        this.f20917b = i;
        this.f20918c = i2;
        this.f20916a = str;
    }

    public int mo5131b() {
        int length = Integer.toString(Math.max(Math.abs(this.f20918c), Math.abs(this.f20917b))).length();
        if (this.f20917b < 0) {
            return length + 1;
        }
        return length;
    }

    public int mo5129a() {
        return (this.f20918c - this.f20917b) + 1;
    }

    public String mo5130a(int i) {
        if (i < 0 || i >= mo5129a()) {
            return null;
        }
        int i2 = this.f20917b + i;
        if (this.f20916a == null) {
            return Integer.toString(i2);
        }
        return String.format(this.f20916a, new Object[]{Integer.valueOf(i2)});
    }
}
