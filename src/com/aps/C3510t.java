package com.aps;

import java.util.TimerTask;

final class C3510t extends TimerTask {
    private /* synthetic */ C3509s f13237a;

    C3510t(C3509s c3509s) {
        this.f13237a = c3509s;
    }

    public final void run() {
        try {
            if (al.f12904a && this.f13237a.f13236a.f13211d != null) {
                this.f13237a.f13236a.f13211d.startScan();
            }
        } catch (Exception e) {
        }
    }
}
