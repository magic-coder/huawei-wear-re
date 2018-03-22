package com.huawei.ui.main.stories.downloadhihealth.activity;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: HealthStartActivity */
class C2375g implements OnClickListener {
    final /* synthetic */ HealthStartActivity f8566a;

    C2375g(HealthStartActivity healthStartActivity) {
        this.f8566a = healthStartActivity;
    }

    public void onClick(View view) {
        HealthStartActivity.e(this.f8566a).cancel();
    }
}
