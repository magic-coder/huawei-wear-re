package com.huawei.multisimservice;

import android.os.IBinder;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.p086k.C1090a;
import com.huawei.p190v.C2538c;
import com.huawei.p192w.C2546c;

/* compiled from: MultiSimService */
class C1196i extends C1194g {
    final /* synthetic */ MultiSimService f2615a;

    C1196i(MultiSimService multiSimService) {
        this.f2615a = multiSimService;
    }

    public IBinder mo2369a(String str) {
        C2538c.m12677c("MultiSimService", "getServiceBinder input packageName is ", str);
        if (str == null || str.isEmpty()) {
            C2538c.m12679d("MultiSimService", "getServiceBinder input para error");
            return null;
        } else if (!this.f2615a.f2609c.equals("") && !this.f2615a.f2609c.equals(str)) {
            C2538c.m12677c("MultiSimService", "Service already bind with", this.f2615a.f2609c);
            return null;
        } else if (C1090a.m4699a(BaseApplication.m2632b(), str)) {
            this.f2615a.f2609c = str;
            C2546c.m12702a().m12751c(this.f2615a.f2609c);
            if (str.equals("com.huawei.hwmultisim")) {
                C2538c.m12677c("MultiSimService", "getServiceBinder return mAttachedDeviceBinder");
                return this.f2615a.f2611e;
            }
            C2538c.m12677c("MultiSimService", "getServiceBinder return mIOpenMultiSimBinder");
            return this.f2615a.f2612f;
        } else {
            C2538c.m12677c("MultiSimService", "AuthUtils failure with", str);
            return null;
        }
    }
}
