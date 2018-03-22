package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.huawei.p190v.C2538c;

/* compiled from: BindbyQrActivity */
class C1918i implements OnKeyListener {
    final /* synthetic */ BindbyQrActivity f6683a;

    C1918i(BindbyQrActivity bindbyQrActivity) {
        this.f6683a = bindbyQrActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        C2538c.m12674b(this.f6683a.f6266b, "matb showVirifyInfoExpiredDialog setPositiveButton... keyCode = " + i);
        if (i == 4) {
            return true;
        }
        return false;
    }
}
