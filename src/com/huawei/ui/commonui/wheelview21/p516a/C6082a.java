package com.huawei.ui.commonui.wheelview21.p516a;

/* compiled from: ArrayWheelAdapter */
public class C6082a<T> implements C6081b {
    private int f21025a;
    private T[] f21026b;
    private String f21027c;

    public C6082a(T[] tArr, int i) {
        this.f21027c = "";
        this.f21026b = (Object[]) tArr.clone();
        this.f21025a = i;
        this.f21027c = "";
    }

    public C6082a(T[] tArr) {
        this(tArr, -1);
    }

    public String mo5133a(int i) {
        if (i < 0 || i >= this.f21026b.length) {
            return null;
        }
        if (this.f21027c == null || this.f21027c.isEmpty()) {
            return this.f21026b[i].toString();
        }
        if (!this.f21027c.contains("%1$s")) {
            return this.f21026b[i].toString() + this.f21027c;
        }
        return String.format(this.f21027c, new Object[]{this.f21026b[i].toString()});
    }

    public int mo5132a() {
        return this.f21026b.length;
    }

    public int mo5134b() {
        return this.f21025a;
    }
}
