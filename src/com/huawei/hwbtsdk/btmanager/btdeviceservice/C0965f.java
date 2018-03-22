package com.huawei.hwbtsdk.btmanager.btdeviceservice;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import cn.com.fmsh.tsm.business.constants.Constants.TagName;
import com.google.android.gms.wearable.ab;
import com.huawei.hwcommonmodel.C0973a;
import com.huawei.p190v.C2538c;

/* compiled from: BTDeviceAWService */
class C0965f extends Handler {
    final /* synthetic */ C0960a f1598a;

    public C0965f(C0960a c0960a, Looper looper) {
        this.f1598a = c0960a;
        super(looper);
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        C2538c.m12661a("01", 1, "BTDeviceAWService", "receive msg:" + message.what);
        switch (message.what) {
            case 1:
                if (2 == this.f1598a.f1586i) {
                    byte[] bArr = new byte[]{(byte) 0, (byte) 1, (byte) 1, TagName.USER_LOGIN_FAIL_COUNT, (byte) 0};
                    C2538c.m12661a("01", 1, "BTDeviceAWService", "Start to send V1 check command.");
                    C2538c.m12661a("01", 0, "BTDeviceAWService", "SDK-->Device : " + C0973a.m3509a(bArr));
                    ab a = ab.m1688a("/phone");
                    a.m1689a().m2246a("byte", bArr);
                    a.m1689a().m2240a("current_time", System.currentTimeMillis());
                    if (this.f1598a.f1585h != null) {
                        a.m1689a().m2243a("NODE", this.f1598a.f1585h.getId());
                        C2538c.m12661a("01", 1, "BTDeviceAWService", "NODE = " + this.f1598a.f1585h.getId());
                    } else {
                        C2538c.m12661a("01", 1, "BTDeviceAWService", "sendBTDeviceData NODE = null");
                    }
                    this.f1598a.m3396a(a);
                    return;
                }
                return;
            default:
                return;
        }
    }
}
