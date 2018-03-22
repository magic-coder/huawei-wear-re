package com.huawei.pluginkidwatch.plugin.p152a.p153a.p160d;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.os.Build.VERSION;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.p152a.p153a.p154c.p155a.C1690h;

@SuppressLint({"NewApi"})
/* compiled from: BluetoothConnectServiceFactory */
public class C1704j {
    public static C1700i m8070a(Context context, BluetoothDevice bluetoothDevice, C1690h c1690h, int i) {
        C2538c.m12674b("BluetoothConnectServiceFactory", "sdkVersion = " + VERSION.SDK_INT);
        if (VERSION.SDK_INT >= 18) {
            if (bluetoothDevice == null) {
                C2538c.m12674b("BluetoothConnectServiceFactory", "Error device is null !");
            } else {
                int type = bluetoothDevice.getType();
                C2538c.m12674b("BluetoothConnectServiceFactory", "type = " + type);
                if (1 == type) {
                    C2538c.m12674b("BluetoothConnectServiceFactory", "Create classic connection service ");
                    return C1701f.m8051a(context, c1690h);
                } else if (2 == type || 3 == type) {
                    C2538c.m12674b("BluetoothConnectServiceFactory", "Create BLE connection service ");
                    return C1705k.m8079a(context, c1690h, i);
                } else if (type == 0 && (4 == i || 5 == i)) {
                    C2538c.m12674b("BluetoothConnectServiceFactory", "BluetoothDevice type is DEVICE_TYPE_UNKNOWN! device = " + bluetoothDevice);
                    return C1705k.m8079a(context, c1690h, i);
                }
            }
        }
        return C1701f.m8051a(context, c1690h);
    }
}
