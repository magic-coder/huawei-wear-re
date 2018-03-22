package com.huawei.pluginmessagecenter;

import com.huawei.pluginmessagecenter.p499a.C5861g;

/* compiled from: PluginMessageCenter */
class C5872l implements Runnable {
    final /* synthetic */ j f20145a;

    C5872l(j jVar) {
        this.f20145a = jVar;
    }

    public void run() {
        synchronized (j.b(this.f20145a)) {
            C5861g.m27024c("PluginMessageCenter", "Enter lock");
            this.f20145a.c();
        }
    }
}
