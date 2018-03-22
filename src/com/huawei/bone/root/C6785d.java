package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.d.d;
import com.huawei.p190v.C2538c;

/* compiled from: MainActivity */
class C6785d extends BroadcastReceiver {
    final /* synthetic */ MainActivity f23323a;

    C6785d(MainActivity mainActivity) {
        this.f23323a = mainActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mAppAutoCheckNewVersionReceiver onReceive: action = " + intent.getAction()});
            if ("action_band_auto_check_new_version_result".equals(intent.getAction())) {
                C2538c.a("MainUI", 0, "MainActivity", new Object[]{"result = " + intent.getIntExtra("result", 6)});
                if (intent.getIntExtra("result", 6) == 5) {
                    C2538c.a("MainUI", 0, "MainActivity", new Object[]{"ACTION_APP_AUTO_CHECK_NEW_VERSION_RESULT:AUTO_CHECK_SUCCESS "});
                    String stringExtra = intent.getStringExtra("name");
                    int intExtra = intent.getIntExtra(UploadFile.SIZE_LABEL, -1);
                    String stringExtra2 = intent.getStringExtra("changelog");
                    Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("isForced", false));
                    this.f23323a.f23212c.b(context);
                    if (d.o(this.f23323a.f23220k)) {
                        C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mAppAutoCheckNewVersionReceiver isBackground "});
                        this.f23323a.f23222m = true;
                        this.f23323a.f23223n = stringExtra;
                        this.f23323a.f23224o = intExtra;
                        this.f23323a.f23225p = stringExtra2;
                        this.f23323a.f23226q = valueOf.booleanValue();
                        return;
                    }
                    C2538c.a("MainUI", 0, "MainActivity", new Object[]{"mAppAutoCheckNewVersionReceiver is not background"});
                    this.f23323a.f23212c.a(this.f23323a.f23220k, stringExtra, intExtra, stringExtra2, valueOf);
                    this.f23323a.f23222m = false;
                }
            }
        }
    }
}
