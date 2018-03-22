package com.huawei.login.ui.login;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import com.huawei.hwcommonmodel.application.BaseApplication;
import com.huawei.hwdataaccessmodel.a.c;
import com.huawei.hwdataaccessmodel.sharedpreference.a;
import com.huawei.p190v.C2538c;
import com.huawei.pluginmessagecenter.service.MessageObserver;
import com.huawei.ui.commonui.base.BaseActivity;

/* compiled from: LoginInit */
class C5428b implements Runnable {
    final /* synthetic */ a f19251a;

    C5428b(a aVar) {
        this.f19251a = aVar;
    }

    public void run() {
        this.f19251a.h();
        a.a(BaseApplication.b(), String.valueOf(MessageObserver.RET_AUTH_ERROR), "KEY_GUIDE_SET_USER_INFO_SUCCESS_FLAG", "false", null);
        a.a(BaseApplication.b(), String.valueOf(20007), "current_token_is_timeout", "", new c());
        a.a(BaseApplication.b(), String.valueOf(20007), "migrate_migrate_over", "", new c(0));
        LocalBroadcastManager instance = LocalBroadcastManager.getInstance(BaseApplication.b());
        if (instance != null) {
            Intent intent = new Intent();
            intent.setAction("com.huawei.plugin.account.logout");
            instance.sendBroadcast(intent);
            if (BaseApplication.b() != null) {
                BaseApplication.b().sendBroadcast(intent, com.huawei.hwcommonmodel.b.c.a);
            } else {
                C2538c.c("LoginInit", new Object[]{"----mContext is null----"});
            }
            C2538c.c("LoginInit", new Object[]{"Enter logout  --> close "});
            intent = new Intent();
            intent.setAction(BaseActivity.CLEAN_ACTIVITY);
            instance.sendBroadcast(intent);
        }
    }
}
