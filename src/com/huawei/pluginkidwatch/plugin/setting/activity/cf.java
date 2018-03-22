package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: SetKidWatchNumActivity */
class cf implements OnClickListener {
    final /* synthetic */ SetKidWatchNumActivity f6659a;

    cf(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6659a = setKidWatchNumActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b(this.f6659a.f6500b, " setPositiveButton... i = " + i);
        this.f6659a.f6519u.dismiss();
    }
}
