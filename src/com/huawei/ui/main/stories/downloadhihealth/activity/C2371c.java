package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Message;
import com.huawei.p190v.C2538c;
import com.huawei.ui.main.stories.account.interactor.WeChat;

/* compiled from: HealthStartActivity */
class C2371c extends BroadcastReceiver {
    final /* synthetic */ HealthStartActivity f8562a;

    C2371c(HealthStartActivity healthStartActivity) {
        this.f8562a = healthStartActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            String stringExtra = intent.getStringExtra("mPackageName");
            C2538c.m12677c("HealthStartActivity", "onReceive: action = " + action);
            C2538c.m12677c("HealthStartActivity", "onReceive: mPackageName = " + stringExtra);
            if ("action_app_check_new_version_state".equals(action) && WeChat.HEALTH_PACKAGE_NAME.equals(stringExtra)) {
                Message obtainMessage = HealthStartActivity.a(this.f8562a).obtainMessage();
                obtainMessage.what = 1;
                obtainMessage.obj = intent;
                HealthStartActivity.a(this.f8562a).sendMessage(obtainMessage);
                return;
            }
            return;
        }
        C2538c.m12677c("HealthStartActivity", "mBroadcastReceiver onReceive: arg1 is null");
    }
}
