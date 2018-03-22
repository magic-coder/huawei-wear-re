package com.huawei.ui.commonui.titlebar;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: CustomTitleBar */
class C6040b implements OnClickListener {
    final /* synthetic */ CustomTitleBar f20808a;

    C6040b(CustomTitleBar customTitleBar) {
        this.f20808a = customTitleBar;
    }

    public void onClick(View view) {
        try {
            ((Activity) this.f20808a.f20784a).finish();
        } catch (Exception e) {
            C2538c.c("CustomTitleBar", new Object[]{"loadDetailTypeView() Exception e=" + e.getMessage()});
        }
    }
}
