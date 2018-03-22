package com.huawei.pluginkidwatch.common.ui.wheelview;

import android.content.Context;

/* compiled from: ThreeWheelPicker */
public class C1605e {
    private static int f4065a = 24;
    private static float f4066b = 3.0f;
    private WheelView f4067c = null;
    private WheelView f4068d = null;
    private WheelView f4069e = null;
    private C1601a f4070f;
    private C1601a f4071g;
    private String[] f4072h;
    private String[] f4073i;
    private String[] f4074j;
    private C1603c f4075k = null;

    public C1605e(Context context, WheelView wheelView, WheelView wheelView2) {
        this.f4067c = wheelView;
        this.f4067c.f4037a = (float) f4065a;
        this.f4069e = wheelView2;
        this.f4069e.f4037a = (float) f4065a;
    }

    public C1605e(Context context, WheelView wheelView, WheelView wheelView2, WheelView wheelView3) {
        this.f4067c = wheelView;
        this.f4067c.f4037a = (float) f4065a;
        this.f4068d = wheelView2;
        this.f4068d.f4037a = (float) f4065a;
        this.f4069e = wheelView3;
        this.f4069e.f4037a = (float) f4065a;
    }

    public void m7426a(String[] strArr, int i, boolean z) {
        if (strArr != null) {
            this.f4072h = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f4072h, 0, strArr.length);
            this.f4070f = new C1601a(strArr);
            this.f4067c.setAdapter(this.f4070f);
            this.f4067c.setCyclic(z);
            this.f4067c.setCurrentItem(i);
            this.f4067c.setOnTouchListener(new C1606f(this));
            return;
        }
        this.f4072h = null;
    }

    public void m7428b(String[] strArr, int i, boolean z) {
        int i2 = 0;
        if (strArr != null) {
            this.f4074j = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f4074j, 0, strArr.length);
            this.f4071g = new C1601a(strArr);
            this.f4069e.setAdapter(this.f4071g);
            this.f4069e.setCyclic(z);
            if (i >= strArr.length) {
                if (strArr.length - 1 >= 0) {
                    i2 = strArr.length - 1;
                }
            } else if (i >= 0) {
                i2 = i;
            }
            this.f4069e.setCurrentItem(i2);
            this.f4069e.setOnTouchListener(new C1607g(this));
            if (this.f4075k != null) {
                this.f4069e.m7404a(this.f4075k);
                return;
            }
            return;
        }
        this.f4074j = null;
    }

    public void m7425a(C1603c c1603c) {
        this.f4075k = c1603c;
    }

    public String m7424a() {
        return this.f4072h[this.f4067c.getCurrentItem()];
    }

    public String m7427b() {
        return this.f4073i[this.f4068d.getCurrentItem()];
    }

    public String m7429c() {
        return this.f4074j[this.f4069e.getCurrentItem()];
    }

    public int m7430d() {
        return this.f4069e.getCurrentItem();
    }
}
