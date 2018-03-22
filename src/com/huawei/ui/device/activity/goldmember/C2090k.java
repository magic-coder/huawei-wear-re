package com.huawei.ui.device.activity.goldmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: VIPUserInfoActivity */
class C2090k implements OnClickListener {
    final /* synthetic */ VIPUserInfoActivity f7370a;

    C2090k(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7370a = vIPUserInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b(VIPUserInfoActivity.f7302d, "showUpgradeDialog cancel click");
        this.f7370a.m10830a(Boolean.valueOf(true));
        this.f7370a.f7317M.dismiss();
        this.f7370a.f7317M = null;
    }
}
