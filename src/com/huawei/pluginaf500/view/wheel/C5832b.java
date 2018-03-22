package com.huawei.pluginaf500.view.wheel;

/* compiled from: NumericWheelAdapter */
public class C5832b implements C5830e {
    private int f20083a;
    private int f20084b;
    private String f20085c;

    public C5832b() {
        this(0, 9);
    }

    public C5832b(int i, int i2) {
        this(i, i2, null);
    }

    public C5832b(int i, int i2, String str) {
        this.f20083a = i;
        this.f20084b = i2;
        this.f20085c = str;
    }

    public String mo5121a(int i) {
        if (i < 0 || i >= mo5120a()) {
            return null;
        }
        int i2 = this.f20083a + i;
        if (this.f20085c == null) {
            return Integer.toString(i2);
        }
        return String.format(this.f20085c, new Object[]{Integer.valueOf(i2)});
    }

    public int mo5120a() {
        return (this.f20084b - this.f20083a) + 1;
    }

    public int mo5122b() {
        int length = Integer.toString(Math.max(Math.abs(this.f20084b), Math.abs(this.f20083a))).length();
        if (this.f20083a < 0) {
            return length + 1;
        }
        return length;
    }
}
