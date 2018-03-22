package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothHeadset;
import android.bluetooth.BluetoothInputDevice;
import android.bluetooth.BluetoothProfile.ServiceListener;
import android.content.Context;
import com.huawei.p190v.C2538c;

@SuppressLint({"NewApi"})
/* compiled from: ApiUtil */
public class C1695a {
    private static BluetoothAdapter f4437a = null;
    private static BluetoothHeadset f4438b = null;
    private static BluetoothInputDevice f4439c = null;
    private static ServiceListener f4440d = null;

    public static BluetoothInputDevice m7889a() {
        return f4439c;
    }

    public static void m7890a(BluetoothInputDevice bluetoothInputDevice) {
        f4439c = bluetoothInputDevice;
    }

    public static void m7891a(Context context, BluetoothAdapter bluetoothAdapter) {
        C1695a.m7892b();
        C2538c.m12664a("ApiUtil", " Enter initBluetoothProfile()");
        if (f4440d == null) {
            f4440d = new C1696b();
        }
        if (bluetoothAdapter == null) {
            C2538c.m12664a("ApiUtil", " mAdapter is null");
            BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
            f4437a = defaultAdapter;
            if (defaultAdapter != null) {
                C2538c.m12674b("ApiUtil", "initBluetoothProfile: mAdapter = " + defaultAdapter);
                defaultAdapter.getProfileProxy(context, f4440d, 1);
                defaultAdapter.getProfileProxy(context, f4440d, 4);
                return;
            }
            return;
        }
        f4437a = bluetoothAdapter;
        bluetoothAdapter.getProfileProxy(context, f4440d, 1);
        bluetoothAdapter.getProfileProxy(context, f4440d, 4);
    }

    public static void m7892b() {
        if (f4437a != null) {
            f4437a.closeProfileProxy(1, f4438b);
            f4437a.closeProfileProxy(4, C1695a.m7889a());
            f4437a = null;
            f4438b = null;
            C1695a.m7890a(null);
            f4440d = null;
        }
    }
}
