package com.huawei.bone.root;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: STTimeoutActivity */
class C6807z extends BroadcastReceiver {
    final /* synthetic */ STTimeoutActivity f23349a;

    C6807z(STTimeoutActivity sTTimeoutActivity) {
        this.f23349a = sTTimeoutActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.c(STTimeoutActivity.f23251f, new Object[]{"onReceive"});
        this.f23349a.finish();
    }
}
