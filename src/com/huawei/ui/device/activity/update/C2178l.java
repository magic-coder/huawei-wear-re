package com.huawei.ui.device.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;

/* compiled from: UpdateVersionActivity */
class C2178l extends BroadcastReceiver {
    final /* synthetic */ UpdateVersionActivity f7758a;

    C2178l(UpdateVersionActivity updateVersionActivity) {
        this.f7758a = updateVersionActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("UpdateVersionActivity", "mConnectStateChangedReceiver(): intent = " + intent.getAction());
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra != null) {
                if (parcelableExtra instanceof DeviceInfo) {
                    C2538c.m12677c("UpdateVersionActivity", "mConnectStateChangedReceiver(): state = " + ((DeviceInfo) parcelableExtra).getDeviceConnectState() + ",deviceInfo = " + r0.toString());
                    switch (((DeviceInfo) parcelableExtra).getDeviceConnectState()) {
                        case 2:
                            this.f7758a.f7714B = true;
                            return;
                        case 3:
                            this.f7758a.m11168t();
                            this.f7758a.m11142b(this.f7758a.f7721a.getString(i.IDS_music_management_disconnection));
                            this.f7758a.f7714B = false;
                            return;
                        case 4:
                            this.f7758a.m11168t();
                            this.f7758a.m11142b(this.f7758a.f7721a.getString(i.IDS_device_switch_device_connect_fail));
                            return;
                        default:
                            return;
                    }
                }
                C2538c.m12677c("UpdateVersionActivity", "! parcelableExtra instanceof DeviceInfo ");
            }
        }
    }
}
