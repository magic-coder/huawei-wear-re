package com.huawei.pluginaf500.view.wheel;

import android.content.Context;

/* compiled from: WheelSportRemindPicker */
public class C5838j {
    int f20095a;
    int f20096b;
    Context f20097c;
    int f20098d;
    int f20099e;
    private int f20100f = 0;
    private int f20101g = 0;
    private WheelView f20102h;
    private WheelView f20103i;
    private int f20104j;

    public C5838j(Context context, WheelView wheelView, WheelView wheelView2, int i, int i2, int i3) {
        this.f20102h = wheelView;
        this.f20103i = wheelView2;
        this.f20104j = i;
        this.f20095a = i2;
        this.f20096b = i3;
        this.f20097c = context;
    }

    private void m26988a(int i, int i2, int i3) {
        if (this.f20096b < 15 && this.f20095a == i2 + 1) {
            this.f20102h.setAdapter(new C5832b(i, this.f20095a - 1, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, this.f20096b + 45, "%02d"));
            this.f20102h.setCurrentItem(i2);
            this.f20103i.setCurrentItem(i3);
        } else if (this.f20096b < 15 && this.f20095a > i2) {
            this.f20102h.setAdapter(new C5832b(i, this.f20095a - 1, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
            this.f20102h.setCurrentItem(i2 - i);
            this.f20103i.setCurrentItem(i3);
        } else if (this.f20096b >= 15 && this.f20095a > i2) {
            this.f20102h.setAdapter(new C5832b(i, this.f20095a, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
            this.f20102h.setCurrentItem(i2 - i);
            this.f20103i.setCurrentItem(i3);
        } else if (this.f20096b >= 15 && this.f20095a == i2) {
            this.f20102h.setAdapter(new C5832b(i, this.f20095a, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, this.f20096b - 15, "%02d"));
            this.f20102h.setCurrentItem(i2 - i);
            this.f20103i.setCurrentItem(i3);
        }
    }

    private void m26991b(int i, int i2, int i3) {
        if (this.f20096b > 45 && this.f20095a == i2 - 1) {
            this.f20102h.setAdapter(new C5832b(this.f20095a + 1, i, "%02d"));
            this.f20103i.setAdapter(new C5832b(15 - (60 - this.f20096b), 59, "%02d"));
            this.f20102h.setCurrentItem((i2 - this.f20095a) - 1);
            this.f20103i.setCurrentItem(i3 - (15 - (60 - this.f20096b)));
        } else if (this.f20096b > 45 && this.f20095a < i2) {
            this.f20102h.setAdapter(new C5832b(this.f20095a + 1, i, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
            this.f20102h.setCurrentItem((i2 - this.f20095a) - 1);
            this.f20103i.setCurrentItem(i3);
        } else if (this.f20096b <= 45 && this.f20095a < i2) {
            this.f20102h.setAdapter(new C5832b(this.f20095a, i, "%02d"));
            this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
            this.f20102h.setCurrentItem(i2 - this.f20095a);
            this.f20103i.setCurrentItem(i3);
        } else if (this.f20096b <= 45 && this.f20095a == i2) {
            this.f20102h.setAdapter(new C5832b(this.f20095a, i, "%02d"));
            this.f20103i.setAdapter(new C5832b(this.f20096b + 15, 59, "%02d"));
            this.f20102h.setCurrentItem(i2 - this.f20095a);
            this.f20103i.setCurrentItem(i3 - (this.f20096b + 15));
        }
    }

    private void m26993c(int i) {
        if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a || this.f20096b < 15) {
            if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a - 1 || this.f20096b >= 15) {
                this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
                this.f20103i.setCurrentItem(i);
                return;
            }
            this.f20103i.setAdapter(new C5832b(0, this.f20096b + 45, "%02d"));
            this.f20103i.setCurrentItem(i);
        } else if (i > this.f20096b - 15) {
            this.f20103i.setAdapter(new C5832b(0, this.f20096b - 15, "%02d"));
            this.f20103i.setCurrentItem(this.f20096b - 15);
        } else {
            this.f20103i.setAdapter(new C5832b(0, this.f20096b - 15, "%02d"));
            this.f20103i.setCurrentItem(i);
        }
    }

    private void m26994d(int i) {
        if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a || this.f20096b >= 45) {
            if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a + 1 || this.f20096b <= 45) {
                this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
                this.f20103i.setCurrentItem(i);
                return;
            }
            this.f20103i.setAdapter(new C5832b(15 - (60 - this.f20096b), 59, "%02d"));
            this.f20103i.setCurrentItem(i);
        } else if (i > this.f20096b + 15) {
            this.f20103i.setAdapter(new C5832b(this.f20096b + 15, 59, "%02d"));
            this.f20103i.setCurrentItem(i - (this.f20096b + 15));
        } else {
            this.f20103i.setAdapter(new C5832b(this.f20096b + 15, 59, "%02d"));
            this.f20103i.setCurrentItem(0);
        }
    }

    public void m26997a(int i, int i2) {
        this.f20098d = i;
        this.f20099e = i2;
        this.f20100f = i;
        this.f20101g = i2;
        if (this.f20104j == 1) {
            m26988a(0, i, i2);
        } else if (this.f20104j == 2) {
            m26991b(11, i, i2);
        } else if (this.f20104j == 3) {
            m26988a(12, i, i2);
        } else if (this.f20104j == 4) {
            if (this.f20096b <= 45 || this.f20095a > i) {
                m26991b(23, i, i2);
            } else {
                this.f20102h.setAdapter(new C5832b(this.f20095a + 1, 23, "%02d"));
                this.f20103i.setAdapter(new C5832b(0, 59, "%02d"));
                this.f20102h.setCurrentItem((i - this.f20095a) - 1);
                this.f20103i.setCurrentItem(i2);
            }
        }
        this.f20102h.setCyclic(true);
        this.f20103i.setCyclic(true);
        C5791c c5839k = new C5839k(this);
        C5791c c5840l = new C5840l(this);
        this.f20102h.m26967a(c5839k);
        this.f20103i.m26967a(c5840l);
        this.f20103i.f20056a = (float) 30;
        this.f20102h.f20056a = (float) 30;
    }

    public int m26995a(int i) {
        if (this.f20104j == 1) {
            if (this.f20095a == 0) {
                this.f20098d = 0;
            } else if (this.f20096b < 15) {
                this.f20098d = i;
            } else {
                this.f20098d = i;
            }
        } else if (this.f20104j == 2) {
            if (this.f20095a > 10) {
                this.f20098d = 11;
            } else if (this.f20096b > 45) {
                this.f20098d = (this.f20095a + i) + 1;
            } else {
                this.f20098d = this.f20095a + i;
            }
        } else if (this.f20104j == 3) {
            if (this.f20095a == 12) {
                this.f20098d = 12;
            } else if (this.f20096b < 15) {
                this.f20098d = i + 12;
            } else {
                this.f20098d = i + 12;
            }
        } else if (this.f20104j == 4) {
            if (this.f20095a > 22) {
                this.f20098d = 23;
            } else if (this.f20096b > 45) {
                this.f20098d = (this.f20095a + i) + 1;
            } else {
                this.f20098d = this.f20095a + i;
            }
        }
        return this.f20098d;
    }

    public int m26998b(int i) {
        if (this.f20104j == 1) {
            this.f20099e = i;
        } else if (this.f20104j == 2) {
            if (m26995a(this.f20102h.getCurrentItem()) == this.f20095a) {
                this.f20099e = (this.f20096b + i) + 15;
                if (this.f20099e > 59) {
                    this.f20099e = 59;
                }
            } else if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a + 1 || this.f20096b <= 44) {
                this.f20099e = i;
            } else {
                this.f20099e = (15 - (60 - this.f20096b)) + i;
            }
        } else if (this.f20104j == 3) {
            this.f20099e = i;
        } else if (this.f20104j == 4) {
            if (m26995a(this.f20102h.getCurrentItem()) == this.f20095a) {
                this.f20099e = (this.f20096b + i) + 15;
                if (this.f20099e > 59) {
                    this.f20099e = 59;
                }
            } else if (m26995a(this.f20102h.getCurrentItem()) != this.f20095a + 1 || this.f20096b <= 44) {
                this.f20099e = i;
            } else {
                this.f20099e = (15 - (60 - this.f20096b)) + i;
            }
        }
        return this.f20099e;
    }

    public String m26996a() {
        String str;
        m26995a(this.f20102h.getCurrentItem());
        m26998b(this.f20103i.getCurrentItem());
        if (this.f20104j == 1) {
            if (this.f20098d > 11 || this.f20098d > this.f20095a || ((this.f20098d == this.f20095a && this.f20096b < 15) || (this.f20098d == this.f20095a && this.f20099e > this.f20096b - 15))) {
                this.f20098d = this.f20100f;
                this.f20099e = this.f20101g;
            }
        } else if (this.f20104j == 2) {
            if (this.f20098d > 11 || this.f20098d < this.f20095a || ((this.f20098d == this.f20095a && this.f20096b > 44) || (this.f20098d == this.f20095a && this.f20099e < this.f20096b + 15))) {
                this.f20098d = this.f20100f;
                this.f20099e = this.f20101g;
            }
        } else if (this.f20104j == 3) {
            if (this.f20098d < 12 || this.f20098d > 23 || this.f20098d > this.f20095a || ((this.f20098d == this.f20095a && this.f20096b < 15) || (this.f20098d == this.f20095a && this.f20099e > this.f20096b - 15))) {
                this.f20098d = this.f20100f;
                this.f20099e = this.f20101g;
            }
        } else if (this.f20104j == 4 && (this.f20098d < 12 || this.f20098d > 23 || this.f20098d < this.f20095a || ((this.f20098d == this.f20095a && this.f20096b > 44) || (this.f20098d == this.f20095a && this.f20099e < this.f20096b + 15)))) {
            this.f20098d = this.f20100f;
            this.f20099e = this.f20101g;
        }
        if (this.f20098d < 10) {
            str = "0" + this.f20098d;
        } else {
            str = this.f20098d + "";
        }
        if (this.f20099e < 10) {
            return str + ":0" + this.f20099e;
        }
        return str + ":" + this.f20099e;
    }
}
