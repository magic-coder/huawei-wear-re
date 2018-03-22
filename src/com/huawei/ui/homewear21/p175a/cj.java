package com.huawei.ui.homewear21.p175a;

import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.C1093a;
import com.huawei.p190v.C2538c;
import com.huawei.up.a.a;

/* compiled from: LeftMenuFragment */
class cj implements IBaseResponseCallback {
    final /* synthetic */ cf f8127a;

    cj(cf cfVar) {
        this.f8127a = cfVar;
    }

    public void onResponse(int i, Object obj) {
        C2538c.m12677c("LeftMenuFragment", "loginForHuid err_code：" + i);
        if (i == 0) {
            if (C1093a.m4739a(BaseApplication.m2632b()).m4750c().equals((String) obj)) {
                int a = new a(this.f8127a.f8109c).a(this.f8127a, 1);
                C2538c.m12677c("LeftMenuFragment", "jumpToHwIdAccountCenter, errorCode = " + a);
                return;
            }
            C2538c.m12677c("LeftMenuFragment", "loginForCenter enter else");
        } else if (40 == i && this.f8127a.f8121o != null) {
            this.f8127a.f8121o.sendEmptyMessage(2);
        }
    }
}
