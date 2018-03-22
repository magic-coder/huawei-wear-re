package com.huawei.hwid.openapi.auth;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hwid.core.constants.HwAccountConstants;
import com.huawei.hwid.openapi.p440a.C5212a;
import com.huawei.hwid.openapi.p445e.C5248c;

class C5216c extends BroadcastReceiver {
    private C5212a f18821a;
    private boolean f18822b = false;

    C5216c(C5212a c5212a) {
        this.f18821a = c5212a;
    }

    public synchronized void onReceive(Context context, Intent intent) {
        if (intent != null) {
            try {
                String action = intent.getAction();
                if (!this.f18822b) {
                    this.f18821a.f18805a.unregisterReceiver(this);
                    this.f18822b = true;
                    if ("com.huawei.cloudserive.getSTCancel".equals(action)) {
                        C5248c.m25445a(C5215b.f18820a, "ACTION_GET_ST_FAILED:" + intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE));
                        this.f18821a.f18806b.finish(intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE));
                    } else if ("com.huawei.cloudserive.getSTSuccess".equals(action)) {
                        this.f18821a.f18814j = intent.getBundleExtra(HwAccountConstants.EXTRA_BUNDLE).getString("authToken");
                        C5214a.m25354a(this.f18821a);
                    }
                }
            } catch (Throwable th) {
                C5248c.m25448b(C5215b.f18820a, th.toString(), th);
            }
        }
    }
}
