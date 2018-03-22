package com.huawei.hwcommonservice;

import android.os.IBinder;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p086k.C1090a;
import com.huawei.p190v.C2538c;

/* compiled from: HWWearCommonService */
class C0983a extends C0982g {
    final /* synthetic */ HWWearCommonService f1658a;

    C0983a(HWWearCommonService hWWearCommonService) {
        this.f1658a = hWWearCommonService;
    }

    public IBinder mo2306a(String str, int i) {
        C2538c.m12677c("HWWearCommonService", "getServiceBinder input packageName is ", str);
        if (str == null || str.isEmpty()) {
            C2538c.m12679d("HWWearCommonService", "getServiceBinder input para error");
        } else if (!C1090a.m4699a(BaseApplication.m2632b(), str)) {
            C2538c.m12677c("HWWearCommonService", "AuthUtils failure with", str);
        } else if (i == 1) {
        }
        return null;
    }
}
