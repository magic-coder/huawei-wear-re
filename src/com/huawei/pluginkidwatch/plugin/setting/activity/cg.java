package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

/* compiled from: SetKidWatchNumActivity */
class cg implements OnClickListener {
    final /* synthetic */ SetKidWatchNumActivity f6660a;

    cg(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6660a = setKidWatchNumActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        this.f6660a.f6519u.dismiss();
        this.f6660a.finish();
    }
}
