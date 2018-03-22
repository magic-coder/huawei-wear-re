package com.huawei.pluginkidwatch.plugin.menu.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: ContactInfoActivity */
class bo implements OnClickListener {
    final /* synthetic */ ContactInfoActivity f5973a;

    bo(ContactInfoActivity contactInfoActivity) {
        this.f5973a = contactInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f5973a.f5567q.dismiss();
        this.f5973a.m9138a(12, "");
    }
}
