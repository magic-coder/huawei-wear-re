package com.huawei.sim.esim.view;

import android.content.Intent;

/* compiled from: ConformActivity */
class C5927d implements Runnable {
    final /* synthetic */ int f20438a;
    final /* synthetic */ Object f20439b;
    final /* synthetic */ C5926c f20440c;

    C5927d(C5926c c5926c, int i, Object obj) {
        this.f20440c = c5926c;
        this.f20438a = i;
        this.f20439b = obj;
    }

    public void run() {
        Intent intent;
        if (this.f20438a == 0) {
            intent = new Intent(this.f20440c.f20437a, EsimProfileSuccessActivity.class);
            intent.putExtra("conform_status", true);
            this.f20440c.f20437a.startActivity(intent);
        } else if (4 == this.f20438a) {
            intent = new Intent(this.f20440c.f20437a, EsimConformBTFailActivity.class);
            intent.putExtra("conform_error", "network_failed");
            intent.putExtra("conform_code", this.f20440c.f20437a.f20293c);
            this.f20440c.f20437a.startActivityForResult(intent, 0);
        } else if (1 == this.f20438a || 2 == this.f20438a) {
            this.f20440c.f20437a.f20296f = 1;
            this.f20440c.f20437a.m27196c();
        } else if (this.f20439b == null || -2 != ((Integer) this.f20439b).intValue() || this.f20440c.f20437a.f20295e == null || !this.f20440c.f20437a.f20295e.isShowing()) {
            this.f20440c.f20437a.m27189a(this.f20438a);
        } else {
            intent = new Intent(this.f20440c.f20437a, EsimConformBTFailActivity.class);
            intent.putExtra("conform_code", this.f20440c.f20437a.f20293c);
            this.f20440c.f20437a.startActivityForResult(intent, 0);
            this.f20440c.f20437a.m27193b();
            return;
        }
        this.f20440c.f20437a.m27193b();
    }
}
