package com.huawei.ui.main.stories.about.activity.cloudservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.huawei.p190v.C2538c;

/* compiled from: HuaweiCloudServiceActivity */
class C2294a extends BroadcastReceiver {
    final /* synthetic */ HuaweiCloudServiceActivity f8346a;

    C2294a(HuaweiCloudServiceActivity huaweiCloudServiceActivity) {
        this.f8346a = huaweiCloudServiceActivity;
    }

    public void onReceive(Context context, Intent intent) {
        C2538c.m12674b(HuaweiCloudServiceActivity.f8337a, " intent = " + intent.getAction());
        if (context != null && "com.huawei.bone.action.CLOUD_SWITCH_CHANGED".equals(intent.getAction())) {
            C2538c.m12674b(HuaweiCloudServiceActivity.f8337a, "ACTION_CLOUD_SWITCH_CHANGED ");
            this.f8346a.f8344h = this.f8346a.f8343g.m11744a();
            this.f8346a.m11803b(this.f8346a.f8344h);
        }
    }
}
