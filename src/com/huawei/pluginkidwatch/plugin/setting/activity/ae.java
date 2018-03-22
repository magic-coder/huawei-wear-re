package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: CheckBillActivity */
class ae extends BroadcastReceiver {
    final /* synthetic */ CheckBillActivity f6585a;

    ae(CheckBillActivity checkBillActivity) {
        this.f6585a = checkBillActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("CheckBillActivity", "=checkBill= 收到新短信通知的广播 arg1 =" + intent);
        if (this.f6585a.f6294D != null) {
            this.f6585a.f6297b.removeCallbacks(this.f6585a.f6294D);
        }
        this.f6585a.m9818m();
    }
}
