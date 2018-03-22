package com.huawei.pluginaf500.view;

import com.huawei.p190v.C2538c;

/* compiled from: GlobuleSportView */
class C5829c implements Runnable {
    final /* synthetic */ C5828b f20037a;

    C5829c(C5828b c5828b) {
        this.f20037a = c5828b;
    }

    public void run() {
        while (!Thread.currentThread().isInterrupted() && !this.f20037a.f20032f) {
            this.f20037a.f20036j = true;
            if (this.f20037a.f20031e <= 360.0f) {
                this.f20037a.f20031e = this.f20037a.f20031e + 2.0f;
            } else {
                this.f20037a.f20031e = 0.0f;
            }
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                C2538c.e("GlobuleSportView", new Object[]{"Exception e = " + e.getMessage()});
            }
            this.f20037a.m26931b();
            this.f20037a.f20029c.obtainMessage(4).sendToTarget();
        }
        this.f20037a.f20036j = false;
    }
}
