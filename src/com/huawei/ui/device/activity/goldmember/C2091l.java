package com.huawei.ui.device.activity.goldmember;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: VIPUserInfoActivity */
class C2091l implements OnClickListener {
    final /* synthetic */ VIPUserInfoActivity f7371a;

    C2091l(VIPUserInfoActivity vIPUserInfoActivity) {
        this.f7371a = vIPUserInfoActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b(VIPUserInfoActivity.f7302d, "showUpgradeDialog ok click");
        this.f7371a.m10821m();
        this.f7371a.m10830a(Boolean.valueOf(true));
        this.f7371a.f7317M.dismiss();
        this.f7371a.f7317M = null;
    }
}
