package com.huawei.ui.device.activity.update;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.i;

/* compiled from: DeviceOtaActivity */
class C2170d extends BroadcastReceiver {
    final /* synthetic */ DeviceOtaActivity f7750a;

    C2170d(DeviceOtaActivity deviceOtaActivity) {
        this.f7750a = deviceOtaActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver(): mUpgradeHandler = " + this.f7750a.f7710x + ",+intent = " + intent.getAction());
        if (context != null && this.f7750a.f7710x != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra != null) {
                if (parcelableExtra instanceof DeviceInfo) {
                    C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver(): state = " + ((DeviceInfo) parcelableExtra).getDeviceConnectState() + ",deviceInfo = " + r0.toString());
                    C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver(): mUpdateStatus = " + this.f7750a.f7706s.f6876k);
                    int i;
                    switch (((DeviceInfo) parcelableExtra).getDeviceConnectState()) {
                        case 2:
                            C2538c.m12677c("DeviceOtaActivity", "device connected");
                            this.f7750a.f7685A = true;
                            break;
                        case 3:
                            C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver mOtaType =  " + this.f7750a.f7706s.m10331b());
                            if (1 == this.f7750a.f7706s.m10331b()) {
                                C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver V1 ");
                                this.f7750a.f7710x.sendEmptyMessageDelayed(1000, 120000);
                                this.f7750a.m11123h();
                            }
                            if (2 == this.f7750a.f7706s.m10331b()) {
                                C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver V1X  mUpdateStatus = " + this.f7750a.f7706s.f6876k);
                                i = this.f7750a.f7706s.f6876k;
                                this.f7750a.f7706s;
                                if (i != 12) {
                                    this.f7750a.m11108a(this.f7750a.f7688a.getString(i.IDS_music_management_disconnection));
                                }
                            }
                            if (3 == this.f7750a.f7706s.m10331b()) {
                                C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver V2  mUpdateStatus = " + this.f7750a.f7706s.f6876k);
                                i = this.f7750a.f7706s.f6876k;
                                this.f7750a.f7706s;
                                if (i != 12) {
                                    this.f7750a.m11108a(this.f7750a.f7688a.getString(i.IDS_music_management_disconnection));
                                }
                            }
                            this.f7750a.f7685A = false;
                            break;
                        case 4:
                            i = this.f7750a.f7706s.f6876k;
                            this.f7750a.f7706s;
                            if (i != 12) {
                                this.f7750a.m11108a(this.f7750a.f7688a.getString(i.IDS_device_switch_device_connect_fail));
                                break;
                            }
                            break;
                    }
                    C2538c.m12677c("DeviceOtaActivity", "mConnectStateChangedReceiver() end *** mUpdateStatus = " + this.f7750a.f7706s.f6876k);
                    return;
                }
                C2538c.m12677c("DeviceOtaActivity", "! parcelableExtra instanceof DeviceInfo ");
            }
        }
    }
}
