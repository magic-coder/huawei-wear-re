package com.huawei.pluginkidwatch.home;

import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.pluginkidwatch.common.entity.C1462f;

/* compiled from: HomeActivity */
class C1646b implements OnClickListener {
    final /* synthetic */ HomeActivity f4264a;

    C1646b(HomeActivity homeActivity) {
        this.f4264a = homeActivity;
    }

    public void onClick(View view) {
        if (C1462f.m6746j().equals("")) {
            this.f4264a.m7640a(true, true);
        } else {
            this.f4264a.m7624u();
        }
    }
}
