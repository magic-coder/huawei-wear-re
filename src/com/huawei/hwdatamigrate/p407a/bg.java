package com.huawei.hwdatamigrate.p407a;

import com.huawei.hihealth.HiUserInfo;

/* compiled from: UserInfoTable */
public class bg extends be {
    public int f17586w;
    public String f17587x;

    public bg() {
        m22845a();
    }

    private void m22845a() {
        this.f17586w = -1;
        this.f17587x = "";
        this.a = "";
        this.b = 1;
        this.c = HiUserInfo.BIRTHDAY_DEFAULT;
        this.d = "";
        this.n = "";
        this.e = "";
        this.f = HiUserInfo.HEIGHT_DEFAULT;
        this.g = 67;
        this.h = 0;
        this.i = 60;
        this.j = 132;
        this.k = 0;
        this.l = Math.round(C4775h.m22857a(this.f));
        this.m = Math.round(C4775h.m22861b(this.f));
        this.o = "";
        this.p = "";
        this.q = "";
        this.s = 0;
        this.t = "";
        this.r = HiUserInfo.BIRTHDAY_DEFAULT;
        this.u = "";
        this.v = "";
    }

    public String toString() {
        return "UserInfoTable [ID=" + this.f17586w + ", userID=" + this.f17587x + ", userName=" + this.a + ", gender=" + (1 == this.b ? "Male" : "Female") + ", age=" + this.c + ", portrait=" + this.n + ", tokenID=" + this.e + ", height=" + this.f + ", height_ft=" + this.g + ", height_type=" + this.h + ", weight=" + this.i + ", weight_lb=" + this.j + ", weight_type=" + this.k + ", walkLength=" + this.l + ", runLength=" + this.m + ", nick=" + this.o + ", email=" + this.p + ", mobile=" + this.q + ", birthday=" + this.r + ", unit_type=" + this.s + ", location=" + this.t + ", hobby=" + this.u + ", description=" + this.v + "]";
    }
}
