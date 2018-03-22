package com.huawei.login.ui.login;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwbasemgr.IBaseResponseCallback;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;

/* compiled from: LoginInit */
class C5429c implements Runnable {
    final /* synthetic */ IBaseResponseCallback f19252a;
    final /* synthetic */ a f19253b;

    C5429c(a aVar, IBaseResponseCallback iBaseResponseCallback) {
        this.f19253b = aVar;
        this.f19252a = iBaseResponseCallback;
    }

    public void run() {
        C2538c.b("LoginInit", new Object[]{"Enter logoutWhenStTimeout time st is = " + this.f19253b.g()});
        a.a(BaseApplication.b(), String.valueOf(20008), "migrate_timeout_s_key", r0, new com.huawei.hwdataaccessmodel.a.c(1));
        a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout", "true", new com.huawei.hwdataaccessmodel.a.c());
        this.f19253b.h();
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(BaseApplication.b());
        if (instance != null) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.plugin.account.logout");
            instance.sendBroadcast(intent);
            if (BaseApplication.b() != null) {
                BaseApplication.b().sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
                C2538c.c("LoginInit", new Object[]{"----mContext sendBroadcast----"});
            } else {
                C2538c.c("LoginInit", new Object[]{"----mContext is null----"});
            }
        }
        if (this.f19252a != null) {
            this.f19252a.onResponse(0, "");
        }
    }
}
