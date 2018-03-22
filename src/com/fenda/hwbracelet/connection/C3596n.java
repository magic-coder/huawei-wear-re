package com.fenda.hwbracelet.connection;

import android.bluetooth.BluetoothDevice;
import com.huawei.p190v.C2538c;

/* compiled from: XwConnection */
public class C3596n {
    private static String f13765a = null;
    private static BluetoothDevice f13766b = null;
    private static int f13767c;

    static {
        f13767c = 0;
        C2538c.e("XwConnection", new Object[]{"mState: " + f13767c});
        f13767c = 0;
    }

    public static int m18054a() {
        C2538c.e("XwConnection", new Object[]{"mState: " + f13767c});
        return f13767c;
    }

    public static boolean m18056b() {
        C2538c.e("XwConnection", new Object[]{"mState: " + f13767c});
        if (f13767c == 3) {
            return true;
        }
        return false;
    }

    public static void m18055a(int i) {
        C2538c.e("XwConnection", new Object[]{"state: " + i});
        f13767c = i;
    }
}
