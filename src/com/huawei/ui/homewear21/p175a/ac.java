package com.huawei.ui.homewear21.p175a;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;
import com.huawei.ui.device.activity.notification.NotificationSettingActivity;

/* compiled from: HomeFragment */
class ac implements OnClickListener {
    final /* synthetic */ C2217a f8044a;

    ac(C2217a c2217a) {
        this.f8044a = c2217a;
    }

    public void onClick(View view) {
        C2538c.m12674b("HomeFragment", "notification ok click");
        this.f8044a.m11487b(bz.NOTIFICATION);
        Intent intent = new Intent();
        intent.setClass(this.f8044a.f8041z, NotificationSettingActivity.class);
        this.f8044a.startActivity(intent);
    }
}
