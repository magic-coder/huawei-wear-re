package com.huawei.pluginaf500.ui;

import android.content.Intent;
import com.fenda.hwbracelet.p261d.C3597a;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.DeviceInfo;
import com.huawei.hwcommonmodel.p063b.C4713a;
import com.huawei.p464l.p465a.C5417c;
import java.util.HashMap;
import java.util.Map;

/* compiled from: AF500GuideActivity */
class C5797e implements C3597a {
    final /* synthetic */ AF500GuideActivity f19959a;

    C5797e(AF500GuideActivity aF500GuideActivity) {
        this.f19959a = aF500GuideActivity;
    }

    public void mo4602a(DeviceInfo deviceInfo) {
        if (deviceInfo != null) {
            int deviceConnectState = deviceInfo.getDeviceConnectState();
            if (1 == deviceConnectState) {
                this.f19959a.f19657q = true;
                this.f19959a.f19644b = false;
                if (!this.f19959a.f19658r) {
                    this.f19959a.f19665y.sendEmptyMessage(102);
                }
            } else if (2 == deviceConnectState) {
                this.f19959a.setResult(2);
                this.f19959a.finish();
                Map hashMap = new HashMap();
                hashMap.put("devicename", "AF500");
                hashMap.put("mac", deviceInfo.getDeviceIdentify());
                C5417c.m26022a().m26023a(BaseApplication.b(), C4713a.SETTING_1090001.m22567a(), hashMap, 0);
                C5417c.m26022a().m26024a(BaseApplication.b());
                Intent intent = new Intent();
                intent.setClassName(this.f19959a.f19660t, "com.huawei.bone.root.MainActivity");
                this.f19959a.startActivity(intent);
            } else if (3 == deviceConnectState && !this.f19959a.f19644b) {
                this.f19959a.f19657q = false;
                if (!this.f19959a.f19658r) {
                    this.f19959a.f19665y.sendEmptyMessage(104);
                }
            }
        }
    }
}
