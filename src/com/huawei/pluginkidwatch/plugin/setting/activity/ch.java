package com.huawei.pluginkidwatch.plugin.setting.activity;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;
import com.huawei.p190v.C2538c;

/* compiled from: SetKidWatchNumActivity */
class ch implements OnKeyListener {
    final /* synthetic */ SetKidWatchNumActivity f6661a;

    ch(SetKidWatchNumActivity setKidWatchNumActivity) {
        this.f6661a = setKidWatchNumActivity;
    }

    public boolean onKey(DialogInterface dialogInterface, int i, KeyEvent keyEvent) {
        C2538c.m12674b(this.f6661a.f6500b, " setPositiveButton... keyCode = " + i);
        if (i == 4) {
            return true;
        }
        return false;
    }
}
