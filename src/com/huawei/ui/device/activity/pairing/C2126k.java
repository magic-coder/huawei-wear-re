package com.huawei.ui.device.activity.pairing;

import android.os.RemoteException;
import com.huawei.hwservicesmgr.C1047b;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2126k extends C1047b {
    final /* synthetic */ DevicePairGuideActivity f7532a;

    C2126k(DevicePairGuideActivity devicePairGuideActivity) {
        this.f7532a = devicePairGuideActivity;
    }

    public void mo2634a(int i) throws RemoteException {
        switch (i) {
            case 1:
                C2538c.m12677c("DevicePairGuideActivity", "iAddDeviceStateAIDLCallback(): 用户取消了蓝牙开启!");
                this.f7532a.ai.sendEmptyMessage(8);
                break;
            case 2:
                C2538c.m12677c("DevicePairGuideActivity", "iAddDeviceStateAIDLCallback():蓝牙开启失败!");
                this.f7532a.ai.sendEmptyMessage(3);
                break;
            case 3:
                C2538c.m12677c("DevicePairGuideActivity", "iAddDeviceStateAIDLCallback(): 用户取消了蓝牙搜索");
                break;
        }
        if (4 == i) {
            C2538c.m12677c("DevicePairGuideActivity", "AddDeviceState.DEVICE_BT_ENABLE_SCAN MSG_ENABLE_RIGHT_BTN");
            this.f7532a.ai.sendEmptyMessage(5);
        }
    }
}
