package com.huawei.ui.device.p170a;

import com.google.gson.JsonSyntaxException;
import com.huawei.datatype.HealthSupportModel;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C0993c;
import com.huawei.hwdataaccessmodel.sharedpreference.C0996a;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1984l implements IBaseResponseCallback {
    final /* synthetic */ C1983k f6930a;

    C1984l(C1983k c1983k) {
        this.f6930a = c1983k;
    }

    public void onResponse(int i, Object obj) {
        HealthSupportModel healthSupportModel;
        JsonSyntaxException e;
        C2538c.m12677c("CompatibilityInteractor", "getDeviceListFromWear onResponse err_code:" + i);
        this.f6930a.f6926a.removeCallbacksAndMessages(null);
        if (i == 0 && obj != null && (obj instanceof String)) {
            HealthSupportModel healthSupportModel2 = new HealthSupportModel();
            try {
                String str = (String) obj;
                healthSupportModel = (HealthSupportModel) this.f6930a.f6929d.f6902a.fromJson(str, HealthSupportModel.class);
                try {
                    C0996a.m3611a(BaseApplication.m2632b(), String.valueOf(10000), "UNION_HEALTH_SUPPORT_LIST", str, new C0993c());
                } catch (JsonSyntaxException e2) {
                    e = e2;
                    C2538c.m12677c("CompatibilityInteractor", "JsonSyntaxException:" + e.toString());
                    C2538c.m12677c("CompatibilityInteractor", "healthSupportModel:" + healthSupportModel.toString());
                    this.f6930a.f6927b.onResponse(0, healthSupportModel);
                    this.f6930a.f6928c.shutdownNow();
                }
            } catch (JsonSyntaxException e3) {
                JsonSyntaxException jsonSyntaxException = e3;
                healthSupportModel = healthSupportModel2;
                e = jsonSyntaxException;
                C2538c.m12677c("CompatibilityInteractor", "JsonSyntaxException:" + e.toString());
                C2538c.m12677c("CompatibilityInteractor", "healthSupportModel:" + healthSupportModel.toString());
                this.f6930a.f6927b.onResponse(0, healthSupportModel);
                this.f6930a.f6928c.shutdownNow();
            }
            C2538c.m12677c("CompatibilityInteractor", "healthSupportModel:" + healthSupportModel.toString());
            this.f6930a.f6927b.onResponse(0, healthSupportModel);
        } else {
            this.f6930a.f6927b.onResponse(0, new HealthSupportModel());
        }
        this.f6930a.f6928c.shutdownNow();
    }
}
