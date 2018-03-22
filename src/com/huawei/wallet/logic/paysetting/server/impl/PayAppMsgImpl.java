package com.huawei.wallet.logic.paysetting.server.impl;

import com.huawei.wallet.logic.paysetting.server.PayAppMsg;
import com.huawei.wallet.utils.log.LogC;

public class PayAppMsgImpl implements PayAppMsg {
    private String f21281a;
    private boolean f21282b;
    private boolean f21283c;

    public class AppInfo {
    }

    private void m28072a() {
    }

    public void m28073a(boolean z) {
        if (!this.f21282b && !this.f21281a.isEmpty()) {
            LogC.m28530b("PayAppMsgImpl  updata sp msg", false);
            this.f21283c = z;
            m28072a();
        }
    }
}
