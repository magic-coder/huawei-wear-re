package com.huawei.p108n;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwservicesmgr.a.q;
import com.huawei.n.c;
import com.huawei.p190v.C2538c;

import java.util.List;

/* compiled from: HWDeviceConfigManager */
class C5515v extends BroadcastReceiver {
    final /* synthetic */ c f19423a;

    C5515v(c cVar) {
        this.f19423a = cVar;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            C2538c.c("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() context = " + context + " intent = " + intent.getAction()});
            DeviceInfo deviceInfo;
            if ("com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
                deviceInfo = (DeviceInfo) intent.getParcelableExtra("deviceinfo");
                if (deviceInfo != null) {
                    C2538c.c("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() ConnectState() = " + deviceInfo.getDeviceConnectState()});
                    switch (deviceInfo.getDeviceConnectState()) {
                        case 2:
                            c.c(this.f19423a);
                            c.a(this.f19423a, deviceInfo);
                            q.a(c.d(this.f19423a));
                            c.e(this.f19423a);
                            return;
                        case 3:
                            synchronized (c.p()) {
                                c.a(null);
                            }
                            synchronized (c.q()) {
                                for (Integer num : c.r()) {
                                    ((List) c.s().get(num)).clear();
                                }
                            }
                            return;
                        default:
                            return;
                    }
                }
                C2538c.e("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() deviceInfo is null"});
                return;
            } else if ("android.intent.action.TIMEZONE_CHANGED".equals(intent.getAction()) || "android.intent.action.TIME_SET".equals(intent.getAction())) {
                deviceInfo = this.f19423a.c();
                if (deviceInfo == null) {
                    C2538c.e("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() deviceInfo is null"});
                    return;
                } else if (deviceInfo.getDeviceProtocol() != 0) {
                    c.a(this.f19423a, c.f(this.f19423a), c.g(this.f19423a), c.a(this.f19423a), true);
                    return;
                } else {
                    C2538c.e("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() deviceInfo.getDeviceProtocol() is V0"});
                    return;
                }
            } else if ("com.huawei.bone.action.PHONE_SERVICE_BIND_SUCCESS".equalsIgnoreCase(intent.getAction())) {
                C2538c.c("HWDeviceConfigManager", new Object[]{"收到phoneService绑定成功的广播"});
                c.c(this.f19423a);
                c.e(this.f19423a);
                q.a(c.d(this.f19423a));
                return;
            } else {
                return;
            }
        }
        C2538c.e("HWDeviceConfigManager", new Object[]{"mConnectStateChangedReceiver() intent is null"});
    }
}
