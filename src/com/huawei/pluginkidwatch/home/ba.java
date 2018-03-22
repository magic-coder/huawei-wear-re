package com.huawei.pluginkidwatch.home;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.huawei.p190v.C2538c;

/* compiled from: HomeActivity */
class ba implements OnKeyListener {
    final /* synthetic */ HomeActivity f4265a;

    ba(HomeActivity homeActivity) {
        this.f4265a = homeActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        C2538c.m12674b("KIDWATCH_HomeActivity", " setPositiveButton... keyCode = " + i);
        if (i == 4) {
            return true;
        }
        return false;
    }
}
