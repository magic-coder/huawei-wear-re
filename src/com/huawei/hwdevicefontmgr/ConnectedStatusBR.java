package com.huawei.hwdevicefontmgr;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwbasemgr.C0956c;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

public class ConnectedStatusBR extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2538c.m12680e("ConnectedStatusBR", "mConnectStateChangedReceiver() context = " + context + " intent = " + intent.getAction());
        if (context == null) {
            return;
        }
        if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        C2538c.m12677c("ConnectedStatusBR", "mConnectStateChangedReceiver()  send command ");
                        C1021a.m3912a(context).m3915b();
                        return;
                    default:
                        return;
                }
            }
            C2538c.m12680e("ConnectedStatusBR", "mConnectStateChangedReceiver() deviceInfo is null");
        } else if ("com.huawei.bone.action.health_refresh_imperial_unit".equals(intent.getAction())) {
            int intExtra = intent.getIntExtra("unit", -1);
            if (-1 != intExtra) {
                boolean z;
                if (1 == intExtra) {
                    z = true;
                } else {
                    z = false;
                }
                if (z != C0956c.m3349a()) {
                    C0956c.m3348a(z);
                    C1021a.m3912a(context).m3915b();
                }
            }
        }
    }
}
