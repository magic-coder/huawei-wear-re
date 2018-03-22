package com.huawei.up.p517a;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.cloudservice.opensdk.OutReturn;
import com.huawei.cloudservice.opensdk.ResReqHandler;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.login.ui.login.a;
import com.huawei.login.ui.login.util.C5433c;
import com.huawei.p190v.C2538c;

/* compiled from: UpApi */
class C6110c extends ResReqHandler {
    final /* synthetic */ C6108a f21121b;

    C6110c(C6108a c6108a) {
        this.f21121b = c6108a;
    }

    public void onComplete(Bundle bundle) {
        if (OutReturn.isRequestSuccess(bundle)) {
            String accessToken = OutReturn.getAccessToken(bundle);
            C5433c.m26039a(this.f21121b.f21116a).m26053c(accessToken, null);
            C2538c.c("UpApi", new Object[]{"onComplete success "});
            if (a.a(this.f21121b.f21116a) != null) {
                a.a(this.f21121b.f21116a).a(accessToken, null);
                Intent intent = new Intent();
                intent.setAction("com.huawei.plugin.account.login.st.to.at");
                if (LocalBroadcastManager.getInstance(this.f21121b.f21116a) != null) {
                    LocalBroadcastManager.getInstance(this.f21121b.f21116a).sendBroadcast(intent);
                }
                this.f21121b.f21116a.sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
                return;
            }
            return;
        }
        C2538c.c("UpApi", new Object[]{"onComplete get Token failed!! ret_code: " + OutReturn.getRetCode(bundle)});
        if (1202 == OutReturn.getRetCode(bundle)) {
            a.a(BaseApplication.b()).h();
        }
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout", "true", new com.huawei.hwdataaccessmodel.a.c());
        com.huawei.hwdataaccessmodel.sharedpreference.a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "false", new com.huawei.hwdataaccessmodel.a.c(0));
    }
}
