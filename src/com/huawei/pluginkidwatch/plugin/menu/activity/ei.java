package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: GeneralSettingsActivity */
class ei implements OnClickListener {
    final /* synthetic */ GeneralSettingsActivity f6077a;

    ei(GeneralSettingsActivity generalSettingsActivity) {
        this.f6077a = generalSettingsActivity;
    }

    public void onClick(View view) {
        C2538c.m12674b("KIDWATCH_GeneralSettingsActivity", "==ww======取消地图选择 ");
        this.f6077a.f5748q.dismiss();
    }
}
