package com.huawei.nfc;

import com.huawei.nfc.carrera.logic.lostmanager.callback.CheckDeviceStatusCallback;
import com.huawei.p190v.C2538c;

class PluginPay$1 implements CheckDeviceStatusCallback {
    final /* synthetic */ PluginPay this$0;

    PluginPay$1(PluginPay pluginPay) {
        this.this$0 = pluginPay;
    }

    public void checkDeviceStatusCallback(String str) {
        C2538c.b("PluginPay", new Object[]{"== card status checkDeviceStatusCallback status : " + str});
    }
}
