package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.huawei.p190v.C2538c;

/* compiled from: BindbyQrActivity */
class C1917h implements OnClickListener {
    final /* synthetic */ BindbyQrActivity f6682a;

    C1917h(BindbyQrActivity bindbyQrActivity) {
        this.f6682a = bindbyQrActivity;
    }

    public void onClick(DialogInterface dialogInterface, int i) {
        C2538c.m12674b(this.f6682a.f6266b, "matb showVirifyInfoExpiredDialog setPositiveButton... i = " + i);
        this.f6682a.m9769i();
    }
}
