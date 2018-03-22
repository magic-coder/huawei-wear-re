package com.alipay.p238a.p239a.p240a.p241a;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.alipay.p238a.p239a.p240a.C3141c;

final class C3138b implements ServiceConnection {
    final /* synthetic */ C3137a f10504a;

    C3138b(C3137a c3137a) {
        this.f10504a = c3137a;
    }

    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        Log.v("EasyBarcodeSDK", "onServiceConnected");
        synchronized (this.f10504a.f10501b) {
            this.f10504a.f10502c = C3141c.m13976a(iBinder);
            this.f10504a.f10501b.notify();
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        Log.v("EasyBarcodeSDK", "onServiceDisconnected");
        this.f10504a.f10502c = null;
    }
}
