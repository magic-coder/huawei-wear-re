package com.huawei.pluginaf500.ui;

import android.os.Handler;
import android.os.Message;
import com.huawei.pluginaf500.connect_ble.BleDeviceInfo;
import com.huawei.pluginaf500.h;

/* compiled from: AF500GuideActivity */
class C5794c extends Handler {
    final /* synthetic */ AF500GuideActivity f19947a;

    C5794c(AF500GuideActivity aF500GuideActivity) {
        this.f19947a = aF500GuideActivity;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        switch (message.what) {
            case 0:
                this.f19947a.f19656p = true;
                this.f19947a.f19657q = false;
                this.f19947a.f19653m.clear();
                this.f19947a.m26613m();
                return;
            case 1:
                this.f19947a.f19656p = false;
                if (!this.f19947a.f19657q) {
                    if (this.f19947a.f19653m.size() == 0) {
                        this.f19947a.m26595b(-4);
                        return;
                    }
                    this.f19947a.m26614n();
                    this.f19947a.m26615o();
                    return;
                }
                return;
            case 3:
                this.f19947a.m26591a((BleDeviceInfo) message.obj);
                return;
            case 100:
                this.f19947a.m26618r();
                this.f19947a.m26608j();
                return;
            case 101:
                this.f19947a.m26618r();
                Integer num = (Integer) message.obj;
                if (num == null) {
                    this.f19947a.m26595b(-6);
                    return;
                }
                int intValue = num.intValue();
                if (intValue == 1) {
                    this.f19947a.m26595b(-3);
                    return;
                } else if (intValue == 2) {
                    this.f19947a.m26595b(-5);
                    return;
                } else {
                    this.f19947a.m26595b(-6);
                    return;
                }
            case 102:
                this.f19947a.m26599c(h.connect_searching);
                return;
            case 103:
                this.f19947a.m26618r();
                this.f19947a.m26599c(h.binding_device);
                return;
            case 104:
                this.f19947a.m26618r();
                if (!this.f19947a.f19656p) {
                    this.f19947a.m26595b(-2);
                    return;
                }
                return;
            case 106:
                this.f19947a.m26609k();
                return;
            default:
                return;
        }
    }
}
