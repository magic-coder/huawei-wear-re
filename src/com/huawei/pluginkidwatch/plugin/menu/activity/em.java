package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: GeneralSettingsActivity */
class em implements OnClickListener {
    final /* synthetic */ GeneralSettingsActivity f6082a;

    em(GeneralSettingsActivity generalSettingsActivity) {
        this.f6082a = generalSettingsActivity;
    }

    public void onClick(View view) {
        this.f6082a.f5739h.cancel();
        this.f6082a.f5739h = null;
    }
}
