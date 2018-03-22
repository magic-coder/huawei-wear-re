package com.huawei.hihealth.p036a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.hihealth.p393b.C4537b;
import com.huawei.p190v.C2538c;

/* compiled from: HiHealthNativeAPI */
class ae extends BroadcastReceiver {
    private ae() {
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null) {
            C2538c.d("HiH_HiHealthNativeAPI", new Object[]{"MyBroadcastReceiver onReceive intent = null"});
            return;
        }
        C4537b.m21741a(context, intent);
    }
}
