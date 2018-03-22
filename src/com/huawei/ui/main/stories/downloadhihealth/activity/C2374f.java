package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HealthStartActivity */
class C2374f implements OnClickListener {
    final /* synthetic */ HealthStartActivity f8565a;

    C2374f(HealthStartActivity healthStartActivity) {
        this.f8565a = healthStartActivity;
    }

    public void onClick(View view) {
        HealthStartActivity.d(this.f8565a).m11739g();
        HealthStartActivity.e(this.f8565a).cancel();
    }
}
