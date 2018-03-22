package com.huawei.sim.esim.view;

import android.content.Intent;

/* compiled from: EsimConformBTFailActivity */
class C5941r implements Runnable {
    final /* synthetic */ int f20454a;
    final /* synthetic */ Object f20455b;
    final /* synthetic */ C5940q f20456c;

    C5941r(C5940q c5940q, int i, Object obj) {
        this.f20456c = c5940q;
        this.f20454a = i;
        this.f20455b = obj;
    }

    public void run() {
        Intent intent;
        if (this.f20454a == 0) {
            intent = new Intent(this.f20456c.f20453a, EsimProfileSuccessActivity.class);
            intent.putExtra("conform_status", true);
            this.f20456c.f20453a.startActivity(intent);
            this.f20456c.f20453a.finish();
        } else if (1 == this.f20454a) {
            this.f20456c.f20453a.f20336p = "network_failed";
        } else if (1 == this.f20454a || 2 == this.f20454a) {
            intent = new Intent();
            intent.putExtra("conform_report", 1);
            this.f20456c.f20453a.setResult(1, intent);
            this.f20456c.f20453a.finish();
        } else if (this.f20455b == null || -2 != ((Integer) this.f20455b).intValue()) {
            this.f20456c.f20453a.m27220a(this.f20454a);
        } else {
            this.f20456c.f20453a.m27219a();
            return;
        }
        this.f20456c.f20453a.m27219a();
    }
}
