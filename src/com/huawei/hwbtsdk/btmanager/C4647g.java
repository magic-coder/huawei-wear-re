package com.huawei.hwbtsdk.btmanager;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.p190v.C2538c;

/* compiled from: BLEReconnectManager */
class C4647g extends Handler {
    final /* synthetic */ C4645e f16992a;

    public C4647g(C4645e c4645e, Looper looper) {
        this.f16992a = c4645e;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.a("01", 1, "BLEReconnectManager", new Object[]{"mReconnectHandler receive msg:" + message.what});
        switch (message.what) {
            case 1:
                this.f16992a.m22276c((DeviceInfo) message.obj);
                return;
            default:
                return;
        }
    }
}
