package com.huawei.account.aidl;

import android.os.IBinder;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p086k.C1090a;
import com.huawei.p190v.C2538c;

/* compiled from: AccountAidlService */
class C0635c extends C0634h {
    final /* synthetic */ AccountAidlService f1136a;

    C0635c(AccountAidlService accountAidlService) {
        this.f1136a = accountAidlService;
    }

    public IBinder mo2110a(String str) {
        C2538c.m12674b(this.f1136a.f1128a, "getServiceBinder packageName:" + str);
        C2538c.m12677c(this.f1136a.f1128a, "getServiceBinder enter");
        boolean a = C1090a.m4699a(BaseApplication.m2632b(), str);
        C2538c.m12677c(this.f1136a.f1128a, "getServiceBinder res:" + a);
        if (a) {
            return this.f1136a.f1134g;
        }
        return null;
    }
}
