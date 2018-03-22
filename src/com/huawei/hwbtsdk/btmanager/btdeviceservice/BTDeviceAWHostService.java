package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.wearable.C0526d;
import com.google.android.gms.wearable.C0568w;
import com.google.android.gms.wearable.C0569x;
import com.google.android.gms.wearable.C0570o;
import com.google.android.gms.wearable.WearableListenerService;
import com.huawei.p190v.C2538c;
import java.util.List;

public class BTDeviceAWHostService extends WearableListenerService {
    private C0960a f1574a = null;

    public void onCreate() {
        super.onCreate();
        C2538c.m12661a("01", 1, "BTDeviceAWHostService", "BTDeviceAWHostService onCreate");
        this.f1574a = C0960a.m3374a();
        this.f1574a.m3392a((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
        C2538c.m12661a("01", 1, "BTDeviceAWHostService", "BTDeviceAWHostService onDestroy");
    }

    public void mo2288a(List<C0569x> list) {
        super.mo2288a((List) list);
        C2538c.m12661a("01", 1, "BTDeviceAWHostService", "onConnectedNodes:" + list.size());
    }

    public void mo1910a(C0569x c0569x) {
        super.mo1910a(c0569x);
        C2538c.m12661a("01", 1, "BTDeviceAWHostService", "onPeerConnected:" + c0569x);
        if (this.f1574a != null) {
            this.f1574a.mo1910a(c0569x);
        }
    }

    public void mo1912b(C0569x c0569x) {
        super.mo1912b(c0569x);
        C2538c.m12661a("01", 1, "BTDeviceAWHostService", "onPeerDisconnected:" + c0569x);
        if (this.f1574a != null) {
            this.f1574a.mo1912b(c0569x);
        }
    }

    public void mo1908a(C0570o c0570o) {
        C2538c.m12661a("01", 0, "BTDeviceAWHostService", "onDataChanged:" + c0570o);
        if (this.f1574a != null) {
            this.f1574a.mo1908a(c0570o);
        }
    }

    public void mo1907a(C0526d c0526d) {
        C2538c.m12661a("01", 0, "BTDeviceAWHostService", "onCapabilityChanged:" + c0526d);
        if (this.f1574a != null) {
            this.f1574a.mo1907a(c0526d);
        }
    }

    public void mo1909a(C0568w c0568w) {
        C2538c.m12661a("01", 0, "BTDeviceAWHostService", "onMessageReceived: " + c0568w);
        if (this.f1574a != null) {
            this.f1574a.mo1909a(c0568w);
        }
    }

    public static void m3355a(Context context) {
        if (context != null) {
            C2538c.m12661a("01", 1, "BTDeviceAWHostService", "BTDeviceAWHostService start");
            context.startService(new Intent(context, BTDeviceAWHostService.class));
        }
    }
}
