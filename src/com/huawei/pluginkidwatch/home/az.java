package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.huawei.p190v.C2538c;
import com.huawei.pluginkidwatch.plugin.setting.activity.SetKidWatchNumActivity;

/* compiled from: HomeActivity */
class az implements OnClickListener {
    final /* synthetic */ HomeActivity f4193a;

    az(HomeActivity homeActivity) {
        this.f4193a = homeActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b("KIDWATCH_HomeActivity", " setPositiveButton... i = " + i);
        this.f4193a.f4109F.startActivity(new Intent(this.f4193a, SetKidWatchNumActivity.class));
    }
}
