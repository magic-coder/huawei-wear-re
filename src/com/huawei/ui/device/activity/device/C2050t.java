package com.huawei.ui.device.activity.device;

import android.os.Message;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1988p;
import com.huawei.ui.device.views.device.C2202h;
import java.util.Iterator;

/* compiled from: DeviceManagerListActivity */
class C2050t implements IBaseResponseCallback {
    final /* synthetic */ DeviceManagerListActivity f7159a;

    private C2050t(DeviceManagerListActivity deviceManagerListActivity) {
        this.f7159a = deviceManagerListActivity;
    }

    public void onResponse(int i, Object obj) {
        if (obj != null) {
            DeviceManagerListActivity.f7110k = ((Integer) obj).intValue();
            C2538c.m12677c("DeviceManagerListActivity", "mIBaseResponseCallback(): battery = " + DeviceManagerListActivity.f7110k + ",err_code = " + i);
            if (C1988p.m10381a(BaseApplication.m2632b()).m10384a() != null) {
                String deviceIdentify = C1988p.m10381a(BaseApplication.m2632b()).m10384a().getDeviceIdentify();
                if (deviceIdentify != null && this.f7159a.f7117f != null) {
                    Iterator it = this.f7159a.f7117f.iterator();
                    while (it.hasNext()) {
                        C2202h c2202h = (C2202h) it.next();
                        if (c2202h.m11320b() == 2 && c2202h.m11326e().equalsIgnoreCase(deviceIdentify)) {
                            c2202h.m11319a(c2202h.m11326e(), DeviceManagerListActivity.f7110k);
                            C2538c.m12677c("DeviceManagerListActivity", "mIBaseResponseCallback():" + c2202h.m11316a() + ",mac is :" + c2202h.m11326e() + ", deviceBattery =" + DeviceManagerListActivity.f7110k + "," + deviceIdentify);
                            C2538c.m12677c("DeviceManagerListActivity", "mIBaseResponseCallback():电量callback回来啦，通知更新Adapter！ ");
                            if (this.f7159a.f7131u != null) {
                                Message message = new Message();
                                message.arg1 = 2;
                                message.what = 1;
                                this.f7159a.f7131u.sendMessage(message);
                            }
                            C2538c.m12677c("DeviceManagerListActivity", "电量值设置完毕，mDeviceItemList:" + this.f7159a.f7117f.toString());
                        }
                    }
                }
            }
        }
    }
}
