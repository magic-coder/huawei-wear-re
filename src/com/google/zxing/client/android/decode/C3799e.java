package com.google.zxing.client.android.decode;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.os.AsyncTask;

/* compiled from: InactivityTimer */
public final class C3799e {
    private static final String f14777a = C3799e.class.getSimpleName();
    private final Activity f14778b;
    private final BroadcastReceiver f14779c;
    private C3800f f14780d;
    private boolean f14781e = false;

    public C3799e(Activity activity) {
        this.f14778b = activity;
        this.f14779c = new C3801g();
        m19036a();
    }

    public synchronized void m19036a() {
        m19035f();
        this.f14780d = new C3800f();
    }

    public void m19037b() {
        m19035f();
        if (this.f14781e) {
            this.f14778b.unregisterReceiver(this.f14779c);
            this.f14781e = false;
        }
    }

    public void m19038c() {
        this.f14778b.registerReceiver(this.f14779c, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f14781e = true;
        m19036a();
    }

    private synchronized void m19035f() {
        AsyncTask asyncTask = this.f14780d;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f14780d = null;
        }
    }

    public void m19039d() {
        m19035f();
    }
}
