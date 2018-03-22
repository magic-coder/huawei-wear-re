package com.huawei.ui.commonui.wheelview.p515a;

/* compiled from: ArrayWheelAdapter */
public class C6054a<T> implements C6053c {
    private int f20913a;
    private T[] f20914b;
    private String f20915c;

    public C6054a(T[] tArr, int i) {
        this.f20915c = "";
        this.f20914b = (Object[]) tArr.clone();
        this.f20913a = i;
        this.f20915c = "";
    }

    public C6054a(T[] tArr) {
        this(tArr, -1);
    }

    public String mo5130a(int i) {
        if (i < 0 || i >= this.f20914b.length) {
            return null;
        }
        if (this.f20915c == null || this.f20915c.isEmpty()) {
            return this.f20914b[i].toString();
        }
        if (!this.f20915c.contains("%1$s")) {
            return this.f20914b[i].toString() + this.f20915c;
        }
        return String.format(this.f20915c, new Object[]{this.f20914b[i].toString()});
    }

    public int mo5129a() {
        return this.f20914b.length;
    }

    public int mo5131b() {
        return this.f20913a;
    }
}
