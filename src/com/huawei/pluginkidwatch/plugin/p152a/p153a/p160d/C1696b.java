package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothProfile;
import android.bluetooth.BluetoothProfile.ServiceListener;
import com.huawei.p190v.C2538c;

/* compiled from: ApiUtil */
final class C1696b implements ServiceListener {
    C1696b() {
    }

    public void onServiceConnected(int i, BluetoothProfile bluetoothProfile) {
        C2538c.m12664a("ApiUtil", " Enter onServiceConnected() proxyListener = " + C1695a.f4440d);
        C2538c.m12674b("ApiUtil", "onServiceConnected: arg0 = " + i + ", arg1 = " + bluetoothProfile);
        switch (i) {
            case 1:
                C2538c.m12674b("ApiUtil", "onServiceConnected() hfp service connected");
                C1695a.f4438b = (BluetoothHeadset) bluetoothProfile;
                return;
            case 4:
                C2538c.m12674b("ApiUtil", "onServiceConnected() hid service connected");
                C1695a.m7890a((BluetoothInputDevice) bluetoothProfile);
                return;
            default:
                return;
        }
    }

    public void onServiceDisconnected(int i) {
        C2538c.m12674b("ApiUtil", "onServiceDisconnected: arg0 = " + i);
        switch (i) {
            case 1:
                C2538c.m12674b("ApiUtil", "onServiceConnected() hfp service disConnected");
                C1695a.f4438b = null;
                return;
            case 4:
                C2538c.m12674b("ApiUtil", "onServiceConnected() hid service disConnected");
                C1695a.m7890a(null);
                return;
            default:
                return;
        }
    }
}
