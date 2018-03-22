package com.huawei.ui.device.p170a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.p190v.C2538c;

/* compiled from: CompatibilityInteractor */
class C1980h implements IBaseResponseCallback {
    final /* synthetic */ C1979g f6918a;

    C1980h(C1979g c1979g) {
        this.f6918a = c1979g;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("CompatibilityInteractor", "Enter overabroadcheckGoHealthForBind err_code:" + i);
        this.f6918a.f6916d.removeMessages(102, this.f6918a.f6915c);
        if (i == 0 && obj != null && (obj instanceof String)) {
            C2538c.m12677c("CompatibilityInteractor", "Enter overabroadcheckGoHealthForBind objData:" + obj);
            String str = "";
            try {
                obj = (String) obj;
            } catch (ClassCastException e) {
                C2538c.m12677c("CompatibilityInteractor", "ClassCastException:" + e.getMessage());
                String str2 = str;
            }
            if (String.valueOf(true).equals(obj)) {
                this.f6918a.f6915c.onResponse(0, Boolean.valueOf(true));
                return;
            } else {
                this.f6918a.f6915c.onResponse(0, Boolean.valueOf(false));
                return;
            }
        }
        this.f6918a.f6915c.onResponse(0, Boolean.valueOf(false));
    }
}
