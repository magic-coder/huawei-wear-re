package com.aps;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* compiled from: ConnectionServiceManager */
class av implements ServiceConnection {
    final /* synthetic */ aw f12969a;
    final /* synthetic */ at f12970b;

    av(at atVar, aw awVar) {
        this.f12970b = atVar;
        this.f12969a = awVar;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f12970b.f12959e = C3492b.m17388a(iBinder);
        this.f12969a.mo4150a(0);
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f12970b.f12959e = null;
    }
}
