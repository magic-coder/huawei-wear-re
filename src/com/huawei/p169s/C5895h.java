package com.huawei.p169s;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.s.b;
import com.huawei.ui.main.stories.lightcloud.constants.LightCloudConstants;
import com.huawei.p190v.C2538c;

/* compiled from: HWGPSLocationManager */
class C5895h extends BroadcastReceiver {
    final /* synthetic */ b f20189a;

    C5895h(b bVar) {
        this.f20189a = bVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            DeviceInfo deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
            if (deviceInfo != null) {
                C2538c.c("HWGPSLocationManager", new Object[]{"mConnectStateChangedReceiver() status = " + deviceInfo.getDeviceConnectState()});
                switch (deviceInfo.getDeviceConnectState()) {
                    case 2:
                        if (b.f(this.f20189a) != null) {
                            b.f(this.f20189a).removeMessages(1);
                        }
                        if (C5889a.m27091e()) {
                            if (b.g(this.f20189a) == null) {
                                if (b.f(this.f20189a) != null) {
                                    b.f(this.f20189a).sendEmptyMessage(1);
                                }
                            } else if ((deviceInfo.getDeviceIdentify() == null || !b.g(this.f20189a).equalsIgnoreCase(deviceInfo.getDeviceIdentify())) && b.f(this.f20189a) != null) {
                                b.f(this.f20189a).sendEmptyMessage(1);
                            }
                            this.f20189a.b();
                        }
                        b.a(this.f20189a, deviceInfo.getDeviceIdentify());
                        return;
                    case 3:
                        if (b.f(this.f20189a) != null) {
                            b.f(this.f20189a).sendEmptyMessageDelayed(1, LightCloudConstants.LightCloud_FAULT_INTERVAL_TIME);
                            return;
                        }
                        return;
                    default:
                        return;
                }
            }
        }
    }
}
