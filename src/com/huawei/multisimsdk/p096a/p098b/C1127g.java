package com.huawei.multisimsdk.p096a.p098b;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import com.huawei.multisimsdk.multidevicemanager.p105e.C1183h;
import com.huawei.multisimservice.model.MultiSimDeviceInfo;

/* compiled from: AttachedDeviceManager */
class C1127g extends Handler {
    final /* synthetic */ C1119a f2383a;

    private C1127g(C1119a c1119a, Looper looper) {
        this.f2383a = c1119a;
        super(looper);
    }

    private void m5020a(int i) {
        Message obtainMessage = obtainMessage();
        switch (i) {
            case 6:
                obtainMessage.what = 9;
                obtainMessage.arg1 = i;
                sendMessageDelayed(obtainMessage, 35000);
                return;
            default:
                C1183h.m5286d("AttachedDeviceManager", "Can not find type to send over time message.");
                return;
        }
    }

    private void m5022b(int i) {
        C1183h.m5282b("AttachedDeviceManager", "AttachedDeviceMgrHandler start to handle over time." + i + ", " + 6 + ", intTime" + this.f2383a.f2375g);
        switch (i) {
            case 6:
                m5019a();
                return;
            default:
                C1183h.m5286d("AttachedDeviceManager", "AttachedDeviceMgrHandler Handle Over Time ERROR.");
                return;
        }
    }

    private void m5019a() {
        if (!this.f2383a.f2375g) {
            try {
                MultiSimDeviceInfo multiSimDeviceInfo = new MultiSimDeviceInfo();
                multiSimDeviceInfo.setResultCode(-4);
                this.f2383a.f2376l.mo2359a(multiSimDeviceInfo);
            } catch (RemoteException e) {
                C1183h.m5286d("AttachedDeviceManager", "RemoteException has occurred.");
            }
        }
    }

    private void m5021b() {
        this.f2383a.f2375g = false;
        if (!this.f2383a.f2371c.hasMessages(6)) {
            m5020a(6);
        }
        if (this.f2383a.f2373e == null) {
            C1183h.m5286d("AttachedDeviceManager", "handleMessage mService is null");
            return;
        }
        try {
            this.f2383a.f2373e.mo2363a();
        } catch (RemoteException e) {
            C1183h.m5286d("AttachedDeviceManager", "Server RemoteException.");
        }
    }

    public void handleMessage(Message message) {
        C1183h.m5282b("AttachedDeviceManager", "AttachedDeviceMgrHandler handle message: " + message.what);
        if (message.getData() == null) {
            C1183h.m5286d("AttachedDeviceManager", "bundle is null");
            return;
        }
        switch (message.what) {
            case 6:
                C1183h.m5278a("AttachedDeviceManager", "MSG: get device sim info.");
                m5021b();
                return;
            case 7:
                this.f2383a.f2375g = true;
                C1183h.m5278a("AttachedDeviceManager", "MSG: get device sim info callback.");
                removeMessages(9);
                this.f2383a.m4990a(message);
                return;
            case 9:
                C1183h.m5286d("AttachedDeviceManager", "MSG: Service time out, with type = " + message.arg1);
                m5022b(message.arg1);
                return;
            default:
                return;
        }
    }
}
