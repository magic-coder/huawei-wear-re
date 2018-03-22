package com.huawei.pluginkidwatch.common.ui.view;

import android.os.Handler;
import java.util.Timer;

/* compiled from: CustomCircleProgress */
class C1582r {
    public Handler f3917a;
    public boolean f3918b = false;
    public Timer f3919c = new Timer();
    public C1593t f3920d = null;
    public int f3921e;
    public int f3922f = 0;
    public float f3923g;
    final /* synthetic */ CustomCircleProgress f3924h;
    private boolean f3925i = false;
    private int f3926j = 5;
    private boolean f3927k = false;

    public C1582r(CustomCircleProgress customCircleProgress) {
        this.f3924h = customCircleProgress;
        this.f3917a = new C1583s(this, customCircleProgress);
        this.f3918b = false;
        if (this.f3919c != null) {
            this.f3919c.cancel();
        }
        this.f3919c = new Timer();
        this.f3921e = 0;
        this.f3922f = 50;
        this.f3923g = 0.0f;
    }

    public void m7291a(int i) {
        if (i > 0 && !this.f3918b) {
            this.f3918b = true;
            this.f3925i = false;
            this.f3926j = 5;
            this.f3924h.setMainProgress(0);
            this.f3924h.setSubProgress(0);
            this.f3921e = this.f3924h.f3793b;
            this.f3924h.f3793b = (1000 / this.f3922f) * i;
            this.f3923g = 0.0f;
            if (this.f3920d != null) {
                this.f3920d.cancel();
                this.f3920d = null;
            }
            this.f3920d = new C1593t(this);
            this.f3919c.schedule(this.f3920d, (long) this.f3922f, (long) this.f3922f);
        }
    }

    public boolean m7292a() {
        return this.f3918b;
    }

    public void m7294b(int i) {
        if (!this.f3918b && !this.f3927k) {
            this.f3927k = true;
            m7291a(i);
        }
    }

    public void m7293b() {
        if (this.f3918b) {
            this.f3927k = false;
            this.f3924h.f3793b = this.f3921e;
            if (this.f3924h.f3798g) {
                this.f3924h.setMainProgress(0);
                this.f3924h.setSubProgress(0);
            } else {
                this.f3924h.setMainProgress(this.f3924h.f3793b);
            }
            if (this.f3920d != null) {
                this.f3920d.cancel();
            }
            this.f3918b = false;
        }
    }

    public void m7295c() {
        if (this.f3918b) {
            this.f3927k = false;
            this.f3925i = true;
        }
    }
}
