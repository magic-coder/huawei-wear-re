package com.huawei.hwcloudmodel.p061c.p403a;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.huawei.hwcloudmodel.callback.C3957a;
import com.huawei.hwcloudmodel.model.CloudCommonReponse;
import com.huawei.p190v.C2538c;
import com.huawei.up.p520e.C6133g;

import java.util.Map;

/* compiled from: HealthDataHiCloudClient */
class C4684c implements Runnable {
    final /* synthetic */ String f17097a;
    final /* synthetic */ Map f17098b;
    final /* synthetic */ C3957a f17099c;
    final /* synthetic */ C4683b f17100d;

    C4684c(C4683b c4683b, String str, Map map, C3957a c3957a) {
        this.f17100d = c4683b;
        this.f17097a = str;
        this.f17098b = map;
        this.f17099c = c3957a;
    }

    public void run() {
        try {
            boolean z;
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice!!!"});
            String b = this.f17100d.m22426b(this.f17097a, this.f17098b, 30, 30, 1);
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice response = " + b});
            CloudCommonReponse cloudCommonReponse = (CloudCommonReponse) new Gson().fromJson(b, CloudCommonReponse.class);
            if (cloudCommonReponse == null || cloudCommonReponse.getResultCode() != 0) {
                z = false;
            } else {
                C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice response success is true"});
                z = true;
            }
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice response success = " + z});
            if (this.f17099c != null) {
                this.f17099c.mo4330a(null, b, z);
            }
        } catch (C6133g e) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice NSPException !!!"});
            if (this.f17099c != null) {
                this.f17099c.mo4330a(null, "", false);
            }
        } catch (JsonSyntaxException e2) {
            C2538c.c("HealthDataHiCloudClient", new Object[]{"matb requestKidwatchHiCloud call sevice JsonSyntaxException !!!"});
            if (this.f17099c != null) {
                this.f17099c.mo4330a(null, "", false);
            }
        }
    }
}
