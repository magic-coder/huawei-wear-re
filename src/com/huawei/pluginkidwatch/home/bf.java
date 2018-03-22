package com.huawei.pluginkidwatch.home;

import android.os.Handler;
import android.view.View;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.common.ui.listview.C1529i;

/* compiled from: HomeActivity */
class bf implements C1529i {
    final /* synthetic */ HomeActivity f4270a;

    bf(HomeActivity homeActivity) {
        this.f4270a = homeActivity;
    }

    public void mo2559a(View view) {
        C2538c.m12674b("KIDWATCH_HomeActivity", "================Show Device List");
        this.f4270a.m7474K();
        new Handler().post(new bg(this));
    }
}
