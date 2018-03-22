package com.huawei.ui.homewear21.card.views;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.c.a;
import com.huawei.ui.homewear21.card.p176a.C2243a;
import com.huawei.ui.homewear21.i;

/* compiled from: PariedDevicesSwitcher */
class C2268i implements OnItemClickListener {
    final /* synthetic */ PariedDevicesSwitcher f8250a;

    C2268i(PariedDevicesSwitcher pariedDevicesSwitcher) {
        this.f8250a = pariedDevicesSwitcher;
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        String a;
        this.f8250a.m11677e();
        int size = this.f8250a.f8220l.size();
        if (i < size && size > 0) {
            a = C0996a.m3612a(this.f8250a.f8217i, String.valueOf(MessageObserver.RET_CHECK_PARAM_ERROR), "KEY_SYNCHRONIZING_DATA_FLAG");
            C2538c.m12677c(PariedDevicesSwitcher.f8209b, "onClick synchronizing = " + a);
            if (!"true".equals(a)) {
                for (C2262c c : this.f8250a.f8220l) {
                    if (1 == c.m11703c()) {
                        this.f8250a.f8230v.sendEmptyMessage(5);
                        if (this.f8250a.f8214f != null) {
                            this.f8250a.f8214f.onResponse(101, null);
                            return;
                        }
                        return;
                    }
                }
            } else if (this.f8250a.f8214f != null) {
                this.f8250a.f8214f.onResponse(102, null);
                return;
            } else {
                return;
            }
        }
        String a2 = ((C2262c) this.f8250a.f8220l.get(i)).m11695a();
        a = ((C2262c) this.f8250a.f8220l.get(i)).m11705d();
        DeviceInfo c2 = C2243a.m11601a().m11614c();
        String str = "";
        str = "";
        if (!this.f8250a.m11674c(a) && !this.f8250a.m11672b(a)) {
            if (c2 != null) {
                C2538c.m12677c(PariedDevicesSwitcher.f8209b, "deviceInfo = :" + c2.toString());
                str = c2.getDeviceIdentify();
                int deviceConnectState = c2.getDeviceConnectState();
                String deviceName = c2.getDeviceName();
                if (a2.equalsIgnoreCase(str)) {
                    if (2 == deviceConnectState) {
                        C2538c.m12677c(PariedDevicesSwitcher.f8209b, "进入详细设置界面,设备为：" + ((C2262c) this.f8250a.f8220l.get(i)).m11705d());
                        return;
                    } else if (1 == deviceConnectState) {
                        a.b(this.f8250a.f8217i, this.f8250a.f8217i.getString(i.IDS_device_connecting));
                        return;
                    } else {
                        this.f8250a.m11661a(i);
                        return;
                    }
                } else if (2 == deviceConnectState) {
                    this.f8250a.m11668a(deviceName, a, i);
                    return;
                } else {
                    this.f8250a.m11661a(i);
                    return;
                }
            }
            C2538c.m12677c(PariedDevicesSwitcher.f8209b, "deviceInfo is null!");
            this.f8250a.m11661a(i);
        }
    }
}
