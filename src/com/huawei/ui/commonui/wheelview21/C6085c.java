package com.huawei.ui.commonui.wheelview21;

import android.content.Context;
import com.huawei.ui.commonui.wheelview21.p516a.C6082a;

/* compiled from: ThreeWheelPicker */
public class C6085c {
    private static int f21028a = 24;
    private static float f21029b = 3.0f;
    private WheelView f21030c = null;
    private WheelView f21031d = null;
    private WheelView f21032e = null;
    private C6082a f21033f;
    private C6082a f21034g;
    private C6082a f21035h;
    private String f21036i = "";
    private String f21037j = "";
    private String f21038k = "";
    private String[] f21039l = null;
    private String[] f21040m = null;
    private String[] f21041n = null;
    private C6083a f21042o = null;

    public C6085c(Context context, WheelView wheelView, WheelView wheelView2) {
        this.f21030c = wheelView;
        this.f21030c.f20999a = (float) f21028a;
        this.f21032e = wheelView2;
        this.f21032e.f20999a = (float) f21028a;
    }

    public C6085c(Context context, WheelView wheelView, WheelView wheelView2, WheelView wheelView3) {
        this.f21030c = wheelView;
        this.f21030c.f20999a = (float) f21028a;
        this.f21031d = wheelView2;
        this.f21031d.f20999a = (float) f21028a;
        this.f21032e = wheelView3;
        this.f21032e.f20999a = (float) f21028a;
    }

    public void m27814a(String[] strArr, int i, boolean z) {
        if (strArr != null) {
            this.f21039l = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f21039l, 0, strArr.length);
            this.f21033f = new C6082a(strArr);
            this.f21030c.setAdapter(this.f21033f);
            this.f21030c.setCyclic(z);
            this.f21030c.setCurrentItem(i);
            this.f21030c.setOnTouchListener(new C6086d(this));
            return;
        }
        this.f21039l = null;
    }

    public void m27817b(String[] strArr, int i, boolean z) {
        int i2 = 0;
        if (strArr != null) {
            this.f21040m = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f21040m, 0, strArr.length);
            this.f21034g = new C6082a(strArr);
            this.f21031d.setAdapter(this.f21034g);
            this.f21031d.setCyclic(z);
            if (i >= strArr.length) {
                if (strArr.length - 1 >= 0) {
                    i2 = strArr.length - 1;
                }
            } else if (i >= 0) {
                i2 = i;
            }
            this.f21031d.setCurrentItem(i2);
            this.f21031d.setOnTouchListener(new C6087e(this));
            return;
        }
        this.f21040m = null;
    }

    public void m27820c(String[] strArr, int i, boolean z) {
        int i2 = 0;
        if (strArr != null) {
            this.f21041n = new String[strArr.length];
            System.arraycopy(strArr, 0, this.f21041n, 0, strArr.length);
            this.f21035h = new C6082a(strArr);
            this.f21032e.setAdapter(this.f21035h);
            this.f21032e.setCyclic(z);
            if (i >= strArr.length) {
                if (strArr.length - 1 >= 0) {
                    i2 = strArr.length - 1;
                }
            } else if (i >= 0) {
                i2 = i;
            }
            this.f21032e.setCurrentItem(i2);
            this.f21032e.setOnTouchListener(new C6088f(this));
            if (this.f21042o != null) {
                this.f21032e.m27795a(this.f21042o);
                return;
            }
            return;
        }
        this.f21041n = null;
    }

    public void m27813a(C6083a c6083a) {
        this.f21042o = c6083a;
    }

    public void m27816b(C6083a c6083a) {
        if (this.f21030c != null && c6083a != null) {
            this.f21030c.m27795a(c6083a);
        }
    }

    public void m27819c(C6083a c6083a) {
        if (this.f21031d != null && c6083a != null) {
            this.f21031d.m27795a(c6083a);
        }
    }

    public String m27812a() {
        String str = "";
        int currentItem = this.f21030c.getCurrentItem();
        if (this.f21039l == null || this.f21039l.length <= currentItem) {
            return str;
        }
        return this.f21039l[currentItem];
    }

    public String m27815b() {
        String str = "";
        int currentItem = this.f21031d.getCurrentItem();
        if (this.f21040m == null || this.f21040m.length <= currentItem) {
            return str;
        }
        return this.f21040m[currentItem];
    }

    public String m27818c() {
        String str = "";
        int currentItem = this.f21032e.getCurrentItem();
        if (this.f21041n == null || this.f21041n.length <= currentItem) {
            return str;
        }
        return this.f21041n[currentItem];
    }
}
