package com.huawei.ui.main.stories.about.activity;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: AboutActivity */
class C2305e implements OnClickListener {
    final /* synthetic */ AboutActivity f8366a;

    C2305e(AboutActivity aboutActivity) {
        this.f8366a = aboutActivity;
    }

    public void onClick(View view) {
        new Handler().post(new C2306f(this));
    }
}
