package com.huawei.hwcommonservice;

import android.os.RemoteException;
import com.google.gson.Gson;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonservice.model.C0990d;
import com.huawei.hwcommonservice.model.WearableDeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: HWWearCommonService */
class C0987c implements IBaseResponseCallback {
    final /* synthetic */ WearableDeviceInfo f1660a;
    final /* synthetic */ DeviceInfo f1661b;
    final /* synthetic */ C0990d f1662c;
    final /* synthetic */ C0986b f1663d;

    C0987c(C0986b c0986b, WearableDeviceInfo wearableDeviceInfo, DeviceInfo deviceInfo, C0990d c0990d) {
        this.f1663d = c0986b;
        this.f1660a = wearableDeviceInfo;
        this.f1661b = deviceInfo;
        this.f1662c = c0990d;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0) {
            this.f1660a.setBatteryLevel(((Integer) obj).intValue());
        }
        try {
            this.f1660a.setConnectionStatus(2);
            this.f1660a.setDeviceID(this.f1661b.getDeviceIdentify());
            this.f1660a.setDeviceType(this.f1661b.getProductType());
            this.f1662c.m3602a(0, new Gson().toJson(this.f1660a));
        } catch (RemoteException e) {
            C2538c.m12677c("HWWearCommonService", "RemoteException  ", e);
        }
    }
}
