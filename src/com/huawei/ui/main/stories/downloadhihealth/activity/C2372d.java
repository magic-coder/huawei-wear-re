package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HealthStartActivity */
class C2372d implements OnClickListener {
    final /* synthetic */ HealthStartActivity f8563a;

    C2372d(HealthStartActivity healthStartActivity) {
        this.f8563a = healthStartActivity;
    }

    public void onClick(View view) {
        HealthStartActivity.b(this.f8563a);
        HealthStartActivity.c(this.f8563a).cancel();
    }
}
