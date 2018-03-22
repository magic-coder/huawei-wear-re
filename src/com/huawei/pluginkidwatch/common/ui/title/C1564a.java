package com.huawei.pluginkidwatch.common.ui.title;

import android.view.View;
import android.view.View.OnClickListener;

/* compiled from: CustomTitle */
class C1564a implements OnClickListener {
    final /* synthetic */ CustomTitle f3787a;

    C1564a(CustomTitle customTitle) {
        this.f3787a = customTitle;
    }

    public void onClick(View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof String)) {
            this.f3787a.m7189a(this.f3787a.f3765e, (String) view.getTag(), view);
        }
    }
}
