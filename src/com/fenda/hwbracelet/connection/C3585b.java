package com.fenda.hwbracelet.connection;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BleConnectionManager */
class C3585b extends BroadcastReceiver {
    final /* synthetic */ C3584a f13743a;

    C3585b(C3584a c3584a) {
        this.f13743a = c3584a;
    }

    public void onReceive(Context context, Intent intent) {
        if (context == null || intent == null) {
            C2538c.e("BluetoothGatt", new Object[]{"alarmBroadcastReceiver onReceive null == context or null == intent, so don't need to reconnect."});
            return;
        }
        String action = intent.getAction();
        if (action == null) {
            C2538c.e("BluetoothGatt", new Object[]{"alarmBroadcastReceiver actiont is null"});
            return;
        }
        C2538c.b("BluetoothGatt", new Object[]{"onReceive -> " + action});
        if (C3596n.m18054a() == 3) {
            C2538c.e("BluetoothGatt", new Object[]{"ble has connected, so don't need to reconnect."});
            return;
        }
        int a = this.f13743a.m18013b(this.f13743a.f13723f);
        C2538c.e("BluetoothGatt", new Object[]{"-alarm braocast--getStatusFromGatt-" + a});
        if (action.equals("com.af500.ble_connect_timeout_action") && this.f13743a.f13735s) {
            this.f13743a.f13735s = false;
            if (C3596n.m18054a() == 3) {
                return;
            }
            if (this.f13743a.f13723f != null) {
                C2538c.e("BluetoothGatt", new Object[]{"receive the  BLE_CONNECT_TIMEOUT_ACTION"});
                if (this.f13743a.m18013b(this.f13743a.f13723f) == 2) {
                    C2538c.e("BluetoothGatt", new Object[]{"BLE_CONNECT_TIMEOUT_ACTION Failed-----but mBluetoothGatt.discoverServices()"});
                    this.f13743a.f13723f.discoverServices();
                    return;
                }
                this.f13743a.m18046d();
                return;
            }
            int c;
            synchronized (this.f13743a) {
                c = this.f13743a.f13731o;
            }
            if (c != 0 && this.f13743a.f13733q) {
                this.f13743a.m18026g();
            }
        } else if (action.equals("com.af500.ble_reconnect_action") && this.f13743a.f13736t) {
            this.f13743a.f13736t = false;
            if (this.f13743a.f13733q && C3596n.m18054a() == 0) {
                C2538c.e("BluetoothGatt", new Object[]{"receive the  BLE_RECONNECT_ACTION "});
                this.f13743a.m18009a(this.f13743a.f13727j, 2);
            }
        }
    }
}
