package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: HomeActivity */
class C1673t implements OnClickListener {
    final /* synthetic */ HomeActivity f4373a;

    C1673t(HomeActivity homeActivity) {
        this.f4373a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f4373a.bd.dismiss();
    }
}
