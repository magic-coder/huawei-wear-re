package com.tencent.wxop.stat;

import java.util.List;

final class an implements Runnable {
    final /* synthetic */ List f22638a;
    final /* synthetic */ int f22639b = 1;
    final /* synthetic */ boolean f22640c;
    final /* synthetic */ boolean f22641d;
    final /* synthetic */ am f22642e;

    an(am amVar, List list, boolean z) {
        this.f22642e = amVar;
        this.f22638a = list;
        this.f22640c = z;
        this.f22641d = true;
    }

    public final void run() {
        this.f22642e.m29677a(this.f22638a, this.f22639b, this.f22640c);
        if (this.f22641d) {
            this.f22638a.clear();
        }
    }
}
