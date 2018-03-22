package com.tencent.wxop.stat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

final class as extends BroadcastReceiver {
    final /* synthetic */ C6548z f22655a;

    as(C6548z c6548z) {
        this.f22655a = c6548z;
    }

    public final void onReceive(Context context, Intent intent) {
        if (this.f22655a.f22870e != null) {
            this.f22655a.f22870e.m29719a(new C6529f(this));
        }
    }
}
