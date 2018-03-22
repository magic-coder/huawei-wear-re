package com.huawei.pluginaf500.view.wheel;

/* compiled from: ArrayWheelAdapter */
public class C5831a<T> implements C5830e {
    private T[] f20081a;
    private int f20082b;

    public C5831a(T[] tArr, int i) {
        this.f20081a = (Object[]) tArr.clone();
        this.f20082b = i;
    }

    public C5831a(T[] tArr) {
        this(tArr, -1);
    }

    public String mo5121a(int i) {
        if (i < 0 || i >= this.f20081a.length) {
            return null;
        }
        return this.f20081a[i].toString();
    }

    public int mo5120a() {
        return this.f20081a.length;
    }

    public int mo5122b() {
        return this.f20082b;
    }
}
