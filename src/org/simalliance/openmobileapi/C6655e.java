package org.simalliance.openmobileapi;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import org.simalliance.openmobileapi.service.C6659c;

/* compiled from: SEService */
class C6655e implements ServiceConnection {
    final /* synthetic */ C6651c f22898a;

    C6655e(C6651c c6651c) {
        this.f22898a = c6651c;
    }

    public synchronized void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f22898a.f22892c = C6659c.m29970a(iBinder);
        if (this.f22898a.f22896g != null) {
            this.f22898a.f22896g.serviceConnected(this.f22898a);
        }
        Log.v("SEService", "Service onServiceConnected");
    }

    public void onServiceDisconnected(ComponentName componentName) {
        this.f22898a.f22892c = null;
        Log.v("SEService", "Service onServiceDisconnected");
    }
}
