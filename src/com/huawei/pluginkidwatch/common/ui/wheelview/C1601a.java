package com.huawei.pluginkidwatch.common.ui.wheelview;

/* compiled from: ArrayWheelAdapter */
public class C1601a<T> implements C1600h {
    private T[] f4060a;
    private int f4061b;

    public C1601a(T[] tArr, int i) {
        this.f4060a = (Object[]) tArr.clone();
        this.f4061b = i;
    }

    public C1601a(T[] tArr) {
        this(tArr, -1);
    }

    public String mo2551a(int i) {
        if (i < 0 || i >= this.f4060a.length) {
            return null;
        }
        return this.f4060a[i].toString();
    }

    public int mo2550a() {
        return this.f4060a.length;
    }

    public int mo2552b() {
        return this.f4061b;
    }
}
