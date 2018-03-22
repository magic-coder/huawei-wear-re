package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzaaz extends BroadcastReceiver {
    protected Context f889a;
    private final bi f890b;

    public zzaaz(bi biVar) {
        this.f890b = biVar;
    }

    public synchronized void m1634a() {
        if (this.f889a != null) {
            this.f889a.unregisterReceiver(this);
        }
        this.f889a = null;
    }

    public void m1635a(Context context) {
        this.f889a = context;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f890b.mo1833a();
            m1634a();
        }
    }
}
