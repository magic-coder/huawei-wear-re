package com.huawei.pluginkidwatch.plugin.menu.activity;

import com.huawei.p190v.C2538c;

/* compiled from: AddFenceActivity */
class C1883y implements Runnable {
    final /* synthetic */ AddFenceActivity f6191a;

    C1883y(AddFenceActivity addFenceActivity) {
        this.f6191a = addFenceActivity;
    }

    public void run() {
        if (this.f6191a.f5455o > 5) {
            this.f6191a.al.removeCallbacks(this);
            this.f6191a.f5455o = 0;
            C2538c.m12674b("AddFenceActivity", "没有获取到逆地址编码的信息，保存失败");
        } else if (this.f6191a.f5456p) {
            this.f6191a.m9047h();
            this.f6191a.al.removeCallbacks(this);
            this.f6191a.f5456p = false;
            C2538c.m12674b("AddFenceActivity", "获取到逆地址编码的信息，正在保存......");
        } else {
            C2538c.m12674b("AddFenceActivity", "获取了一次是否逆地址编码的信息");
            this.f6191a.al.postDelayed(this, 1000);
            this.f6191a.f5455o = this.f6191a.f5455o + 1;
        }
    }
}
