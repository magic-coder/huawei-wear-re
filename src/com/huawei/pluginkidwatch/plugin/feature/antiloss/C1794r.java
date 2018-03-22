package com.huawei.pluginkidwatch.plugin.feature.antiloss;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: AntilossActivity */
class C1794r extends BroadcastReceiver {
    final /* synthetic */ AntilossActivity f4943a;

    C1794r(AntilossActivity antilossActivity) {
        this.f4943a = antilossActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("AntilossActivity", "==========Enter SosLocatReceiver ");
        if (!this.f4943a.isFinishing()) {
            this.f4943a.finish();
        }
    }
}
