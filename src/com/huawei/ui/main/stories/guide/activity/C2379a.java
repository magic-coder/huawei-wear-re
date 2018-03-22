package com.huawei.ui.main.stories.guide.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: BasicInfoSettingActivity */
class C2379a extends BroadcastReceiver {
    final /* synthetic */ BasicInfoSettingActivity f8635a;

    C2379a(BasicInfoSettingActivity basicInfoSettingActivity) {
        this.f8635a = basicInfoSettingActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12677c("BasicInfoSettingActivity", "BroadcastReceiver mUserProfileReceiver onReceive(): intent = " + intent.getAction());
        if (this.f8635a.f8589P && this.f8635a.f8611q != null && this.f8635a.f8611q.isShowing()) {
            C2538c.m12677c("BasicInfoSettingActivity", "user info is loading !!!");
            return;
        }
        this.f8635a.m12062c();
    }
}
