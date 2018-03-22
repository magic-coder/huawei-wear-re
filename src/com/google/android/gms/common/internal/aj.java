package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;

public abstract class aj {
    private static final Object f402a = new Object();
    private static aj f403b;

    public static aj m593a(Context context) {
        synchronized (f402a) {
            if (f403b == null) {
                f403b = new al(context.getApplicationContext());
            }
        }
        return f403b;
    }

    protected abstract boolean mo1765a(ak akVar, ServiceConnection serviceConnection, String str);

    public boolean m595a(String str, String str2, ServiceConnection serviceConnection, String str3) {
        return mo1765a(new ak(str, str2), serviceConnection, str3);
    }

    protected abstract void mo1766b(ak akVar, ServiceConnection serviceConnection, String str);

    public void m597b(String str, String str2, ServiceConnection serviceConnection, String str3) {
        mo1766b(new ak(str, str2), serviceConnection, str3);
    }
}
