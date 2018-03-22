package com.huawei.ui.device.activity.adddevice;

import android.os.RemoteException;
import com.huawei.hwservicesmgr.C1047b;
import com.huawei.p190v.C2538c;

/* compiled from: AddDeviceChildActivity */
class C2012n extends C1047b {
    final /* synthetic */ AddDeviceChildActivity f7052a;

    C2012n(AddDeviceChildActivity addDeviceChildActivity) {
        this.f7052a = addDeviceChildActivity;
    }

    public void mo2634a(int i) throws RemoteException {
        switch (i) {
            case 1:
                C2538c.m12677c("AddDeviceChildActivity", "iAddDeviceStateAIDLCallback(): 用户取消了蓝牙开启!");
                return;
            case 2:
                C2538c.m12677c("AddDeviceChildActivity", "iAddDeviceStateAIDLCallback(): 蓝牙开启失败!");
                return;
            case 3:
                C2538c.m12677c("AddDeviceChildActivity", "iAddDeviceStateAIDLCallback(): 用户取消了蓝牙搜索");
                return;
            default:
                return;
        }
    }
}
