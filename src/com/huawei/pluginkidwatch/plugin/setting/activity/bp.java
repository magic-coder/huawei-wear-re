package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: RelationSettingActivity */
class bp implements OnClickListener {
    final /* synthetic */ RelationSettingActivity f6637a;

    bp(RelationSettingActivity relationSettingActivity) {
        this.f6637a = relationSettingActivity;
    }

    public void onClick(View view) {
        this.f6637a.f6437o.cancel();
        this.f6637a.f6437o = null;
    }
}
