package com.huawei.ui.device.activity.pairing;

import android.os.Looper;
import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.c.a;
import com.huawei.p190v.C2538c;

/* compiled from: DevicePairGuideActivity */
class C2139x extends a<DevicePairGuideActivity> {
    public C2139x(Looper looper, DevicePairGuideActivity devicePairGuideActivity) {
        super(looper, devicePairGuideActivity);
    }

    protected void m10964a(DevicePairGuideActivity devicePairGuideActivity, Message message) {
        C2538c.m12677c("DevicePairGuideActivity", "Enter handleMessageWhenReferenceNotNull");
        switch (message.what) {
            case 100:
                C2538c.m12677c("DevicePairGuideActivity", "Enter getbinddevice from itmeout");
                ((IBaseResponseCallback) message.obj).onResponse(-1, "getbinddevice from itmeout");
                return;
            case 101:
                C2538c.m12677c("DevicePairGuideActivity", "Enter unBindHealthDevice from itmeout");
                ((IBaseResponseCallback) message.obj).onResponse(-1, "unBindHealthDevice from itmeout");
                return;
            case 102:
                C2538c.m12677c("DevicePairGuideActivity", "Enter is support from itmeout");
                ((IBaseResponseCallback) message.obj).onResponse(-1, "is support from itmeout");
                return;
            default:
                return;
        }
    }
}
