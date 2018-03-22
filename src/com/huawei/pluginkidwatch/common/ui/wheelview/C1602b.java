package com.huawei.pluginkidwatch.common.ui.wheelview;

/* compiled from: NumericWheelAdapter */
public class C1602b implements C1600h {
    private int f4062a;
    private int f4063b;
    private String f4064c;

    public C1602b() {
        this(0, 9);
    }

    public C1602b(int i, int i2) {
        this(i, i2, null);
    }

    public C1602b(int i, int i2, String str) {
        this.f4062a = i;
        this.f4063b = i2;
        this.f4064c = str;
    }

    public String mo2551a(int i) {
        if (i < 0 || i >= mo2550a()) {
            return null;
        }
        int i2 = this.f4062a + i;
        if (this.f4064c == null) {
            return Integer.toString(i2);
        }
        return String.format(this.f4064c, new Object[]{Integer.valueOf(i2)});
    }

    public int mo2550a() {
        return (this.f4063b - this.f4062a) + 1;
    }

    public int mo2552b() {
        int length = Integer.toString(Math.max(Math.abs(this.f4063b), Math.abs(this.f4062a))).length();
        if (this.f4062a < 0) {
            return length + 1;
        }
        return length;
    }
}
