package com.huawei.ui.homewear21.p175a;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: LeftMenuFragment */
class cg extends BroadcastReceiver {
    final /* synthetic */ cf f8124a;

    cg(cf cfVar) {
        this.f8124a = cfVar;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("LeftMenuFragment", "UserProfileActivity mUserProfileReceiver(): intent = " + intent.getAction());
        this.f8124a.m11592c();
    }
}
