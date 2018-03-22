package com.aps;

import android.os.Handler;
import android.os.Message;

final class au extends Handler {
    private /* synthetic */ C3513w f12968a;

    au(C3513w c3513w) {
        this.f12968a = c3513w;
    }

    public final void handleMessage(Message message) {
        try {
            switch (message.what) {
                case 1:
                    if (this.f12968a.f13239a.f13115E != null) {
                        this.f12968a.f13239a.f13115E.m17631a((String) message.obj);
                        return;
                    }
                    return;
                default:
                    return;
            }
        } catch (Exception e) {
        }
    }
}
