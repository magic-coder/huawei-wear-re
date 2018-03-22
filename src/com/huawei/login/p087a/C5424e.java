package com.huawei.login.p087a;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.p065a.C4761b;
import com.huawei.hwdataaccessmodel.p065a.C4762d;
import com.huawei.login.a.a;
import com.huawei.login.ui.login.util.C5432b;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiLoginManager */
class C5424e implements C4761b {
    final /* synthetic */ a f19242a;

    C5424e(a aVar) {
        this.f19242a = aVar;
    }

    public void mo4692a(C4762d c4762d) {
        C2538c.b("PLGLOGIN_HuaweiLoginManager", new Object[]{"----login result" + c4762d.m22752a()});
        C5433c.m26039a(a.c(this.f19242a)).m26046a(true);
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(1007), "need_relogin", "false", null);
        if (a.d(this.f19242a) != null) {
            a.d(this.f19242a).onLoginSuccess(new C5432b());
        }
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"----login successful, send broadcast!----"});
        Intent intent = new Intent();
        intent.setAction("com.huawei.plugin.account.login");
        if (LocalBroadcastManager.getInstance(a.c(this.f19242a)) != null) {
            LocalBroadcastManager.getInstance(a.c(this.f19242a)).sendBroadcast(intent);
        }
        if (a.c(this.f19242a) != null) {
            C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"----send broadcast to social----"});
            a.c(this.f19242a).sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
            return;
        }
        C2538c.c("PLGLOGIN_HuaweiLoginManager", new Object[]{"----mContext is null----"});
    }
}
