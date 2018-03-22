package com.huawei.ui.device.activity.pairing;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2127l extends BroadcastReceiver {
    final /* synthetic */ DevicePairGuideActivity f7533a;

    C2127l(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7533a = devicePairGuideActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : intent = " + intent.getAction());
        if (context != null && "com.huawei.bone.action.CONNECTION_STATE_CHANGED".equals(intent.getAction())) {
            Parcelable parcelableExtra = intent.getParcelableExtra("deviceinfo");
            if (parcelableExtra != null) {
                if (parcelableExtra instanceof DeviceInfo) {
                    DeviceInfo deviceInfo;
                    try {
                        deviceInfo = (DeviceInfo) parcelableExtra;
                    } catch (ClassCastException e) {
                        C2538c.m12677c("DevicePairGuideActivity", "ClassCastException e.getmessage:" + e.getMessage());
                        deviceInfo = null;
                    }
                    if (deviceInfo == null) {
                        C2538c.m12677c("DevicePairGuideActivity", "deviceInfo is null return");
                        return;
                    }
                    if (this.f7533a.f7504j) {
                        this.f7533a.f7491W = this.f7533a.f7496b;
                    }
                    C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : " + deviceInfo.getDeviceName() + ",connectState = " + deviceInfo.getDeviceConnectState());
                    switch (deviceInfo.getDeviceConnectState()) {
                        case 1:
                            this.f7533a.f7491W = deviceInfo.getDeviceIdentify();
                            C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : DEVICE_CONNECTING！, tempMac =" + this.f7533a.f7491W);
                            this.f7533a.ai.sendEmptyMessage(1);
                            return;
                        case 2:
                            C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : 配对成功! DeviceConnectState : DEVICE_CONNECTED");
                            this.f7533a.ai.sendEmptyMessage(2);
                            this.f7533a.ai.sendEmptyMessage(5);
                            this.f7533a.f7502h = deviceInfo.getDeviceIdentify();
                            return;
                        case 3:
                            C2538c.m12677c("DevicePairGuideActivity", "DEVICE_DISCONNECTED ,mac = " + deviceInfo.getDeviceIdentify() + ",tempMac:" + this.f7533a.f7491W);
                            this.f7533a.ai.sendEmptyMessage(5);
                            if ((3 == deviceInfo.getProductType() && 3 == this.f7533a.f7500f) || (10 == deviceInfo.getProductType() && 10 == this.f7533a.f7500f)) {
                                this.f7533a.ai.sendEmptyMessage(3);
                                return;
                            } else if (this.f7533a.f7491W.equalsIgnoreCase(deviceInfo.getDeviceIdentify())) {
                                this.f7533a.ai.sendEmptyMessage(3);
                                this.f7533a.f7491W = "";
                                return;
                            } else {
                                return;
                            }
                        case 4:
                            C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : state = " + r1 + ",tempMac:" + this.f7533a.f7491W);
                            this.f7533a.ai.sendEmptyMessage(5);
                            this.f7533a.ai.sendEmptyMessage(3);
                            this.f7533a.f7491W = "";
                            return;
                        case 5:
                            C2538c.m12677c("DevicePairGuideActivity", "mConnectStateChangedReceiver : state = " + r1);
                            this.f7533a.ai.sendEmptyMessage(5);
                            this.f7533a.ai.sendEmptyMessage(7);
                            this.f7533a.f7491W = "";
                            return;
                        default:
                            return;
                    }
                }
                C2538c.m12677c("DevicePairGuideActivity", "! parcelableExtra instanceof DeviceInfo ");
            }
        }
    }
}
