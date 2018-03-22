package com.huawei.ui.commonui.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BaseActivity */
class C5993a extends BroadcastReceiver {
    final /* synthetic */ BaseActivity f20605a;

    C5993a(BaseActivity baseActivity) {
        this.f20605a = baseActivity;
    }

    public void onReceive(Context context, Intent intent) {
        if (intent != null && intent.getAction() != null) {
            C2538c.b(BaseActivity.access$000(), new Object[]{"mBroadcast Start action = " + intent.getAction()});
            if (intent.getAction().compareTo(BaseActivity.CLEAN_ACTIVITY) == 0) {
                this.f20605a.finish();
            }
        }
    }
}
