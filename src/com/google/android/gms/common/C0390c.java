package com.google.android.gms.common;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

@SuppressLint({"HandlerLeak"})
class C0390c extends Handler {
    final /* synthetic */ C0389b f308a;
    private final Context f309b;

    public C0390c(C0389b c0389b, Context context) {
        this.f308a = c0389b;
        super(Looper.myLooper() == null ? Looper.getMainLooper() : Looper.myLooper());
        this.f309b = context.getApplicationContext();
    }

    public void handleMessage(Message message) {
        switch (message.what) {
            case 1:
                int a = this.f308a.mo1742a(this.f309b);
                if (this.f308a.mo1745a(a)) {
                    this.f308a.m434a(this.f309b, a);
                    return;
                }
                return;
            default:
                Log.w("GoogleApiAvailability", "Don't know how to handle this message: " + message.what);
                return;
        }
    }
}
