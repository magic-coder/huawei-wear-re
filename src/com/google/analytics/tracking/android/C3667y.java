package com.google.analytics.tracking.android;

import android.os.Handler.Callback;
import android.os.Message;

/* compiled from: GAServiceManager */
class C3667y implements Callback {
    final /* synthetic */ w f14202a;

    C3667y(w wVar) {
        this.f14202a = wVar;
    }

    public boolean handleMessage(Message message) {
        if (1 == message.what && w.f().equals(message.obj)) {
            am.m18240a().m18242a(true);
            this.f14202a.c();
            am.m18240a().m18242a(false);
            if (w.b(this.f14202a) > 0 && !w.c(this.f14202a)) {
                w.d(this.f14202a).sendMessageDelayed(w.d(this.f14202a).obtainMessage(1, w.f()), (long) (w.b(this.f14202a) * 1000));
            }
        }
        return true;
    }
}
