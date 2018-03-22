package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: RewardActivity */
class bx extends BroadcastReceiver {
    final /* synthetic */ RewardActivity f6649a;

    bx(RewardActivity rewardActivity) {
        this.f6649a = rewardActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b("RewardActivity", "===================收到达到奖励目标的广播 ");
        this.f6649a.m10010g();
    }
}
