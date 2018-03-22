package com.huawei.ui.device.activity.adddevice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwappdfxmgr.upload.UploadFile;
import com.huawei.hwcommonmodel.p064d.C0977d;
import com.huawei.p190v.C2538c;

/* compiled from: AddDeviceActivity */
class C2004f extends BroadcastReceiver {
    final /* synthetic */ AddDeviceActivity f7042a;

    C2004f(AddDeviceActivity addDeviceActivity) {
        this.f7042a = addDeviceActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            C2538c.m12677c("AddDeviceActivity", "mAppAutoCheckNewVersionReceiver onReceive: action = " + intent.getAction());
            if ("action_band_auto_check_new_version_result".equals(intent.getAction())) {
                C2538c.m12677c("AddDeviceActivity", "result = " + intent.getIntExtra("result", 6));
                if (intent.getIntExtra("result", 6) == 5) {
                    C2538c.m12677c("AddDeviceActivity", "ACTION_APP_AUTO_CHECK_NEW_VERSION_RESULT:AUTO_CHECK_SUCCESS ");
                    String stringExtra = intent.getStringExtra("name");
                    int intExtra = intent.getIntExtra(UploadFile.SIZE_LABEL, -1);
                    String stringExtra2 = intent.getStringExtra("changelog");
                    Boolean valueOf = Boolean.valueOf(intent.getBooleanExtra("isForced", false));
                    this.f7042a.f6986K.m11734b(context);
                    if (C0977d.m3576o(this.f7042a.f6987L)) {
                        C2538c.m12677c("AddDeviceActivity", "mAppAutoCheckNewVersionReceiver isBackground ");
                        this.f7042a.f6988M = true;
                        this.f7042a.f6989N = stringExtra;
                        this.f7042a.f6990O = intExtra;
                        this.f7042a.f6991P = stringExtra2;
                        this.f7042a.f6992Q = valueOf.booleanValue();
                        return;
                    }
                    C2538c.m12677c("AddDeviceActivity", "mAppAutoCheckNewVersionReceiver is not background");
                    this.f7042a.f6986K.m11729a(this.f7042a.f6987L, stringExtra, intExtra, stringExtra2, valueOf);
                    this.f7042a.f6988M = false;
                }
            }
        }
    }
}
