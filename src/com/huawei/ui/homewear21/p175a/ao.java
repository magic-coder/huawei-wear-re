package com.huawei.ui.homewear21.p175a;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwcommonmodel.datatypes.HuaweiHealthData;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.p170a.C1988p;

/* compiled from: HomeFragment */
class ao implements Runnable {
    final /* synthetic */ boolean f8057a;
    final /* synthetic */ an f8058b;

    ao(an anVar, boolean z) {
        this.f8058b = anVar;
        this.f8057a = z;
    }

    public void run() {
        String str = "";
        if ("".equals(this.f8058b.f8055a.getUUID())) {
            str = this.f8058b.f8055a.getDeviceIdentify();
        } else {
            str = this.f8058b.f8055a.getUUID();
        }
        C1988p.m10381a(BaseApplication.m2632b()).m10389a(str, this.f8057a, null);
        Object huaweiHealthData = new HuaweiHealthData();
        Gson gson = new Gson();
        try {
            huaweiHealthData.setCommandType(2);
            huaweiHealthData.setData(C2217a.af.b());
            huaweiHealthData.setData1(String.valueOf(this.f8057a));
            str = gson.toJson(huaweiHealthData);
            C2538c.m12677c("HomeFragment", "gson:" + str);
            if (str != null) {
                C1988p.m10381a(BaseApplication.m2632b()).m10388a(str, new ap(this));
            }
        } catch (JsonSyntaxException e) {
            C2538c.m12677c("HomeFragment", "Enter JsonSyntaxException");
        }
    }
}
