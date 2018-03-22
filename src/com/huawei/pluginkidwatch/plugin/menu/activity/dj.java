package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: EditRelationSettingActivity */
class dj implements OnClickListener {
    final /* synthetic */ EditRelationSettingActivity f6034a;

    dj(EditRelationSettingActivity editRelationSettingActivity) {
        this.f6034a = editRelationSettingActivity;
    }

    public void onClick(View view) {
        this.f6034a.f5695p.cancel();
        this.f6034a.f5695p = null;
    }
}
