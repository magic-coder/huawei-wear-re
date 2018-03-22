package com.google.android.gms.wearable;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.List;

public abstract class WearableListenerService extends Service implements aa, C0520b, C0521h, C0522l, C0523u {
    private ComponentName f908a;
    private zzb f909b;
    private IBinder f910c;
    private Intent f911d;
    private Looper f912e;
    private final Object f913f = new Object();
    private boolean f914g;

    final class zzb extends Handler {
        final /* synthetic */ WearableListenerService f905a;
        private boolean f906b;
        private final ah f907c = new ah(this.f905a);

        zzb(WearableListenerService wearableListenerService, Looper looper) {
            this.f905a = wearableListenerService;
            super(looper);
        }

        @SuppressLint({"UntrackedBindService"})
        private synchronized void m1657a(String str) {
            if (this.f906b) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(this.f905a.f908a);
                    Log.v("WearableLS", new StringBuilder((String.valueOf(str).length() + 17) + String.valueOf(valueOf).length()).append("unbindService: ").append(str).append(", ").append(valueOf).toString());
                }
                try {
                    this.f905a.unbindService(this.f907c);
                } catch (Throwable e) {
                    Log.e("WearableLS", "Exception when unbinding from local service", e);
                }
                this.f906b = false;
            }
        }

        @SuppressLint({"UntrackedBindService"})
        private synchronized void m1658b() {
            if (!this.f906b) {
                if (Log.isLoggable("WearableLS", 2)) {
                    String valueOf = String.valueOf(this.f905a.f908a);
                    Log.v("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 13).append("bindService: ").append(valueOf).toString());
                }
                this.f905a.bindService(this.f905a.f911d, this.f907c, 1);
                this.f906b = true;
            }
        }

        void m1659a() {
            getLooper().quit();
            m1657a("quit");
        }

        public void dispatchMessage(Message message) {
            m1658b();
            try {
                super.dispatchMessage(message);
            } finally {
                if (!hasMessages(0)) {
                    m1657a("dispatch");
                }
            }
        }
    }

    public Looper m1674a() {
        if (this.f912e == null) {
            HandlerThread handlerThread = new HandlerThread("WearableListenerService");
            handlerThread.start();
            this.f912e = handlerThread.getLooper();
        }
        return this.f912e;
    }

    public void mo1905a(Channel channel) {
    }

    public void mo1906a(Channel channel, int i, int i2) {
    }

    public void m1677a(au auVar) {
    }

    public void m1678a(aw awVar) {
    }

    public void mo1907a(C0526d c0526d) {
    }

    public void mo1908a(C0570o c0570o) {
    }

    public void mo1909a(C0568w c0568w) {
    }

    public void mo1910a(C0569x c0569x) {
    }

    public void mo2288a(List<C0569x> list) {
    }

    public void mo1911b(Channel channel, int i, int i2) {
    }

    public void mo1912b(C0569x c0569x) {
    }

    public void mo1913c(Channel channel, int i, int i2) {
    }

    public final IBinder onBind(Intent intent) {
        return "com.google.android.gms.wearable.BIND_LISTENER".equals(intent.getAction()) ? this.f910c : null;
    }

    public void onCreate() {
        super.onCreate();
        this.f908a = new ComponentName(this, getClass().getName());
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.f908a);
            Log.d("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 10).append("onCreate: ").append(valueOf).toString());
        }
        this.f909b = new zzb(this, m1674a());
        this.f911d = new Intent("com.google.android.gms.wearable.BIND_LISTENER");
        this.f911d.setComponent(this.f908a);
        this.f910c = new ai();
    }

    public void onDestroy() {
        if (Log.isLoggable("WearableLS", 3)) {
            String valueOf = String.valueOf(this.f908a);
            Log.d("WearableLS", new StringBuilder(String.valueOf(valueOf).length() + 11).append("onDestroy: ").append(valueOf).toString());
        }
        synchronized (this.f913f) {
            this.f914g = true;
            if (this.f909b == null) {
                String valueOf2 = String.valueOf(this.f908a);
                throw new IllegalStateException(new StringBuilder(String.valueOf(valueOf2).length() + 111).append("onDestroy: mServiceHandler not set, did you override onCreate() but forget to call super.onCreate()? component=").append(valueOf2).toString());
            } else {
                this.f909b.m1659a();
            }
        }
        super.onDestroy();
    }
}
