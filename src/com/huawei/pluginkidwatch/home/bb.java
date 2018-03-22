package com.huawei.pluginkidwatch.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class bb extends BroadcastReceiver {
    final /* synthetic */ HomeActivity f4266a;

    bb(HomeActivity homeActivity) {
        this.f4266a = homeActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            this.f4266a.cb.m11731a(false);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "mAppAutoCheckNewVersionReceiver onReceive: action = " + intent.getAction());
        if ("action_band_auto_check_new_version_result".equals(intent.getAction())) {
            C2538c.m12674b("KIDWATCH_HomeActivity", "result = " + intent.getIntExtra("result", 6));
            if (intent.getIntExtra("result", 6) == 5) {
                C2538c.m12674b("KIDWATCH_HomeActivity", "ACTION_APP_AUTO_CHECK_NEW_VERSION_RESULT:AUTO_CHECK_SUCCESS ");
                this.f4266a.cb.m11729a(this.f4266a.f4109F, intent.getStringExtra("name"), intent.getIntExtra(UploadFile.SIZE_LABEL, -1), intent.getStringExtra("changelog"), Boolean.valueOf(intent.getBooleanExtra("isForced", false)));
                this.f4266a.cb.m11734b(context);
                return;
            }
            C2538c.m12674b("KIDWATCH_HomeActivity", "mAppAutoCheckNewVersionReceiver result not is AUTO_CHECK_APP_SUCCESS set false");
            this.f4266a.cb.m11731a(false);
            return;
        }
        C2538c.m12674b("KIDWATCH_HomeActivity", "mAppAutoCheckNewVersionReceiver not is ACTION_AUTO_CHECK_NEW_VERSION_RESULT set false");
        this.f4266a.cb.m11731a(false);
    }
}
