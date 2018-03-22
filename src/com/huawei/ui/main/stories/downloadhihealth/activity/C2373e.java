package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HealthStartActivity */
class C2373e implements OnClickListener {
    final /* synthetic */ HealthStartActivity f8564a;

    C2373e(HealthStartActivity healthStartActivity) {
        this.f8564a = healthStartActivity;
    }

    public void onClick(View view) {
        HealthStartActivity.c(this.f8564a).cancel();
    }
}
