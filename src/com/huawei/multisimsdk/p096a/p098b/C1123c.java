package com.huawei.multisimsdk.p096a.p098b;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimservice.C1189b;
import com.huawei.multisimservice.C1194g;

/* compiled from: AttachedDeviceManager */
class C1123c implements ServiceConnection {
    final /* synthetic */ C1119a f2380a;

    C1123c(C1119a c1119a) {
        this.f2380a = c1119a;
    }

    public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        C1183h.m5282b("AttachedDeviceManager", "onServiceConnected");
        if (this.f2380a.m4994a(componentName)) {
            this.f2380a.f2372d = C1194g.m5328a(iBinder);
            try {
                iBinder.linkToDeath(this.f2380a.f2378n, 0);
                if (this.f2380a.f2372d != null) {
                    this.f2380a.f2373e = C1189b.m5316a(this.f2380a.f2372d.mo2369a("com.huawei.hwmultisim"));
                }
                if (this.f2380a.f2373e != null) {
                    this.f2380a.f2373e.mo2365a(this.f2380a.f2376l);
                    C1119a.f2368k = 0;
                } else {
                    C1183h.m5286d("AttachedDeviceManager", "Service is null");
                }
            } catch (RemoteException e) {
                C1119a.f2368k = 1;
                C1183h.m5286d("AttachedDeviceManager", "ServiceConnected RemoteException occurred.");
            }
            this.f2380a.m4997b(C1119a.f2368k);
            C1183h.m5278a("AttachedDeviceManager", "multiSimService connected: " + C1119a.f2368k);
            return;
        }
        C1183h.m5286d("AttachedDeviceManager", "checkServiceIdentity failed, unbind service.");
        this.f2380a.m5009d();
    }

    public void onServiceDisconnected(ComponentName componentName) {
        C1183h.m5282b("AttachedDeviceManager", "multiSimService disconnected.");
        if (this.f2380a.f2373e != null) {
            try {
                this.f2380a.f2373e.mo2368b(this.f2380a.f2376l);
            } catch (RemoteException e) {
                C1183h.m5286d("AttachedDeviceManager", "unRegisterCallback remote exception occurred.");
            }
        } else {
            C1183h.m5286d("AttachedDeviceManager", "Service is null");
        }
        this.f2380a.f2373e = null;
        C1119a.f2368k = 1;
        this.f2380a.m4997b(C1119a.f2368k);
    }
}
