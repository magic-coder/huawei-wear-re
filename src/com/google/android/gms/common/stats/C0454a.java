package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.util.C0459d;
import java.util.Collections;
import java.util.List;

public class C0454a {
    private static final Object f469a = new Object();
    private static C0454a f470b;
    private final List<String> f471c = Collections.EMPTY_LIST;
    private final List<String> f472d = Collections.EMPTY_LIST;
    private final List<String> f473e = Collections.EMPTY_LIST;
    private final List<String> f474f = Collections.EMPTY_LIST;

    private C0454a() {
    }

    public static C0454a m793a() {
        synchronized (f469a) {
            if (f470b == null) {
                f470b = new C0454a();
            }
        }
        return f470b;
    }

    private boolean m794a(Context context, Intent intent) {
        ComponentName component = intent.getComponent();
        return component == null ? false : C0459d.m812a(context, component.getPackageName());
    }

    @SuppressLint({"UntrackedBindService"})
    public void m795a(Context context, ServiceConnection serviceConnection) {
        context.unbindService(serviceConnection);
    }

    public void m796a(Context context, ServiceConnection serviceConnection, String str, Intent intent) {
    }

    @SuppressLint({"UntrackedBindService"})
    public boolean m797a(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        if (!m794a(context, intent)) {
            return context.bindService(intent, serviceConnection, i);
        }
        Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
        return false;
    }

    public void m798b(Context context, ServiceConnection serviceConnection) {
    }
}
