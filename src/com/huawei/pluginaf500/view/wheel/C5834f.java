package com.huawei.pluginaf500.view.wheel;

import android.content.Context;

/* compiled from: WheelAlarmPicker */
public class C5834f {
    Context f20086a;
    private WheelView f20087b;
    private WheelView f20088c;
    private int f20089d;

    public C5834f(Context context, WheelView wheelView, WheelView wheelView2, int i) {
        this.f20087b = wheelView;
        this.f20088c = wheelView2;
        this.f20089d = i;
        this.f20086a = context;
    }

    public void m26982a(int i, int i2) {
        if (this.f20089d == 1 || this.f20089d == 2) {
            this.f20087b.setAdapter(new C5832b(0, 12, "%02d"));
        } else if (this.f20089d == 3 || this.f20089d == 4) {
            this.f20087b.setAdapter(new C5832b(12, 23, "%02d"));
        } else {
            this.f20087b.setAdapter(new C5832b(0, 23, "%02d"));
        }
        this.f20087b.setCyclic(true);
        this.f20087b.setCurrentItem(i);
        this.f20088c.setAdapter(new C5832b(0, 59, "%02d"));
        this.f20088c.setCyclic(true);
        this.f20088c.setCurrentItem(i2);
        C5791c c5835g = new C5835g(this);
        this.f20087b.m26967a(c5835g);
        this.f20088c.m26967a(c5835g);
        this.f20088c.f20056a = (float) 30;
        this.f20087b.f20056a = (float) 30;
    }
}
