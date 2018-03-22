package com.huawei.ui.main.stories.about.p179a;

import android.content.Context;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.C1971j;
import java.util.List;

/* compiled from: AppUpdateInteractor */
class C2280b implements IBaseResponseCallback {
    final /* synthetic */ C1971j f8278a;
    final /* synthetic */ int f8279b;
    final /* synthetic */ Context f8280c;
    final /* synthetic */ C2279a f8281d;

    C2280b(C2279a c2279a, C1971j c1971j, int i, Context context) {
        this.f8281d = c2279a;
        this.f8278a = c1971j;
        this.f8279b = i;
        this.f8280c = context;
    }

    public void onResponse(int i, Object obj) {
        if (i == 0 && obj != null) {
            try {
                obj = (List) obj;
            } catch (ClassCastException e) {
                C2538c.m12677c("AppUpdateInteractor", "makeMessage, " + e.getMessage());
                obj = null;
            }
            if (obj == null || obj.size() <= 0) {
                this.f8278a.m10247a("device", "device_app_update", new C2281c(this));
                return;
            }
            C2538c.m12677c("AppUpdateInteractor", "has message donot makeMessage, ");
        }
    }
}
