package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.HashSet;
import java.util.Set;

final class am implements ServiceConnection {
    final /* synthetic */ al f413a;
    private final Set<ServiceConnection> f414b = new HashSet();
    private int f415c = 2;
    private boolean f416d;
    private IBinder f417e;
    private final ak f418f;
    private ComponentName f419g;

    public am(al alVar, ak akVar) {
        this.f413a = alVar;
        this.f418f = akVar;
    }

    public void m608a(ServiceConnection serviceConnection, String str) {
        this.f413a.f410d.m796a(this.f413a.f408b, serviceConnection, str, this.f418f.m600c());
        this.f414b.add(serviceConnection);
    }

    public void m609a(String str) {
        this.f415c = 3;
        this.f416d = this.f413a.f410d.m797a(this.f413a.f408b, str, this.f418f.m600c(), this, 129);
        if (this.f416d) {
            this.f413a.f409c.sendMessageDelayed(this.f413a.f409c.obtainMessage(1, this.f418f), this.f413a.f412f);
            return;
        }
        this.f415c = 2;
        try {
            this.f413a.f410d.m795a(this.f413a.f408b, (ServiceConnection) this);
        } catch (IllegalArgumentException e) {
        }
    }

    public boolean m610a() {
        return this.f416d;
    }

    public boolean m611a(ServiceConnection serviceConnection) {
        return this.f414b.contains(serviceConnection);
    }

    public int m612b() {
        return this.f415c;
    }

    public void m613b(ServiceConnection serviceConnection, String str) {
        this.f413a.f410d.m798b(this.f413a.f408b, serviceConnection);
        this.f414b.remove(serviceConnection);
    }

    public void m614b(String str) {
        this.f413a.f409c.removeMessages(1, this.f418f);
        this.f413a.f410d.m795a(this.f413a.f408b, (ServiceConnection) this);
        this.f416d = false;
        this.f415c = 2;
    }

    public boolean m615c() {
        return this.f414b.isEmpty();
    }

    public IBinder m616d() {
        return this.f417e;
    }

    public ComponentName m617e() {
        return this.f419g;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        synchronized (this.f413a.f407a) {
            this.f413a.f409c.removeMessages(1, this.f418f);
            this.f417e = iBinder;
            this.f419g = componentName;
            for (ServiceConnection onServiceConnected : this.f414b) {
                onServiceConnected.onServiceConnected(componentName, iBinder);
            }
            this.f415c = 1;
        }
    }

    public void onServiceDisconnected(ComponentName componentName) {
        synchronized (this.f413a.f407a) {
            this.f413a.f409c.removeMessages(1, this.f418f);
            this.f417e = null;
            this.f419g = componentName;
            for (ServiceConnection onServiceDisconnected : this.f414b) {
                onServiceDisconnected.onServiceDisconnected(componentName);
            }
            this.f415c = 2;
        }
    }
}
